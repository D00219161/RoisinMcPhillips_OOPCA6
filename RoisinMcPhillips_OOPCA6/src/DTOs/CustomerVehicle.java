/*Roisin McPhillips OOP CA6*/
package DTOs;

public class CustomerVehicle
{
    private int customerid;
    private int vehicleid;

    public CustomerVehicle(int customerid, int vehicleid)
    {
        this.customerid = customerid;
        this.vehicleid = vehicleid;
    }
    
    public String toJson() {
        return "{"
                + "\"CustomerID\":" + this.customerid +","
                + "\"VehicleID\":" + this.vehicleid +","
                + "}";
    }
    
    public CustomerVehicle()
    {
        this.customerid = 0;
        this.vehicleid = 0;
    }

    public int getCustomerid()
    {
        return customerid;
    }

    public void setCustomerid(int customerid)
    {
        this.customerid = customerid;
    }

    public int getVehicleid()
    {
        return vehicleid;
    }

    public void setVehicleid(int vehicleid)
    {
        this.vehicleid = vehicleid;
    }

    @Override
    public String toString()
    {
        return "CustomerVehicle{" + "CustomerID: " + customerid + ", VehicleID: " + vehicleid + '}';
    }

 
}
