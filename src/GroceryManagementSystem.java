import java.io.IOException;
public class GroceryManagementSystem {
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();

        GroceryItem apple = new GroceryItem("Apple", 1.0, Category.FRUIT);
        GroceryItem carrot = new GroceryItem("Carrot", 0.5, Category.VEGETABLE);

        inventoryManager.addItem(apple, 10);
        inventoryManager.addItem(carrot, 20);

        inventoryManager.displayInventory();

        try {
            inventoryManager.removeItem(apple, 5);
            inventoryManager.removeItem(carrot, 25); // This will throw an exception
        } catch (InventoryException e) {
            System.out.println("Inventory Exception: " + e.getMessage());
        }

        inventoryManager.displayInventory();

        try {
            inventoryManager.writeInventoryToFile("inventory.txt");
            System.out.println("Inventory written to file successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}



