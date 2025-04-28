package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import task.Task;

class TaskTest {

	@Test
	void allGoodTest() {
		Task task = new Task("goodID", "goodName", "goodDescription");
		assertTrue(task.getTaskID().equals("goodID"));
		assertTrue(task.getTaskName().equals("goodName"));
		assertTrue(task.getTaskDescription().equals("goodDescription"));
	}
	
	@Test
	void testBadIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			new Task("badidtoolong", "goodName", "goodDescription");
		});
	}
	
	@Test
	void testBadIdNull() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			new Task(null, "goodName", "goodDescription");
		});
	}
	
	@Test
	void testBadNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			new Task("goodID", "badNameBecauseItsJustTooLong", "goodDescription");
		});
	}
	
	@Test
	void testBadNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			new Task("goodID", null, "goodDescription");
		});
	}
	
	@Test
	void testBadDescriptionTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			new Task("goodID", "goodName", "BadDescription11111111112222222222333333333344444444445555555555");
		});
	}
	
	@Test
	void testBadDescriptionNull() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			new Task("goodID", "goodName", null);
		});
	}
}
