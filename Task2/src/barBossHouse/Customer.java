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
public final class Customer { //immutable
    private final String name;
    private final String surname;
    private final int age;
    private final Address address;
    
    private static String DEFAULT_NAME = "";
    private static String DEFAULT_SURNAME = "";
    private static int DEFAULT_AGE = 0;
    
    public Customer()
    {
        this.name = DEFAULT_NAME;
        this.surname = DEFAULT_SURNAME;
        this.age = DEFAULT_AGE;
        this.address = new Address();
    }
    
    public Customer(int age)
    {
        this.name = DEFAULT_NAME;
        this.surname = DEFAULT_SURNAME;
        this.age = age;
        this.address = new Address();
    }
    
    public Customer(String name, String surname, int age, Address address)
    {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getSurname()
    {
        return surname;
    }
    
    public int getAge()
    {
        return age;
    }
    
    public Address getAddress()
    {
        return address;
    }
    
    @Override
    public String toString()
    {   
        String result = String.format("Customer: %s %s %d %s", surname, name, age, address.toString());
        return result;
    }
    
    @Override
    public int hashCode()
    {
        return surname.hashCode() ^ name.hashCode() ^ age ^ address.hashCode();
    }
    
    @Override 
    public boolean equals(Object obj)
    {
        if (obj.getClass() != Customer.class) return false;
        return obj.hashCode() == this.hashCode();
    }

}
