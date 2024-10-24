public class ServiceSubscription extends Subscription {
    private String serviceType;  // Regular, Premium
    private String billingCycle; // Monthly, Annual

    public ServiceSubscription(int id, String user, String startDate, String endDate, String currentStatus, String serviceType, String billingCycle) {
        super(id, user, startDate, endDate, currentStatus);
        this.serviceType = serviceType;
        this.billingCycle = billingCycle;
    }

    @Override
    protected void displaySpecificInfo() {
        System.out.println("Service Type: " + serviceType);
        System.out.println("Billing Cycle: " + billingCycle);
    }

    public void upgradeToPremium() {
        if (!serviceType.equals("Premium")) {
            serviceType = "Premium";
            System.out.println("Upgraded to Premium.");
        } else {
            System.out.println("Already on Premium plan.");
        }
    }
}