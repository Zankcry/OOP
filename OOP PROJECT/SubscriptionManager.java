import java.util.ArrayList;

public class SubscriptionManager{
    private ArrayList<Subscription> subscriptions = new ArrayList<>();

    public void createSubscription(Subscription subscription) {
        subscriptions.add(subscription);
        System.out.println("Subscription created.");
    }

    public void updateSubscription(int id, String newStatus) {
        Subscription sub = findSubscriptionById(id);
        if (sub != null) {
            sub.currentStatus = newStatus;
            System.out.println("Subscription updated.");
        } else {
            System.out.println("Subscription not found.");
        }
    }
    
    public Subscription searchByID(int id) {
        for (Subscription sub : subscriptions) {
            if (sub.id == id) {
                return sub;
            }
        }
        return null;
    }
    
    public void upgradeToPremium(int id) {
        Subscription sub = findSubscriptionById(id);
        if (sub != null && sub instanceof ServiceSubscription) {
            ((ServiceSubscription) sub).upgradeToPremium();
        } else {
            System.out.println("Subscription not found or not eligible for upgrade.");
        }
    }

    public void cancelSubscription(int id) {
        Subscription sub = findSubscriptionById(id);
        if (sub != null) {
            sub.cancelSubscription();
        } else {
            System.out.println("Subscription not found.");
        }
    }

    public void viewSubscription(int id) {
        Subscription sub = findSubscriptionById(id);
        if (sub != null) {
            sub.displayInfo();
        } else {
            System.out.println("Subscription not found.");
        }
    }

    private Subscription findSubscriptionById(int id) {
        return searchByID(id);
    }
}
