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
public interface Order {
    public boolean addMenuItem(MenuItem thisItem);
    public boolean removeFirstItemByName(String itemName);
    public boolean removeFirstItemByEqualty(MenuItem thisItem);
    public int removeAllItemsByName (String itemName);
    public int removeAllItemsByEqualty (MenuItem thisItem);
    public int countMenuItems();
    public MenuItem[] getItemsArray();
    public double getSummaryPrice();
    public int countItemsByName (String itemName);
    public int countItemsByEqualty (MenuItem thisItem);
    public String[] getItemNamesArray();
    public MenuItem[] getItemArraySortedByPrice();
    public void setCustomer(Customer customer);
    public Customer getCustomer();
    
    @Override
    public String toString();
}
