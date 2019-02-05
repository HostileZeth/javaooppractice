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
public class Drink extends MenuItem implements Alchoholable {

    private DrinkTypeEnum type;
    private double alchoholVol;
    
    private static double DEFAULT_ALCHOHOL_VOL = 0;
    
    public Drink (String name, DrinkTypeEnum type)
    {
        super(name, "", MenuItem.DEFAULT_COST);
        this.alchoholVol = DEFAULT_ALCHOHOL_VOL;
        this.type = type;
    }
    
    public Drink(double cost, String name, DrinkTypeEnum type, String description)
    {
        super(name, description, cost);
        this.type = type;
        this.alchoholVol = DEFAULT_ALCHOHOL_VOL;
    }
    
    public Drink (double cost, String name, DrinkTypeEnum type, String description, double alchoholVol)
    {
        super(name, description, cost);
        this.type = type;
        this.alchoholVol = alchoholVol;
    }
    
    public DrinkTypeEnum getType()
    {
        return type;
    }
    
    
    
    @Override
    public boolean isAlchoholable() {
        return Math.abs(alchoholVol) >= 0.1;
    }

    @Override
    public double getAlchoholVol() {
        return alchoholVol;
    }
    
    @Override 
    public String toString()
    {
        if (super.getCost() == MenuItem.DEFAULT_COST) return String.format("Drink: %s %s", type, super.getName());
        if (alchoholVol == DEFAULT_ALCHOHOL_VOL) return String.format("Drink: %s %s, %fр. %s", type, super.getName(), super.getCost(), super.getDescription());
        
        return String.format("Drink: %s %s, %fр. AlchoholVol:%f. %s", type, super.getName(), super.getCost(), alchoholVol, super.getDescription());
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if (obj.getClass() != Drink.class) return false;
        if (!super.equals(obj)) return false;
        Drink drinkObject = (Drink) obj;
        
        if (drinkObject.getAlchoholVol() != alchoholVol) return false;
        return drinkObject.getType() == type;
    }
    
    @Override
    public int hashCode()
    {
        int result = super.hashCode() ^ type.hashCode() ^ Math.round((float)alchoholVol * MenuItem.COST_HASH_MULTIPLIER);
        return result;
    }
    
}
