package org.treasurehunt.parser;

import org.treasurehunt.universe.Cell;
import org.treasurehunt.universe.Dimension;
import org.treasurehunt.universe.Universe;

public class CommandMap implements  CommandHandlerStrategy{

    Universe universe;

    public CommandMap(Universe universe) {
        this.universe = universe;
    }

    @Override
    public void execute(String line) throws CommandLineInvalidArgumentException {
        String[] command = line.split("-");
        if (command.length != 3)  { throw new CommandLineInvalidArgumentException();}
        int x = Integer.parseInt(command[1]);
        int y = Integer.parseInt(command[2]);
        universe.setDimension(new Dimension(x,y));
        universe.setMap(new Cell[x][y]);
        universe.initMap();

    }
}
