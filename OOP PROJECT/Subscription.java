public class Subscription {
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

    public void displayInfo(){
        System.out.println("Service Subscription Info:");
        System.out.println("ID: " + id);
        System.out.println("User: " + user);
        System.out.println("Status: " + currentStatus);
        System.out.println("Start Date: " + startDate);
        System.out.println("End Date: " + endDate);
    }
    
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
