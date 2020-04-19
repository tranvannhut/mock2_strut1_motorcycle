/**
 * StringProcessTest.java
 * 
 * Version 1.0
 *
 * Date:Feb 11, 2020
 *
 * Copyright
 *
 * Modification Logs:
 * DATE                AUTHOR                   DESCRIPTION
 * -----------------------------------------------------------------------
 * Feb 11, 2020             NhutTV1                  Create
 */
package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import common.StringProcess;
import junit.framework.TestCase;

public class StringProcessTest extends TestCase {
    StringProcess instance;
	@Before
	protected void setUp() throws Exception {
		instance = new  StringProcess();
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

    @Test
    public void testGetValidString1(){
    	String expectResult = "";
    	String str = "";
    	String actualResult = StringProcess.getValidString(str);
    	assertEquals(expectResult, actualResult);
    }
    @Test
    public void testGetValidString2(){
    	String expectResult = "";
    	String str = null;
    	String actualResult = StringProcess.getValidString(str);
    	assertEquals(expectResult, actualResult);
    }
    @Test
    public void testGetValidString3(){
    	String expectResult = "1";
    	String str = "1";
    	String actualResult = StringProcess.getValidString(str);
    	assertEquals(expectResult, actualResult);
    }
    
    @Test
    public void testCheckValidString1(){
    	boolean  expectResult = false;
    	String str = "";
    	boolean actualResult = StringProcess.checkValidString(str);
    	assertEquals(expectResult, actualResult);
    }
    @Test
    public void testCheckValidString2(){
    	boolean  expectResult = false;
    	String str = null;
    	boolean actualResult = StringProcess.checkValidString(str);
    	assertEquals(expectResult, actualResult);
    }
    @Test
    public void testCheckValidString3(){
    	boolean  expectResult = true;
    	String str = "1";
    	boolean actualResult = StringProcess.checkValidString(str);
    	assertEquals(expectResult, actualResult);
    }
    @Test
    public void testCheckSpecialCharacter1(){
    	String str = "stupid and smart";
    	boolean expectResult = true;
    	boolean actualResult = StringProcess.checkSpecialCharacter(str);
    	assertEquals(expectResult,actualResult);
    }
    @Test
    public void testCheckSpecialCharacter2(){
    	String str = "smart $$$l";
    	boolean expectResult = false;
    	boolean actualResult = StringProcess.checkSpecialCharacter(str);
    	assertEquals(expectResult,actualResult);
    }
    @Test
    public void testCheckSpecialCharacter3(){
    	String str = "1w ##";
    	boolean expectResult = false;
    	boolean actualResult = StringProcess.checkSpecialCharacter(str);
    	assertEquals(expectResult,actualResult);
    }
    @Test
    public void testCheckNumberNotRequired1(){
    	String str = "";
    	boolean expectResult = true;
    	boolean actualResult = StringProcess.checkNumberNotRequired(str);
    	assertEquals(expectResult,actualResult);
    }
    @Test
    public void testCheckNumberNotRequired2(){
    	String str = "12D";
    	boolean expectResult = false;
    	boolean actualResult = StringProcess.checkNumberNotRequired(str);
    	assertEquals(expectResult,actualResult);
    }
    @Test
    public void testCheckNumberNotRequired3(){
    	String str = "12";
    	boolean expectResult = true;
    	boolean actualResult = StringProcess.checkNumberNotRequired(str);
    	assertEquals(expectResult,actualResult);
    }
    @Test
    public void testCheckNumber1(){
    	String str = "";
    	boolean expectResult = true;
    	boolean actualResult = StringProcess.checkNumberNotRequired(str);
    	assertEquals(expectResult,actualResult);
    }
    @Test
    public void testCheckNumber2(){
    	String str = "12D";
    	boolean expectResult = false;
    	boolean actualResult = StringProcess.checkNumberNotRequired(str);
    	assertEquals(expectResult,actualResult);
    }
    @Test
    public void testCheckNumber3(){
    	String str = "12";
    	boolean expectResult = true;
    	boolean actualResult = StringProcess.checkNumberNotRequired(str);
    	assertEquals(expectResult,actualResult);
    }

    @Test
    public void testCheckYearFormat1(){
    	String str = "";
    	boolean expectResult = true;
    	boolean actualResult = StringProcess.checkNumberNotRequired(str);
    	assertEquals(expectResult,actualResult);
    }
    @Test
    public void testCheckYearFormat2(){
    	String str = "12D33";
    	boolean expectResult = false;
    	boolean actualResult = StringProcess.checkNumberNotRequired(str);
    	assertEquals(expectResult,actualResult);
    }
    @Test
    public void testCheckYearFormat3(){
    	String str = "2018";
    	boolean expectResult = true;
    	boolean actualResult = StringProcess.checkNumberNotRequired(str);
    	assertEquals(expectResult,actualResult);
    }

}
