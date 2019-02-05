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
    
    public void addDishToOrder(int tableNumber, MenuItem dish)
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
            if (orderArray[i] != null) usedTables[currentUsedTable++] = i;
        
        int[] usedTablesFinal = new int[currentUsedTable];
        
        for (int i=0; i<currentUsedTable; i++)
            usedTablesFinal[i] = usedTables[i];
        
        return usedTablesFinal;
    }
    
    public int[] getFreeTablesNumberArray()
    {
        int[] freeTables = new int[orderArray.length];
        int currentFreeTable = 0;
        
        for (int i=0; i<orderArray.length; i++)
            if (orderArray[i] == null) freeTables[currentFreeTable++] = i;
        
        int[] freeTablesFinal = new int[currentFreeTable];
        
        for (int i=0; i<currentFreeTable; i++)
            freeTablesFinal[i] = freeTables[i];
        
        return freeTablesFinal;
    }
    
    public Order[] getOrderArray()
    {
        return orderArray;
    }
            
    public double getSummaryOrderPrice ()
    {
        double priceSum = 0;
        for (int i=0; i<orderArray.length; i++)
        {
            //System.out.println("Table "+i+" price: " + orderArray[i].getOrderPrice());
            if (orderArray[i]!=null) priceSum += orderArray[i].getOrderPrice();
        }
        return priceSum;
    }
    
    public int countOverallDishCount (String datDish)
    {
        MenuItem[] currentDishArray;
        int dishCount = 0;
        
        for (int i=0; i<orderArray.length; i++)
        {
            if (orderArray[i] == null) continue;
            else dishCount += orderArray[i].getDishCountByName(datDish);
        }
        
        return dishCount;
    }
    
    @Override
    public String toString()
    {
        String out = "ORDER MANAGER has THOSE TABLES:\n";
        
        for (int i=0; i<orderArray.length; i++)
        {
            out += "Table "+i+":\n";
            if (orderArray[i] == null) out += "Empty table\n";
            else out += orderArray[i].toString();
        }
        
        return out;
    }
}
