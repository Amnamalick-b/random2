import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class InventoryManager {
    private Map<GroceryItem, Integer> inventory;

    public InventoryManager() {
        inventory = new HashMap<>();
    }

    public void addItem(GroceryItem item, int quantity) {
        inventory.put(item, inventory.getOrDefault(item, 0) + quantity);
    }

    public void removeItem(GroceryItem item, int quantity) throws InventoryException {
        if (inventory.containsKey(item)) {
            int currentQuantity = inventory.get(item);
            if (currentQuantity >= quantity) {
                inventory.put(item, currentQuantity - quantity);
            } else {
                throw new InventoryException("Insufficient quantity in the inventory.");
            }
        } else {
            throw new InventoryException("Item not found in the inventory.");
        }
    }

    public void displayInventory() {
        System.out.println("Inventory:");
        for (Map.Entry<GroceryItem, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey().getName() + " - Quantity: " + entry.getValue());
        }
    }

    public void writeInventoryToFile(String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Map.Entry<GroceryItem, Integer> entry : inventory.entrySet()) {
                writer.write(entry.getKey().getName() + "," + entry.getValue() + "\n");
            }
        }
    }
}


