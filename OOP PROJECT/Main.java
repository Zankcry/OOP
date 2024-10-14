public class Main {
    public static void main(String[] args) {
        boolean run = true;

        while (run) {
            try {
                UserInterface ui = new UserInterface();
                ui.getUserInput();
                run = false;
            } catch (Exception e) {
                System.out.println("An error occurred. Please try Again. ");
        }
    }
}
}
