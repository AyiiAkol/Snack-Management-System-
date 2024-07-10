import java.util.*;

class Snack {
    private String name;
    private int quantity;
    private double price;

    public Snack(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void addQuantity(int amount) {
        quantity += amount;
    }

    public boolean deductQuantity(int amount) {
        if (quantity >= amount) {
            quantity -= amount;
            return true;
        }
        return false;
    }

    public double getTotalSales() {
        return price * (double) (quantity);
    }
}

public class SnackManagementSystem {
    public static void main(String[] args) {

        List<Snack> snacks = new ArrayList<>();
        snacks.add(new Snack("Chips", 50, 1.5));
        snacks.add(new Snack("Chocolate", 30, 2.0));
        snacks.add(new Snack("Soda", 20, 1.0));
        snacks.add(new Snack("Biscuit", 60, 1.0));
        snacks.add(new Snack("Gum", 100, 0.2));
        snacks.add(new Snack("Water", 80, 0.5));

    
        Scanner scanner = new Scanner(System.in);

        System.out.println("Snack Management System!");
        System.out.println("\nAvailable Snacks:");
        printInventory(snacks);

        while (true) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Buy Snacks");
            System.out.println("2. Exit");

            System.out.print("Enter your choice (1 or 2): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            if (choice == 1) {
            
                System.out.println("\nAvailable Snacks:");
                for (int i = 0; i < snacks.size(); i++) {
                    Snack snack = snacks.get(i);
                    System.out.println((i + 1) + ". " + snack.getName() + " - Quantity: " + snack.getQuantity() + ", Price: $" + snack.getPrice());
                }

            
                System.out.print("\nEnter the number of the snack you'd like to buy: ");
                int snackIndex = scanner.nextInt();
                scanner.nextLine();

                if (snackIndex < 1 || snackIndex > snacks.size()) {
                    System.out.println("Invalid snack number. Choice a valid number.");
                    continue;
                }

                Snack selectedSnack = snacks.get(snackIndex - 1);

            
                System.out.print("Enter the quantity you want to buy: ");
                int quantity = scanner.nextInt();
                scanner.nextLine();

                if (quantity <= 0 || quantity > selectedSnack.getQuantity()) {
                    System.out.println("Invalid quantity. Please try again.");
                    continue;
                }

               
                if (selectedSnack.deductQuantity(quantity)) {
                    System.out.println("\nYou have successfully bought " + quantity + " " + selectedSnack.getName() + "(s).");

                
                    System.out.println("\nUpdated Snack Inventory:");
                    printInventory(snacks);

               
                    double totalSales = 0.0;
                    for (Snack snack : snacks) {
                        totalSales += snack.getTotalSales();
                    }
                    System.out.println("\nTotal Sales: $" + totalSales);
                } else {
                    System.out.println("Not enough quantity available. Please try again.");
                }

            } else if (choice == 2) {
                System.out.println("Thank you for using Snack Management System. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please enter 1 or 2.");
            }
        }

    }

    private static void printInventory(List<Snack> snacks) {
        for (Snack snack : snacks) {
            System.out.println(snack.getName() + " - Quantity: " + snack.getQuantity() + ", Price: $" + snack.getPrice());
        }
    }
}
