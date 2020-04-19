/**
 * MotorCycleDaoTest.java
 * 
 * Version 1.0
 *
 * Date:Feb 10, 2020
 *
 * Copyright
 *
 * Modification Logs:
 * DATE                AUTHOR                   DESCRIPTION
 * -----------------------------------------------------------------------
 * Feb 10, 2020             NhutTV1                  Create
 */
package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import model.bean.MotorCycle;
import model.dao.MotorCycleDao;

public class MotorCycleDaoTest extends TestCase {
   MotorCycleDao instance;
	@Before
	protected void setUp() throws Exception {
		instance = new MotorCycleDao();
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}
  // run UT for sheet ListMotor in whiteBox
	@Test
	public void testListMotor1(){
		int size = 0;
		int pageSize = 10;
		int pageNum = 1;
		String makerId = "";
		String motorCycleName = "Sirius 125cc";
		String cylinder = "2332";
		String releasedInYear = "2011";
		int result = instance.getAllMotorCycle(pageSize, pageNum, makerId, motorCycleName, cylinder, releasedInYear).size();
        assertEquals(size, result);	
	}
	@Test
	public void testListMotor2(){
		int size = 10;
		int pageSize = 10;
		int pageNum = 1;
		String makerId = "";
		String motorCycleName = "";
		String cylinder = "";
		String releasedInYear = "";
		int result = instance.getAllMotorCycle(pageSize, pageNum, makerId, motorCycleName, cylinder, releasedInYear).size();
        assertEquals(size, result);	
	}
    
	@Test
	public void testGetList3(){
		int size = 1;
		int pageSize = 10;
		int pageNum = 6;
		String makerId = "";
		String motorCycleName = "";
		String cylinder = "";
		String releasedInYear = "";
		int result = instance.getAllMotorCycle(pageSize, pageNum, makerId, motorCycleName, cylinder, releasedInYear).size();
        assertEquals(size, result);	
	}
	@Test
	public void testGetList4(){
		int size = 0;
		int pageSize = 10;
		int pageNum = 8;
		String makerId = "";
		String motorCycleName = "";
		String cylinder = "";
		String releasedInYear = "";
		int result = instance.getAllMotorCycle(pageSize, pageNum, makerId, motorCycleName, cylinder, releasedInYear).size();
        assertEquals(size, result);	
	}
	@Test
	public void testGetList5(){
		int size = 20;
		int pageSize = 20;
		int pageNum = 1;
		String makerId = "";
		String motorCycleName = "";
		String cylinder = "";
		String releasedInYear = "";
		int result = instance.getAllMotorCycle(pageSize, pageNum, makerId, motorCycleName, cylinder, releasedInYear).size();
        assertEquals(size, result);	
	}
	@Test
	public void testGetList6(){
		int size = 11;
		int pageSize = 20;
		int pageNum = 3;
		String makerId = "";
		String motorCycleName = "";
		String cylinder = "";
		String releasedInYear = "";
		int result = instance.getAllMotorCycle(pageSize, pageNum, makerId, motorCycleName, cylinder, releasedInYear).size();
        assertEquals(size, result);	
	}
	@Test
	public void testGetList7(){
		int size = 10;
		int pageSize = 10;
		int pageNum = 1;
		String makerId = "HD001";
		String motorCycleName = "";
		String cylinder = "125";
		String releasedInYear = "";
		int result = instance.getAllMotorCycle(pageSize, pageNum, makerId, motorCycleName, cylinder, releasedInYear).size();
        assertEquals(size, result);	
	}
	@Test
	public void testGetList8(){
		int size = 8;
		int pageSize = 10;
		int pageNum = 1;
		String makerId = "HD001";
		String motorCycleName = "";
		String cylinder = "125";
		String releasedInYear = "2010";
		int result = instance.getAllMotorCycle(pageSize, pageNum, makerId, motorCycleName, cylinder, releasedInYear).size();
        assertEquals(size, result);	
	}
	@Test
	public void testGetList9(){
		int size = 1;
		int pageSize = 10;
		int pageNum = 1;
		String makerId = "HD001";
		String motorCycleName = "Sirius 125cc";
		String cylinder = "125";
		String releasedInYear = "2010";
		int result = instance.getAllMotorCycle(pageSize, pageNum, makerId, motorCycleName, cylinder, releasedInYear).size();
        assertEquals(size, result);	
	}
	// test script UT for sheet ListMotorCycleNameAndCylinder in White-box Motor
	@Test
	public void testListMotorCycleNameAndCylinder1(){
		int size = 0;
		int result = instance.getListMotorNameAndCylinder().size();
		assertEquals(size, result);		
	}
	@Test
	public void testListMotorCycleNameAndCylinder2(){
		int size = 10;
		int result = instance.getListMotorNameAndCylinder().size();
		assertEquals(size, result);		
	}
	//Write script UT for sheet getCountRecord
    @Test
    public void testGetCountRecord1(){
    	int expectOfNumber = 0;
    	String makerId = "HD001";
    	String motorCycleName = "Sirius 110cc";
    	String cylinder = "125";
    	String releasedInYear = "";
    	int result = instance.getCountRecord(makerId, motorCycleName, cylinder, releasedInYear);
    	assertEquals(expectOfNumber,result);
    }
    @Test
    public void testGetCountRecord2(){
    	int expectOfNumber = 10;
    	String makerId = "HD001";
    	String motorCycleName = "";
    	String cylinder = "";
    	String releasedInYear = "2010";
    	int result = instance.getCountRecord(makerId, motorCycleName, cylinder, releasedInYear);
    	assertEquals(expectOfNumber,result);
    }
    @Test
    public void testGetCountRecord3(){
    	int expectOfNumber = 50;
    	String makerId = "";
    	String motorCycleName = "";
    	String cylinder = "";
    	String releasedInYear = "";
    	int result = instance.getCountRecord(makerId, motorCycleName, cylinder, releasedInYear);
    	assertEquals(expectOfNumber,result);
    }
    
