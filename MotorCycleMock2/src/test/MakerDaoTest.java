/*
* (C)Copyright 2019 Fresher Academy . All right reverse
* Author HP_NhutTV1
* Date  Feb 10, 2020
* Version 1.0
*/
/**
 * 
 */
package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import model.dao.MakerDao;

/**
 * @author HP
 *
 */
public class MakerDaoTest  extends TestCase{
    MakerDao instance;
	
	@Before
	public void setUp() throws Exception {
		instance = new MakerDao();
	}

	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetList1(){
		int expectResult = 0;
		int actualResult = instance.getListMarker().size();
		assertEquals(expectResult, actualResult);
	}
	@Test
	public void testGetList2(){
		int expectResult = 3;
		int actualResult = instance.getListMarker().size();
		assertEquals(expectResult, actualResult);
	}
}
