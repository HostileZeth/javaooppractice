/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barBossHouse;

/**
 *
 * @author rLogic
 */
public class BarHouseTester {
    
    static Dish[] testDishesArray;
    static OrderManager[] testOrdManArray;
    
    public static void initializeDishArray()
    {
        System.out.println("Initialize Dish array...");
        
        testDishesArray = new Dish[5];
        
        testDishesArray[0] = new Dish("Fried Potato", "Some potato and its fried, yo", 5.99);
        testDishesArray[1] = new Dish("Free meal for stupid", "Cooked for random ingridients found in the trash can");
        testDishesArray[2] = new Dish("Free beer", "Only if you ordered for over 9000$");
        testDishesArray[3] = new Dish("Best Hamburger In The Universe", "So delicious you could not live anymore", 14.99);
        testDishesArray[4] = new Dish("Piece of bread","Better than nothing", 0.99);
        
        for (int i=0; i<5; i++)
            System.out.println(testDishesArray[i]);
        
        System.out.println("Dish array initialization is done!\n");
    }
    
    public static void testDishMethods()
    {
        System.out.println("Lets test the Dish class methods");
        System.out.println("Lets get all the data about dish #0");
        System.out.println("Dish #0 name is " + testDishesArray[0].getName());
        System.out.println("Dish #0 description is " + testDishesArray[0].getDescription());
        System.out.println("Dish #0 cost is " + testDishesArray[0].getCost());
        System.out.println("Lets change all the data about dish #3");
        testDishesArray[3].setCost(9.99);
        testDishesArray[3].setName("Juss A Nice Burger");
        testDishesArray[3].setDescription("You definitely won't be sorry about spending money on this");
        System.out.println(testDishesArray[3].toString());
        System.out.println("Testing Dish class methods is done!\n");
    }
   
    public static void initializeOrderManagerArray()
    {
        System.out.println("Initializing OrderManager array...");
        testOrdManArray = new OrderManager[2];
        testOrdManArray[0] = new OrderManager(5); //small cafe
        testOrdManArray[1] = new OrderManager(10); //decent cafe
        
        for (OrderManager OM : testOrdManArray)
            System.out.println(OM);
        
        System.out.println("OrderManager array initialization is done!\n");
    }
    
    public static void someGenericOrdersProcessing (OrderManager OM)
    {
        System.out.println("Lets process some orders!");
        
        OM.setOrder(0, new Order());
        OM.setOrder(2, new Order());
        OM.setOrder(3, new Order());
        
        System.out.println("After few orders placed, first free table is :" + OM.getFirstFreeTableNumber());
        
        OM.setOrder(OM.getFirstFreeTableNumber(), new Order());
        
        System.out.println("After one more order is placed, first free table is :" + OM.getFirstFreeTableNumber());
        
        System.out.println(OM.toString());
        
        System.out.println("Order processing is done!");
    }
    
    public static void testOrderMethods ()
    {
        Order order1 = new Order();

        order1.addDish(testDishesArray[0]);
        
        Order order2 = new Order(8);
        
        order2.addDish(testDishesArray[0]);
        order2.addDish(testDishesArray[0]);
        order2.addDish(testDishesArray[1]);
        order2.addDish(testDishesArray[0]);
        order2.addDish(testDishesArray[1]);
        order2.addDish(testDishesArray[0]);
        order2.addDish(testDishesArray[1]);
        order2.addDish(testDishesArray[0]);
        order2.addDish(testDishesArray[1]);
        order2.addDish(testDishesArray[1]);
        
        Dish[] dishArray = new Dish[3];
        
        dishArray[0] = testDishesArray[1];
        dishArray[1] = testDishesArray[3];
        dishArray[2] = testDishesArray[4];
        
        Order order3 = new Order(dishArray);
        
        OrderManager OM = new OrderManager(3);
        
        OM.setOrder(0, order1);
        OM.setOrder(1, order2);
        OM.setOrder(2, order3);
        
        System.out.println("Summary order price: "+OM.getSummaryOrderPrice());
        //OM.addDishToOrder(1, testDishesArray[3]);
        OM.addDishToOrder(1, testDishesArray[3]);
        OM.addDishToOrder(1, testDishesArray[3]);
        OM.addDishToOrder(1, testDishesArray[3]);
        
        System.out.println("Summary order price: "+OM.getSummaryOrderPrice());
        
        System.out.println(OM.toString());
        
        System.out.println("Specific data method testing:\n");
        
        System.out.println("Order 1 meals names:");
        Dish[] gettingDishArray = OM.getOrder(1).getDishArray();
        for (Dish d : gettingDishArray) System.out.println(d);
        
        System.out.println("Order 1 meals sorted:");
        String[] dishNames = OM.getOrder(1).getDishNamesArray();
        
        for (String s : dishNames)
            System.out.println(s);
        
        System.out.println("Order 2 meals:");
        gettingDishArray = OM.getOrder(2).getDishArray();
        for (Dish d : gettingDishArray) System.out.println(d);
        
        System.out.println("Order 2 meals names:");
        dishNames = OM.getOrder(2).getDishNamesArray();
        for (String s : dishNames)
            System.out.println(s);
        
        System.out.println("Order 1 meals sorted by price:");
        //Dish[] sortedDishArray = OM.getOrder(1).getDishArraySortedByPrice();
        Dish[] sortedDishArray = order2.getDishArraySortedByPrice();
        for (Dish d : sortedDishArray) System.out.println(d);
    }
    //this
    public static void main(String[] args) {
        initializeDishArray();
        //testDishMethods();
        //initializeOrderManagerArray();
        //someGenericOrdersProcessing(testOrdManArray[0]);

        testOrderMethods();

    }
}

 
    /*public static void smallEmptyCafe()
    {
        OrderManager CafeOwner = new OrderManager(5);
        
        System.out.println("First free table:" + CafeOwner.getFirstFreeTableNumber());
        
        Order someOrder = new Order();
        CafeOwner.setOrder(0, someOrder);
        CafeOwner.setOrder(1, someOrder);
        CafeOwner.setOrder(3, someOrder);
        
        
        
        System.out.println("First free table:" + CafeOwner.getFirstFreeTableNumber());
        
    }*/