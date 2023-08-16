import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ProjectCompletionEventHandler implements EventHandler {
    private List<Project> projects;
    private List<Project> completedProjects;

    public ProjectCompletionEventHandler(List<Project> projects, List<Project> completedProjects) {
        this.projects = projects;
        this.completedProjects = completedProjects;
    }

    @Override
    public void handleEvent(Object data) {
        if (data instanceof Project) {
            Project project = (Project) data;

            if (projects.contains(project)) {
                // Check if the project is already completed
                if (completedProjects.contains(project)) {
                    System.out.println("Project '" + project.getTitle() + "' is already marked as completed.");
                } else {
                    boolean isConfirmed = confirmProjectCompletion(project);

                    if (isConfirmed) {
                        project.setCompleted(true);
                        completedProjects.add(project);
                        System.out.println("Project '" + project.getTitle() + "' marked as completed and added to the completed projects list.");
                    } else {
                        System.out.println("Project completion not confirmed.");
                    }
                }
            } else {
                System.out.println("Project not found.");
            }
        } else {
            System.out.println("Invalid data provided for project completion.");
        }
    }

    private boolean confirmProjectCompletion(Project project) {
        // Simulate confirmation logic here (e.g., buyer and coder agreement)
        // Return true if project completion is confirmed, false otherwise
        
        // For the purpose of this example, we'll simulate buyer and coder confirmation using console input
        
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.println("Buyer: Has the project '" + project.getTitle() + "' been completed? (yes/no)");
            String buyerConfirmation = scanner.nextLine().trim().toLowerCase();
            
            System.out.println("Coder: Has the project '" + project.getTitle() + "' been completed? (yes/no)");
            String coderConfirmation = scanner.nextLine().trim().toLowerCase();
            
            return buyerConfirmation.equals("yes") && coderConfirmation.equals("yes");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid project number.");
            scanner.nextLine(); // Consume invalid input
            return false;
        }
    }

}
