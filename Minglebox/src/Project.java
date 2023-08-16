public class Project {
    private String title;
    private String description;
    private double budget;
    private boolean isOpenForBidding;
    private boolean isCompleted;
    private Buyer buyer; // Add reference to the associated buyer

    public Project(String title, String description, double budget) {
        this.title = title;
        this.description = description;
        this.budget = budget;
        this.isOpenForBidding = true;
        this.isCompleted = false;
        this.buyer = null; // Initialize buyer as null
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getBudget() {
        return budget;
    }

    public boolean isOpenForBidding() {
        return isOpenForBidding;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public void setOpenForBidding(boolean openForBidding) {
        isOpenForBidding = openForBidding;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }
}
