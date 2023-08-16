import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EventDispatcher eventDispatcher = new EventDispatcher();

        List<Project> projects = new ArrayList<>();
        List<Project> completedProjects = new ArrayList<>(); // List to store completed projects
        List<Coder> coders = new ArrayList<>();
        List<Buyer> buyers = new ArrayList<>();
        List<Bid> bids = new ArrayList<>();
        
        // Create and add the event handlers
        eventDispatcher.addHandler("register", new RegistrationEventHandler(scanner, coders, buyers));
        eventDispatcher.addHandler("addProject", new ProjectEventHandler(scanner, projects));
        eventDispatcher.addHandler("selectCoder", new BiddingEventHandler(scanner, bids, projects, coders));
        eventDispatcher.addHandler("pay", new PaymentEventHandler(scanner, bids, completedProjects));
        eventDispatcher.addHandler("completeProject", new ProjectCompletionEventHandler(projects, completedProjects));

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Register Coder/Buyer");
            System.out.println("2. Add Project for Bidding");
            System.out.println("3. Select Coder for Bidding");
            System.out.println("4. Mark Project as Completed");
            System.out.println("5. Make Payment");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    eventDispatcher.dispatchEvent("register", null);
                    break;
                case 2:
                    eventDispatcher.dispatchEvent("addProject", null);
                    break;
                case 3:
                    eventDispatcher.dispatchEvent("selectCoder", null);
                    break;
                case 4:
                	eventDispatcher.dispatchEvent("completeProject", selectProjectToComplete(projects, scanner));
                    break;
                case 5:
                    eventDispatcher.dispatchEvent("pay", null);
                    break;
                    
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

        private static Project selectProjectToComplete(List<Project> projects, Scanner scanner) {
        System.out.println("Select a project to mark as completed:");
        for (int i = 0; i < projects.size(); i++) {
            System.out.println((i + 1) + ". " + projects.get(i).getTitle());
        }

        try {
            int projectNumber = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            return (projectNumber >= 1 && projectNumber <= projects.size()) ? projects.get(projectNumber - 1) : null;
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid project number.");
            scanner.nextLine(); // Consume invalid input
            return null;
        }
    }
}


