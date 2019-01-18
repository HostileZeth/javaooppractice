/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2;

/**
 *
 * @author rLogic
 */
public class Order {
    
    private static int defaultDishMassiveSize = 16;
    private static int defaultDishCount = 0;
    
    
    private Dish[] dishArray;
    private int dishCount;
    
    
    Order()
    {
        this.dishArray = new Dish[defaultDishCount];
        dishCount = defaultDishCount;
    }
    
    Order (Dish[] dishMassive)
    {
        this.dishArray = dishMassive;
        this.dishCount = dishMassive.length;
    }
    
    Order (int dishCount)
    {
        this.dishArray = new Dish[dishCount];
        this.dishCount = defaultDishCount;
    }
    
    public boolean addDish(Dish anotherDish)
    {
        if (dishArray.length == dishCount) resizeArray();
        dishArray[dishCount] = anotherDish;
        
        dishCount++;
        
        return true;
    }
    
    private void removeDishByIndex(int RemoveIndex)
    {
        for (int i=RemoveIndex; i<dishCount-1; i++)
        {
            dishArray[i] = dishArray[i+1];
        }
        
        dishArray[dishCount-1] = null;
        
    }
    
    public boolean removeFirstDishByName(String dishName)
    {
        boolean isRemoved = false;
        
        for (int i=0; i<dishArray.length; i++)
        {
            if (dishName.equals(dishArray[i].getName()))
            {
                removeDishByIndex(i);
                isRemoved = true;
                break;
            }
        }
        
        return isRemoved;
    }
    
    public int removeAllDishByName(String dishName)
    {
        int removedCount = 0;
        
        for (int i=0; i<dishArray.length; i++)
        {
            if (dishName.equals(dishArray[i].getName()))
            {
                removeDishByIndex(i);
                removedCount++;
            }
        }
        
        return removedCount;
    }
    
    private void resizeArray()
    {
        Dish[] duplicateArray = new Dish[dishArray.length * 2];
        for (int i=0; i<dishArray.length; i++) duplicateArray[i] = dishArray[i];
        
        dishArray = duplicateArray;
        //drag something here
    }
    
}
