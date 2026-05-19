[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=23950935)
# Lab 10: ArrayList + Generics (Packing Problems)

  Ellen Ochoa and her fellow astronauts need help preparing for their mission STS-96. Your job is to make sure all the items required are accounted for and are ready for departure. Three arrays of items have been provided for you. They are the default items that are brought on every mission, however there are special items we are taking on STS-96 and you need to make sure everything gets on board.

**Given:**
  - Three classes: `Food`, `Supplies`, `Parts`; with `Food` and `Parts` being derived from `Supplies`. 
  - Three `array`'s that you will have to convert to `ArrayList`'s and copy all elements over.
  - You will only need to work in the `Transfer` class and  `Inventory` class. You do not need to worry about `Main` or `Setup`.

## Steps
1. First and foremost, we have to get all the data from our `array`'s in the `Transfer` class into three new `ArrayList`'s from the `List` interface. Create three `ArrayList`'s called *foodList*, *partsList*, and *suppliesList* and set the type in the diamond `<>`as `<Food>`, `<Parts>`, and `<Supplies>`. Once these are created, edit the `Transfer` default constructor to copy all the items from our `array`'s into our lists.
*Note : There is a `printLists()` method at the very end of `Transfer` which does the job of printing all our list items in a nicely formatted table. Once you have created the lists, be sure to go to that print method and delete the multi-line comment symbols so you can use the method! Run the program and naviage to -> View Lists to see if you did it correctly.* 
2. Once our three `ArrayList`'s have been made, you will see a method in `Transfer` called `addItems()` where we have used `Scanner` inside the method to gather user input from the console and create `Food`, `Parts`, and `Supplies` objects. All you have to do is add these new objects to the appropriate lists using the `add()` method for `List`.
Once `addItems()` is complete, run the program and use the console to navigate through the menus  *Edit Lists* -> *(any) List* -> *Add to List*. There should be no reason to edit the `Main` method as the only information it passes in is the *listNumber* and that is handled for you. 
Add the below items to their appropriate lists. Also, don't forget to add Ellen Ochoa's favorite instrument. She'd be pretty upset if we forgot it! 
*Note : Check the article to find out which instrument to add!*
- FOOD: 
    - Pears, Perishable True, Qty 20
    - Hot Sauce, Perishable False, Qty 5
    - Chocolate, Perishable False, Qty 30 
- PARTS:
    - Copper Tube, Qty 50, 10053
    - Kevlar Strap, Qty 30, 10040
    - Titanium Bolts, Qty 45, 10032
- SUPPLIES:
    - Sleep Mask, Qty 10
    - Book, Qty 5
    - "Ochoa's Instrument", Qty 1
            
3. Go to the `Inventory`class and make it generic with a bounded type for `<T extends Supplies>` so that it will work with any type inherited from `Supplies` so that we will be able to access the `getName()` and `getQuantity()` methods from the `Supplies` class. Be sure to populate it with the instance variable, constructor, and get/set methods.
4. Go back to our `Transfer` class and create three new `Inventory` objects with our specific types in the diamond: `<Food>`, `<Parts>`, `<Supplies>`.
5. Now that our `Inventory` objects are created in `Transfer`, go back to the `Inventory` class and create a method that inputs a `List<T>` and a `String name` as parameters. Have it search the `List` and use the `getName()` method to see if the input `name` matches any objects in our list. If it does, return the index of an object. Name this method `searchByName()`. Remember, our generic variable `T` extends `Supplies`, so we can use `Supplies` methods on `T` because it is being interpreted as a `Supplies` object.
6. Once the `searchByName()` method has been complete in `Inventory`, you shouuld be able to use it in the method `removeItems()` in the `Transfer` class and use the `List` method `remove()` to remove items by index returned from `searchByName()`. 
7. Write one final generic method in `Inventory.java` that looks inside any of our lists and checks to see if the quantity we want for a certain object matches what is present in our list. Call it `checkQty()`. This method should input the `List`, `int desiredQuantity`, and `String name`. 
Hey, didn't we just write a method that searches a list by name? Maybe we can use it to return the index of the object we want to find? That would be much easier to handle to change the quantity within the list. Let's try it!
8. Once your `checkQty()` method is complete, implement this generic method in our `Transfer` class method `editQuantity()`. Once that is done, run the program and navigate in the menus to *Edit Lists* -> *(any) List* -> *Edit Quantity* and check the following items by name and enter the desired quantity.
- FOOD: 
    - Bread - new Qty 20
    - Orange - new Qty 30
    - Protein Bar - new Qty 30 
- PARTS:
    - Steel Truss - new Qty 4
    - Solar Panel - new Qty: 25
    - Steel Panel - new Qty: 4
- SUPPLIES:
    - Laptop - new Qty: 9
    - Sleep Restraint - new Qty: 5
    - First Aid Kit - new Qty: 5
---
And that should be it. Thanks a lot for your help with this. It certainly saved us a precious time getting things ready for our mission. Ochoa would be proud!
