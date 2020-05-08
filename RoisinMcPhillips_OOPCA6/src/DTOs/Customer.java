/*Roisin McPhillips OOP CA6*/
package DTOs;

public class Customer
{
    private int id;
    private String name;
    private String address;

    public Customer(int id, String name, String address)
    {
        this.id = id;
        this.name = name;
        this.address = address;
    }

     public Customer(String name, String address)
    {
        this.id = 0;
        this.name = name;
        this.address = address;
    }

    public Customer() 
    {
    }
    
    public String toJson() {
        return "{"
                + "\"ID\":" + this.id +","
                + "\"Name\":" + this.name +","
                + "\"Address\":" + "\"" + this.address + "\","
                + "}";
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    @Override
    public String toString()
    {
        return "Customer{" + "ID: " + id + ", Name: " + name + ", Address: " + address + '}';
    }
    
    
}
