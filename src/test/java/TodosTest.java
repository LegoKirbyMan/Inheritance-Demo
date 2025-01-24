import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ru.netology.Epic;
import ru.netology.Meeting;
import ru.netology.SimpleTask;
import ru.netology.Task;
import ru.netology.Todos;

public class TodosTest {
@Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchTest() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("Позвонить");
        Assertions.assertArrayEquals(expected, actual);

        Task[] expected2 = {epic};
        actual = todos.search("Хлеб");
        Assertions.assertArrayEquals(expected2, actual);

        Task[] expected3 = {meeting};
        actual = todos.search("приложения");
        Assertions.assertArrayEquals(expected3, actual);
        actual = todos.search("НетоБанка");
        Assertions.assertArrayEquals(expected3, actual);
    }

    @Test
    public void searchTest2() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("Спагетти");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchTest3() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        
        
        String expected = "Позвонить родителям";
        String actual = simpleTask.getTitle();
        Assertions.assertEquals(expected, actual);

        expected = "Выкатка 3й версии приложения";
        actual = meeting.getTopic();
        Assertions.assertEquals(expected, actual);

        expected = "Приложение НетоБанка";
        actual = meeting.getProject();
        Assertions.assertEquals(expected, actual);

        expected = "Во вторник после обеда";
        actual = meeting.getStart();
        Assertions.assertEquals(expected, actual);

        String[] expected2 = { "Молоко", "Яйца", "Хлеб" };
        String[] actual2 = epic.getSubtasks();
        Assertions.assertArrayEquals(expected2, actual2);
    }
}
