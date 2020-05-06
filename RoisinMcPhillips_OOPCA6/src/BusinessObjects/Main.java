/* Was used to test DAO's separately and where then placed in menu in MainApp.java file */
package BusinessObjects;

import DTOs.TollEvent;
import Daos.MySqlTollEventDao;
import Daos.TollEventDaoInterface;
import Exceptions.DaoException;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        TollEventDaoInterface IEventDao = new MySqlTollEventDao(); //I for interface

        try
        {
            System.out.println("Printing out the list of TollEvents Currently in the Database");
            List<TollEvent> events = IEventDao.findAllTollEvents();

            if (events.isEmpty())
            {
                System.out.println("There are no Toll Events");
            }

            for (TollEvent event : events)
            {
                System.out.println("TollEvent: " + event.toString());
            }

            System.out.println("\nFinding A TollEvent by Registration");
            // test dao - with good reg ("191LH1111");
            TollEvent event = IEventDao.findTollEventByRegistration("181MH3461");
            if (event != null)
            {
                System.out.println("Registration Found: " + event);
            }
            else
            {
                System.out.println("Toll Event with that Registration not found");
            }

            System.out.println("\nFinding a toll event by a specified date - Timestamp");
            event = IEventDao.findAllTollEventByCertainDate(2020 - 02 - 14);
            if (event != null)
            {
                System.out.println("Toll Event Found: " + event);
            }
            else
            {
                System.out.println("Toll Event with that Timestamp not found");
            }

            System.out.println("\nInserting Data into Event Table");
            //IEventDao.insertTollEvent("192CN2514", 30442);
            System.out.println("\nUpdating Data into Event Table");
            //IEventDao.updateTollEvent("181MH3461", 30450);

        } catch (DaoException e)
        {
            e.printStackTrace();
        }
    }
}
