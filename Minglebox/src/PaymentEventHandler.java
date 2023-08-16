import java.util.List;
import java.util.Scanner;

public class PaymentEventHandler implements EventHandler {
    private Scanner scanner;
    private List<Bid> bids;
    private List<Project> completedProjects;

    public PaymentEventHandler(Scanner scanner, List<Bid> bids, List<Project> completedProjects) {
        this.scanner = scanner;
        this.bids = bids;
        this.completedProjects = completedProjects;
    }

    @Override
    public void handleEvent(Object data) {
        System.out.println("Select a completed project for payment:");
        int projectNumber = displayCompletedProjects();

        if (projectNumber >= 1 && projectNumber <= completedProjects.size()) {
            Project selectedProject = completedProjects.get(projectNumber - 1);

            Bid selectedBid = findBidForProject(selectedProject);
            if (selectedBid != null) {
                double paymentAmount = selectedBid.getBidAmount();

                // Access buyer directly from the project
                Buyer buyer = selectedProject.getBuyer();

                if (buyer != null && buyer.getBudget() >= paymentAmount) {
                    buyer.setBudget(buyer.getBudget() - paymentAmount);
                    Coder coder = selectedBid.getCoder();
                    coder.setRating(coder.getRating() + 0.1); // Update coder's rating

                    System.out.println("Payment successful!");
                } else {
                    System.out.println("Insufficient funds or project not found.");
                }
            } else {
                System.out.println("No bid found for the selected project.");
            }
        } else {
            System.out.println("Invalid project number.");
        }
    }

    private int displayCompletedProjects() {
        for (int i = 0; i < completedProjects.size(); i++) {
            Project project = completedProjects.get(i);
            System.out.println((i + 1) + ". " + project.getTitle() + " - Bid Amount: " + getBidAmountForProject(project)+ " - Project Budget: " + project.getBudget());
        }

        System.out.print("Select a project to make a payment (enter project number): ");
        return scanner.nextInt();
    }

    private Bid findBidForProject(Project project) {
        for (Bid bid : bids) {
            if (bid.getProject() == project) {
                return bid;
            }
        }
        return null;
    }

    private double getBidAmountForProject(Project project) {
        Bid bid = findBidForProject(project);
        return (bid != null) ? bid.getBidAmount() : 0.0;
    }
}
