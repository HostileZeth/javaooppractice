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
public class OrderManager {
    
    Order[] orderArray;
    
    OrderManager (int tableCount)
    {
        orderArray = new Order[tableCount];
    }
    
    public void setOrder(int tableNumber, Order order)
    {
        orderArray[tableNumber] = order;
    }
    
    public Order getOrder(int tableNumber)
    {
        return orderArray[tableNumber];
    }
    
    public void removeOrder(int tableNumber)
    {
        orderArray[tableNumber] = null;
    }
    
    public void addDishToOrder(int tableNumber, Dish dish)
    {
        orderArray[tableNumber].addDish(dish);
    }
    
    public int getFirstFreeTableNumber()
    {
        for (int i=0; i<orderArray.length; i++)
            if (orderArray[i] == null) return i;
        
        return -1;
    }
    
    public int[] getUsedTablesNumberArray()
    {
        int[] usedTables = new int[orderArray.length];
        int currentUsedTable = 0;
        
        for (int i=0; i<orderArray.length; i++)
            if (orderArray[i] == null) usedTables[currentUsedTable++] = i;
        
        int[] usedTablesFinal = new int[currentUsedTable];
        
        for (int i=0; i<currentUsedTable; i++)
            usedTablesFinal[i] = usedTables[i];
        
        return usedTablesFinal;
    }
    
    public Order[] getOrderArray()
    {
        return orderArray;
    }
            
    public double getSummaryOrderPrice ()
    {
        double priceSum = 0;
        for (int i=0; i<orderArray.length; i++)
            if (orderArray[i]!=null) priceSum += orderArray[i].getOrderPrice();
        
        return priceSum;
    }
    
    public int countOverallDishCount (String datDish)
    {
        Dish[] currentDishArray;
        int dishCount = 0;
        
        for (int i=0; i<orderArray.length; i++)
        {
            if (orderArray[i] == null) continue;
            
            currentDishArray = orderArray[i].getDishArray();
            
            for (int j=0; j<currentDishArray.length; j++)
                if (currentDishArray[j].getName().equals(datDish)) dishCount++;
        }
        
        return dishCount;
    }
}
