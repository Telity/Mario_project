import java.util.*;
import java.io.*;

public class Customer{
Menu menu = new Menu();
Random random = new Random();
Scanner sc = new Scanner(System.in); 
private int time;

public int getTime(){ 
   int choice = random.nextInt(1,3);
      if(choice != 1){
         time = 15; 
      }
      else{
         time = random.nextInt(30,61);
      }
   return time;
}

public int choosePizza(){
   int choice;
   if(time> 15){
      System.out.println("Hello im calling to order a Pizza");
      System.out.println("Hello, yes that is fine, What number pizza you want?");
      choice = sc.nextInt();
      System.out.println("i would like a " + menu.menuList.get(choice));
      System.out.println("i will be there in " + time +" min");
   }
   else{
      System.out.println("Hello, What number pizza you want?");
      choice = sc.nextInt();
      System.out.println("i would like a " + menu.menuList.get(choice));
      System.out.println("it will be ready in " + time +" min");
   }
return choice; 
}
}