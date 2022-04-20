package org.treasurehunt.parser;

import org.treasurehunt.player.Coordinate;
import org.treasurehunt.universe.CellItem;
import org.treasurehunt.universe.Universe;

public class CommandMountain implements CommandHandlerStrategy {
    Universe universe;

    public CommandMountain(Universe universe) {
        this.universe = universe;
    }

    @Override
    public void execute(String line) throws CommandLineInvalidArgumentException {
        String[] command = line.split("-");
        if (command.length != 3) { throw new CommandLineInvalidArgumentException(); }
        int x = Integer.parseInt(command[1]);
        int y = Integer.parseInt(command[2]);
        universe.getCell(new Coordinate(x,y)).setCellItem(CellItem.MOUNTAIN);

    }
}
