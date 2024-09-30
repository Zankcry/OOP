import java.util.Scanner;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);
    private SubscriptionManager subscriptionManager = new SubscriptionManager();

    public void getUserInput() {
        while (true) {
            System.out.println("1. Create Subscription");
            System.out.println("2. Update Subscription");
            System.out.println("3. Cancel Subscription");
            System.out.println("4. View Subscription");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            handleChoice(choice);
        }
    }

    private void handleChoice(int choice) {
        switch (choice) {
            case 1:
                createSubscription();
                break;
            case 2:
                updateSubscription();
                break;
            case 3:
                cancelSubscription();
                break;
            case 4:
                viewSubscription();
                break;
            case 5:
                System.exit(0);
        }
    }

    private void createSubscription() {
        System.out.println("Enter New Id: ");
        int userId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter User Name: ");
        String user = scanner.nextLine();
        ServiceSubscription sub = new ServiceSubscription(userId, user, "2024-09-01", "2025-09-01", "Active", "Regular", "Monthly");
        subscriptionManager.createSubscription(sub);
    }

    private void updateSubscription() {
        System.out.println("Enter Subscription ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Choose update option:");
        System.out.println("1. Update status");
        System.out.println("2. Upgrade to Premium");
        System.out.print("Enter choice: ");
        int updateChoice = scanner.nextInt();
        scanner.nextLine();

        switch (updateChoice) {
            case 1:
                System.out.println("Enter new status (Active/Cancelled): ");
                String newStatus = scanner.nextLine();
                subscriptionManager.updateSubscription(id, newStatus);
                break;
            case 2:
                subscriptionManager.upgradeToPremium(id);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private void cancelSubscription() {
        System.out.println("Enter Subscription ID to cancel: ");
        int id = scanner.nextInt();
        subscriptionManager.cancelSubscription(id);
    }

    private void viewSubscription() {
        System.out.println("Enter Subscription ID to view: ");
        int id = scanner.nextInt();
        subscriptionManager.viewSubscription(id);
    }
}