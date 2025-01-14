package com.codurance.training.commands;

import com.codurance.training.commands.interfaces.ICommandHandler;
import com.codurance.training.tasks.Projects;
import com.codurance.training.tasks.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Add implements ICommandHandler {
    private Map<String,ICommandHandler> addCommandHandlers;

    Add(Projects projects) {
        addCommandHandlers = Map.of("project", new AddProject(projects),
                "task",new AddTask(projects));

    }

    @Override
    public void execute(Command command){
        String subcommand = command.argumentAt(0);
        addCommandHandlers.get(subcommand).execute(command);
    }
}
