import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Transfer {
    Setup setup = new Setup();
    Food[] foodArray = setup.getFoodArray();
    Parts[] partsArray = setup.getPartsArray();
    Supplies[] suppliesArray = setup.getSuppliesArray();

    List<Food> foodList = new ArrayList<Food>();
    List<Parts> partsList = new ArrayList<Parts>();
    List<Supplies> suppliesList = new ArrayList<Supplies>();

    Inventory<Food> foodInventory = new Inventory<Food>(foodList);
    Inventory<Parts> partsInventory = new Inventory<Parts>(partsList);
    Inventory<Supplies> suppliesInventory = new Inventory<Supplies>(suppliesList);

    public Transfer() {
        for (int i = 0; i < foodArray.length; i++) {
            foodList.add(foodArray[i]);
        }

        for (int i = 0; i < partsArray.length; i++) {
            partsList.add(partsArray[i]);
        }

        for (int i = 0; i < suppliesArray.length; i++) {
            suppliesList.add(suppliesArray[i]);
        }
    }

    public void addItems(int listNumber) {
        Scanner keyboard = new Scanner(System.in);

        if (listNumber == 1) {
            System.out.print("Food name: ");
            String name = keyboard.nextLine();
            System.out.print("Quantity: ");
            int qty = keyboard.nextInt();
            keyboard.nextLine();
            System.out.print("Perishable? (T/F): ");
            boolean perishable = false;
            String perish = keyboard.nextLine();
            perish = perish.substring(0, 1);

            if (perish.equalsIgnoreCase("T")) {
                perishable = true;
            }

            Food newFoodItem = new Food(name, qty, perishable);
            foodList.add(newFoodItem);
            System.out.println(newFoodItem.getName() + " added to food list.");

        } else if (listNumber == 2) {
            System.out.print("Part name: ");
            String name = keyboard.nextLine();
            System.out.print("Quantity: ");
            int qty = keyboard.nextInt();
            System.out.print("Part Number (5-digit) : ");
            int pn = keyboard.nextInt();

            Parts newPartsItem = new Parts(name, qty, pn);
            partsList.add(newPartsItem);
            System.out.println(newPartsItem.getName() + " added to parts list.");

        } else {
            System.out.print("Supplies name: ");
            String name = keyboard.nextLine();
            System.out.print("Quantity: ");
            int qty = keyboard.nextInt();

            Supplies newSuppliesItem = new Supplies(name, qty);
            suppliesList.add(newSuppliesItem);
            System.out.println(newSuppliesItem.getName() + " added to supplies list.");
        }
    }

    public void removeItems(int listNumber) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("\nName of Item to be Removed: ");
        String name = keyboard.nextLine();

        if (listNumber == 1) {
            int index = foodInventory.searchByName(foodList, name);

            if (index == -1) {
                System.out.println(name + " was not found in food list.");
            } else {
                Food removed = foodList.remove(index);
                System.out.println(removed.getName() + " removed from food list.");
            }

        } else if (listNumber == 2) {
            int index = partsInventory.searchByName(partsList, name);

            if (index == -1) {
                System.out.println(name + " was not found in parts list.");
            } else {
                Parts removed = partsList.remove(index);
                System.out.println(removed.getName() + " removed from parts list.");
            }

        } else if (listNumber == 3) {
            int index = suppliesInventory.searchByName(suppliesList, name);

            if (index == -1) {
                System.out.println(name + " was not found in supplies list.");
            } else {
                Supplies removed = suppliesList.remove(index);
                System.out.println(removed.getName() + " removed from supplies list.");
            }
        }
    }

    public void editQuantity(int listNumber) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("\nName of Item to Edit: ");
        String name = keyboard.nextLine();
        System.out.println("Desired Quantity: ");
        int desiredQty = keyboard.nextInt();

        if (listNumber == 1) {
            foodInventory.checkQty(foodList, name, desiredQty);

        } else if (listNumber == 2) {
            partsInventory.checkQty(partsList, name, desiredQty);

        } else if (listNumber == 3) {
            suppliesInventory.checkQty(suppliesList, name, desiredQty);
        }
    }

    public void printLists() {
        if (foodList.isEmpty() && partsList.isEmpty() && suppliesList.isEmpty()) {
            System.out.printf("\n%19s", "No objects found in lists.");
        }

        if (!foodList.isEmpty()) {
            System.out.printf("\n\n%s", "FOOD");
            System.out.print("\n----------------------------------------------");
            System.out.printf("\n%-25.25s %-15.15s %-10.10s%n", "Name", "Perishable", "Qty");
            System.out.print("----------------------------------------------");

            for (int i = 0; i < foodList.size(); i++) {
                Food tempFood = foodList.get(i);
                System.out.printf("\n%-25.25s %-15.15s %-10.10s",
                        tempFood.getName(), tempFood.getPerishable(), "" + tempFood.getQuantity());
            }
        }

        if (!partsList.isEmpty()) {
            System.out.printf("\n\n%s", "PARTS");
            System.out.print("\n----------------------------------------------");
            System.out.printf("\n%-25.25s %-15.15s %-10.10s%n", "Name", "PN", "Qty");
            System.out.print("----------------------------------------------");

            for (int i = 0; i < partsList.size(); i++) {
                Parts tempPart = partsList.get(i);
                System.out.printf("\n%-25.25s %-15.15s %-10.10s",
                        tempPart.getName(), "" + tempPart.getPartNumber(), "" + tempPart.getQuantity());
            }
        }

        if (!suppliesList.isEmpty()) {
            System.out.printf("\n\n%s", "SUPPLIES");
            System.out.print("\n----------------------------------------------");
            System.out.printf("\n%-25.25s %-15.15s %-10.10s%n", "Name", "Qty", "");
            System.out.print("----------------------------------------------");

            for (int i = 0; i < suppliesList.size(); i++) {
                Supplies tempSupplies = suppliesList.get(i);
                System.out.printf("\n%-25.25s %-15.15s %-10.10s",
                        tempSupplies.getName(), "" + tempSupplies.getQuantity(), "");
            }
        }
    }
}