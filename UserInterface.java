import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);
    private ISubscriptionManager subscriptionManager = new SubscriptionManager();

    public void getUserInput() {
        while (true) {
            System.out.println("\n--- Subscription Manager ---");
            System.out.println("1. Create Subscription");
            System.out.println("2. Update Subscription");
            System.out.println("3. Cancel Subscription");
            System.out.println("4. Search Subscription by ID");
            System.out.println("5. Renew Subscription");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = getValidIntInput(1, 6);
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
                renewSubscription();
                break;
            case 6:
                System.exit(0);
        }
    }

    private void renewSubscription() {
        int id = getValidIntInput("Enter Subscription ID to renew: ", 1, Integer.MAX_VALUE);
        String newEndDate = getValidDateInput("Enter new end date (YYYY-MM-DD): ");
        ((SubscriptionManager) subscriptionManager).renewSubscription(id, newEndDate);
    }

    private void createSubscription() {
        int userId = getValidIntInput("Enter New Id: ", 1, Integer.MAX_VALUE);
        String user = getValidStringInput("Enter User Name: ");
        String startDate = getValidDateInput("Enter Start date (YYYY-MM-DD): ");
        String endDate = getValidDateInput("Enter End date (YYYY-MM-DD): ");
        String status = getValidOption("Enter Current Status", new String[]{"Active", "Cancelled"});
        String serviceType = getValidOption("Enter Service type", new String[]{"Regular", "Premium"});
        String cycle = getValidOption("Enter Billing Cycle", new String[]{"Monthly", "Annual"});

        ServiceSubscription sub = new ServiceSubscription(userId, user, startDate, endDate, status, serviceType, cycle);
        subscriptionManager.createSubscription(sub);
    }

    private void updateSubscription() {
        int id = getValidIntInput("Enter Subscription ID to update: ", 1, Integer.MAX_VALUE);
        System.out.println("Choose update option:");
        System.out.println("1. Update status");
        System.out.println("2. Upgrade to Premium");

        int updateChoice = getValidIntInput("Enter choice: ", 1, 2);

        switch (updateChoice) {
            case 1:
                String newStatus = getValidOption("Enter new status", new String[]{"Active", "Cancelled"});
                subscriptionManager.updateSubscription(id, newStatus);
                break;
            case 2:
                subscriptionManager.upgradeToPremium(id);
                break;
        }
    }

    private void cancelSubscription() {
        int id = getValidIntInput("Enter Subscription ID to cancel: ", 1, Integer.MAX_VALUE);
        subscriptionManager.cancelSubscription(id);
    }

    private void viewSubscription() {
        int id = getValidIntInput("Enter Subscription ID to view: ", 1, Integer.MAX_VALUE);
        subscriptionManager.viewSubscription(id);
    }

    private int getValidIntInput(int min, int max) {
        while (true) {
            try {
                int input = Integer.parseInt(scanner.nextLine());
                if (input >= min && input <= max) {
                    return input;
                } else {
                    System.out.printf("Please enter a number between %d and %d: ", min, max);
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }

    private int getValidIntInput(String prompt, int min, int max) {
        System.out.print(prompt);
        return getValidIntInput(min, max);
    }

    private String getValidStringInput(String prompt) {
        System.out.print(prompt);
        while (true) {
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            } else {
                System.out.print("Input cannot be empty. Please try again: ");
            }
        }
    }

    private String getValidDateInput(String prompt) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        while (true) {
            String input = getValidStringInput(prompt);
            try {
                LocalDate.parse(input, formatter);
                return input;
            } catch (DateTimeParseException e) {
                System.out.print("Invalid date format. Please use YYYY-MM-DD: ");
            }
        }
    }

    private String getValidOption(String prompt, String[] options) {
        System.out.print(prompt + " (" + String.join("/", options) + "): ");
        while (true) {
            String input = scanner.nextLine().trim();
            for (String option : options) {
                if (option.equalsIgnoreCase(input)) {
                    return option;
                }
            }
            System.out.print("Invalid option. Please choose from " + String.join("/", options) + ": ");
        }
    }
}