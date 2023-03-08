package datastruct;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyUnsortedListTest {

	@Test
	public void emptyTest() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		assertEquals("list should be empty",true, list.isEmpty());
	}
	
	@Test
	public void notEmptyTest() {
		UnsortedList<Integer> list = MyUnsortedList.of(1);
		assertEquals("list should not be empty",false, list.isEmpty());
	}
	
	@Test
	public void emptySizeTest() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		assertEquals("list size should be 0",0, list.size());
	}
	
	@Test
	public void notEmptySizeTest() {
		UnsortedList<Integer> list = MyUnsortedList.of(1,2,3,4);
		assertEquals("list size should be 4",4, list.size());
	}
	
	@Test
	public void equalsTest() {
		UnsortedList<Integer> list1 = MyUnsortedList.of(1,2,3,4);
		UnsortedList<Integer> list2 = MyUnsortedList.of(1,2,3,4);
		assertEquals("lists should be equals",true, list1.equals(list2));
	}
	
	@Test
	public void equalsTest2() {
		UnsortedList<Integer> list1 = MyUnsortedList.of();
		UnsortedList<Integer> list2 = MyUnsortedList.of();
		assertEquals("lists should be equals",true, list1.equals(list2));
	}
	
	@Test
	public void notEqualsTest() {
		UnsortedList<Integer> list1 = MyUnsortedList.of(1,2,3,4);
		UnsortedList<Integer> list2 = MyUnsortedList.of(1,3,4);
		assertEquals("lists should not be equals",false, list1.equals(list2));
	}
	
	@Test
	public void notEqualsTest2() {
		UnsortedList<Integer> list1 = MyUnsortedList.of(1,2,3,4);
		UnsortedList<Integer> list2 = MyUnsortedList.of(1,3,4,5);
		assertEquals("lists should not be equals",false, list1.equals(list2));
	}
	
	@Test
	public void equalsNullTest() {
		UnsortedList<Integer> list1 = MyUnsortedList.of(1,2,3,4);
		assertEquals("lists should not be equals",false, list1.equals(null));
	}
	
	@Test(expected = EmptyListException.class)
	public void popExceptionTest() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		int elem =  list.pop();
	}
	
	@Test
	public void popTest() {
		UnsortedList<Integer> list = MyUnsortedList.of(1,5,6,8,4,9);
		int elem =  list.pop();
		assertEquals("elem should be 1",1, elem);
		elem =  list.pop();
		assertEquals("elem should be 1",5, elem);
		elem =  list.pop();
		assertEquals("elem should be 1",6, elem);
		elem =  list.pop();
		assertEquals("elem should be 1",8, elem);
	}
	
	@Test(expected = EmptyListException.class)
	public void popLastExceptionTest() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		int elem =  list.popLast();
	}
	
	@Test
	public void popLastTest() {
		UnsortedList<Integer> list = MyUnsortedList.of(1,5,6,8,4,9);
		int elem =  list.popLast();
		assertEquals("elem should be 9",9, elem);
		elem =  list.popLast();
		assertEquals("elem should be 4",4, elem);
		elem =  list.popLast();
		assertEquals("elem should be 8",8, elem);
		elem =  list.popLast();
		assertEquals("elem should be 6",6, elem);
	}
	
	@Test
	public void appendSizeTest() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		list.append(5);
		list.append(10);
		list.append(25);
		assertEquals("list size should be 3",3, list.size());
	}
	
	@Test
	public void appendTest() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		list.append(5);
		list.append(10);
		list.append(25);
		UnsortedList<Integer> list2 = MyUnsortedList.of(5,10,25);
		assertEquals("lists should be equals",true, list.equals(list2));
	}
	
	@Test
	public void prependSizeTest() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		list.prepend(5);
		list.prepend(10);
		list.prepend(25);
		assertEquals("list size should be 3",3, list.size());
	}
	
	@Test
	public void prependTest() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		list.prepend(5);
		list.prepend(10);
		list.prepend(25);
		UnsortedList<Integer> list2 = MyUnsortedList.of(25,10,5);
		assertEquals("lists should be equals",true, list.equals(list2));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void removeExceptionTest1() {
		UnsortedList<Integer> list = MyUnsortedList.of(1,5,6);
		list.remove(-5);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void removeExceptionTest2() {
		UnsortedList<Integer> list = MyUnsortedList.of(1,5,6);
		list.remove(5);
	}
	
	@Test
	public void removeTest() {
		UnsortedList<Integer> list = MyUnsortedList.of(1,5,6);
		int elem = list.remove(2);
		assertEquals("elem should be 6",6, elem);
		elem = list.remove(0);
		assertEquals("elem should be 1",1, elem);
		elem = list.remove(0);
		assertEquals("elem should be 5",5, elem);
		
	}
	
	@Test
	public void removeSizeTest() {
		UnsortedList<Integer> list = MyUnsortedList.of(1,5,6,8);
		assertEquals("size should be 4",4, list.size());
		list.remove(0);
		assertEquals("size should be 3",3, list.size());
		list.remove(0);
		assertEquals("size should be 2",2, list.size());
		list.remove(0);
		assertEquals("size should be 1",1, list.size());
		list.remove(0);
		assertEquals("size should be 0",0, list.size());
		assertEquals("list should be empty",true, list.isEmpty());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void insertExceptionTest1() {
		UnsortedList<Integer> list = MyUnsortedList.of(1,5,6);
		list.insert(50, -5);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void insertExceptionTest2() {
		UnsortedList<Integer> list = MyUnsortedList.of(1,5,6);
		list.insert(50, 5);
	}	
	
	@Test
	public void insertTest() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		list.insert(50, 0);
		list.insert(10, 0);
		list.insert(25, 1);
		list.insert(100, 3);
		UnsortedList<Integer> list2 = MyUnsortedList.of(10,25,50,100);
		assertEquals("lists should be equals",true, list.equals(list2));
	}
	
	@Test
	public void insertSizeTest() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		list.insert(50, 0);
		list.insert(10, 0);
		list.insert(25, 1);
		list.insert(100, 3);
		assertEquals("size should be 4",4, list.size());
		int elem =  list.popLast();
		assertEquals("size should be 3",3, list.size());
		elem =  list.popLast();
		assertEquals("size should be 2",2, list.size());
		elem =  list.popLast();
		assertEquals("size should be 1",1, list.size());
		elem =  list.popLast();
		assertEquals("size should be 0",0, list.size());
		assertEquals("list should be empty",true, list.isEmpty());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void showExceptionTest() {
		UnsortedList<Integer> list = MyUnsortedList.of(10,20);
		int elem = list.show(10);
	}
	
	@Test
	public void showTest() {
		UnsortedList<Integer> list = MyUnsortedList.of(10,20,30,40);
		int elem = list.show(0);
		assertEquals("elem should be 10",10, elem);
		elem = list.show(1);
		assertEquals("elem should be 20",20, elem);
		elem = list.show(2);
		assertEquals("elem should be 30",30, elem);
		elem = list.show(3);
		assertEquals("elem should be 40",40, elem);
		
	}

}
