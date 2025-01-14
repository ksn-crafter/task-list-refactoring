package com.codurance.training.commands;

import com.codurance.training.tasks.Task;

import java.util.List;
import java.util.Map;

import static java.lang.System.out;

public class Uncheck implements ICommandHandler {
    private final Map<String, List<Task>> projects;

    Uncheck(Map<String,List<Task>> projects){
        this.projects = projects;
    }

    @Override
    public void execute(Command command){
        String idString = command.argumentAt(0);
        setDone(idString, false);
    }

    private void setDone(String idString, boolean done) {
        int id = Integer.parseInt(idString);
        for (Map.Entry<String, List<Task>> project : projects.entrySet()) {
            for (com.codurance.training.tasks.Task task : project.getValue()) {
                if (task.getId() == id) {
                    task.setDone(done);
                    return;
                }
            }
        }
        out.printf("Could not find a task with an ID of %d.", id);
        out.println();
    }
}
