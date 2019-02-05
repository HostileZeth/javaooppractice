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
    
    static MenuItem[] testDishesArray;
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
        //testDishesArray[3].setCost(9.99);
        //testDishesArray[3].setName("Juss A Nice Burger");
        //testDishesArray[3].setDescription("You definitely won't be sorry about spending money on this");
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
        
        System.out.println("Lets get the order from the table !");
        Order testOrder = OM.getOrder(0);
        
        System.out.println(testOrder);
        
        System.out.println("Lets add the dish!");
        testOrder.addDish(testDishesArray[2]);
        
        System.out.println(testOrder);
        
        System.out.println("Lets see free tablezzzz........");
        int[] freeTablez = OM.getFreeTablesNumberArray();
        for(int i=0; i<freeTablez.length; i++)
            System.out.println(freeTablez[i]);
        
        System.out.println("Lets see used tablezzzz........");
        int[] usedTablez = OM.getUsedTablesNumberArray();
        for(int i=0; i<usedTablez.length; i++)
            System.out.println(usedTablez[i]);

        
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
        
        MenuItem[] dishArray = new MenuItem[3];
        
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
        MenuItem[] gettingDishArray = OM.getOrder(1).getDishArray();
        for (MenuItem d : gettingDishArray) System.out.println(d);
        
        System.out.println("Order 1 meals sorted:");
        String[] dishNames = OM.getOrder(1).getDishNamesArray();
        
        for (String s : dishNames)
            System.out.println(s);
        
        System.out.println("Order 2 meals:");
        gettingDishArray = OM.getOrder(2).getDishArray();
        for (MenuItem d : gettingDishArray) System.out.println(d);
        
        System.out.println("Order 2 meals names:");
        dishNames = OM.getOrder(2).getDishNamesArray();
        for (String s : dishNames)
            System.out.println(s);

    }
    
    public static void orderPriceSort()
    {
        Order testingOrder = new Order();
        
        testingOrder.addDish(testDishesArray[2]);
        testingOrder.addDish(testDishesArray[2]);
        testingOrder.addDish(testDishesArray[1]);
        testingOrder.addDish(testDishesArray[0]);
        testingOrder.addDish(testDishesArray[3]);
        testingOrder.addDish(testDishesArray[4]);
        testingOrder.addDish(testDishesArray[3]);
        
        System.out.println("Order without any sorting\n");
        System.out.println(testingOrder);
        
        MenuItem[] sortedDishArray = testingOrder.getDishArraySortedByPrice();
        
        System.out.println("\nOrder sorted\n");
        
        for(int i=0; i<sortedDishArray.length; i++)
            System.out.println(sortedDishArray[i].toString());
    }
    
    public static void testDishCounter()
    {
        OrderManager OM = new OrderManager(3);
        
        OM.setOrder(0, new Order());
        OM.setOrder(1, new Order());
        OM.setOrder(2, new Order());
        
        OM.addDishToOrder(1, testDishesArray[0]);
        OM.addDishToOrder(1, testDishesArray[0]);
        OM.addDishToOrder(1, testDishesArray[0]);
        OM.addDishToOrder(1, testDishesArray[3]);
        
        OM.addDishToOrder(0, testDishesArray[0]);
        OM.addDishToOrder(0, testDishesArray[0]);
        OM.addDishToOrder(0, testDishesArray[2]);
        
        OM.addDishToOrder(2, testDishesArray[1]);
        OM.addDishToOrder(2, testDishesArray[1]);
        OM.addDishToOrder(2, testDishesArray[0]);
        OM.addDishToOrder(2, testDishesArray[0]);
        
        String dishesToCount = "Fried Potato";
        
        System.out.println("POTATOS:"+OM.countOverallDishCount(dishesToCount));
        
        System.out.println("Lets count potatos on the table 0!");
        System.out.println(OM.getOrder(0).toString());
        System.out.println("POTATOS:"+ OM.getOrder(0).getDishCountByName(dishesToCount));
        
    }
    
    public static void sortZeroElements()
    {   
        System.out.println("Testing on zero data");
        OrderManager orderManager = new OrderManager(3);
        System.out.println("POTATOS:"+ orderManager.countOverallDishCount("Fried Potato"));
        System.out.println("Let's sort!");
        
        orderManager.setOrder(0, new Order());
        orderManager.setOrder(1, new Order());
        orderManager.setOrder(2, new Order());
        String[] dishNameArray = orderManager.getOrder(1).getDishNamesArray();
        
        
        
        for (int i=0; i<dishNameArray.length; i++)
            System.out.println(dishNameArray[i]);
        
        System.out.println("SUMMARY:"+ orderManager.getSummaryOrderPrice()+"$");
        
        
    }
    
    public static void removeDishTester()
    {
        System.out.println("Test dishes removing...");
        System.out.println("Today we removing :" + testDishesArray[0].getName());
        Order newOrder = new Order();
        newOrder.addDish(testDishesArray[0]);
        newOrder.addDish(testDishesArray[0]);
        newOrder.addDish(testDishesArray[1]);
        newOrder.addDish(testDishesArray[2]);
        
        System.out.println(newOrder.removeFirstDishByName(testDishesArray[1].getName()));
        
        System.out.println("Lets remove the potato");
        
        
        System.out.println(newOrder.removeAllDishByName(testDishesArray[0].getName()));
        
        
        
        System.out.println("After removing....");
        System.out.println(newOrder);
        
        System.out.println("Remove one potato from only beer order:" + newOrder.removeFirstDishByName(testDishesArray[0].getName()));
        System.out.println("Remove one beer from only beer order:" + newOrder.removeFirstDishByName(testDishesArray[2].getName()));
        
        System.out.println("After removing....");
        System.out.println(newOrder);
        
    }
    
    public static void main(String[] args) {
        initializeDishArray();
        testDishMethods();
        initializeOrderManagerArray();
        someGenericOrdersProcessing(testOrdManArray[0]);

        testOrderMethods();
        orderPriceSort();
        testDishCounter();
        sortZeroElements();
        
        removeDishTester();
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