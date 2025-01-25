package ru.netology;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TaskTest {
    @Test
    void testEquals() {
        Task task = new Task(7);
        boolean expected = true;
        boolean actual = task.equals(task);
        assertEquals(expected, actual);
        expected = false;
        actual = task.equals(null);
        assertEquals(expected, actual);
        var object = 5;
        expected = false;
        actual = task.equals(object);
        assertEquals(expected, actual);
        expected = false;
    }

    @Test
    void testHashCode() {
        Task task = new Task(7);
        var expected = 7;
        var actual = task.getId();
        assertEquals(expected, actual);
    }

    @Test
    void testMatches() {
        Task task = new Task(7);
        boolean expected = false;
        boolean actual = task.matches("Спагетти");
        assertEquals(expected, actual);
    }
}
