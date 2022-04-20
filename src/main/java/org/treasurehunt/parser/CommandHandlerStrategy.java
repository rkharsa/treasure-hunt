package org.treasurehunt.parser;

import org.treasurehunt.universe.Universe;

public interface CommandHandlerStrategy {
    void execute(String line) throws CommandLineInvalidArgumentException;
}

