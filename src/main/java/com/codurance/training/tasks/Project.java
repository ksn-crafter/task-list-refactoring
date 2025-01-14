package com.codurance.training.tasks;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private String name;
    private List<Task> tasks;

    Project(String name){
        this.name = name;
        tasks = new ArrayList<>();
    }

    public void addTask(String description){
        tasks.add(new Task(tasks.size()+1,description,false));
    }

    public String format(){
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append("\n");
        for(Task task:tasks){
            sb.append(task.format());
        }

        return sb.toString();
    }

    public void markTaskAsDone(String idString,boolean done){
        for (Task task : tasks) {
                if (task.idEqualTo(Integer.parseInt(idString))) {
                    task.changeDone(done);
                    return;
                }
            }
    }
}
