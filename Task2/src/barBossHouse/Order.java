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
public class Order {
    
    private static int defaultDishMassiveSize = 16;
    private static int defaultDishCount = 0;
    
    
    private Dish[] dishArray;
    private int dishCount;
    
    //конструкторы
    //не принимающий параметров, инициирующий массив из 16 элементов (сами элементы имеют значение null)
    Order()
    {
        this.dishArray = new Dish[defaultDishMassiveSize];
        dishCount = defaultDishCount;
    }
    
    //принимающий массив блюд
    Order (Dish[] dishMassive)
    {
        this.dishArray = dishMassive.clone();
        this.dishCount = dishMassive.length;
    }
    
    //принимающий целое число – емкость массива, инициирующий массив указанным числом элементов (сами элементы имеют значение 
    //null)
    Order (int dishCount)
    {
        this.dishArray = new Dish[dishCount];
        this.dishCount = defaultDishCount;
    }
    
    //добавляющий блюдо в заказ (принимает ссылку на экземпляр класса Dish)
    public boolean addDish(Dish anotherDish)
    {
        if (dishArray.length == dishCount) resizeArray();
        dishArray[dishCount] = anotherDish;
        
        dishCount++;
        
        return true;
    }
    
    //удаляющий блюдо из заказа по его названию
    //(принимает название блюда в качестве параметра)
    public boolean removeFirstDishByName(String dishName)
    {
        boolean isRemoved = false;
        
        for (int i=0; i<dishCount; i++)
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
    
    //удаляющий  все  блюда  с  заданным  именем  (принимает  название  блюда  в  качестве параметра)
    public int removeAllDishByName(String dishName)
    {
        int removedCount = 0;
        
        for (int i=0; i<dishCount; i++)
        {
            if (dishName.equals(dishArray[i].getName()))
            {
                removeDishByIndex(i);
                i--;
                removedCount++;
            }
        }
        
        return removedCount;
    }
    
    //возвращающий общее число блюд (повторяющиеся блюда тоже считаются) в заказе
    public int getDishCount()
    {
        return dishCount;
    }
    
    //возвращающий массив блюд (значений null в массиве быть не должно)
    public Dish[] getDishArray()
    {
        Dish[] resultArray = new Dish[dishCount];
        for (int i=0; i<dishCount; i++)
        {
            
            //resultArray[i] = dishArray[i];
            
            Dish currentDish = dishArray[i];
            resultArray[i] = new Dish(currentDish.getName(), currentDish.getDescription(), currentDish.getCost());
            
        }
        
        return resultArray;
    }
    
    //возвращающий общую стоимость заказа
    public double getOrderPrice()
    {   
        double resultPrice = 0;
    
        for (int i=0; i<dishCount; i++)
        {
            resultPrice += dishArray[i].getCost();
            //System.out.println("DISH COST:" + dishArray[i].getCost());
        }
        
        return resultPrice;
    }
    
    //возвращающий число заказанных блюд (принимает название блюда в качестве параметра)
    public int getDishCountByName(String dishName)
    {
        int resultCount = 0;
        
        for (int i=0; i<dishCount; i++)
            if (dishArray[i].getName().equals(dishName)) resultCount++;
        
        return resultCount;
    }

    public Dish[] getDishArraySortedByPrice()
    {
        Dish[] resultDishArray = getDishArray();
        
        if (dishCount == 0) return resultDishArray;
        
        qsortDishesByPrice(resultDishArray, 0, dishCount-1);
             
        return resultDishArray;
    }
    
    //возвращающий массив названий заказанных блюд (без повторов)
    public String[] getDishNamesArray()
    {
        String[] namesArray = new String[dishCount];
        
        if (dishCount == 0) return namesArray;
        
        int namesCount = 0;
        
        Dish[] sortedDishArray = getDishArray();
        qsortDishesByName(sortedDishArray, 0, dishCount-1);
        
        for (int i=0; i<dishCount-1; i++)
            if (!sortedDishArray[i].getName().equals( sortedDishArray[i+1].getName()))
                namesArray[namesCount++] = sortedDishArray[i].getName();
        
        namesArray[namesCount++] = sortedDishArray[dishCount-1].getName();
        
        String[] finalNamesArray = new String[namesCount];
        for (int i=0; i<namesCount; i++)
            finalNamesArray[i] = namesArray[i];
        
        return finalNamesArray;
    }
    
    static private void qsortDishesByPrice(Dish[] array, int low, int high) // FIX IT
    {
        if (array.length == 0) return; //nothing to sort
        
        if (low >= high) return; //nothing to sort
        
        int m = (low + high) / 2;
        double splitValue = array[m].getCost();
        
        int i = low; int j = high;
        
        while (i<=j)
        {
            while (array[i].getCost() < splitValue)
                i++;
            
            while (array[j].getCost() > splitValue)
                j--;
            
            if (i<=j)
            {
                Dish dishBuffer = array[i];
                array[i] = array[j];
                array[j] = dishBuffer;
                
                i++;
                j--;
            }
        }
        
        if (low < j) qsortDishesByPrice(array, low, j);
        if (high > i) qsortDishesByPrice(array, i, high);

    }
    
    static private void qsortDishesByName(Dish[] array, int low, int high)
    {
        if (array.length == 0) return; //nothing to sort
        
        if (low >= high) return; //nothing to sort
        
        int m = (low + high) / 2;
        String splitValue = array[m].getName();
        
        //System.out.println("SPLIT VALUE:" + splitValue);
        
        int i = low; int j = high;
        
        while (i<=j)
        {
            while (array[i].getName().compareTo(splitValue) < 0)
                i++;
            
            while (array[j].getName().compareTo(splitValue) > 0)
                j--;
            
            if (i<=j)
            {
                Dish dishBuffer = array[i];
                array[i] = array[j];
                array[j] = dishBuffer;
                i++;
                j--;
            }
            
            //System.out.println("I:"+i+"J:"+j);
        }
        
        //System.out.println();
        
        if (low < j) qsortDishesByName(array, low, j);
        if (high > i) qsortDishesByName(array, i, high);
        
        
    }
    
    private void resizeArray()
    {
        Dish[] duplicateArray = new Dish[dishArray.length * 2];
        for (int i=0; i<dishArray.length; i++) duplicateArray[i] = dishArray[i];
        
        dishArray = duplicateArray;
        //drag something here
    }

    private void removeDishByIndex(int RemoveIndex)
    {
        for (int i=RemoveIndex; i<dishCount-1; i++)
        {
            dishArray[i] = dishArray[i+1];
        }
        
        dishArray[dishCount-1] = null;
        dishCount--;
    }
    
    @Override
    public String toString()
    {
        String outString = "This order contains:\n";
        if (dishCount == 0) outString += "NOTHING xD\n";
        
        for (int i=0; i<dishCount; i++)
            outString += dishArray[i].toString() + "\n";
        
        return outString;
    }
}