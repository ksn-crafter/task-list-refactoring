package com.codurance.training.commands.interfaces;

import com.codurance.training.commands.Command;

public interface ICommandHandler {
    void execute(Command command);
}
