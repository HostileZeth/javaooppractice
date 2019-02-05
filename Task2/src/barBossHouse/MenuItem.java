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
public abstract class MenuItem {
    
    static protected double DEFAULT_COST = 0;
    static protected int COST_HASH_MULTIPLIER = 100;

    private String name;
    private double cost;
    private String description;
    
    protected MenuItem (String name, String description)
    {
        this.name = name;
        this.description = description;
        this.cost = DEFAULT_COST;
    }
    
    protected MenuItem (String name, String description, double cost)
    {
        this.name = name;
        this.description = description;
        this.cost = cost;
    }
    
    public String getName ()
    {
        return name;
    }
    
    public String getDescription ()
    {
        return description;
    }
    
    public double getCost ()
    {
        return cost;
    }
        
    @Override
    public String toString()
    {         
        
        return String.format("Name %s, cost %.2fр.", name, cost);
        
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if (obj.getClass() != MenuItem.class) return false;
        MenuItem objMenuItem = (MenuItem)obj;
        
        if (!objMenuItem.getName().equals(name)) return false;
        if (objMenuItem.getCost() != cost) return false;
        //if (!objMenuItem.getDescription().equals (description)) return false;
        
        return true;
    }
    
    @Override
    public int hashCode()
    {
        int result = name.hashCode() ^ Math.round((float)cost * COST_HASH_MULTIPLIER) ^ description.hashCode();
        
        return result;
    }
    
    //public static void main(String[] args) {
        // TODO code application logic here
    //}
    
}
