public class Main {
    public static void main(String[] args) {
        boolean needToRerun = true;

        while (needToRerun) {
            try {
                UserInterface ui = new UserInterface();
                ui.getUserInput();
                needToRerun = false;
            } catch (Exception e) {
                System.out.println("An error occurred. Please try Again. ");
        }
    }
}
}
