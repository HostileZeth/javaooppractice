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
public final class Address { //Immutable
    private final String city;
    private final String street;
    private final int ZIPcode;
    private final int buildingNumber;
    private final char literal;
    private final int roomNumber;
    
    static private String DEFAULT_STRING_VALUE ="";
    static private int DEFAULT_INT_VALUE = -1;
    
    static private String DEFAULT_CITY_VALUE = "Samara";
    
    public static Address defaultAddress = new Address();
    
    public Address ()
    {
        this.city = DEFAULT_STRING_VALUE;
        this.street = DEFAULT_STRING_VALUE;
        this.ZIPcode = DEFAULT_INT_VALUE;
        this.buildingNumber = DEFAULT_INT_VALUE;
        this.literal = (char)DEFAULT_INT_VALUE;
        this.roomNumber = DEFAULT_INT_VALUE;
    }
    
    public Address (String street, int buildingNumber, char literal, int apartmentNumber)
    {
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.literal = literal;
        this.roomNumber = apartmentNumber;
        this.ZIPcode = DEFAULT_INT_VALUE;
        this.city = DEFAULT_CITY_VALUE;
    }
    
    public Address (String city, String street, int ZIPcode, int buildingNumber, char literal, int roomNumber)
    {
        this.city = city;
        this.street = street;
        this.ZIPcode = ZIPcode;
        this.buildingNumber = buildingNumber;
        this.literal = literal;
        this.roomNumber = roomNumber;
    }
    
    //not setting anything but getting everything
    //because of IMMUTABLENESS
    public String getCity()
    {
        return city;
    }
    public String getStreet()
    {
        return street;
    }
    
    public int getZIPcode()
    {
        return ZIPcode;
    }
    
    public int getBuildingNumber()
    {
        return buildingNumber;
    }
    
    public char getLiteral()
    {
        return literal;
    }
    
    public int getApartmentNumber()
    {
        return roomNumber;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if (obj.getClass() != Address.class) return false;
        Address anotherAddress = (Address)obj;
        
        if (!anotherAddress.getCity().equals(this.city)) return false;
        if (!anotherAddress.getStreet().equals(this.street)) return false;
        if (anotherAddress.getZIPcode()!= ZIPcode) return false;
        if (anotherAddress.getBuildingNumber()!= buildingNumber) return false;
        if (anotherAddress.getLiteral() != literal) return false;
        if (anotherAddress.getApartmentNumber() != roomNumber) return false;     
        
        return true;
    }
    
    @Override
    public String toString()
    {
        if (street.equals("")) return "Address: <empty>";
        if (ZIPcode==-1) return String.format("Address: %s %d, %s %d%c-%d", city, ZIPcode, street, buildingNumber, literal, roomNumber);
        
        return String.format("Address: %s, %s %d%c-%d", city, street, buildingNumber, literal, roomNumber);
    }
    
    @Override
    public int hashCode()
    {
        int result = city.hashCode() ^ street.hashCode() ^ ZIPcode ^ buildingNumber ^ literal ^ roomNumber;
        return result;
    }
    
    public static void main(String[] args)
    {
        Address newAddr = new Address();
        Address anotherNewAddr = new Address("Samara", "Revolution str.", 443023, 22, 'x', 42);
        
        System.out.println(newAddr.equals(Address.defaultAddress));       
        System.out.println(anotherNewAddr.equals(Address.defaultAddress));
        System.out.println(anotherNewAddr.equals(anotherNewAddr));
        
        System.out.println(anotherNewAddr.hashCode());
        System.out.println(Address.defaultAddress.hashCode());
        
        //if (newAddr.hashCode() == Address.defaultAddress.hashCode()) System.out.println("it works");
        
    }
}
