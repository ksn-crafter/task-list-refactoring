import com.codurance.training.tasks.Task;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TaskTests {

    @Test
    public void testTaskFormatWhichIsNotDone(){
        Task task = new Task(123,"some task",false);
        String formattedTask = task.format();
        String expectedFormat = "[ ] 123: some task\r\n";
        assertEquals(expectedFormat,formattedTask);
    }

    @Test
    public void testTaskFormatWhichIsDone(){
        Task task = new Task(123,"some task",true);
        String formattedTask = task.format();
        String expectedFormat = "[x] 123: some task\r\n";
        assertEquals(expectedFormat,formattedTask);
    }
}
