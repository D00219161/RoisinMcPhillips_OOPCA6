package Daos;

import DTOs.TollEvent;
import Exceptions.DaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlTollEventDao extends MySqlDao implements TollEventDaoInterface
{
    @Override
    public List<TollEvent> findAllTollEvents() throws DaoException 
    {
    	Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<TollEvent> events = new ArrayList<>();
        
        try 
        {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            con = this.getConnection();

            String query = "SELECT * FROM EVENT";
            ps = con.prepareStatement(query);
            
            //Using a PreparedStatement to execute SQL...
            rs = ps.executeQuery();
            while (rs.next()) 
            {
                int Id = rs.getInt("ID");
                String registration = rs.getString("REGISTRATION");
                long imageId = rs.getLong("IMAGEID");
                long timestamp = rs.getLong("TIMESTAMP");
                TollEvent event = new TollEvent(Id, registration, imageId, timestamp);
                events.add(event);
            }
        } 
        catch (SQLException e) 
        {
            throw new DaoException("findAllTollEvents() " + e.getMessage());
        } 
        finally 
        {
            try 
            {
                if (rs != null) 
                {
                    rs.close();
                }
                if (ps != null) 
                {
                    ps.close();
                }
                if (con != null) 
                {
                    freeConnection(con);
                }
            } 
            catch (SQLException e) 
            {
                throw new DaoException("findAllTollEvents() " + e.getMessage());
            }
        }
        return events;
    }
    
      @Override
    public TollEvent findTollEventByRegistration(String reg) throws DaoException 
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        TollEvent event = null;
        try {
            con = this.getConnection();
            
            String query = "SELECT * FROM EVENT WHERE REGISTRATION = ? ";
            ps = con.prepareStatement(query);
            ps.setString(1, reg);

            rs = ps.executeQuery();
            if (rs.next()) 
            {
                int id = rs.getInt("ID");
                String registration = rs.getString("REGISTRATION");
                long imageId = rs.getLong("IMAGEID");
                long timestamp = rs.getLong("TIMESTAMP");
                event = new TollEvent(registration, imageId, timestamp);
            }
        } 
        catch (SQLException e) 
        {
            throw new DaoException("findTollEventByRegistration() " + e.getMessage());
        } 
        finally 
        {
            try 
            {
                if (rs != null) 
                {
                    rs.close();
                }
                if (ps != null) 
                {
                    ps.close();
                }
                if (con != null) 
                {
                    freeConnection(con);
                }
            } 
            catch (SQLException e) 
            {
                throw new DaoException("findTollEventByRegistration() " + e.getMessage());
            }
        }
        return event;     // event may be null 
    } 
    
     @Override
    public TollEvent findAllTollEventByCertainDate(long tstamp) throws DaoException 
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        TollEvent event = null;
        try {
            con = this.getConnection();
            
            String query = "SELECT * FROM EVENT WHERE TIMESTAMP = ?";
            ps = con.prepareStatement(query);
            ps.setLong(1, tstamp);
            
            rs = ps.executeQuery();
            if (rs.next()) 
            {
            	int id = rs.getInt("ID");
                String registration = rs.getString("REGISTRATION");
                long imageId = rs.getLong("IMAGEID");
                long timestamp = rs.getLong("TIMESTAMP");
                event = new TollEvent(registration, imageId, timestamp);
            }
        } 
        catch (SQLException e) 
        {
            throw new DaoException("findUserByUsernamePassword() " + e.getMessage());
        } 
        finally 
        {
            try 
            {
                if (rs != null) 
                {
                    rs.close();
                }
                if (ps != null) 
                {
                    ps.close();
                }
                if (con != null) 
                {
                    freeConnection(con);
                }
            } 
            catch (SQLException e) 
            {
                throw new DaoException("findUserByUsernamePassword() " + e.getMessage());
            }
        }
        return event;     // event may be null 
    }  
   
     @Override
      public void insertTollEvent(String registration, long imageId, long timestamp) throws DaoException 
    {
    	Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try 
        {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            con = this.getConnection();

            String query = "INSERT INTO EVENT VALUES (null, ?, ?, ?)";
             ps = con.prepareStatement(query);
            // ps.setInt(1, null);AUTO_INCREMENTED //- database does this for us 
             ps.setString(1, registration);
             ps.setLong(2, imageId);
             ps.setLong(3, timestamp);

            //Using a PreparedStatement to execute SQL...
            ps.executeUpdate(); // For Insert, Update and Delete
          
        } 
        catch (SQLException e) 
        {
            throw new DaoException("insertTollEvent() " + e.getMessage());
        } 
        finally 
        {
            try 
            {
                if (rs != null) 
                {
                    rs.close();
                }
                if (ps != null) 
                {
                    ps.close();
                }
                if (con != null) 
                {
                    freeConnection(con);
                }
            } 
            catch (SQLException e) 
            {
                throw new DaoException("insertTollEvent() " + e.getMessage());
            }
        } 
    }
      
      @Override
      public void updateTollEvent(String registration, long imageId)throws DaoException 
    {
    	Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try 
        {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            con = this.getConnection();

            String query = "UPDATE EVENT SET IMAGEID =? WHERE REGISTRATION = ?";
             ps = con.prepareStatement(query);
            //ps.setInt(1, null); //AUTO_INCREMENTED - database does this for us 
             ps.setString(1, registration);
             ps.setLong(2, imageId);
            
            //Using a PreparedStatement to execute SQL...
            ps.executeUpdate(); // For Insert, Update and Delete
          
        } 
        catch (SQLException e) 
        {
            throw new DaoException("updateTollEvent() " + e.getMessage());
        } 
        finally 
        {
            try 
            {
                if (rs != null) 
                {
                    rs.close();
                }
                if (ps != null) 
                {
                    ps.close();
                }
                if (con != null) 
                {
                    freeConnection(con);
                }
            } 
            catch (SQLException e) 
            {
                throw new DaoException("updateTollEvent() " + e.getMessage());
            }
        } 
    }
