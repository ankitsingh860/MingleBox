import java.util.List;
import java.util.Scanner;

public class PaymentEventHandler implements EventHandler {
    private Scanner scanner;
    private List<Bid> bids;
    private List<Buyer> buyers;

    public PaymentEventHandler(Scanner scanner, List<Bid> bids, List<Buyer> buyers) {
        this.scanner = scanner;
        this.bids = bids;
        this.buyers = buyers;
    }

    @Override
    public void handleEvent(Object data) {
        System.out.println("Select a completed project for payment:");
        for (int i = 0; i < bids.size(); i++) {
            Bid bid = bids.get(i);
            if (bid.getProject().isCompleted()) {
                System.out.println((i + 1) + ". " + bid.getProject().getTitle() + " - Bid Amount: " + bid.getBidAmount());
            }
        }

        System.out.print("Select a project to make a payment (enter project number): ");
        int projectNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (projectNumber >= 1 && projectNumber <= bids.size()) {
            Bid selectedBid = bids.get(projectNumber - 1);
            Project selectedProject = selectedBid.getProject();
            Coder selectedCoder = selectedBid.getCoder();

            double paymentAmount = selectedBid.getBidAmount();
            Buyer buyer = getBuyerForProject(selectedProject);

            if (buyer != null && buyer.getBudget() >= paymentAmount) {
                buyer.setBudget(buyer.getBudget() - paymentAmount);
                selectedCoder.setRating(selectedCoder.getRating() + 0.1); // Update coder's rating

                System.out.println("Payment successful!");
            } else {
                System.out.println("Insufficient funds or project not found.");
            }
        } else {
            System.out.println("Invalid project number.");
        }
    }

    private Buyer getBuyerForProject(Project project) {
        for (Bid bid : bids) {
            if (bid.getProject().equals(project)) {
                return findBuyerByUsername(bid.getCoder().getUsername());
            }
        }
        return null;
    }

    private Buyer findBuyerByUsername(String username) {
        for (Buyer buyer : buyers) {
            if (buyer.getUsername().equals(username)) {
                return buyer;
            }
        }
        return null;
    }
}
