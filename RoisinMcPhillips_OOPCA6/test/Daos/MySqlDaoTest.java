/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import java.sql.Connection;
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
public class MySqlDaoTest
{
    
    public MySqlDaoTest()
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
     * Test of getConnection method, of class MySqlDao.
     */
    @Test
    public void testGetConnection() throws Exception
    {
        System.out.println("getConnection");
        MySqlDao instance = new MySqlDao();
        Connection expResult = null;
        Connection result = instance.getConnection();
        assertEquals(expResult, result);
    }

    /**
     * Test of freeConnection method, of class MySqlDao.
     */
    @Test
    public void testFreeConnection() throws Exception
    {
        System.out.println("freeConnection");
        Connection con = null;
        MySqlDao instance = new MySqlDao();
        instance.freeConnection(con);
    }
    
}
