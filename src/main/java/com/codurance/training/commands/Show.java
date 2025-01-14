package com.codurance.training.commands;

import com.codurance.training.commands.interfaces.ICommandHandler;
import com.codurance.training.tasks.Projects;
import com.codurance.training.tasks.Task;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Map;

public class Show implements ICommandHandler {
    private final Writer writer;
    private final Projects projects;

    Show(Writer writer, Projects projects) {
        this.writer = writer;
        this.projects = projects;
    }

    //TODO: add validations and unit tests
    @Override
    public void execute(Command command){
        try {
            writer.write(projects.format());
        } catch (IOException e) {
            System.out.println("An exception occurred while executing the show command");
        }
    }
}
