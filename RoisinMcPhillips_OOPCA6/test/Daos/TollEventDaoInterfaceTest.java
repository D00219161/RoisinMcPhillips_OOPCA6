/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import DTOs.TollEvent;
import Exceptions.DaoException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class TollEventDaoInterfaceTest
{
    
    public TollEventDaoInterfaceTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of findAllTollEvents method, of class TollEventDaoInterface.
     */
    @Test
    public void testFindAllTollEvents() throws Exception
    {
        System.out.println("findAllTollEvents");
        TollEventDaoInterface instance = new TollEventDaoInterfaceImpl();
        List<TollEvent> expResult = null;
        List<TollEvent> result = instance.findAllTollEvents();
        assertEquals(expResult, result);
    }

    /**
     * Test of findTollEventByRegistration method, of class TollEventDaoInterface.
     */
    @Test
    public void testFindTollEventByRegistration() throws Exception
    {
        System.out.println("findTollEventByRegistration");
        String reg = "";
        TollEventDaoInterface instance = new TollEventDaoInterfaceImpl();
        TollEvent expResult = null;
        TollEvent result = instance.findTollEventByRegistration(reg);
        assertEquals(expResult, result);
    }

    /**
     * Test of findAllTollEventByCertainDate method, of class TollEventDaoInterface.
     */
    @Test
    public void testFindAllTollEventByCertainDate() throws Exception
    {
        System.out.println("findAllTollEventByCertainDate");
        long Timestamp = 0L;
        TollEventDaoInterface instance = new TollEventDaoInterfaceImpl();
        TollEvent expResult = null;
        TollEvent result = instance.findAllTollEventByCertainDate(Timestamp);
        assertEquals(expResult, result);
    }

    /**
     * Test of insertTollEvent method, of class TollEventDaoInterface.
     */
    @Test
    public void testInsertTollEvent() throws Exception
    {
        System.out.println("insertTollEvent");
        String registration = "";
        long imageId = 0L;
        long timestamp = 0L;
        TollEventDaoInterface instance = new TollEventDaoInterfaceImpl();
        instance.insertTollEvent(registration, imageId, timestamp);
    }

    /**
     * Test of updateTollEvent method, of class TollEventDaoInterface.
     */
    @Test
    public void testUpdateTollEvent() throws Exception
    {
        System.out.println("updateTollEvent");
        String registration = "";
        long timestamp = 0L;
        TollEventDaoInterface instance = new TollEventDaoInterfaceImpl();
        instance.updateTollEvent(registration, timestamp);
    }

    public class TollEventDaoInterfaceImpl implements TollEventDaoInterface
    {

        public List<TollEvent> findAllTollEvents() throws DaoException
        {
            return null;
        }

        public TollEvent findTollEventByRegistration(String reg) throws DaoException
        {
            return null;
        }

        public TollEvent findAllTollEventByCertainDate(long Timestamp) throws DaoException
        {
            return null;
        }

        public void insertTollEvent(String registration, long imageId, long timestamp) throws DaoException
        {
        }

        public void updateTollEvent(String registration, long timestamp) throws DaoException
        {
        }

        @Override
        public List<TollEvent> findBill() throws DaoException
        {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public List<TollEvent> findBillTotal() throws DaoException
        {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    /**
     * Test of findBill method, of class TollEventDaoInterface.
     */
    @Test
    public void testFindBill() throws Exception
    {
        System.out.println("findBill");
        TollEventDaoInterface instance = new TollEventDaoInterfaceImpl();
        List<TollEvent> expResult = null;
        List<TollEvent> result = instance.findBill();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findBillTotal method, of class TollEventDaoInterface.
     */
    @Test
    public void testFindBillTotal() throws Exception
    {
        System.out.println("findBillTotal");
        TollEventDaoInterface instance = new TollEventDaoInterfaceImpl();
        List<TollEvent> expResult = null;
        List<TollEvent> result = instance.findBillTotal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    
}
