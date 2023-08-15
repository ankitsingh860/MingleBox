import java.util.List;

public class ProjectCompletionEventHandler implements EventHandler {
    private List<Project> completedProjects;

    public ProjectCompletionEventHandler(List<Project> completedProjects) {
        this.completedProjects = completedProjects;
    }

    @Override
    public void handleEvent(Object data) {
        if (data instanceof Project) {
            Project completedProject = (Project) data;
            
            // Assume there is a confirmation process, and the project is marked as completed
            completedProject.setCompleted(true);
            
            completedProjects.add(completedProject);
            
            System.out.println("Project '" + completedProject.getTitle() + "' marked as completed and added to the completed projects list.");
        } else {
            System.out.println("Invalid data provided for project completion.");
        }
    }
}


