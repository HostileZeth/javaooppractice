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
public class Address { //Immutable
    private String city;
    private String street;
    private int ZIPcode;
    private int buildingNumber;
    private char literal;
    private int apartmentNumber;
    
    static private String DEFAULT_STRING_VALUE ="";
    static private int DEFAULT_INT_VALUE = -1;
    
    static private String DEFAULT_CITY_VALUE = "Samara";
    
    public static Address defaultAddress = new Address();
    
    public Address ()
    {
        city = DEFAULT_STRING_VALUE;
        street = DEFAULT_STRING_VALUE;
        ZIPcode = DEFAULT_INT_VALUE;
        buildingNumber = DEFAULT_INT_VALUE;
        literal = (char)DEFAULT_INT_VALUE;
        apartmentNumber = DEFAULT_INT_VALUE;
    }
    
    public Address (String street, int buildingNumber, char literal, int apartmentNumber)
    {
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.literal = literal;
        this.apartmentNumber = apartmentNumber;
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
        this.apartmentNumber = apartmentNumber;
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
        return apartmentNumber;
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
        if (anotherAddress.getApartmentNumber() != apartmentNumber) return false;     
        
        return true;
    }
    
    @Override
    public String toString()
    {
        if (street.equals("")) return "Address: <empty>";
        if (ZIPcode==-1) return String.format("Address: %s %d, %s %d%c-%d", city, ZIPcode, street, buildingNumber, literal, apartmentNumber);
        
        return String.format("Address: %s, %s %d%c-%d", city, street, buildingNumber, literal, apartmentNumber);
    }
    
    @Override
    public int hashCode()
    {
        int result = city.hashCode() ^ street.hashCode() ^ ZIPcode ^ buildingNumber ^ literal ^ apartmentNumber;
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
    }
}
