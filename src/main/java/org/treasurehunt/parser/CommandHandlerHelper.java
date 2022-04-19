package org.treasurehunt.parser;

import org.treasurehunt.universe.Universe;

public class CommandHandlerHelper {

    private final CommandHandlerStrategy commandHandlerStrategy;


    public CommandHandlerHelper(CommandHandlerStrategy commandHandlerStrategy) {
        this.commandHandlerStrategy = commandHandlerStrategy;
    }

    public void execute(String line, Universe universe) throws CommandLineInvalidArgumentException {
        commandHandlerStrategy.execute(line,universe);
    }
}
