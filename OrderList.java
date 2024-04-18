import java.util.*;
import java.io.*;
import java.time.format.*;
import java.time.*;

public class OrderList {
    Pizza menu = new Pizza();
    Scanner scan = new Scanner(System.in);
    static LocalTime time = LocalTime.of(14, 0); // Initialize time to 14:00 (pizzeria opens at 14:00)
    static Random random = new Random();
    static int count;

    ArrayList<Pizza> orderList = new ArrayList<Pizza>();
    ArrayList<Pizza> savedOrders = new ArrayList<Pizza>();

    // Creates a new order (time & pizza ID)
    public void makeOrder() {
        System.out.println("Is the customer ordering in the shop or calling? (1 for shop, 2 for call)");
        int type = scan.nextInt();
        if (type > 2 || type < 0) {
            System.out.println("Invalid option!");
        }
        while (type == 1 || type == 2) {
            if (type == 1) {
                time = time.plusMinutes(15); // Add 15 minutes
            } else if (type == 2) {
                System.out.println("Hello and thank you for calling");
                time = time.plusHours(1); // Add 1 hour
            }
            System.out.println("How many pizzas is the customer ordering?");
            int choice = scan.nextInt();

            // Display the menu
            System.out.println("Here is the current menu: ");
            Pizza.viewMenu();
            System.out.println();

            boolean invalid = true;
            double price = 0;
            for (int x = 0; x < choice; x++) {
                System.out.println("Which pizza number would you like to add to the order list?");
                int pizzaID = scan.nextInt() - 1;
                if (pizzaID < 0 || pizzaID >= menu.menuList.size()) {
                    System.out.println("Sorry, that pizza is not on the menu. Please try again.");
                    invalid = false;
                    break;
                }

                Pizza orgPizza = menu.menuList.get(pizzaID);
                if (orgPizza != null) {
                    // Ensure that the Pizza object is properly initialized
                    Pizza pizza = new Pizza(orgPizza.getID(), orgPizza.getName(), orgPizza.getSize(),
                            orgPizza.getToppings(), orgPizza.getPrice());
                    pizza.setTime(time); // Set the time for the pizza order

                    // Add the pizza to both order lists
                    orderList.add(pizza);
                    savedOrders.add(pizza);

                    // Calculate the total price
                    price += pizza.getPrice();
                }

            }
            if (!invalid) {
                break;
            }
            System.out.println("Pizzas will be ready at " + time);
            System.out.println("The total price is: " + price);
            break;
        }
    }

    // Sorts the pizzas by time
    public void sortOrder() {
        Collections.sort(orderList, new Comparator<Pizza>() {
            @Override
            public int compare(Pizza pizza1, Pizza pizza2) {
                return pizza1.getTime().compareTo(pizza2.getTime());
            }
        });
    }

    // Prints out the order list
    public void showOrder() {
        int actualNumber = 1;

        for (Pizza pizza : orderList) {
            pizza.setActualNumber(actualNumber);
            System.out.print("Number: " + pizza.getActualNumber());
            System.out.print(" Name: " + pizza.getName());
            System.out.print(" Size: " + pizza.getSize());
            System.out.print(" Toppings: " + pizza.getToppings());
            System.out.print(" Time: " + pizza.getTime());
            System.out.println();
            actualNumber++;
        }

        if (orderList.size() == 0) {
            System.out.println("You're fast! There are no current orders");
        }
    }

    // Removes an order from the order list
    public void removeOrder() {
        System.out.println("Here is the current order list:");
        showOrder();

        boolean pizzaFound = false;

        System.out.println("How many pizzas would you like to remove from the order list?");
        int amount = scan.nextInt();

        for (int i = 0; i < amount; i++) {
            System.out.println("Here is the current order list:");
            showOrder();
            System.out.println("What is the number of the pizza you want to remove?");
            int number = scan.nextInt();

            for (int j = 0; j < orderList.size(); j++) {
                Pizza pizza = orderList.get(j);
                if (pizza.getActualNumber() == number) {
                    System.out.println("Pizza number: " + number + " " + orderList.get(number - 1).getName()
                            + " has been removed");
                    orderList.remove(number - 1);
                    pizzaFound = true;
                    break;
                }
            }

            if (!pizzaFound) {
                System.out.println("Cannot find pizza: " + number);
            }
        }
    }

    // Count method which is called in fileOrder, tells how many times a pizza name is on the list
    public static int count(ArrayList<Pizza> list, String name) {
        count = 0;
        for (Pizza pizza : list) {
            if (pizza.getName().equals(name)) {
                count++;
            }
        }
        return count;
    }

    // Creates an order - writes today's date - writes individual pizza details - sorts pizza by name and occurrences -
    // statistic
    public void fileOrder() {
        try {
            File file = new File("savedOrders.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter writer = new FileWriter(file, true);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String dkDate = LocalDate.now().format(formatter);
            writer.write("Today's date: [" + dkDate + "]\n");

            // Sort the pizzas by names
            Collections.sort(savedOrders, new Comparator<Pizza>() {
                @Override
                public int compare(Pizza p1, Pizza p2) {
                    return p1.getName().compareTo(p2.getName());
                }
            });

            for (Pizza pizza : savedOrders) {
                writer.write("ID: [" + pizza.getID() + "]  Name: [" + pizza.getName() + "] Size: [" + pizza.getSize()
                        + "] Toppings: [" + pizza.getToppings() + "] Price: [" + pizza.getPrice() + "] Time: ["
                        + pizza.getTime() + "]\n");
            }
            writer.write("\n");

            // Statistics for pizza, tells pizza name and how many of that type there is
            String[] pizzaNames = new String[savedOrders.size()];
            int[] pizzaCounts = new int[savedOrders.size()];

            int numPizza = 0;

            for (Pizza pizza : savedOrders) {
                String pizzaName = pizza.getName();
                boolean isProcessed = false;

                for (int i = 0; i < numPizza; i++) {
                    if (pizzaNames[i].equals(pizzaName)) {
                        isProcessed = true;
                        break;
                    }
                }

                if (!isProcessed) {
                    int count = count(savedOrders, pizzaName);
                    pizzaNames[numPizza] = pizzaName;
                    pizzaCounts[numPizza] = count;
                    numPizza++;
                }
            }

            writer.write("Data for Statistics\n");
            for (int i = 0; i < numPizza; i++) {
                writer.write("Number of " + pizzaNames[i] + " ordered: " + pizzaCounts[i] + "\n");
            }
            writer.write("\n");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}