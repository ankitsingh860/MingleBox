import java.util.Scanner;
import java.util.List;

public class BiddingEventHandler implements EventHandler {
    private Scanner scanner;
    private List<Bid> bids;
    private List<Project> projects;
    private List<Coder> coders;

    public BiddingEventHandler(Scanner scanner, List<Bid> bids, List<Project> projects, List<Coder> coders) {
        this.scanner = scanner;
        this.bids = bids;
        this.projects = projects;
        this.coders = coders;
    }

    @Override
    public void handleEvent(Object data) {
        System.out.println("Available Projects:");
        for (int i = 0; i < projects.size(); i++) {
            System.out.println((i + 1) + ". " + projects.get(i).getTitle());
        }
        
        System.out.print("Select a project to place a bid (enter project number): ");
        int projectNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (projectNumber >= 1 && projectNumber <= projects.size()) {
            Project selectedProject = projects.get(projectNumber - 1);

            System.out.println("Available Coders:");
            for (int i = 0; i < coders.size(); i++) {
                System.out.println((i + 1) + ". " + coders.get(i).getUsername() + " - Skills: " + coders.get(i).getSkills()+ " - Rating: " + coders.get(i).getRating());
            }

            System.out.print("Select a coder to place a bid (enter coder number): ");
            int coderNumber = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (coderNumber >= 1 && coderNumber <= coders.size()) {
                Coder selectedCoder = coders.get(coderNumber - 1);

                System.out.print("Enter bid amount: ");
                double bidAmount = scanner.nextDouble();
                scanner.nextLine(); // Consume newline

                Bid newBid = new Bid(selectedCoder, selectedProject, bidAmount);
                bids.add(newBid);

                System.out.println("Bid placed successfully!");
            } else {
                System.out.println("Invalid coder number.");
            }
        } else {
            System.out.println("Invalid project number.");
        }
    }
}