/*Roisin McPhillips OOP CA6 - New DAOs for new Tables for ca6*/
   //Find total bill cost
    @Override
    public List<TollEvent> findBill() throws DaoException 
    {
    	Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<TollEvent> events = new ArrayList<>();
        
        try 
        {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            con = this.getConnection();
            
            String query = "SELECT vehicle_type, vehicle_registration, timestamp, cost FROM toll_event natural"
                    +"join customer_vehicles natural join customer natural join vehicle natural join vehicle_type_cost"
                    + "where customer_name = John Smith ";
            ps = con.prepareStatement(query);
            
            //Using a PreparedStatement to execute SQL...
            rs = ps.executeQuery();
            while (rs.next()) 
            {
                int Id = rs.getInt("ID");
                String registration = rs.getString("REGISTRATION");
                long imageId = rs.getLong("IMAGEID");
                long timestamp = rs.getLong("TIMESTAMP");
                TollEvent event = new TollEvent(Id, registration, imageId, timestamp);
                events.add(event);
            }
        } 
        catch (SQLException e) 
        {
            throw new DaoException("findBill() " + e.getMessage());
        } 
        finally 
        {
            try 
            {
                if (rs != null) 
                {
                    rs.close();
                }
                if (ps != null) 
                {
                    ps.close();
                }
                if (con != null) 
                {
                    freeConnection(con);
                }
            } 
            catch (SQLException e) 
            {
                throw new DaoException("findBill() " + e.getMessage());
            }
        }
        return events;
    }
    
     //Find total bill cost
    @Override
    public List<TollEvent> findBillTotal() throws DaoException 
    {
    	Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<TollEvent> events = new ArrayList<>();
        
        try 
        {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            con = this.getConnection();
           
            String query = "SELECT sum(cost)FROM toll_event natural join customer_vehicles natural join customer natural "
                    + "join vehicle natural join vehicle_type_cost"
                    + "where customer_name = John Smith ";
            ps = con.prepareStatement(query);
            
            //Using a PreparedStatement to execute SQL...
            rs = ps.executeQuery();
            while (rs.next()) 
            {
                int Id = rs.getInt("ID");
                String registration = rs.getString("REGISTRATION");
                long imageId = rs.getLong("IMAGEID");
                long timestamp = rs.getLong("TIMESTAMP");
                TollEvent event = new TollEvent(Id, registration, imageId, timestamp);
                events.add(event);
            }
        } 
        catch (SQLException e) 
        {
            throw new DaoException("findBillTotal() " + e.getMessage());
        } 
        finally 
        {
            try 
            {
                if (rs != null) 
                {
                    rs.close();
                }
                if (ps != null) 
                {
                    ps.close();
                }
                if (con != null) 
                {
                    freeConnection(con);
                }
            } 
            catch (SQLException e) 
            {
                throw new DaoException("findBillTotal() " + e.getMessage());
            }
        }
        return events;
    }
}