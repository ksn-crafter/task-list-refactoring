package com.codurance.training.commands;

import com.codurance.training.commands.interfaces.ICommandHandler;
import com.codurance.training.tasks.Projects;

public class AddProject implements ICommandHandler {
    private Projects projects;

    AddProject(Projects projects){
        this.projects = projects;
    }


    //TODO: add validations and unit tests
    @Override
    public void execute(Command command){
        projects.addProject(command.argumentAt(1));
    }
}
