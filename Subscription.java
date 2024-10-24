public abstract class Subscription implements ISubscription {
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

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getCurrentStatus() {
        return currentStatus;
    }

    @Override
    public void setCurrentStatus(String status) {
        this.currentStatus = status;
    }

    @Override
    public void renewSubscription(String newEndDate) {
        this.endDate = newEndDate;
        this.currentStatus = "Active";
        System.out.println("Subscription renewed until: " + newEndDate);
    }

    @Override
    public void cancelSubscription() {
        this.currentStatus = "Cancelled";
        System.out.println("Subscription cancelled.");
    }

    @Override
    public void displayInfo() {
        System.out.println("\n--- Subscription Info ---");
        displayBasicInfo();
        displaySpecificInfo();
    }

    protected void displayBasicInfo() {
        System.out.println("ID: " + id);
        System.out.println("User: " + user);
        System.out.println("Status: " + currentStatus);
        System.out.println("Start Date: " + startDate);
        System.out.println("End Date: " + endDate);
    }

    protected abstract void displaySpecificInfo();
}