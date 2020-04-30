/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import DTOs.TollEvent;
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
public class MySqlTollEventDaoTest
{
    
    public MySqlTollEventDaoTest()
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
     * Test of findAllTollEvents method, of class MySqlTollEventDao.
     */
    @Test
    public void testFindAllTollEvents() throws Exception
    {
        System.out.println("findAllTollEvents");
        MySqlTollEventDao instance = new MySqlTollEventDao();
        List<TollEvent> expResult = null;
        List<TollEvent> result = instance.findAllTollEvents();
        assertEquals(expResult, result);
    }

    /**
     * Test of findTollEventByRegistration method, of class MySqlTollEventDao.
     */
    @Test
    public void testFindTollEventByRegistration() throws Exception
    {
        System.out.println("findTollEventByRegistration");
        String reg = "191LH1111";
        MySqlTollEventDao instance = new MySqlTollEventDao();
        TollEvent expResult = null;
        TollEvent result = instance.findTollEventByRegistration(reg);
        assertEquals(expResult, result);
    }

    /**
     * Test of findAllTollEventByCertainDate method, of class MySqlTollEventDao.
     */
    @Test
    public void testFindAllTollEventByCertainDate() throws Exception
    {
        System.out.println("findAllTollEventByCertainDate");
        long tstamp = 2020;
        MySqlTollEventDao instance = new MySqlTollEventDao();
        TollEvent expResult = null;
        TollEvent result = instance.findAllTollEventByCertainDate(tstamp);
        assertEquals(expResult, result);
    }

    /**
     * Test of insertTollEvent method, of class MySqlTollEventDao.
     */
    @Test
    public void testInsertTollEvent() throws Exception
    {
        System.out.println("insertTollEvent");
        String registration = "191LH1111";
        long imageId = 30402;
        long timestamp = 2020;
        MySqlTollEventDao instance = new MySqlTollEventDao();
        instance.insertTollEvent(registration, imageId, timestamp);
    }

    /**
     * Test of updateTollEvent method, of class MySqlTollEventDao.
     */
    @Test
    public void testUpdateTollEvent() throws Exception
    {
        System.out.println("updateTollEvent");
        String registration = "191LH1111";
        long imageId = 30402;
        MySqlTollEventDao instance = new MySqlTollEventDao();
        instance.updateTollEvent(registration, imageId);

    }
    
}
