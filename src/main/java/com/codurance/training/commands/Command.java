package com.codurance.training.commands;


import java.util.HashMap;
import java.util.Map;

public class Command {
    private String name;
    private Arguments arguments;
    private Map<String,CommandType> commandNameTypeMap = Map.of("show",CommandType.SHOW,
            "add",CommandType.ADD,
            "check",CommandType.CHECK,
            "uncheck",CommandType.UNCHECK);

    public CommandType type(){
        return commandNameTypeMap.get(name);
    }


    public static Command parse(String commandString) {
        String[] commandRest = commandString.split(" ", 2);
        Command command = new Command();

        command.name = commandRest[0];
        command.arguments = Arguments.parse(commandRest.length > 1 ? commandRest[1] : "");
        return command;
    }

    public String argumentAt(int idx){
        return arguments.at(idx);
    }
}
