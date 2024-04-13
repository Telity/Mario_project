import java.util.*;
import java.io.*;
import java.time.format.*;
import java.text.*;
import java.time.*;
// pizza class where all pizzas methods and menu methods
public class Pizza{    
   
      private double price; 
      private String name; 
      private int ID;
      private String size; 
      private String toppings; 
      private LocalTime time = LocalTime.of(14, 0);
      private int actualNumber;
      static int Line = 0; 
      
      
      // constructor
      public Pizza(int ID, String name, String size, String toppings, double price){
         this.price = price; 
         this.name = name;
         this.ID = ID; 
         this.toppings = toppings; 
         this.size = size; 
   }
      // default constructor
      public Pizza(){
      
      }
      // getters 
      public double getPrice(){
         return price; 
   }
      public String getName(){
         return name; 
   }
      public String getSize(){
         return size; 
   }
      public String getToppings(){
         return toppings;      
   }
      public int getID(){
         return ID; 
   }
      public void setPrice(double price){
         this.price=price; 
   }
   
      public void setName(String name){
         this.name=name; 
   }
   
      public void setSize(String size){
         this.size=size; 
   }
      public void setToppings(String toppings){
         this.toppings=toppings;   
   }
      public void setID(int ID){
         this.ID=ID; 
   }
      public void setTime(LocalTime time){
         this.time = time;
   }
      public LocalTime getTime(){
         return time; 
   }
      public void setActualNumber(int actualNumber){
         this.actualNumber = actualNumber;   
   }
      public int getActualNumber(){
         return actualNumber;   
   }
      //public void toString(){ // id name size toppins price time
       //System.out.println("Order : Id: ["+ID+"] Pizza: ["+name+"] Size: ["+size+"] Toppings: ["+toppings+"] Price: ["+price+"] Time: ["+time+"]"); 
         
       /* public String toString(){ // id name size toppins price time
        String menuString = "Menu:\n";
            for (Pizza pizza : menuList) {
            menuString += pizza.toString() + "\n";
    }
        return menuString;
    }*/
   //}
     
