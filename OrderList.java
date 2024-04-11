import java.util.*;
import java.io.*;
import java.time.format.*;
import java.text.*;
import java.time.*;
public class OrderList{ 
Pizza menu = new Pizza(); 
Scanner scan = new Scanner(System.in); 
static LocalTime time = LocalTime.of(14, 0); // Initialize time to 14:00
static int up = 0;
static Random random = new Random();
  

ArrayList<Pizza> orderList = new ArrayList<Pizza>();
ArrayList<Pizza> savedOrders = new ArrayList<Pizza>();
public void makeOrder(){
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
            int pizza = scan.nextInt();
            orderList.add(menu.menuList.get(pizza)); // her tilføjes pizza til ordrelisten så Mario kan se dem og de kan fjernes/laves.
            savedOrders.add(menu.menuList.get(pizza)); //Her gemmes pizza bestillinger til senere statistik brug 
            price = orderList.get(x).getPrice() + price; // finder samlede pris for pizzaerne. 
            System.out.println("Pizza will be ready at " + time); // viser tiden pizzaen er klar. 
            orderList.get(x).setTime(time); // Sætter ordre listens pris til tid, så man kan sammenligne tiderne. 

}
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
pizza.setID(actualNumber); 
System.out.println("Number: " + pizza.getID()); 
System.out.println("Name: " + pizza.getName()); 
System.out.println("Size: " + pizza.getSize()); 
System.out.println("Time: " + pizza.getTime()); 
System.out.println(); 
actualNumber++; 
}
}

public void removeOrder(){

boolean pizzaFundet = false; 

System.out.println("Hvad er nummeret på pizzaen du gerne vil fjerne?"); 
   int nummer = scan.nextInt(); 

for(int i=0; i<orderList.size(); i++){
   Pizza pizza = orderList.get(i); 
   if(pizza.getID() == nummer){ // i tvivl om denne skal være getID eller getNumber... eller? 
      orderList.remove(i); 
      pizzaFundet = true; 
   System.out.println("Pizza nummer : " + nummer + " er fjernet"); 
break; 
   }
}
if(!pizzaFundet){
   System.out.println("Kunne ikke finde pizza : " + nummer); 
   
   } 
  }




}