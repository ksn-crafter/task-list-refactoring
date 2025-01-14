package com.codurance.training.commands;

import com.codurance.training.commands.interfaces.ICommandHandler;
import com.codurance.training.tasks.Projects;

public class Check implements ICommandHandler {
    private final Projects projects;

    Check(Projects projects){
        this.projects = projects;
    }

    //TODO: add validations and unit tests
    @Override
    public void execute(Command command){
        String idString = command.argumentAt(0);
        projects.changeTaskDone(idString, true);
    }
}
