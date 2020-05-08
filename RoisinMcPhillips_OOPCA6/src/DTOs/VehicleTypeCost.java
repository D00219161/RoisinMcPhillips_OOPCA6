/*Roisin McPhillips OOP CA6*/
package DTOs;

public class VehicleTypeCost
{
    private String type;
    private int cost;

    public VehicleTypeCost(String type, int cost)
    {
        this.type = type;
        this.cost = cost;
    }
    
    public VehicleTypeCost(String type)
    {
        this.type = type;
        this.cost = 0;
    }
    
    public VehicleTypeCost()
    {
    }
    
    public String toJson() {
        return "{"
                + "\"Type\":" + this.type +","
                + "\"Cost\":" + this.cost +","
                + "}";
    }

    public int getCost()
    {
        return cost;
    }

    public void setCost(int cost)
    {
        this.cost = cost;
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
        return "VehicleTypeCost{" + "Type: " + type + ", Cost: " + cost + '}';
    }

  
    
    
}
