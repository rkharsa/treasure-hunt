package org.treasurehunt.parser;

import org.treasurehunt.universe.Universe;

public class CommandPlayer implements CommandHandlerStrategy {
    final Universe universe;
    public CommandPlayer(Universe universe) {
        this.universe = universe;
    }

    @Override
    public void execute(String line) {
        String[] command = line.split("-");
        if (command.length != 4) { ; }//TODO throw bad command exception
    }
}
