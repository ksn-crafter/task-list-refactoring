package com.codurance.training.commands;

import com.codurance.training.commands.interfaces.ICommandHandler;
import com.codurance.training.tasks.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Add implements ICommandHandler {
    private final Map<String, List<Task>> projects;

    Add(Map<String, List<Task>> projects) {
        this.projects = projects;
    }

    @Override
    public void execute(Command command){
        String subcommand = command.argumentAt(0);
        if (subcommand.equals("project")) {
            addProject(command.argumentAt(1));
        } else if (subcommand.equals("task")) {
            addTask(command.argumentAt(1),command.argumentAt(2));
        }
    }

    private void addProject(String name) {
        projects.put(name, new ArrayList<>());
    }

    private void addTask(String project, String description) {
        List<Task> projectTasks = projects.get(project);
        if (projectTasks == null) {
            throw new IllegalArgumentException("Unknown project: " + project);
        }
        projectTasks.add(new com.codurance.training.tasks.Task(projectTasks.size() + 1, description, false));
    }
}
