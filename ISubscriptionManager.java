public interface ISubscriptionManager {
    void createSubscription(ISubscription subscription);
    void updateSubscription(int id, String newStatus);
    void cancelSubscription(int id);
    void viewSubscription(int id);
    ISubscription searchByID(int id);
    void upgradeToPremium(int id);
}