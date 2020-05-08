/*Roisin McPhillips OOP CA6*/
package BusinessObjects;

import DTOs.TollEvent;
import Daos.MySqlTollEventDao;
import Daos.TollEventDaoInterface;
import Exceptions.DaoException;
import java.util.List;

public class MainCA6
{
    public static void main(String[] args)
    {
        TollEventDaoInterface IEventDao = new MySqlTollEventDao(); //I for interface

        try
        {
            System.out.println("Printing out the list of TollEvents Currently in the Database");
            
            List<TollEvent> events = IEventDao.findBill();

            if (events.isEmpty())
            {
                System.out.println("There is no Bill");
            }
            
            
            events = IEventDao.findBillTotal();

            if (events.isEmpty())
            {
                System.out.println("There is no Bill Total");
            }
            
        } catch (DaoException e)
        {
            e.printStackTrace();
        }
    }
}
