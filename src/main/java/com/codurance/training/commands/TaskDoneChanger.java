package com.codurance.training.commands;

import com.codurance.training.tasks.Task;

import java.util.List;
import java.util.Map;

import static java.lang.System.out;

public class TaskDoneChanger {
    //TODO: add test cases for toggleTask
    protected void changeTaskDone(String idString, boolean done, Map<String, List<Task>> projects) {
        int id = Integer.parseInt(idString);
        for (Map.Entry<String, List<Task>> project : projects.entrySet()) {
            for (Task task : project.getValue()) {
                if (task.idEqualTo((long)id)) {
                    task.changeDone(done);
                    return;
                }
            }
        }
        out.printf("Could not find a task with an ID of %d.", id);
        out.println();
    }
}
