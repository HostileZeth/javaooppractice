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
public class InternetOrder {
    
    private Customer orderCustomer;
    private InternetOrderNode firstOrderNode;
    
    public InternetOrder()
    {
        orderCustomer = new Customer();
        firstOrderNode = new InternetOrderNode();
    }
    
    public InternetOrder(MenuItem[] itemArray, Customer customer)
    {
        orderCustomer = customer;
        
        firstOrderNode = new InternetOrderNode();
        InternetOrderNode currentNode = firstOrderNode;
        
        
        for (int i=0; i<itemArray.length; i++)
        {
            currentNode.setNextNode(new InternetOrderNode (itemArray[i]));
            currentNode = currentNode.getNextOrderNode();
        }
    }
    
    public void setCustomer(Customer customer)
    {
        orderCustomer = customer;
    }
    
    public Customer getCustomer()
    {
        return orderCustomer;
    }
    
    public boolean addMenuItem(MenuItem thisItem)
    {
        InternetOrderNode currentNode = firstOrderNode;
        
        while (currentNode.getNextOrderNode()!=null) currentNode = currentNode.getNextOrderNode();

        currentNode.setNextNode(new InternetOrderNode(thisItem));
        
        return true;
    }
    
    public boolean removeFirstItemByName(String itemName)
    {
        InternetOrderNode currentNode = firstOrderNode;
        
        while(currentNode.getNextOrderNode() != null)
        {
            if (currentNode.getNextOrderNode().getMenuItem().getName().equals(itemName))
            {
                currentNode.setNextNode(currentNode.getNextOrderNode().getNextOrderNode());
                return true;
                //remove
                
            }
            else
                currentNode = currentNode.getNextOrderNode();
        }
        
        return false;
    }
    
    public boolean removeFirstItemByEqualty(MenuItem thisItem)
    {
        InternetOrderNode currentNode = firstOrderNode;
        
        while(currentNode.getNextOrderNode() != null)
        {
            if (currentNode.getNextOrderNode().getMenuItem().equals(thisItem))
            {
                currentNode.setNextNode(currentNode.getNextOrderNode().getNextOrderNode());
                return true;
                //remove
                
            }
            else
                currentNode = currentNode.getNextOrderNode();
        }
        
        return false;
    }
    
    public int removeAllItemsByName (String itemName)
    {
        int removedCounter = 0;
        
        InternetOrderNode currentNode = firstOrderNode;
        while(currentNode.getNextOrderNode() != null)
        {
        if (currentNode.getNextOrderNode().getMenuItem().getName().equals(itemName))
            {
                currentNode.setNextNode(currentNode.getNextOrderNode().getNextOrderNode());
                //remove
                
            }
            else
                currentNode = currentNode.getNextOrderNode();
        }
        return removedCounter;
    }
    
    public int countItemsByName (String itemName)
    {
        int itemCounter = 0;
        
        InternetOrderNode currentNode = firstOrderNode;
        while(currentNode.getNextOrderNode() != null)
        {
        if (currentNode.getNextOrderNode().getMenuItem().getName().equals(itemName))
            itemCounter++;
        currentNode = currentNode.getNextOrderNode();
        }
        return itemCounter;
    }
    
    
    
    public int removeAllItemsByEqualty (MenuItem thisItem)
    {
        int removedCounter = 0;
        
        InternetOrderNode currentNode = firstOrderNode;
        while(currentNode.getNextOrderNode() != null)
        {
        if (currentNode.getNextOrderNode().getMenuItem().equals(thisItem))
            {
                currentNode.setNextNode(currentNode.getNextOrderNode().getNextOrderNode());
                removedCounter++;
                
            }
            else
                currentNode = currentNode.getNextOrderNode();
        }
        return removedCounter;
    }
    
    public int countItemsByEqualty (MenuItem thisItem)
    {
        int itemCounter = 0;
        
        InternetOrderNode currentNode = firstOrderNode;
        while(currentNode.getNextOrderNode() != null)
        {
        if (currentNode.getNextOrderNode().getMenuItem().equals(thisItem))
                itemCounter++;
                
            currentNode = currentNode.getNextOrderNode();
        }
        return itemCounter;
    }
    
    public int countMenuItems()
    {   
        int itemCounter = 0;
        InternetOrderNode currentNode = firstOrderNode.getNextOrderNode();
        while(currentNode != null)
        {
            itemCounter++;
            currentNode = currentNode.getNextOrderNode();
        }
        
        return itemCounter;
    }
    
    public double getSummaryPrice()
    {
        double sumPrice = 0;
        
        InternetOrderNode currentNode = firstOrderNode.getNextOrderNode();
        while(currentNode != null)
        {
            sumPrice += currentNode.getMenuItem().getCost();
            currentNode = currentNode.getNextOrderNode();
        }
        
        return sumPrice;
    }
    
    public MenuItem[] getItemsArray()
    {
        int itemCount = countMenuItems();
        MenuItem[] menuItemArray = new MenuItem[itemCount];
        
        InternetOrderNode currentNode = firstOrderNode.getNextOrderNode();
        
        int i=0;
        
        while(currentNode != null)
        {
            menuItemArray[i] = currentNode.getMenuItem();
            currentNode = currentNode.getNextOrderNode();
            i++;
        }
        
        return menuItemArray;
    }
    
    public MenuItem[] getItemArraySortedByPrice()
    {
        MenuItem[] menuItemArray = getItemsArray();
        
        qsortDishesByPrice(menuItemArray, 0, menuItemArray.length-1);
        
        return menuItemArray;
    }
    
    public String[] getItemNamesArray()
    {
        MenuItem[] menuItemArray = getItemsArray();
        qsortDishesByName(menuItemArray, 0, menuItemArray.length-1);
        
        String[] itemNamesArray = new String[menuItemArray.length];
        
        int namesCount = 0;
        
        for (int i=0; i<menuItemArray.length-1; i++)
            if (!menuItemArray[i].getName().equals( menuItemArray[i+1].getName()))
                itemNamesArray[namesCount++] = menuItemArray[i].getName();
        
        String[] finalNamesArray = new String[namesCount];
        for (int i=0; i<namesCount; i++)
            finalNamesArray[i] = itemNamesArray[i];
        
        return finalNamesArray;
    }
    
    @Override
    public String toString()
    {
        String result = orderCustomer.toString() +"\n";
        
        String itemArrayString = "";
        
        InternetOrderNode currentNode = firstOrderNode.getNextOrderNode();
        
        int i=0;
        
        while(currentNode != null)
        {
            itemArrayString += currentNode.getMenuItem().toString() +"\n";
            currentNode = currentNode.getNextOrderNode();
            i++;
        }
        
        result+= "Size " + i;
        
        result+= itemArrayString;
        
        
        return result;
    }
    
    @Override
    public int hashCode()
    {
        int result = -1;
        
        return result;
    }
    
    static private void qsortDishesByPrice(MenuItem[] array, int low, int high) // FIX IT
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
                MenuItem dishBuffer = array[i];
                array[i] = array[j];
                array[j] = dishBuffer;
                
                i++;
                j--;
            }
        }
        
        if (low < j) qsortDishesByPrice(array, low, j);
        if (high > i) qsortDishesByPrice(array, i, high);

    }
    
    static private void qsortDishesByName(MenuItem[] array, int low, int high)
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
                MenuItem dishBuffer = array[i];
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
}
