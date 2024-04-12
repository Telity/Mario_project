import java.util.Scanner;

//UI is only a collection method. you need to use a different file to acces everything.

public class Ui {
   public Ui() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the UI");
            System.out.println("1: Look at the current orders");
            System.out.println("2: Add order");
            System.out.println("**OPTIONIAL*** 3: Remove order");
            System.out.println("***OPTIONIAL** 4: Save sale statistics of the day");
            System.out.println("5: See menu card");
            System.out.println("6: Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Call method to view current orders
                    break;
                case 2:
                    // Call method to add order
                    break;
                case 3:
                    // Call method to remove order
                    break;
                case 4:
                    // Call method to save sale statistics of the day
                    break;
                case 5:
                    // Call method to see menu card
                    break;
                case 6:
                    System.out.println("Exiting UI. Have a great day");
                    System.exit(0);
                default:
                    System.out.println("Invalid input");
            }
        }
   }
}
