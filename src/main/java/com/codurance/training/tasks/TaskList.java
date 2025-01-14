package com.codurance.training.tasks;

import com.codurance.training.commands.Command;
import com.codurance.training.commands.CommandHandlerFactory;
import com.codurance.training.commands.interfaces.ICommandHandler;

import java.io.Writer;

//TODO: this should be a runner class rather than a TaskList
public final class TaskList {
    private final CommandHandlerFactory commandHandlerFactory;

    public TaskList(Writer writer) {
        commandHandlerFactory = new CommandHandlerFactory(writer,new Projects());
    }

    public void execute(String commandLine) throws Exception {
        Command command = Command.parse(commandLine);
        ICommandHandler commandHandler = commandHandlerFactory.resolve(command);
        commandHandler.execute(command);
    }
}
