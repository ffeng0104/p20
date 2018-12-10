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
 * @author Fei
 *
 */
public class OrderedMapTest {
	OrderedMap<String, String> map = new LinkedMap<String, String>();

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
		map.put("ONE", "1");
		map.put("TWO", "2");
		map.put("THREE", "3");
		Object actual = map.firstKey();
		assertEquals( "ONE", actual );
	}
	
	@Test (expected = NoSuchElementException.class)
	public void testFirstKeyException() {
		map.firstKey();
	}
	
	@Test
	public void testLastKeyPass() {
		map.put("ONE", "1");
		map.put("TWO", "2");
		map.put("THREE", "3");
		Object actual = map.lastKey();
		assertEquals( "THREE", actual );
	}
	
	@Test (expected = NoSuchElementException.class)
	public void testLastKeyException() {
		map.lastKey();
	}
	
	@Test
	public void testNextKeyPass() {
		map.put("ONE", "1");
		map.put("TWO", "2");
		map.put("THREE", "3");
		Object actual = map.nextKey("ONE");
		assertEquals( "TWO", actual );
	}
	
	@Test
	public void testNextKeyAtEnd() {
		map.put("ONE", "1");
		map.put("TWO", "2");
		map.put("THREE", "3");
		Object actual = map.nextKey("THREE");
		assertEquals( null, actual );
	}
	
	@Test 
	public void testNextKeyNoMatch() {
		map.put("ONE", "1");
		map.put("TWO", "2");
		map.put("THREE", "3");
		Object actual = map.nextKey("FIVE");
		assertEquals( null, actual );
	}
	
	@Test 
	public void testNextKeyEmptyMap() {
		Object actual = map.nextKey("ONE");
		assertEquals( null, actual );
	}
	
	@Test
	public void testPreviousKeyPass() {
		map.put("ONE", "1");
		map.put("TWO", "2");
		map.put("THREE", "3");
		Object actual = map.previousKey("THREE");
		assertEquals( "TWO", actual );
	}
	
	@Test
	public void testPreviousKeyAtStart() {
		map.put("ONE", "1");
		map.put("TWO", "2");
		map.put("THREE", "3");
		Object actual = map.previousKey("ONE");
		assertEquals( null, actual );
	}
	
	@Test 
	public void testPreviousKeyNoMatch() {
		map.put("ONE", "1");
		map.put("TWO", "2");
		map.put("THREE", "3");
		Object actual = map.previousKey("FIVE");
		assertEquals( null, actual );
	}
	
	@Test 
	public void testPreviousKeyEmptyMap() {
		Object actual = map.previousKey("ONE");
		assertEquals( null, actual );
	}

}
