package org.treasurehunt.parser;

import org.treasurehunt.parser.exceptions.CommandLineInvalidArgumentException;

public class CommandFactory {

    public CommandHandlerHelper getCommand(CommandLineCode commandLineCode) throws CommandLineInvalidArgumentException {
        CommandHandlerStrategy commandHandlerStrategy;
        switch (commandLineCode) {
            case A:
                commandHandlerStrategy = new CommandPlayer();
                break;
            case C:
                commandHandlerStrategy = new CommandMap();
                break;
            case M:
                commandHandlerStrategy = new CommandMountain();
                break;
            case T:
                commandHandlerStrategy = new CommandTreasure();
                break;
            default:
                throw new CommandLineInvalidArgumentException();
        }

        return new CommandHandlerHelper(commandHandlerStrategy);
    }
}
