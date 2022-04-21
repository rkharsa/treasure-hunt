package org.treasurehunt.parser;

import org.treasurehunt.parser.exceptions.CommandLineInvalidArgumentException;
import org.treasurehunt.player.enums.Coordinate;
import org.treasurehunt.universe.cell.Cell;
import org.treasurehunt.universe.cell.CellTreasure;
import org.treasurehunt.universe.map.Universe;

public class CommandTreasure implements CommandHandlerStrategy {

    @Override
    public void execute(String line, Universe universe) throws CommandLineInvalidArgumentException {
        String[] command = line.split("-");
        if (command.length != 4) {
            throw new CommandLineInvalidArgumentException();
        }
        int y = Integer.parseInt(command[1]);
        int x = Integer.parseInt(command[2]);
        Coordinate coordinate = new Coordinate(x, y);
        int numberOfTreasure = Integer.parseInt(command[3]);
        Cell oldCell = universe.getCell(coordinate);
        CellTreasure cellTreasure = new CellTreasure(coordinate, oldCell.getPlayers(), numberOfTreasure);
        universe.setCell(coordinate, cellTreasure);
    }
}
