import java.util.List;
import java.util.Scanner;

public class ProjectEventHandler implements EventHandler {
    private Scanner scanner;
    private List<Project> projects;

    public ProjectEventHandler(Scanner scanner, List<Project> projects) {
        this.scanner = scanner;
        this.projects = projects;
    }
    
    @Override
    public void handleEvent(Object data) {
        System.out.println("Adding a Project for Bidding");
        System.out.print("Enter project title: ");
        String title = scanner.nextLine();

        System.out.print("Enter project description: ");
        String description = scanner.nextLine();

        System.out.print("Enter project budget: ");
        double budget = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Project newProject = new Project(title, description, budget);
        projects.add(newProject);

        System.out.println("Project added for bidding: " + newProject.getTitle());
    }
}
