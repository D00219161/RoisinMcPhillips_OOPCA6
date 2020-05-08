/*Roisin McPhillips OOP CA6*/
package DTOs;

public class Vehicle
{
     private int id;
    private String registration;
    private String type;

    public Vehicle(int id, String registration, String type)
    {
        this.id = id;
        this.registration = registration;
        this.type = type;
    }
    
    public Vehicle(String registration, String type)
    {
        this.id = 0;
        this.registration = registration;
        this.type = type;
    }
    
     public Vehicle()
     {
         
     }
     
      public String toJson() {
        return "{"
                + "\"ID\":" + this.id +","
                + "\"Registration\":" + this.registration +","
                + "\"Type\":" + "\"" + this.type + "\","
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

    public String getRegistration()
    {
        return registration;
    }

    public void setRegistration(String registration)
    {
        this.registration = registration;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    @Override
    public String toString()
    {
        return "Vehicle{" + "ID: " + id + ", Registration: " + registration + ", Type: " + type + '}';
    }
      
      
}
