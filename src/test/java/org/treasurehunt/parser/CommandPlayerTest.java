package org.treasurehunt.parser;

import org.junit.Test;
import org.treasurehunt.parser.exceptions.CommandLineInvalidArgumentException;
import org.treasurehunt.player.Player;
import org.treasurehunt.player.enums.Coordinate;
import org.treasurehunt.player.orientation.Orientation;
import org.treasurehunt.universe.map.Dimension;
import org.treasurehunt.universe.map.Universe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class CommandPlayerTest {
    /*
    A(Rani)|.|.|.|
     END    |.|.|.|
     .     |.|.|.|
     */
    @Test
    public void shouldSetPLayerInCell_whenCommandIsValid() throws CommandLineInvalidArgumentException {
        Universe universe = new Universe(new Dimension(4, 3));
        universe.initMap();

        String command = "A-Rani-0-0-S-AADADA";

        CommandPlayer commandPlayer = new CommandPlayer();
        commandPlayer.execute(command, universe);

        Coordinate coordinate = new Coordinate(1, 0);
        Player player = new Player(coordinate, Orientation.NORTH, "Rani");
        Player resultPlayer = universe.getCell(coordinate).getPlayerByName("Rani");


        assertEquals(player.toString(), resultPlayer.toString());
    }

    /*
A(Rani)|.|.|.|
 END    |.|.|.|
 .     |.|.|.|
 */
    @Test
    public void shouldThrowCommandLineInvalidException_whenCommandIsInvalid() {
        Universe universe = new Universe(new Dimension(4, 3));
        universe.initMap();

        String command = "A-Rani-0-0-S";

        CommandPlayer commandPlayer = new CommandPlayer();

        assertThrows(CommandLineInvalidArgumentException.class, () -> {
            commandPlayer.execute(command, universe);
        });
    }

    @Test
    public void playerShouldBeInBottomRightCorner_whenSequenceOfMoveIsAAAADAAA() throws CommandLineInvalidArgumentException {

        Universe universe = new Universe(new Dimension(4, 3));
        universe.initMap();

        String command = "A-Rani-0-0-E-AAAADAAA";

        CommandPlayer commandPlayer = new CommandPlayer();
        commandPlayer.execute(command, universe);

        Coordinate coordinate = new Coordinate(3, 2);
        Player player = new Player(coordinate, Orientation.SOUTH, "Rani");
        Player resultPlayer = universe.getCell(coordinate).getPlayerByName("Rani");


        assertEquals(player.toString(), resultPlayer.toString());
    }

    @Test
    public void playerShouldBeInBottomRightCornerWith2Treasures_whenSequenceOfMoveIsAAAADAAA() throws CommandLineInvalidArgumentException {

        Universe universe = new Universe(new Dimension(4, 3));
        universe.initMap();

        String treasureCommand = "T-0-0-1";
        CommandTreasure commandTreasure = new CommandTreasure();
        commandTreasure.execute(treasureCommand, universe);

        treasureCommand = "T-1-0-1";
        commandTreasure.execute(treasureCommand, universe);

        treasureCommand = "T-2-0-1";
        commandTreasure.execute(treasureCommand, universe);

        String command = "A-Rani-0-0-E-AAAADAAA";
        CommandPlayer commandPlayer = new CommandPlayer();
        commandPlayer.execute(command, universe);
        universe.displayGrid();
        universe.displayList();

        Coordinate coordinate = new Coordinate(3, 2);
        Player player = new Player(coordinate, Orientation.SOUTH, "Rani");
        player.setNumberOfTreasureFound(2);

        Player resultPlayer = universe.getCell(coordinate).getPlayerByName("Rani");


        assertEquals(player.toString(), resultPlayer.toString());
        assertEquals(player.toString(), resultPlayer.toString());

    }

    @Test
    public void playerShouldBeInBottomCenterWith5Treasures_whenSequenceOfMoveIsAAAADAAADA() throws CommandLineInvalidArgumentException {

        Universe universe = new Universe(new Dimension(4, 3));
        universe.initMap();

        String treasureCommand = "T-0-0-1";
        CommandTreasure commandTreasure = new CommandTreasure();
        commandTreasure.execute(treasureCommand, universe);

        treasureCommand = "T-1-0-1";
        commandTreasure.execute(treasureCommand, universe);

        treasureCommand = "T-2-0-1";
        commandTreasure.execute(treasureCommand, universe);

        treasureCommand = "T-2-1-1";
        commandTreasure.execute(treasureCommand, universe);

        treasureCommand = "T-2-2-1";
        commandTreasure.execute(treasureCommand, universe);

        treasureCommand = "T-1-3-1";
        commandTreasure.execute(treasureCommand, universe);

        String command = "A-Rani-0-0-E-AAAADAAADA";
        CommandPlayer commandPlayer = new CommandPlayer();
        commandPlayer.execute(command, universe);


        Coordinate coordinate = new Coordinate(3, 1);
        Player player = new Player(coordinate, Orientation.WEST, "Rani");
        player.setNumberOfTreasureFound(5);
        Player resultPlayer = universe.getCell(coordinate).getPlayerByName("Rani");


        assertEquals(player.toString(), resultPlayer.toString());
        assertEquals(player.toString(), resultPlayer.toString());

    }


    @Test
    public void twoPlayersShouldBeInBottomCenterWith5Treasures_whenSequenceOfMoveIsAAAADAAADA() throws CommandLineInvalidArgumentException {

        Universe universe = new Universe(new Dimension(4, 3));
        universe.initMap();

        String treasureCommand = "T-0-0-1";
        CommandTreasure commandTreasure = new CommandTreasure();
        commandTreasure.execute(treasureCommand, universe);

        treasureCommand = "T-1-0-1";
        commandTreasure.execute(treasureCommand, universe);

        treasureCommand = "T-2-0-1";
        commandTreasure.execute(treasureCommand, universe);

        treasureCommand = "T-2-1-1";
        commandTreasure.execute(treasureCommand, universe);

        treasureCommand = "T-2-2-1";
        commandTreasure.execute(treasureCommand, universe);

        treasureCommand = "T-1-3-1";
        commandTreasure.execute(treasureCommand, universe);

        CommandPlayer commandPlayer = new CommandPlayer();

        String command = "A-Rani-0-0-E-AAAADAAADA";
        commandPlayer.execute(command, universe);

        command = "A-Jess-0-0-E-AAAADAAADA";
        commandPlayer.execute(command, universe);


        universe.displayGrid();
        universe.displayList();

        Coordinate coordinate = new Coordinate(3, 1);
        Player player1 = new Player(coordinate, Orientation.WEST, "Rani");
        player1.setNumberOfTreasureFound(5);
        Player resultPlayer1 = universe.getCell(coordinate).getPlayerByName("Rani");

        Player player2 = new Player(coordinate, Orientation.WEST, "Jess");
        player2.setNumberOfTreasureFound(0);
        Player resultPlayer2 = universe.getCell(coordinate).getPlayerByName("Jess");


        assertEquals(player1.toString(), resultPlayer1.toString());
        assertEquals(player1.toString(), resultPlayer1.toString());
        assertEquals(player2.toString(), resultPlayer2.toString());
        assertEquals(player2.toString(), resultPlayer2.toString());

    }
}