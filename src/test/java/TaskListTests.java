import com.codurance.training.tasks.TaskList;
import org.junit.Test;

import java.io.StringWriter;

import static org.junit.Assert.assertEquals;

public class TaskListTests {
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
}
