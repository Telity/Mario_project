import java.util.*;
import java.io.*;
import java.time.format.*;
import java.text.*;
import java.time.*;

public class OrderList{ 
Pizza menu = new Pizza(); 
Scanner scan = new Scanner(System.in); 
static LocalTime time = LocalTime.of(14, 0); // Initialize time to 14:00 / pizzeria opens at 14. 
static Random random = new Random();
static int count;
  

ArrayList<Pizza> orderList = new ArrayList<Pizza>();
ArrayList<Pizza> savedOrders = new ArrayList<Pizza>();

// creates a new order (time & pizza ID)
public void makeOrder(){
   System.out.println("Is customer calling or ordering in shop (1 for shop, 2 for call)");
            int type = scan.nextInt();
            if(type>2 || type<0){
            System.out.println("Invalid option!");
            }
            while(type == 1 || type == 2){
            if (type == 1) {
                time = time.plusMinutes(15); // Add 15 minutes
                } else if(type == 2) {
                System.out.println("Hello and thank you for calling");
                time = time.plusHours(1); // Add 1 hour
                }
             
   System.out.println("How many pizzas is the customer ordering?");
      int choice = scan.nextInt();
   
   // shows the menu 
   System.out.println("Here is the current menu: "); 
   Pizza.viewMenu();   
   System.out.println(" ");    
      
      double price = 0;
         for(int x = 0;x < choice; x++){
            System.out.println("What number pizza would you like to add to orderlist?");
            int pizzaID = scan.nextInt()-1;
        
            Pizza orgPizza = menu.menuList.get(pizzaID);
               if (orgPizza != null) {
            // Ensure that the Pizza object is properly initialized
                  Pizza pizza = new Pizza(orgPizza.getID(),orgPizza.getName(), orgPizza.getSize(), orgPizza.getToppings(), orgPizza.getPrice());
                  pizza.setTime(time); // Set the time for the pizza order
            
            // Add the pizza to both order lists
                  orderList.add(pizza);
                  savedOrders.add(pizza);
            
            // Calculate the total price
                  price += pizza.getPrice();
            }

      }
      System.out.println("Pizzas will be ready at " + time); 
      System.out.println("The total price is: " + price);
break;
   }
}
// sorts the pizzas by time 
public void sortOrder() {
        Collections.sort(orderList, new Comparator<Pizza>() {
            @Override
            public int compare(Pizza pizza1, Pizza pizza2) {
                return pizza1.getTime().compareTo(pizza2.getTime());
            }
        });
    }

// prints out the orderlist 
public void showOrder(){

   int actualNumber = 1; 

   for(Pizza pizza : orderList){
      pizza.setActualNumber(actualNumber); 
      System.out.print("Number: " + pizza.getActualNumber()); 
      System.out.print(" Name: " + pizza.getName()); 
      System.out.print(" Size: " + pizza.getSize()); 
      System.out.print(" Toppings: " + pizza.getToppings());
      System.out.print(" Time: " + pizza.getTime()); 
      System.out.println(); 
      actualNumber++; 
   }
   
   if(orderList.size() == 0){
   System.out.println("You're fast! There are no current orders");
  }
}

// removes a order from the orderlist 
public void removeOrder(){

System.out.println("Here is the current orderlist:"); 
showOrder(); 

boolean pizzaFundet = false;

System.out.println("How many pizzas would you like to remove from the orderlist?"); 
int antal = scan.nextInt(); 

int i; 

for(i=0; i<antal; i++){
System.out.println("Here is the current orderlist:"); 
   showOrder(); 
System.out.println("What is the number of the pizza you want to remove?"); 
   int nummer = scan.nextInt(); 

for(int j=0; j<orderList.size(); j++){
   Pizza pizza = orderList.get(j); 
   if(pizza.getActualNumber() == nummer){ 
      System.out.println("Pizza number : " + nummer + " " + orderList.get(nummer-1).getName()+" is removed"); 
      orderList.remove(nummer-1); 
      pizzaFundet = true; 
   break; 
   }
}

if(!pizzaFundet){
   System.out.println("Can't find the pizza: " + nummer); 
   
    } 
  }
}

    // count method which is called in fileOrder, tell how many times a pizza name is on list. 
    public static int count(ArrayList<Pizza> list, String name) {
        count = 0;
        for (Pizza pizza : list) {
            if (pizza.getName().equals(name)) {
                count++;
            }
        }
        return count;
    }

// creates a order - writes todays date - writes individual pizza details - sorts pizza by name and occurrences - statistic
public void fileOrder(){
   try{
      File file = new File("savedOrders.txt");
         if(!file.exists()){
            file.createNewFile();
         }
      FileWriter writer = new FileWriter(file,true);
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); // Change date from american system to danish
         String dkDate = LocalDate.now().format(formatter); //Changes date to a string  
            writer.write("Todays date: ["+dkDate+"]\n");
            //sort the pizzas after names
            Collections.sort(savedOrders, new Comparator<Pizza>() {
                  @Override
                     public int compare(Pizza p1, Pizza p2) {
                        return p1.getName().compareTo(p2.getName());
                     }
            });
            
            for(Pizza pizza : savedOrders){
                 writer.write("ID: ["+pizza.getID()+"]  Name: [" + pizza.getName()+ "] Size: ["
                  + pizza.getSize()+ "] Toppings: [" + pizza.getToppings()+"] Price: [" + pizza.getPrice() + "] Time: [" 
                  + pizza.getTime()+"]\n");
                 }
                 writer.write("\n");
            //Statistic for pizza, tells pizza name and how many of that type there is.       
            String[] pizzaNames = new String[savedOrders.size()];
            int[] pizzaCounts = new int[savedOrders.size()];

               int numPizza = 0;

               for (Pizza pizza : savedOrders) {
               String pizzaName = pizza.getName();
               boolean isProcessed = false;
                 // checks if the pizza name is already there
                 for (int i = 0; i < numPizza; i++) {
                     if (pizzaNames[i].equals(pizzaName)) {
                     isProcessed = true;
                     break;
                     }
                     }
               // if a new pizza name comes, this will add it to the arrays, with both name and a number.
               // count method, will add how many times that pizza name have occurred, in the savedOrders arraylist. 
                 if (!isProcessed) {
                     int count = count(savedOrders, pizzaName);
                     pizzaNames[numPizza] = pizzaName;
                     pizzaCounts[numPizza] = count;
                     numPizza++;
                     }
                }  
      writer.write("Data for Statistics \n");
      // Writes the name of the pizza and how many times it have been ordered. 
      for (int i = 0; i < numPizza; i++) {
          writer.write("Number of Pizza " + pizzaNames[i] + " is : " + pizzaCounts[i] + "\n");
      }
      writer.write("\n");
      writer.close();
      }
   catch(Exception e){
      e.printStackTrace();
   }

}
}