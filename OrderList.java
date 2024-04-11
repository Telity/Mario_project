public class OrderList{ 

Scanner scan = new Scanner(System.in); 

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