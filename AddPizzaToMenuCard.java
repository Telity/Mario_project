import java.util.Scanner;

class PizzaAdd {    

   private double price; 
   private String name; 
   private int ID;
   private String size; 
   private String topping; 
   
   // Constructor 
   public PizzaAdd(int ID, String name, String size, String topping, double price){
      this.price = price; 
      this.name = name;
      this.ID = ID; 
      this.topping = topping; 
      this.size = size; 
   }
   
   // Getters 
   public double getPrice(){
      return price; 
   }

   public String getName(){
      return name; 
   }

   public String getSize(){
      return size; 
   }

   public String getTopping(){
      return topping; 
   }

   public int getID(){
      return ID; 
   }

   // Setters
   public void setPrice(double price){
      this.price=price; 
   }

   public void setName(String name){
      this.name=name; 
   }

   public void setSize(String size){
      this.size=size; 
   }
   
   public void setTopping(String topping){
      this.topping=topping; 
   }

   public void setID(int ID){
      this.ID=ID; 
   }

   // Method to add new pizza to menu card
   public static PizzaAdd MakeNewPizzaToMenuCard() {
       Scanner scanner = new Scanner(System.in);
       
       System.out.println("Enter the name of the pizza:");
       String name = scanner.nextLine();
       
       System.out.println("Enter the size of the pizza:");
       String size = scanner.nextLine();
       
       System.out.println("Enter the topping of the pizza:");
       String topping = scanner.nextLine();
       
       System.out.println("Enter the price of the pizza:");
       double price = scanner.nextDouble();
       
       System.out.println("Enter the ID of the pizza:");
       int ID = scanner.nextInt();
       
       return new PizzaAdd(ID, name, size, topping, price);
   }
   
   public static void main(String[] args) {
       PizzaAdd pizza = MakeNewPizzaToMenuCard();
       System.out.println(pizza.getName() + " has been added to the menu card.");
   }
}
