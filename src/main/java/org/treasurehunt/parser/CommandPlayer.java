package org.treasurehunt.parser;

import org.treasurehunt.player.Coordinate;
import org.treasurehunt.universe.CellItem;
import org.treasurehunt.universe.Universe;

public class CommandPlayer implements CommandHandlerStrategy {
    @Override
    public void execute(String line, Universe universe) {
        String[] command = line.split("-");
        if (command.length != 4) { ; }//TODO throw bad command exception
    }
}
