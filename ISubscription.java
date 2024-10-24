public interface ISubscription {
    void displayInfo();
    void renewSubscription(String newEndDate);
    void cancelSubscription();
    int getId();
    String getCurrentStatus();
    void setCurrentStatus(String status);
}