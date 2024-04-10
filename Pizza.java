public class Pizza{    

   private double price; 
   private String name; 
   private int ID;
   private String size; 
   private String topping; 
   
   // konstruktør 
   public Pizza(int ID, String name, String size, String topping, double price){
      this.price = price; 
      this.name = name;
      this.ID = ID; 
      this.topping = topping; 
      this.size = size; 
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
      
   public String getTopping(){
      return topping; 
      
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
   
   public void setTopping(String topping){
      this.topping=topping; 
   
}

   public void setID(int ID){
      this.ID=ID; 
}

}