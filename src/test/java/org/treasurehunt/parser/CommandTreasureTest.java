package org.treasurehunt.parser;

import org.junit.Test;
import org.treasurehunt.parser.exceptions.CommandLineInvalidArgumentException;
import org.treasurehunt.player.Coordinate;
import org.treasurehunt.universe.cell.CellTreasure;
import org.treasurehunt.universe.Dimension;
import org.treasurehunt.universe.Universe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class CommandTreasureTest  {

    @Test
    public void should_set_1_treasures_in_cell() throws CommandLineInvalidArgumentException {
        Universe universe = new Universe(new Dimension(10,15));
        universe.initMap();

        String command = "T-1-0-1";

        CommandTreasure commandTreasure = new CommandTreasure();
        commandTreasure.execute(command,universe);

        int expectedTreasureNumber  = 1;
        int resultTreasureCount  =((CellTreasure)universe.getCell(new Coordinate(0,1))).getTreasure();

        assertEquals(expectedTreasureNumber,resultTreasureCount);

    }

    @Test
    public void should_set_2_treasures_in_cell() throws CommandLineInvalidArgumentException {
        Universe universe = new Universe(new Dimension(10,15));
        universe.initMap();

        String command = "T-1-0-2";

        CommandTreasure commandTreasure = new CommandTreasure();
        commandTreasure.execute(command,universe);

        int expectedTreasureNumber  = 2;
        int resultTreasureCount  = ((CellTreasure)universe.getCell(new Coordinate(0,1))).getTreasure();

        assertEquals(expectedTreasureNumber,resultTreasureCount);

    }

    @Test()
    public void whenAnOptionIsMissing_thenThrowsCommandLineInvalidException()  {
        Universe universe = new Universe(new Dimension(10,15));
        universe.initMap();

        String command = "T-0-1";

        CommandTreasure commandTreasure = new CommandTreasure();

        assertThrows(CommandLineInvalidArgumentException.class, () -> {
            commandTreasure.execute(command,universe);
        });

    }
    @Test()
    public void whenTwoOptionsAreMissing_thenThrowsCommandLineInvalidException()  {
        Universe universe = new Universe(new Dimension(10,15));
        universe.initMap();

        String command = "T-0";

        CommandTreasure commandTreasure = new CommandTreasure();

        assertThrows(CommandLineInvalidArgumentException.class, () -> {
            commandTreasure.execute(command,universe);
        });

    }

    @Test()
    public void whenCommandIsEmpty_thenThrowsCommandLineInvalidException()  {
        Universe universe = new Universe(new Dimension(10,15));
        universe.initMap();

        String command = "";

        CommandTreasure commandTreasure = new CommandTreasure();

        assertThrows(CommandLineInvalidArgumentException.class, () -> {
            commandTreasure.execute(command,universe);
        });

    }

    @Test()
    public void whenCommandHasCoordinateInvalid_thenThrowsArrayIndexOutOfBoundsException()  {
        Universe universe = new Universe(new Dimension(10,15));
        universe.initMap();

        String command = "T-200-900-3";

        CommandTreasure commandTreasure = new CommandTreasure();

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            commandTreasure.execute(command,universe);
        });
    }




}