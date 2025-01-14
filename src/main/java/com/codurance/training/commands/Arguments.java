package com.codurance.training.commands;

import java.util.Arrays;
import java.util.List;

public class Arguments {
    List<String> arguments;

    //TODO: handle empty argsString
    public static Arguments parse(String argsString){
        Arguments commandArgs = new Arguments();
        commandArgs.arguments = Arrays.asList(argsString.split(" "));
        return commandArgs;
    }

    public String at(int idx){
        return arguments.get(idx);
    }
}
