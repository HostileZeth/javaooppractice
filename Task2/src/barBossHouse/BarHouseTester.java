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
public class BarHouseTester {
    
    public static void smallEmptyCafe()
    {
        OrderManager CafeOwner = new OrderManager(5);
        
        System.out.println("First free table:" + CafeOwner.getFirstFreeTableNumber());
        
        Order someOrder = new Order();
        CafeOwner.setOrder(0, someOrder);
        CafeOwner.setOrder(1, someOrder);
        CafeOwner.setOrder(3, someOrder);
        
        
        
        System.out.println("First free table:" + CafeOwner.getFirstFreeTableNumber());
        
    }
    
    //this
    public static void main(String[] args) {
        smallEmptyCafe();
    }
}
