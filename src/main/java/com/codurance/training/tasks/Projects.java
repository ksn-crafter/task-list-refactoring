package com.codurance.training.tasks;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

public class Projects {
    private Map<String, Project> projects = new LinkedHashMap<>();

    public void addProject(String name){
        projects.put(name, new Project(name));
    }

    public void addTask(String projectName,String taskDescription){
        Project project = projects.get(projectName);
        if (project == null) {
            throw new IllegalArgumentException("Unknown project: " + projectName);
        }
        project.addTask(taskDescription);
    }

    public String format(){
        StringBuilder sb = new StringBuilder();
        for (Project project : projects.values()) {
                sb.append(project.format());
        }
        return sb.toString();
    }

    public void changeTaskDone(String idString, boolean done) {
        int id = Integer.parseInt(idString);
        for (Project project : projects.values()) {
            project.markTaskAsDone(idString,done);
        }
        out.printf("Could not find a task with an ID of %d.", id);
        out.println();
    }
}
