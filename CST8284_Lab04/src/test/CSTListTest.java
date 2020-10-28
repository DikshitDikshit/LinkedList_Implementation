package test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import linkedList.CSTLinkedList;

public class CSTListTest {

	private static final CSTLinkedList<Integer> TEST = new CSTLinkedList<Integer>();
	private static final Integer TEST_NUMBER = 111;

	@BeforeEach
	public void setup() {
		TEST.clear();
		TEST.addLast(222);
		TEST.addLast(333);
	}

	@Test
	public void testAddFirst() {
		TEST.addFirst(TEST_NUMBER);
		assertEquals(TEST_NUMBER, TEST.get(0));
	}

	@Test
	public void testGetFirst() {
		TEST.addFirst(TEST_NUMBER);
		assertEquals(TEST_NUMBER, TEST.getFirst());
	}

	@Test
	public void testAddLast() {
		TEST.addLast(TEST_NUMBER);
		assertEquals(TEST_NUMBER, TEST.get(TEST.size() - 1));
	}

	@Test
	public void testGet() {
		TEST.addFirst(TEST_NUMBER);
		assertEquals(TEST_NUMBER, TEST.get(0));
	}

	@Test
	public void testRemoveFirst() {
		TEST.addFirst(TEST_NUMBER);
		Integer removedElement = TEST.removeFirst();
		assertEquals(TEST_NUMBER, removedElement);
		assertEquals((Integer) 222, TEST.get(0));
	}

	@Test
	public void testRemoveLast() {
		TEST.addLast(TEST_NUMBER);
		Integer removedElement = TEST.removeLast();
		assertEquals(TEST_NUMBER, removedElement);
	}

	@Test
	public void testIsEmpty() {
		assertFalse(TEST.isEmpty());
		TEST.clear();
		assertTrue(TEST.isEmpty());
	}

	@Test
	public void testSize() {
		int originalSize = TEST.size();
		TEST.addFirst(123);
		int afterAddSize = TEST.size();
		assertEquals(originalSize + 1, afterAddSize);
		TEST.removeFirst();
		int afterRemoveSize = TEST.size();
		assertEquals(originalSize, afterRemoveSize);
	}

	@Test
	public void testClear() {
		assertFalse(TEST.isEmpty());
		TEST.clear();
		assertTrue(TEST.isEmpty());
	}

}
