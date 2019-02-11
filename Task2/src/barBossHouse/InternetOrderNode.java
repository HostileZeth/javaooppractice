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
public class InternetOrderNode {
    private final MenuItem menuItem;
    private InternetOrderNode nextOrderNode;
    
    InternetOrderNode()
    {
        menuItem = null;
        nextOrderNode = null;
    }
    
    InternetOrderNode (MenuItem menuItem)
    {
        this.menuItem = menuItem;
        nextOrderNode = null;
    }
    
    public void setNextNode(InternetOrderNode nextOrderNode)
    {
        this.nextOrderNode = nextOrderNode;
    }
    
    public InternetOrderNode getNextOrderNode ()
    {
        return nextOrderNode;
    }
    
    public MenuItem getMenuItem()
    {
        return menuItem;
    }
    
}
