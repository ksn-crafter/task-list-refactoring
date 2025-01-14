package com.codurance.training.commands;

import com.codurance.training.commands.interfaces.ICommandHandler;
import com.codurance.training.tasks.Projects;

public class AddTask implements ICommandHandler {
    private Projects projects;

    AddTask(Projects projects){
        this.projects = projects;
    }

    //TODO: add validations and unit tests
    @Override
    public void execute(Command command){
        projects.addTask(command.argumentAt(1),command.argumentAt(2));
    }
}
