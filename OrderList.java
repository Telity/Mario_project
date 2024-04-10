public class OrderList{ 


ArrayList<Pizza> menuList = new ArrayList<Pizza>(); 

// id navn størrelse pris 
public void menu(){
menuList.add(new Pizza(1,"Pepperoni Paradise", "normal", "cheese, sauce, pepperoni",70);
menuList.add(new Pizza(2,"Margherita Marvel", "normal" ,"cheese, sauce, ham", 70,); 
menuList.add(new Pizza(3,"Supreme Sensation", "normal" ,"cheese, sauce, shrimp", 70,);
menuList.add(new Pizza(4,"BBQ Bonanza", "normal","cheese, sauce, tuna", 70,); 
menuList.add(new Pizza(5,"Veggie Delight", "normal", "cheese, sauce, peber",70);
menuList.add(new Pizza(6,"Meat Lovers Madness", "normal","cheese, sauce, meatballs", 70); 
menuList.add(new Pizza(7,"Hawaiian Heaven", "normal", "cheese, sauce, pineapple",70);
menuList.add(new Pizza(8,"Buffalo Blast", "normal", "cheese, sauce, chicken",70); 
menuList.add(new Pizza(9,"Mediterranea Magic", "normal","cheese, sauce, olives", 70);
menuList.add(new Pizza(10,"Pesto Perfection", "normal", "cheese, sauce, pesto",80); 
menuList.add(new Pizza(11,"Four Cheese Fiesta", "normal", "cheese, sauce, gonzola",80);
menuList.add(new Pizza(12,"Taco Twist", "normal", "cheese, sauce, salsa", 80); 
menuList.add(new Pizza(13,"Bacon Bliss", "normal", "cheese, sauce, bacon", 80);
menuList.add(new Pizza(14,"Spinach Spectacular", "normal", "cheese, sauce, spinach", 80); 
menuList.add(new Pizza(15,"Chiciken Caeser Crunch", "normal","cheese, sauce, bread", 80);
menuList.add(new Pizza(16,"Philly Cheesesteak Supreme", "normal","cheese, sauce, steak",80); 
menuList.add(new Pizza(17,"Garden Harvest", "normal", "cheese, sauce, eggplant",80);
menuList.add(new Pizza(18,"Spicy Sausage Surpirce ", "normal","cheese, sauce, sausage", 80); 
menuList.add(new Pizza(19,"White Pizza Wonder", "normal", "cheese, sauce, ranch",80);
menuList.add(new Pizza(20,"Truffle Temptation", "normal", "cheese, sauce, truffle",80); 
menuList.add(new Pizza(21,"Artichoke Amore", "normal", "cheese, sauce, artichoke",80);
menuList.add(new Pizza(22,"Caprese Classic", "normal", "cheese, sauce, basil",90); 
menuList.add(new Pizza(23,"Seafood Sensation", "normal","cheese, sauce, clams", 90);
menuList.add(new Pizza(24,"Ranch Rupture", "normal", "cheese, sauce, ranch",90);
menuList.add(new Pizza(25,"Greek Goddess", "normal", "cheese, sauce, feta",90);
menuList.add(new Pizza(26,"Sicillian Sizzle", "normal", "cheese, sauce, jamon",90); 
menuList.add(new Pizza(27,"Roasted Red Pepper Romance", "normal", "cheese, sauce, pepper",90);
menuList.add(new Pizza(28,"Meatball Madness", "normal", "cheese, sauce, meatballs",90); 
menuList.add(new Pizza(29,"Rustic Roasted Vegetable", "normal","cheese, sauce, potato", 90);
menuList.add(new Pizza(30,"Alfonso Dream", "normal", "cheese, sauce, gold",90); 
menuList.add(new Pizza(31,"Mario Supreme", "normal", "cheese, sauce, mario special sauce",90);
}

public void showMenu(){
for(Pizza pizza : menuList){
System.out.println("Number: " + pizza.getId()); 
System.out.println("Name: " + pizza.getName()); 
System.out.println("Size: " + pizza.getSize()); 
System.out.println("Toppings: " + pizza.getToppings());
System.out.println("Price : " + pizza.getPrice()); 
System.out.println(); 





}