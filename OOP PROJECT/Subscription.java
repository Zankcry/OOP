public abstract class Subscription {
    protected int id;
    protected String user;
    protected String startDate;
    protected String endDate;
    protected String currentStatus;

    public Subscription(int id, String user, String startDate, String endDate, String currentStatus) {
        this.id = id;
        this.user = user;
        this.startDate = startDate;
        this.endDate = endDate;
        this.currentStatus = currentStatus;
    }

    public abstract void displayInfo();
    
    public void renewSubscription(String newEndDate) {
        this.endDate = newEndDate;
        this.currentStatus = "Active";
        System.out.println("Subscription renewed until: " + newEndDate);
    }

    public void cancelSubscription() {
        this.currentStatus = "Cancelled";
        System.out.println("Subscription cancelled.");
    }
}
