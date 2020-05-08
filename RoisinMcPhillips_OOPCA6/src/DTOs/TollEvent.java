package DTOs;

import java.util.Objects;

public class TollEvent
{
    private int id;
    private String registration;
    private long imageId;
    private long timestamp; // - private Instant timestamp;

    public TollEvent(int id, String registration, long imageId, long timestamp)
    {
        this.id = id;
        this.registration = registration;
        this.imageId = imageId;
        this.timestamp = timestamp;
    }

  public TollEvent( String registration, long imageId, long timestamp) 
    {
        this.id = 0;
        this.registration = registration;
        this.imageId = imageId;
        this.timestamp = timestamp;
    }
    
    public TollEvent() 
    {
    }

    /**
     * Method to convert TollEvent object field data into JSON String format
     * 
     * @return JSON String representation of the objects data
     */
    //Updated for OOPCA6
    public String toJson() {
        return "{"
                + "\"ID\":" + this.id +","
                + "\"Registration\":" + this.registration +","
                + "\"ImageId\":" + "\"" + this.imageId + "\","
                + "\"Timestamp\":" + "\"" + this.timestamp + "\","              
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

    public long getImageId()
    {
        return imageId;
    }

    public void setImageId(long imageId)
    {
        this.imageId = imageId;
    }

    public long getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(long timestamp)
    {
        this.timestamp = timestamp;
    }

    @Override
    public String toString()
    {
        return "TollEvent{" + "Id: " + id + ", Registration: " + registration + ", ImageId: " + imageId + ", Timestamp: " + timestamp + '}';
    }  
}

    
    