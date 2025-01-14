package com.codurance.training.commands;

import com.codurance.training.tasks.Task;

import java.util.List;
import java.util.Map;

public class Uncheck extends TaskDoneChanger implements ICommandHandler {
    private final Map<String, List<Task>> projects;

    Uncheck(Map<String,List<Task>> projects){
        this.projects = projects;
    }

    @Override
    public void execute(Command command){
        String idString = command.argumentAt(0);
        changeTaskDone(idString, false,projects);
    }

}
