package com.codurance.training.tasks;

import com.codurance.training.commands.Command;
import com.codurance.training.commands.CommandHandlerFactory;
import com.codurance.training.commands.ICommandHandler;

import java.io.Writer;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

public final class TaskList {
    private final Map<String, List<Task>> projects = new LinkedHashMap<>();

    private final CommandHandlerFactory commandHandlerFactory;

    public TaskList(Writer writer) {
        commandHandlerFactory = new CommandHandlerFactory(writer,projects);
    }

    public void execute(String commandLine) throws Exception {
        Command command = Command.parse(commandLine);
        ICommandHandler commandHandler = commandHandlerFactory.resolve(command);
        commandHandler.execute(command);
    }
}
