import java.util.List;
import java.util.Scanner;

public class RegistrationEventHandler implements EventHandler {
    private Scanner scanner;
    private List<Coder> coders;
    private List<Buyer> buyers;

    public RegistrationEventHandler(Scanner scanner, List<Coder> coders, List<Buyer> buyers) {
        this.scanner = scanner;
        this.coders = coders;
        this.buyers = buyers;
    }

    @Override
    public void handleEvent(Object data) {
        System.out.println("Registration Event Handler");

        System.out.print("Are you registering as a Coder or a Buyer? (coder/buyer): ");
        String userType = scanner.nextLine();

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter skills (for Coders) or company (for Buyers): ");
        String additionalInfo = scanner.nextLine();

        if ("coder".equalsIgnoreCase(userType)) {
            System.out.print("Enter initial rating: ");
            double rating = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            Coder newCoder = new Coder(username, additionalInfo, rating);
            coders.add(newCoder);
            System.out.println("Coder registered: " + newCoder.getUsername());
        } else if ("buyer".equalsIgnoreCase(userType)) {
            System.out.print("Enter initial budget: ");
            double budget = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            
            Buyer newBuyer = new Buyer(username, additionalInfo, budget);
            buyers.add(newBuyer);
            System.out.println("Buyer registered: " + newBuyer.getUsername());
        } else {
            System.out.println("Invalid user type.");
        }
    }
}
