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
public class Dish {
    
    static private double defaultCost = 0;

    private String name;
    private double cost;
    private String description;
    
    Dish (String name, String description)
    {
        this.name = name;
        this.description = description;
        this.cost = defaultCost;
    }
    
    Dish (String name, String description, double cost)
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
    
    public void setName (String name)
    {
        this.name = name;
    }
    
    public void setDescription (String description)
    {
        this.description = description;
    }
    
    public void setCost (double cost)
    {
        this.cost = cost;
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
