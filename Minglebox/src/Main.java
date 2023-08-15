import java.util.Scanner;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EventDispatcher eventDispatcher = new EventDispatcher();
        List<Coder> coders = new ArrayList<>();
        List<Buyer> buyers = new ArrayList<>();
        List<Project> projects = new ArrayList<>();
        List<Bid> bids = new ArrayList<>();
        List<Project> completedProjects = new ArrayList<>();

        eventDispatcher.addHandler("register", new RegistrationEventHandler(scanner, coders, buyers));
        eventDispatcher.addHandler("addProject", new ProjectEventHandler(scanner, projects));
        eventDispatcher.addHandler("selectCoder", new BiddingEventHandler(scanner, bids, projects, coders));
        eventDispatcher.addHandler("pay", new PaymentEventHandler(scanner, bids, buyers));
        eventDispatcher.addHandler("completeProject", new ProjectCompletionEventHandler(completedProjects));
        
        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Register Coder/Buyer");
            System.out.println("2. Add Project for Bidding");
            System.out.println("3. Select Coder for Bidding");
            System.out.println("4. Make Payment");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

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
                    eventDispatcher.dispatchEvent("pay", null);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
