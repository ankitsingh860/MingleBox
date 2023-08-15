public class Bid {
    private Coder coder;
    private Project project;
    private double bidAmount;

    public Bid(Coder coder, Project project, double bidAmount) {
        this.coder = coder;
        this.project = project;
        this.bidAmount = bidAmount;
    }

    // Getter and Setter for coder
    public Coder getCoder() {
        return coder;
    }

    public void setCoder(Coder coder) {
        this.coder = coder;
    }

    // Getter and Setter for project
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    // Getter and Setter for bidAmount
    public double getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(double bidAmount) {
        this.bidAmount = bidAmount;
    }
}
