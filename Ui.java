import java.util.Scanner;

//UI is only a collection method. you need to use a different file to acces everything.

public class Ui {
   public Ui() {
      Scanner scanner = new Scanner(System.in);
      OrderList orderList = new OrderList();
      Pizza pizza = new Pizza();
      pizza.StartUp();

      while (true) {
         System.out.println("\n");
         System.out.println("Welcome to the UI");
         System.out.println("1: Look at the current orders");
         System.out.println("2: Add order");
         System.out.println("3: Remove order");
         System.out.println("4: View menu card");
         System.out.println("5: Add pizza to the menu card");
         System.out.println("6: Exit");

         int choice = scanner.nextInt();

         switch (choice) {
            case 1: // Look at Current orders
               orderList.showOrder();
               orderList.sortOrder();
               break;
            case 2:// Add order
               orderList.makeOrder();
               orderList.showOrder();
               break;
            case 3:// Remove order
               orderList.removeOrder();
               break;
            case 4:// View menu card
               pizza.viewMenu();
               break;
            case 5:// add pizza to the menu card
               pizza.AddPizza();
               break;
            case 6://exits and files order 
               System.out.println("Exiting UI. Have a great day");
               orderList.fileOrder();
               System.exit(0);
            default:
               System.out.println("Invalid input");
         }
      }
   }
}