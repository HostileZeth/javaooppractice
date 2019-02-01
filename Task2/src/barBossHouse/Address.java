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
    private int postIndex;
    private int buildingNumber;
    private char buildingChar;
    private int roomNumber;
    
    static private String DEFAULT_STRING_VALUE ="";
    static private int DEFAULT_INT_VALUE = -1;
    
    public static Address defaultAddress = new Address();
    
    public Address ()
    {
        city = DEFAULT_STRING_VALUE;
        street = DEFAULT_STRING_VALUE;
        postIndex = DEFAULT_INT_VALUE;
        buildingNumber = DEFAULT_INT_VALUE;
        buildingChar = (char)DEFAULT_INT_VALUE;
        roomNumber = DEFAULT_INT_VALUE;
    }
    
    public Address (String street, int buildingNumber, char buildingChar, int roomNumber)
    {
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.buildingChar = buildingChar;
        this.roomNumber = roomNumber;
    }
    
    public Address (String city, String street, int postIndex, int buildingNumber, char buildingChar, int roomNumber)
    {
        this.city = city;
        this.street = street;
        this.postIndex = postIndex;
        this.buildingNumber = buildingNumber;
        this.buildingChar = buildingChar;
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
    
    public int getPostIndex()
    {
        return postIndex;
    }
    
    public int getBuildingNumber()
    {
        return buildingNumber;
    }
    
    public char getBuildingChar()
    {
        return buildingChar;
    }
    
    public int getRoomNumber()
    {
        return roomNumber;
    }
    
}
