public class Project {
    private String title;
    private String description;
    private double budget;
    private boolean isOpenForBidding;
    private boolean isCompleted;

    public Project(String title, String description, double budget) {
        this.title = title;
        this.description = description;
        this.budget = budget;
        this.isOpenForBidding = true; // New project is open for bidding by default
        this.isCompleted = false;
    }

    // Getter and Setter for title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter and Setter for description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter and Setter for budget
    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    // Getter and Setter for isOpenForBidding
    public boolean isOpenForBidding() {
        return isOpenForBidding;
    }

    public void setOpenForBidding(boolean isOpenForBidding) {
        this.isOpenForBidding = isOpenForBidding;
    }
    
    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
    
    @Override
    public String toString() {
        return "Project{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", budget=" + budget +
                ", isOpenForBidding=" + isOpenForBidding +
                ", isCompleted=" + isCompleted +
                '}';
    }
}
