package BusinessObjects;

import DTOs.TollEvent;
import Daos.MySqlTollEventDao;
import Daos.TollEventDaoInterface;
import Exceptions.DaoException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class MainApp
{
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        boolean quit = false;
        startApplication();
        printActions();
        while (quit == false)
        {
            System.out.print("\nEnter action: (4 to show available actions)> ");
            int action = sc.nextInt();
            sc.nextLine();

            switch (action)
            {
                case 0:
                    System.out.println("Shutting down application");
                    quit = true;
                    break;
                case 1:
                    load();
                    break;
                case 2:
                    vaildateAndWrite();
                    break;
                case 3:
                    database();
                case 4:
                    printActions();
                    break;
            }
        }
    }

    private static void startApplication()
    {
        System.out.println("Starting application...");
    }

    private static void printActions()
    {
        System.out.println("\nAvailable options:\npress");
        System.out.println("0 - to shutdown\n"
                + "1 - Load Data From Vehicles.csv \n"
                + "2 - Vailadate Toll-Event.csv\n"
                + "3 - Display Toll Event Database Data (DAO QUERIES)\n"
                + "4 - to print list of options");
    }

    public static void load()
    {
        Set<String> set;
        ArrayList<String> invalidRegistrationsList = new ArrayList<>();
        set = load("vehicles.csv");

        HashMap<String, ArrayList<TollEvent>> map = new HashMap<>();

        TollEvent event = new TollEvent("201LH309", 222222, 1562537493);
        //event = new TollEvent("192CN7865", 222222, 1562537493);

        if (set.contains(event.getRegistration()))
        {
            System.out.println("Is valid ");
            // then process the TollEvent object
            // i.e. write TollEvent object to a 
            // map<String(registration) ,List of TollEvents (ArrayList)>

            // map( KEY , VALUE );
            if (map.get(event.getRegistration()) == null) // it's not there
            {
                ArrayList<TollEvent> list = new ArrayList<>();
                list.add(event);
                map.put(event.getRegistration(), list);
            }
            else // reg is already there
            {
                ArrayList<TollEvent> list = map.get(event.getRegistration());
                list.add(event);  // adds to ArrayList in the map
            }

            System.out.println("from map:" + map.get("201LH309"));
            System.out.println("From Map: " + map.get("192CN7865"));
        }
        else
        {
            System.out.println("Is NOT a valid Registration");
            // add to a list of Invalid registrations
            invalidRegistrationsList.add(event.getRegistration());
        }

        System.out.println("List of invalid registrations:"
                + invalidRegistrationsList);
    }

    public static Set load(String fileName)
    {
        System.out.println("Reading from " + fileName);

        Set set = new HashSet<String>();

        try
        {
            Scanner sc = new Scanner(new File(fileName));
            // default delimeter is whitespace and newlines
            sc.useDelimiter(";");
            while (sc.hasNext())
            {
                String registration = sc.next();
                set.add(registration);
                System.out.println(registration);
            }
            sc.close();

        } catch (IOException e)
        {
        }

        return set; // of valid registrations
    }

    public static void vaildateAndWrite()
    {
        Set<String> set;
        ArrayList<String> invalidRegistrationsList = new ArrayList<>();
        set = loadVailadation("Toll-Events.csv");

        HashMap<String, ArrayList<TollEvent>> map = new HashMap<>();

        TollEvent event = new TollEvent("192CN0900", 30402, 2020);

        if (set.contains(event.getRegistration()))
        {
            System.out.println("Is valid " + event);
            // then process the TollEvent object
            // i.e. write TollEvent object to a 
            // map<String(registration) ,List of TollEvents (ArrayList)>
            //HashMap<String, ArrayList<TollEvent>> mapList = new HashMap<>();

            // map( KEY , VALUE );
            if (map.get(event.getRegistration()) == null) // it's not there
            {
                ArrayList<TollEvent> list = new ArrayList<>();
                list.add(event);
                map.put(event.getRegistration(), list);
            }
            else // reg is already there
            {
                ArrayList<TollEvent> list = map.get(event.getRegistration());
                list.add(event);  // adds to ArrayList in the map             
            }

            System.out.println("From Map: " + map.get("201LH309"));
        }
        else
        {
            System.out.println("Is NOT a valid Registration");
            // add to a list of Invalid registrations
            invalidRegistrationsList.add(event.getRegistration());
        }

        System.out.println("List of invalid registrations:"
                + invalidRegistrationsList);
    }

    public static Set loadVailadation(String fileName)
    {
        System.out.println("Reading from " + fileName);

        Set set = new HashSet<String>();

        try
        {
            Scanner sc = new Scanner(new File(fileName));
            // default delimeter is whitespace and newlines
            sc.useDelimiter(";");
            while (sc.hasNext())
            {
                String registration = sc.next();
                set.add(registration);
                System.out.println(registration);
//                String registration = sc.next();
//                long imageId = sc.nextLong();
//                long timestamp = sc.nextLong();
//                TollEvent event = new TollEvent(registration, imageId, timestamp);
//                set.add(registration + imageId + timestamp);
            }
            sc.close();

        } catch (IOException e)
        {
        }
        return set; // of valid registrations
    }

    public static void database()
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
