package com.codurance.training.commands;

import com.codurance.training.tasks.Task;

import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandHandlerFactory {
    Map<CommandType, ICommandHandler> commandMap;

    public CommandHandlerFactory(Writer writer, Map<String, List<Task>> projects){
      commandMap = new HashMap<>();
      commandMap.put(CommandType.SHOW,new Show(writer,projects));
      commandMap.put(CommandType.ADD,new Add(projects));
      commandMap.put(CommandType.CHECK,new Check(projects));
      commandMap.put(CommandType.UNCHECK,new Uncheck(projects));
    }

    public ICommandHandler resolve(Command command){
        if(commandMap.containsKey(command.type()) == false){
            throw new IllegalArgumentException("Unknown command fired");
        }

        return commandMap.get(command.type());
    }
}