   //an array for the menu
   static ArrayList<Pizza> menuList = new ArrayList<Pizza>();
   // ID Name Size Toppings Price 
   //a method to call all pizzas
   public static void CreateMenu(){
      menuList.add(new Pizza(1,"Pepperoni Paradise", "normal", "cheese, sauce, pepperoni",70));
      menuList.add(new Pizza(2,"Margherita Marvel", "normal" ,"cheese, sauce, ham", 70)); 
      menuList.add(new Pizza(3,"Supreme Sensation", "normal" ,"cheese, sauce, shrimp", 70));
      menuList.add(new Pizza(4,"BBQ Bonanza", "normal","cheese, sauce, tuna", 70)); 
      menuList.add(new Pizza(5,"Veggie Delight", "normal", "cheese, sauce, peber",70));
      menuList.add(new Pizza(6,"Meat Lovers Madness", "normal","cheese, sauce, meatballs", 70)); 
      menuList.add(new Pizza(7,"Hawaiian Heaven", "normal", "cheese, sauce, pineapple",70));
      menuList.add(new Pizza(8,"Buffalo Blast", "normal", "cheese, sauce, chicken",70)); 
      menuList.add(new Pizza(9,"Mediterranea Magic", "normal","cheese, sauce, olives", 70));
      menuList.add(new Pizza(10,"Pesto Perfection", "normal", "cheese, sauce, pesto",80)); 
      menuList.add(new Pizza(11,"Four Cheese Fiesta", "normal", "cheese, sauce, gonzola",80));
      menuList.add(new Pizza(12,"Taco Twist", "normal", "cheese, sauce, salsa", 80)); 
      menuList.add(new Pizza(13,"Bacon Bliss", "normal", "cheese, sauce, bacon", 80));
      menuList.add(new Pizza(14,"Spinach Spectacular", "normal", "cheese, sauce, spinach", 80)); 
      menuList.add(new Pizza(15,"Chiciken Caeser Crunch", "normal","cheese, sauce, bread", 80));
      menuList.add(new Pizza(16,"Philly Cheesesteak Supreme", "normal","cheese, sauce, steak",80)); 
      menuList.add(new Pizza(17,"Garden Harvest", "normal", "cheese, sauce, eggplant",80));
      menuList.add(new Pizza(18,"Spicy Sausage Surpirce ", "normal","cheese, sauce, sausage", 80)); 
      menuList.add(new Pizza(19,"White Pizza Wonder", "normal", "cheese, sauce, ranch",80));
      menuList.add(new Pizza(20,"Truffle Temptation", "normal", "cheese, sauce, truffle",80)); 
      menuList.add(new Pizza(21,"Artichoke Amore", "normal", "cheese, sauce, artichoke",80));
      menuList.add(new Pizza(22,"Caprese Classic", "normal", "cheese, sauce, basil",90)); 
      menuList.add(new Pizza(23,"Seafood Sensation", "normal","cheese, sauce, clams", 90));
      menuList.add(new Pizza(24,"Ranch Rupture", "normal", "cheese, sauce, ranch",90));
      menuList.add(new Pizza(25,"Greek Goddess", "normal", "cheese, sauce, feta",90));
      menuList.add(new Pizza(26,"Sicillian Sizzle", "normal", "cheese, sauce, jamon",90)); 
      menuList.add(new Pizza(27,"Roasted Red Pepper Romance", "normal", "cheese, sauce, pepper",90));
      menuList.add(new Pizza(28,"Meatball Madness", "normal", "cheese, sauce, meatballs",90)); 
      menuList.add(new Pizza(29,"Rustic Roasted Vegetable", "normal","cheese, sauce, potato", 90));
      menuList.add(new Pizza(30,"Alfonso Dream", "normal", "cheese, sauce, gold",90)); 
      menuList.add(new Pizza(31,"Mario Supreme", "normal", "cheese, sauce, mario special sauce",90));
   }//menu
   //make a new pizza to the menu
   public static void pizzaAdd() {
       Scanner scanner = new Scanner(System.in);
       
       //int ID =menuList.size()+1;
       
       System.out.println("Enter the name of the pizza:");
       String name = scanner.nextLine();
       
       System.out.println("Enter the size of the pizza:");
       String size = scanner.nextLine();
       
       System.out.println("Enter the topping of the pizza:");
       String toppings = scanner.nextLine();
       
       System.out.println("Enter the price of the pizza:");
       double price = scanner.nextDouble();
       
       try{
       File file = new File("Menu.txt");
       Scanner sc = new Scanner(file);
       while(sc.hasNextLine()){
         sc.nextLine();
         Line++;
       }
       sc.close();
       } catch(Exception e){
         e.getStackTrace();
       }
       int ID =Line;
       boolean pizzaExists = false;
       for(Pizza pizza : menuList){
         if(pizza.getName().equalsIgnoreCase(name) &&
            pizza.getSize().equalsIgnoreCase(size) &&
            pizza.getToppings().equalsIgnoreCase(toppings) && 
            pizza.getPrice() ==price){
            pizzaExists = true;
            System.out.println("This pizza already Exists in the menu");
            break;
            }
       }
       if(!pizzaExists){
         menuList.add(new Pizza(ID, name, size, toppings, price));
       }
   }//addpizza

   
   //makes a file and if the file already exists do nothing
   public static void CreateMenuFile() {
      try{
         File myObj = new File("Menu.txt");
         if(myObj.createNewFile()){
            System.out.println("File Created: "+ myObj.getName());
         } else{
            System.out.println();
         }
      
      } catch (IOException e) {
         System.out.println("An error occured");
         e.printStackTrace();
      }
   
   }//createmenu
   //type a new pizza into the menu
   public static void WritetoMenu(){
      try{
         FileWriter myWriter = new FileWriter("Menu.txt",true);
         //myWriter.write("ID|  Pizza Name  |  Size  |  Toppings |  Price\n");
         for(Pizza pizza : menuList){
            boolean pizzaExistsInFile = false;
            File file = new File("Menu.txt");
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()){
               String line = fileScanner.nextLine();
               if(line.contains(pizza.getName()) &&
                  line.contains(pizza.getSize()) &&
                  line.contains(pizza.getToppings()) &&
                  line.contains(Double.toString(pizza.getPrice()))){
                  pizzaExistsInFile = true;
                  break;
                  }
                  
            }
            fileScanner.close();
            if(!pizzaExistsInFile){
            myWriter.write(pizza.getID()+" | "+pizza.getName()+" | "+pizza.getSize()+" | "+pizza.getToppings()+" | "+pizza.getPrice()+"\n");
         }
         }
         myWriter.close();
      
      } catch(IOException e){
         System.out.println("An error occured");
         e.printStackTrace();
      }
      }//write to menu
   public static void AddtoMenu(){
      try{
         FileWriter myWriter = new FileWriter("Menu.txt", true);
         Pizza pizza = menuList.get(menuList.size()-1);
         myWriter.write(pizza.getID()+" | "+pizza.getName()+" | "+pizza.getSize()+" | "+pizza.getToppings()+" | "+pizza.getPrice()+"\n");
         myWriter.close();
         System.out.println("Successfully added a pizza to the menucard");
      
      } catch(IOException e){
         System.out.println("An error occured");
         e.printStackTrace();
      }

   }//addtomenu
   //reads the menu in a file
   public static void viewMenu(){
      try {
         File myObj = new File("Menu.txt");
         Scanner myReader = new Scanner(myObj);
         while (myReader.hasNextLine()){
            String menuData = myReader.nextLine();
            System.out.println(menuData);   
         }   
         myReader.close();
      } catch (FileNotFoundException e){
         System.out.println("An error occured");
         e.printStackTrace();
      }
   }//viewmenu
   public static void StartUp(){
      CreateMenu();
      CreateMenuFile();
      WritetoMenu();
      viewMenu();
   }//Menu
   public static void AddPizza(){
      pizzaAdd();
      WritetoMenu();
   }//AddPizza
   
   /*public static void main (String[]args){
        StartUp();        
        AddPizza();
        viewMenu();
   }*/
}//class