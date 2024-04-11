import java.util.Scanner;

public class Ui{
public static void main (String[] args) {
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
      //call order list with a method
      //break;
      case 2: 
      //add order to list with a method
      //break;
      case 3: 
      //remove order with a method;
      //break;
      case 4: 
      //save sales statistics of the day in a new folder using relative path
      //break;
      case 5: 
      //call method to see menu card
      //break;
      case 6: 
      System.out.println("Exiting UI. Have a great day");
      System.exit(0);
      default:
      System.out.println("Invalid input");
      }
   }
}
}













}