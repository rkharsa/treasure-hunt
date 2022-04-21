package org.treasurehunt.parser;

import org.treasurehunt.parser.exceptions.CommandLineInvalidArgumentException;
import org.treasurehunt.universe.map.Universe;

public interface CommandHandlerStrategy {
    void execute(String line, Universe universe) throws CommandLineInvalidArgumentException;
}