    //write script UT for sheet getMotorCycle
    @Test 
    public void testGetMotorCycle1(){
    	MotorCycle expectOfMotorCycle = null;
    	String id = "";
    	MotorCycle actualOfMotorCycle  = instance.findId(id);
    	assertSame(expectOfMotorCycle, actualOfMotorCycle);
    }
    @Test 
    public void testGetMotorCycle2(){
    	MotorCycle expectOfMotorCycle = null;
    	
    	String id = "33";
    	MotorCycle actualOfMotorCycle = instance.findId(id);
    	assertSame(expectOfMotorCycle, actualOfMotorCycle);
    }
    @Test 
    public void testGetMotorCycle3(){
    	MotorCycle expectOfMotorCycle = new MotorCycle("2","Ya002","Exciter 150 GP","150","2010");
    	String id = "2";
    	MotorCycle actualOfMotorCycle = instance.findId(id);
    	assertSame(expectOfMotorCycle.getId(), actualOfMotorCycle.getId());
    }
    //write script UT for sheet CheckID 
    @Test 
    public void testCheckId1(){
    	boolean expectResult = false;
    	String id = "";
    	boolean actualResult = instance.checkId(id);
    	assertEquals(expectResult, actualResult);
    	
    }
    @Test 
    public void testCheckId2(){
    	boolean expectResult = false;
    	String id = "33";
    	boolean actualResult = instance.checkId(id);
    	assertEquals(expectResult, actualResult);
    	
    }
    @Test 
    public void testCheckId3(){
    	boolean expectResult = true;
    	String id = "1";
    	boolean actualResult = instance.checkId(id);
    	assertEquals(expectResult, actualResult);
    	
    }
    //write script UT case for sheet insertMotorCycle
    @Test 
    public void testInsertMotorCycle1(){
    	boolean expectResult = true;    	
    	boolean actualResult = instance.insertMotorCycle(new MotorCycle("1","HD001","Pcx white 115","115","2010"));
        assertEquals(expectResult, actualResult);
    }
    @Test 
    public void testInsertMotorCycle2(){
    	boolean expectResult = true;    	
    	boolean actualResult = instance.insertMotorCycle(new MotorCycle("2","Ya002","Exciter 150 GP","150","2010"));
        assertEquals(expectResult, actualResult);
    }
    @Test 
    public void testInsertMotorCycle3(){
    	boolean expectResult = false;    	
    	boolean actualResult = instance.insertMotorCycle(new MotorCycle("2","Ya002","Exciter 150 GP","150","2010"));
        assertEquals(expectResult, actualResult);
    }
    //write script UT case for sheet checkNewRowInsert
    @Test 
    public void testCheckNewRowInsert1(){
    	int expectResult = 4;
    	String id = "2";
    	int actualResult = instance.checkNewRowInsert(id);
    	assertEquals(expectResult, actualResult);
    }
    @Test 
    public void testCheckNewRowInsert2(){
    	int expectResult = 0;
    	String id = "33";
    	int actualResult = instance.checkNewRowInsert(id);
    	assertEquals(expectResult, actualResult);
    }
    @Test 
    public void testCheckNewRowInsert3(){
    	int expectResult = 0;
    	String id = "";
    	int actualResult = instance.checkNewRowInsert(id);
    	assertEquals(expectResult, actualResult);
    }
    //Write script UT case for sheet updateMotorCycle
    @Test
    public void testUpdateMotorCycle1(){
    	boolean expectResult = true;
    	boolean actualResult = instance.updateMotor(new MotorCycle("1", "HD001", "Future 115", "115", "2010"));
    	assertEquals(expectResult, actualResult);
    }
    @Test
    public void testUpdateMotorCycle2(){
    	boolean expectResult = false;
    	boolean actualResult = instance.updateMotor(new MotorCycle("1222", "HD001", "Future 115", "115", "2010"));
    	assertEquals(expectResult, actualResult);
    }
    // Write script UT case for sheet deleteMotor
    @Test
    public void testDeleteMotor1(){
    	boolean expectResult = true;
    	String id= "1";
    	boolean actualResult = instance.deleteMotor(id);
    	assertEquals(expectResult, actualResult);
    }
    @Test
    public void testDeleteMotor2(){
    	boolean expectResult = false;
    	String id= "1225";
    	boolean actualResult = instance.deleteMotor(id);
    	assertEquals(expectResult, actualResult);
    }
    
}

