/**
 * 
 */
package project1;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.map.LinkedMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Faye
 *
 */
public class OrderedMapTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFirstKeyPass() {
		OrderedMap<String, String> map = new LinkedMap<String, String>();
		map.put("ONE", "1");
		map.put("TWO", "2");
		map.put("THREE", "3");
		Object actual = map.firstKey();
		assertEquals( "ONE", actual );
	}
	
	@Test
	public void testFirstKeyFail() {
		OrderedMap<String, String> map = new LinkedMap<String, String>();
		map.put("ONE", "1");
		map.put("TWO", "2");
		map.put("THREE", "3");
		Object actual = map.firstKey();
		assertEquals( "TWO", actual );
	}
	
	@Test
	public void testFirstKeyError() {
		OrderedMap<String, String> map = new LinkedMap<String, String>();
		Object actual = map.firstKey();
		assertEquals( "empty", actual );
	}
	
	@Test (expected = NoSuchElementException.class)
	public void testFirstKeyException() {
		OrderedMap<String, String> map = new LinkedMap<String, String>();
		map.firstKey();
	}

}
