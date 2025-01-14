package com.codurance.training.commands;

import com.codurance.training.commands.interfaces.ICommandHandler;
import com.codurance.training.tasks.Projects;
import com.codurance.training.tasks.Task;

import java.util.List;
import java.util.Map;

public class Check implements ICommandHandler {
    private final Projects projects;

    Check(Projects projects){
        this.projects = projects;
    }

    @Override
    public void execute(Command command){
        String idString = command.argumentAt(0);
        projects.changeTaskDone(idString, true);
    }
}
