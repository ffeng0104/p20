package project1;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class BagTest {
	Bag<String> bag = new HashBag<String>();
	Bag<String> emptyBag = new HashBag<String>();
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		bag.add("One");
		bag.add("Two",3);
	}
	
	/**
	 * Test Case 1.1 Add 0 object to a bag.
	 */
	@Test
	public void TC11() {
		assertFalse(bag.add(null));
	}
	
	/**
	 * Test Case 1.2 Add 1 distinct object to a bag.
	 */
	@Test
	public void TC12() {
		assertTrue(bag.add("Three"));
	}
	
	/**
	 * Test Case 2.1 Add 0 copy of null in a bag
	 */
	@Test
    public void TC21() {
		assertFalse(bag.add(null,0));
	}
	
	/**
	 * Test Case 2.2 Add valid number copies of one distinct object to a bag.
	 */
	@Test
	public void TC22() {
		assertTrue(bag.add("Six",3));
	}
	
	/**
	 * Test Case 3.1 Test size of a non-empty bag.
	 */
	@Test
	public void TC31() {
		int i = 4;
		assertSame(bag.size(),i);
	}
	
	/**
	 * Test Case 3.2 Test size of an empty bag.
	 */
	@Test
	public void TC32() {
		int i = 0;
		assertSame(i,emptyBag.size());
	}
	
	/**
	 * Test Case 4.1 Test unique set of a non-empty bag.
	 */
	@Test
	public void TC41() {
		Set<String> expected = new HashSet<>(Arrays.asList("One","Two"));
		assertTrue(expected.containsAll(bag.uniqueSet()));
		assertTrue(bag.uniqueSet().containsAll(expected));
	}
	
	/**
	 * Test Case 4.2 Test unique set of an empty bag.
	 */
	@Test
	public void TC42() {
		assertTrue(emptyBag.uniqueSet().isEmpty());
	}
	
	/**
	 * Test Case 5.1 Test if an empty bag contains null. 
	 */
	@Test (expected = NullPointerException.class)
	public void TC51() {
		emptyBag.containsAll(null);
	}
	
	/**
	 * Test Case 5.2 Test if a non-empty bag contains an object not in the bag.
	 */
	@Test
	public void TC52() {
		assertFalse(bag.containsAll(Arrays.asList("Three")));
	}
	
	/**
	 * Test Case 5.3 Test if a non-empty bag contains a larger object set with an object not in the bag.
	 */
	@Test
	public void TC53() {
		assertFalse(bag.containsAll(Arrays.asList("One","Two","Two","Two","Three")));
	}
	
	/**
	 * Test Case 6.1 Test if an empty bag can retain null. 
	 */
	@Test(expected = NullPointerException.class)
	public void TC61() {
		assertFalse(emptyBag.retainAll(null));
	}
	
	/**
	 * Test Case 6.2 Test if a non-empty bag can retain a larger object set with an object not in the bag.
	 */
	@Test
	public void TC62() {
		assertFalse(bag.retainAll(Arrays.asList("One","Two","Two","Two","Three")));
	}
	
	/**
	 * Test Case 6.3 Test if an empty bag can retain an object which is obviously not in the bag.
	 */
	@Test
	public void TC63() {
		assertFalse(emptyBag.retainAll(Arrays.asList("One")));
	}
	
	/**
	 * Test Case 7.1 Test removing null from a bag.
	 */
	@Test
	public void TC71() {
		assertFalse(bag.remove(null));
	}
	
	/**
	 * Test Case 7.2 Test removing a distinct object from a bag.
	 */
	@Test
	public void TC72() {
		assertTrue(bag.remove("One"));
	}
	
	/**
	 * Test Case 8.1 Test removing 0 copy of null from a bag.
	 */
	@Test
    public void TC81() {
		assertFalse(bag.remove(null,0));
	}
	
	/**
	 * Test Case 8.2 Test removing valid copies of a distinct object from a bag.
	 */
	@Test
	public void TC82() {
		assertTrue(bag.remove("Two",3));
	}
	
	/**
	 * Test Case 9.1 Test removing null from an empty bag.
	 */
	@Test 
	public void TC91() {
		assertTrue(emptyBag.removeAll(null));
	}
	
	/**
	 * Test Case 9.2 Test removing a set of one distinct object from a non-empty bag.
	 */
	@Test
	public void TC92() {
		assertTrue(bag.removeAll(Arrays.asList("Two")));
	}
	
	/**
	 * Test Case 9.3 Test removing an larger object set than the bag which has objects not in the bag.
	 */
	@Test
	public void TC93() {
		assertFalse(bag.removeAll(Arrays.asList("One","Two","Two","Two","Three")));
	}
}
