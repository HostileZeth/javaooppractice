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
public class Dish extends MenuItem {
    
    public Dish (String name, String description)
    {
        super(name, description);
    }
    
    public Dish(String name, String description, double cost)
    {
        super(name, description, cost);
    }
    
        @Override
    public String toString()
    {         
        
        return getDescription().equals("") ? String.format("Name %s, cost %.2fр.", super.getName(), super.getCost()) :
                String.format("Name %s, cost %.2fр., description %s", super.getName(), super.getCost(), super.getDescription());
        
    }
    
    @Override 
    public boolean equals(Object obj)
    {
        if (obj.getClass() != Dish.class) return false;
        MenuItem objMenuItem = (MenuItem)obj;
        
        if (!objMenuItem.getName().equals(super.getName())) return false;
        return objMenuItem.getCost() == super.getCost();
    }
    
    @Override
    public int hashCode()
    {
        int result = getName().hashCode() ^ Math.round((float)getCost() * super.COST_HASH_MULTIPLIER) ^ getDescription().hashCode();
        
        return result;
    }
    
}
