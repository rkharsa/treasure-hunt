package org.treasurehunt.parser;

import org.treasurehunt.parser.exceptions.CommandLineInvalidArgumentException;
import org.treasurehunt.universe.cell.Cell;
import org.treasurehunt.universe.Dimension;
import org.treasurehunt.universe.Universe;

public class CommandMap implements  CommandHandlerStrategy{

    @Override
    public void execute(String line,Universe universe) throws CommandLineInvalidArgumentException {
        String[] command = line.split("-");
        if (command.length != 3)  { throw new CommandLineInvalidArgumentException();}
        int y = Integer.parseInt(command[1]);
        int x = Integer.parseInt(command[2]);
        universe.setDimension(new Dimension(x,y));
        universe.setMap(new Cell[x][y]);
        universe.initMap();
    }
}
