/**
 * 
 */


import textgen.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 


	public MyLinkedList<String> shortList;
	public MyLinkedList<Integer> emptyList;
	public MyLinkedList<Integer> longerList;
	public MyLinkedList<Integer> list1;
        public MyLinkedList<Integer> testMyLinkedList;
        
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
                shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
                
                testMyLinkedList = new MyLinkedList<Integer>();
                testMyLinkedList.add(2);
                testMyLinkedList.add(4);
                testMyLinkedList.add(6);
                testMyLinkedList.add(8);
                testMyLinkedList.add(10);
                testMyLinkedList.add(12);
                
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
	
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		list1.add(0, 10);
		list1.remove(0);
		list1.add(0, 1);
                assertEquals("check ", (Integer)1, list1.get(0));
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
       
            testMyLinkedList.add(14);
            assertEquals("Check add the end", (Integer)14, testMyLinkedList.get(6));
               
            
            try {
			testMyLinkedList.add(null);
			fail("Check null");
		}
		catch (NullPointerException e) {
		
		}
            
               
      
		
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		assertEquals("Check ", (Integer)6, (Integer)testMyLinkedList.size());
               
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        assertEquals("Check befpre adding", (Integer)10, testMyLinkedList.get(4));
                 testMyLinkedList.add(4 , 100);
                 
                 assertEquals("Check prev", (Integer)8   ,   testMyLinkedList.get(3));
                 assertEquals("Check the new element", (Integer)100 , testMyLinkedList.get(4));
                 assertEquals("Check next", (Integer)10  ,  testMyLinkedList.get(5));
                 
                
                try {
			testMyLinkedList.add(-1,-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
                 try {
			testMyLinkedList.add(20,1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
           
		
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
		assertEquals("Check first", (Integer)10, testMyLinkedList.get(4));
                Integer replaced = testMyLinkedList.set(4 , 100);
                
                assertEquals("set new element ", (Integer)100, testMyLinkedList.get(4));
                assertEquals("replaced elemenr", (Integer)10, replaced );
		
		
		try {
			testMyLinkedList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
                try {
			testMyLinkedList.get(9);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
	}


//todo Check that you can't set an element at too high of an index. 
//Test #5: Lower bounds on remove...FAILED. Ensure that you can't remove an element at too low of an index. 
//Test #6: Upper bounds on remove...FAILED. Ensure that you can't remove an element at too high of an index. 
	

}
