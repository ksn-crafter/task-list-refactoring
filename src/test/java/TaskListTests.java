import com.codurance.training.tasks.TaskList;
import org.junit.Test;

import java.io.StringWriter;

import static org.junit.Assert.assertEquals;

public class TaskListTests {
    //TODO: handle line ending \r\n on non windows platform
    @Test
    public void testExecuteWithAdditionOfOneProjectWithOneTask() throws Exception {
        StringWriter writer = new StringWriter();
        TaskList taskList = new TaskList(writer);
        taskList.execute("add project caizin");
        taskList.execute("add task caizin Task1");
        taskList.execute("show");

        String expected = "caizin\n" + "[ ] 1: Task1" + "\r\n";
        assertEquals(expected, writer.toString());
    }

    @Test
    public void testExecuteWithAdditionOfOneProjectWithMultipleTask() throws Exception {
        StringWriter writer = new StringWriter();
        TaskList taskList = new TaskList(writer);
        taskList.execute("add project caizin");
        taskList.execute("add task caizin Task1");
        taskList.execute("add task caizin Task2");
        taskList.execute("show");

        String expected = "caizin\n" +
                "[ ] 1: Task1\r\n" +
                "[ ] 2: Task2\r\n";
        assertEquals(expected, writer.toString());
    }


    @Test
    public void testExecuteWithAdditionOfMultipleProjectWithOneTask() throws Exception {
        StringWriter writer = new StringWriter();
        TaskList taskList = new TaskList(writer);
        taskList.execute("add project caizin");
        taskList.execute("add task caizin Task1");
        taskList.execute("add project smarsh");
        taskList.execute("add task smarsh Task1");
        taskList.execute("show");

        String expected = "caizin\n" +
                "[ ] 1: Task1\r\n" +
                "smarsh\n" +
                "[ ] 1: Task1\r\n";
        assertEquals(expected, writer.toString());
    }
    @Test
    public void testExecuteWithAdditionOfMultipleProjectWithMultipleTask() throws Exception {
        StringWriter writer = new StringWriter();
        TaskList taskList = new TaskList(writer);
        taskList.execute("add project caizin");
        taskList.execute("add task caizin Task1");
        taskList.execute("add task caizin Task2");

        taskList.execute("add project smarsh");
        taskList.execute("add task smarsh Task1");
        taskList.execute("add task smarsh Task2");

        taskList.execute("show");

        String expected = "caizin\n" +
                "[ ] 1: Task1\r\n" +
                "[ ] 2: Task2\r\n" +
                "smarsh\n" +
                "[ ] 1: Task1\r\n" +
                "[ ] 2: Task2\r\n";
                assertEquals(expected, writer.toString());
    }


    @Test
    public void testExecuteWithAdditionOfOneProjectWithOneTaskAndMarkItAsDone() throws Exception{
        StringWriter writer = new StringWriter();
        TaskList taskList = new TaskList(writer);
        taskList.execute("add project caizin");
        taskList.execute("add task caizin Task1");
        taskList.execute("check 1");
        taskList.execute("show");

        String expected = "caizin\n" + "[x] 1: Task1" + "\r\n";
        assertEquals(expected, writer.toString());
    }

    @Test
    public void testExecuteWithAdditionOfOneProjectWithMultipleTaskAndMarkFirstTaskAsDone() throws Exception{
        StringWriter writer = new StringWriter();
        TaskList taskList = new TaskList(writer);
        taskList.execute("add project caizin");
        taskList.execute("add task caizin Task1");
        taskList.execute("add task caizin Task2");
        taskList.execute("check 1");
        taskList.execute("show");

        String expected = "caizin\n" + "[x] 1: Task1" + "\r\n" + "[ ] 2: Task2\r\n";;
        assertEquals(expected, writer.toString());
    }

    @Test
    public void testExecuteWithAdditionOfOneProjectWithOneTaskAndMarkItAsDoneAndUnDoneAgain() throws Exception{
        StringWriter writer = new StringWriter();
        TaskList taskList = new TaskList(writer);
        taskList.execute("add project caizin");
        taskList.execute("add task caizin Task1");
        taskList.execute("check 1");
        taskList.execute("uncheck 1");
        taskList.execute("show");

        String expected = "caizin\n" + "[ ] 1: Task1" + "\r\n";
        assertEquals(expected, writer.toString());
    }
}
