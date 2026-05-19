import java.util.List;

public class Inventory<T extends Supplies> {
    private List<T> inventoryList;

    public Inventory() {
        inventoryList = null;
    }

    public Inventory(List<T> inventoryList) {
        this.inventoryList = inventoryList;
    }

    public List<T> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(List<T> inventoryList) {
        this.inventoryList = inventoryList;
    }

    public int searchByName(List<T> list, String name) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equalsIgnoreCase(name)) {
                return i;
            }
        }

        return -1;
    }

    public T checkQty(List<T> list, String name, int desiredQuantity) {
        int index = searchByName(list, name);

        if (index == -1) {
            System.out.println(name + " was not found.");
            return null;
        }

        T item = list.get(index);

        if (item.getQuantity() == desiredQuantity) {
            System.out.println(item.getName() + " already has the desired quantity.");
        } else {
            item.setQuantity(desiredQuantity);
            System.out.println(item.getName() + " quantity updated to " + desiredQuantity + ".");
        }

        return item;
    }
}