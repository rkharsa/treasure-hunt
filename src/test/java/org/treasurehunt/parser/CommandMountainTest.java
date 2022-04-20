package org.treasurehunt.parser;

import org.junit.Test;
import org.treasurehunt.parser.exceptions.CommandLineInvalidArgumentException;
import org.treasurehunt.player.Coordinate;
import org.treasurehunt.universe.cell.CellItem;
import org.treasurehunt.universe.Dimension;
import org.treasurehunt.universe.Universe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class CommandMountainTest  {

    @Test
    public void whenCommandIsValid_thenAddMountain() throws CommandLineInvalidArgumentException {
        Universe universe = new Universe(new Dimension(10,15));
        universe.initMap();

        String command = "M-0-0";

        CommandMountain commandMountain = new CommandMountain();
        commandMountain.execute(command,universe);

        CellItem expectedCellItemMountain  = CellItem.MOUNTAIN;
        CellItem resultCellItemMountain  = universe.getCell(new Coordinate(0,0)).getCellItem();

        assertEquals(expectedCellItemMountain,resultCellItemMountain);
    }

    @Test
    public void whenAnOptionIsMissing_thenThrowsCommandLineInvalidException()  {
        Universe universe = new Universe(new Dimension(10,15));
        universe.initMap();

        String command = "M-0";

        CommandMountain commandMountain = new CommandMountain();


        assertThrows(CommandLineInvalidArgumentException.class, () -> {
            commandMountain.execute(command,universe);
        });
    }

    @Test
    public void whenTwoOptionsAreMissing_thenThrowsCommandLineInvalidException()  {
        Universe universe = new Universe(new Dimension(10,15));
        universe.initMap();

        String command = "M";

        CommandMountain commandMountain = new CommandMountain();


        assertThrows(CommandLineInvalidArgumentException.class, () -> {
            commandMountain.execute(command,universe);
        });
    }

    @Test
    public void whenCommandHasCoordinateInvalid_thenThrowsArrayIndexOutOfBoundsException()  {
        Universe universe = new Universe(new Dimension(10,15));
        universe.initMap();

        String command = "M-0-900";

        CommandMountain commandMountain = new CommandMountain();


        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            commandMountain.execute(command,universe);
        });
    }
}