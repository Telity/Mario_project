import java.util.*;
import java.io.*;
import java.time.format.*;
import java.text.*;
import java.time.*;
public class OrderList{ 
Pizza menu = new Pizza(); 
Scanner scan = new Scanner(System.in); 
static LocalTime time = LocalTime.of(14, 0); // Initialize time to 14:00
static Random random = new Random();
static int count;
  

ArrayList<Pizza> orderList = new ArrayList<Pizza>();
ArrayList<Pizza> savedOrders = new ArrayList<Pizza>();

public void makeOrder(){
 menu.CreateMenu(); // calls the menu - so we dont run into indexoutofbounds
 System.out.println("Choose if you are calling or ordering in shop (1 for shop, 2 for call)");
            int type = scan.nextInt();

            if (type == 1) {
                time = time.plusMinutes(15); // Add 15 minutes
                }
             else {
                System.out.println("Hello and thank you for calling");
                time = time.plusHours(1); // Add 1 hour
                
               }
         
   
   System.out.println("How many pizzas would you like to order today?");
      int choice = scan.nextInt();
      
      double price = 0;
         for(int x = 0;x < choice; x++){
            System.out.println("what number pizza would you like ?");
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
    
           /* orderList.add(menu.menuList.get(pizza)); // her tilføjes pizza til ordrelisten så Mario kan se dem og de kan fjernes/laves.
            savedOrders.add(menu.menuList.get(pizza)); //Her gemmes pizza bestillinger til senere statistik brug 
            savedOrders.get(x).setTime(time); //Sætter tid på orderene der gemmes til statistik. 
            price = orderList.get(x).getPrice() + price; // finder samlede pris for pizzaerne. 
            orderList.get(x).setTime(time); // Sætter ordre listens pris til tid, så man kan sammenligne tiderne. */

}
System.out.println("Pizzas will be ready at " + time); // viser tiden pizzaen er klar. 
System.out.println("The total price is: " + price);
}
public void sortOrder() {
        Collections.sort(orderList, new Comparator<Pizza>() {
            @Override
            public int compare(Pizza pizza1, Pizza pizza2) {
                return pizza1.getTime().compareTo(pizza2.getTime());
            }
        });
    }


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
}

public void removeOrder(){

boolean pizzaFundet = false; 

System.out.println("What is the number of the pizza you want to remove?"); 
   int nummer = scan.nextInt(); 

for(int i=0; i<orderList.size(); i++){
   Pizza pizza = orderList.get(i); 
   if(pizza.getActualNumber() == nummer){ // i tvivl om denne skal være getID eller getNumber... eller? 
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

/*public static void main(String[] args){

OrderList orderlist = new OrderList(); 

orderlist.makeOrder();
orderlist.sortOrder();
orderlist.showOrder(); 
orderlist.removeOrder(); 

} */
/*public void statistic(){

Collections.sort(savedOrders, new Comparator<Pizza>() {
       @Override
       public int compare(Pizza p1, Pizza p2) {
         return p1.getName().compareTo(p2.getName());
            }
        });
        
        for (Pizza pizza : savedOrders) {
            int number = count(savedOrders, pizza.getName());
            System.out.println("Number of Pizza " + pizza.getName() + "is : " + count);
        }
        
    }*/

    public static int count(ArrayList<Pizza> list, String name) {
        count = 0;
        for (Pizza pizza : list) {
            if (pizza.getName().equals(name)) {
                count++;
            }
        }
        return count;
    }

public void fileOrder(){
   try{
      File file = new File("savedOrders.txt");
         if(!file.exists()){
            file.createNewFile();
         }
      FileWriter writer = new FileWriter(file,true);
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); // ænder datoen fra amerikans order til dansk
         String dkDate = LocalDate.now().format(formatter); //ændre datoen til en string. 
            writer.write("Todays date: ["+dkDate+"]\n");
            //writer.write("\n");
            for(Pizza pizza : savedOrders){
                 writer.write("ID: ["+pizza.getID()+"]  Name: [" + pizza.getName()+ "] Size: ["
                  + pizza.getSize()+ "] Toppings: [" + pizza.getToppings()+"] Price: [" + pizza.getPrice() + "] Time: [" 
                  + pizza.getTime()+"]\n");
                 //writer.write("\n");
                 //writer.close();
                 }
                 writer.write("\n");
                 Collections.sort(savedOrders, new Comparator<Pizza>() {
       @Override
       public int compare(Pizza p1, Pizza p2) {
         return p1.getName().compareTo(p2.getName());
            }
        });
      String[] pizzaNames = new String[savedOrders.size()];
      int[] pizzaCounts = new int[savedOrders.size()];

         int numPizza = 0;

         for (Pizza pizza : savedOrders) {
               String pizzaName = pizza.getName();
    
    // Tjekker om pizza navnet allerede har været der
          boolean isProcessed = false;
            for (int i = 0; i < numPizza; i++) {
                  if (pizzaNames[i].equals(pizzaName)) {
                   isProcessed = true;
                   break;
        }
    }
    
    // hvis en pizza ikke har været der, vil 
    if (!isProcessed) {
        int count = count(savedOrders, pizzaName);
        pizzaNames[numPizza] = pizzaName;
        pizzaCounts[numPizza] = count;
        numPizza++;
    }
}
writer.write("Data for Statistics \n");
// Write the count for each unique pizza name
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