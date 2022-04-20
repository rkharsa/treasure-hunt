package org.treasurehunt.parser;

import org.junit.Test;
import org.treasurehunt.parser.exceptions.CommandLineInvalidArgumentException;
import org.treasurehunt.universe.Universe;

import static org.junit.Assert.assertEquals;

public class CommandMapTest  {
    @Test
    public void shouldInitMapWithDim3x3() throws CommandLineInvalidArgumentException {
        Universe universe = new Universe();

        String command = "C-3-3";

        CommandMap commandMountain = new CommandMap();
        commandMountain.execute(command,universe);
        int resultNumberOfRow = universe.getMap().length;
        int resultNumberOfCol = universe.getMap()[0].length;
        int expectedRowCol = 3;
        assertEquals(resultNumberOfRow,expectedRowCol);
        assertEquals(resultNumberOfCol,expectedRowCol);

    }

    @Test
    public void shouldInitMapWithDim4x4() throws CommandLineInvalidArgumentException {
        Universe universe = new Universe();

        String command = "C-4-4";

        CommandMap commandMountain = new CommandMap();
        commandMountain.execute(command,universe);
        int resultNumberOfRow = universe.getMap().length;
        int resultNumberOfCol = universe.getMap()[0].length;
        int expectedRowCol = 4;
        assertEquals(resultNumberOfRow,expectedRowCol);
        assertEquals(resultNumberOfCol,expectedRowCol);

    }

}