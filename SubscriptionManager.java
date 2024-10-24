import java.util.ArrayList;

public class SubscriptionManager implements ISubscriptionManager {
    private ArrayList<ISubscription> subscriptions = new ArrayList<>();

    @Override
    public void createSubscription(ISubscription subscription) {
        subscriptions.add(subscription);
        System.out.println("Subscription created.");
    }

    @Override
    public void updateSubscription(int id, String newStatus) {
        ISubscription sub = findSubscriptionById(id);
        if (sub != null) {
            sub.setCurrentStatus(newStatus);
            System.out.println("Subscription updated.");
        } else {
            System.out.println("Subscription not found.");
        }
    }
    
    @Override
    public ISubscription searchByID(int id) {
        for (ISubscription sub : subscriptions) {
            if (sub.getId() == id) {
                return sub;
            }
        }
        return null;
    }
    
    @Override
    public void upgradeToPremium(int id) {
        ISubscription sub = findSubscriptionById(id);
        if (sub != null && sub instanceof ServiceSubscription) {
            ((ServiceSubscription) sub).upgradeToPremium();
        } else {
            System.out.println("Subscription not found or not eligible for upgrade.");
        }
    }

    @Override
    public void cancelSubscription(int id) {
        ISubscription sub = findSubscriptionById(id);
        if (sub != null) {
            sub.cancelSubscription();
        } else {
            System.out.println("Subscription not found.");
        }
    }

    @Override
    public void viewSubscription(int id) {
        ISubscription sub = findSubscriptionById(id);
        if (sub != null) {
            sub.displayInfo();
        } else {
            System.out.println("Subscription not found.");
        }
    }

    private ISubscription findSubscriptionById(int id) {
        return searchByID(id);
    }
}