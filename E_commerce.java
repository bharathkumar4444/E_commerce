
import java.util.LinkedList;
import java.util.Scanner;

class Item {

    String name;
    int quantity;
    double price;

    Item(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public double getTotal() {
        return quantity * price;
    }

    @Override
    public String toString() {
        return name + " [Quantity: " + quantity + ", Price: " + price + ", Total: " + getTotal() + "]";
    }
}

public class E_commerce {

    public static void main(String[] args) {

        LinkedList<Item> cart = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("MINI PROJECT - E-COMMERCE WEBSITE");

        while (true) {

            System.out.println("\nShopping Cart Menu");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Update Quantity and Price");
            System.out.println("4. View First Added Item");
            System.out.println("5. View Last Added Item");
            System.out.println("6. View All Items and Total Bill");
            System.out.println("7. Clear the Cart");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Clear newline

            switch (choice) {

                case 1:

                    System.out.print("Enter item name: ");
                    String itemAdd = sc.nextLine();

                    System.out.print("Enter quantity: ");
                    int itemQuantity = sc.nextInt();

                    System.out.print("Enter price: ");
                    double itemPrice = sc.nextDouble();
                    sc.nextLine();

                    cart.add(new Item(itemAdd, itemQuantity, itemPrice));

                    System.out.println("Item added successfully.");
                    break;

                case 2:

                    if (!cart.isEmpty()) {

                        System.out.print("Enter item to remove: ");
                        String itemRemove = sc.nextLine();

                        boolean isRemoved =
                                cart.removeIf(item -> item.name.equalsIgnoreCase(itemRemove));

                        if (isRemoved) {
                            System.out.println(
                                    itemRemove + " removed successfully.");
                        } else {
                            System.out.println(
                                    itemRemove + " not found.");
                        }

                    } else {
                        System.out.println("Cart is empty.");
                    }

                    break;

                case 3:

                    if (!cart.isEmpty()) {

                        System.out.print("Enter item to update: ");
                        String updateItem = sc.nextLine();

                        boolean isFound = false;

                        for (Item item : cart) {

                            if (item.name.equalsIgnoreCase(updateItem)) {

                                System.out.print("Enter updated quantity: ");
                                item.quantity = sc.nextInt();

                                System.out.print("Enter updated price: ");
                                item.price = sc.nextDouble();

                                sc.nextLine();

                                System.out.println("Item updated successfully.");

                                isFound = true;
                                break;
                            }
                        }

                        if (!isFound) {
                            System.out.println("Item not found.");
                        }

                    } else {
                        System.out.println("Cart is empty.");
                    }

                    break;

                case 4:

                    if (!cart.isEmpty()) {

                        System.out.println(
                                "First added item: " + cart.getFirst());

                    } else {
                        System.out.println("Cart is empty.");
                    }

                    break;

                case 5:

                    if (!cart.isEmpty()) {

                        System.out.println(
                                "Last added item: " + cart.getLast());

                    } else {
                        System.out.println("Cart is empty.");
                    }

                    break;

                case 6:

                    if (cart.isEmpty()) {

                        System.out.println("Cart is empty.");

                    } else {

                        double total = 0;

                        System.out.println("\nItems in the cart:");

                        for (Item item : cart) {

                            System.out.println(item);

                            total += item.getTotal();
                        }

                        System.out.println("-------------------------");
                        System.out.println("Total Bill: ₹" + total);
                    }

                    break;

                case 7:

                    if (!cart.isEmpty()) {

                        cart.clear();

                        System.out.println(
                                "All items are cleared from the cart.");

                    } else {
                        System.out.println("Cart is already empty.");
                    }

                    break;

                case 8:

                    System.out.println("Thanks for shopping!");

                    sc.close();

                    return;

                default:

                    System.out.println(
                            "Invalid number. Please try again!");
            }
        }
    }
}