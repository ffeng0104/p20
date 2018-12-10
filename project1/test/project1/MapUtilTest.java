package project1;

import java.util.*;

import org.apache.commons.collections4.MapUtils;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * @author lea
 * */
public class MapUtilTest {
	
	Map<String, Integer> mapToTest01 = new HashMap<String, Integer>();
	Map<String, Integer> mapToTest02 = new HashMap<String, Integer>();
	Map<String, Object> mapToTest03 = new HashMap<String, Object>();
	Map<String, Object> mapToTest04 = new HashMap<String, Object>();
	
	/**
	 * @throws java.lang.Exception
	 * */
	@Before
	public void setUp() throws Exception{
		mapToTest01.put("ONE", 1);
	}
	
	/**
	 * Test frame TC0101
	 * */
	@Test
	public void TC0101(){
		assertTrue("Not null",MapUtils.getObject(null,"ONE") == null);
	}
	
	/**
	 * Test frame TC0102
	 * */
	@Test
	public void TC0102(){
		assertTrue("not equal", MapUtils.getObject(mapToTest01,"ONE") == 1);
	}
	
	/**
	 * Test frame TC0103
	 * */
	@Test
	public void TC0103(){
		assertEquals(null, MapUtils.getObject(mapToTest02,"ONE"));
	}
	
	/**
	 * Test frame TC0201
	 * */
	@Test
	public void TC0201(){	
		MapUtils.safeAddToMap(null, "ONE", null);
		
	}
	
	/**
	 * Test frame TC0202
	 * */
	@Test
	public void TC0202(){	
		MapUtils.safeAddToMap(mapToTest03, "ONE", null);
		assertTrue(mapToTest03.get("ONE") == "");

	}
	
	/**
	 * Test frame TC0203
	 * */
	@Test
	public void TC0203(){	
		MapUtils.safeAddToMap(mapToTest04, "ONE", "1");
		assertTrue("Not equal", mapToTest04.get("ONE").equals("1"));
	}
	
}
