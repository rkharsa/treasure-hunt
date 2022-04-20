package org.treasurehunt.parser;

import org.treasurehunt.parser.exceptions.CommandLineInvalidArgumentException;
import org.treasurehunt.player.Coordinate;
import org.treasurehunt.universe.cell.CellMountain;
import org.treasurehunt.universe.Universe;

public class CommandMountain implements CommandHandlerStrategy {
    @Override
    public void execute(String line, Universe universe) throws CommandLineInvalidArgumentException {
        String[] command = line.split("-");
        if (command.length != 3) {
            throw new CommandLineInvalidArgumentException();
        }
        int y = Integer.parseInt(command[1]);
        int x = Integer.parseInt(command[2]);
        Coordinate coordinate = new Coordinate(x, y);
        CellMountain cellMountain = new CellMountain(coordinate, null);
        universe.setCell(coordinate, cellMountain);
    }
}
