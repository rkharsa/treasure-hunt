package org.treasurehunt.player;

import org.junit.Test;
import org.treasurehunt.player.enums.Coordinate;
import org.treasurehunt.player.movement.Forward;
import org.treasurehunt.player.orientation.Orientation;
import org.treasurehunt.player.orientation.RotateToLeft;
import org.treasurehunt.player.orientation.RotateToRight;
import org.treasurehunt.universe.exceptions.ProhibitedPositionException;
import org.treasurehunt.universe.map.Dimension;
import org.treasurehunt.universe.map.Universe;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    @Test
    public void whenPlayerTurnLeftWithCurrentOrientationEst_thenGoNorth() {
        Coordinate coordinate = new Coordinate(1, 1);
        Player player = new Player(coordinate, Orientation.EST, "Rani");

        Orientation orientationExpectedBeforeTurn = Orientation.EST;
        assertEquals(orientationExpectedBeforeTurn, player.getOrientation());

        player.rotate(new RotateToLeft(player.getOrientation()));

        Orientation orientationExpectedAfterTurn = Orientation.NORTH;
        assertEquals(orientationExpectedAfterTurn, player.getOrientation());
    }

    @Test
    public void whenPlayerTurnLeftWithCurrentOrientationNorth_thenGoWest() {
        Coordinate coordinate = new Coordinate(1, 1);
        Player player = new Player(coordinate, Orientation.NORTH, "");

        Orientation orientationExpectedBeforeTurn = Orientation.NORTH;
        assertEquals(orientationExpectedBeforeTurn, player.getOrientation());

        player.rotate(new RotateToLeft(player.getOrientation()));

        Orientation orientationExpectedAfterTurn = Orientation.WEST;
        assertEquals(orientationExpectedAfterTurn, player.getOrientation());
    }

    @Test
    public void whenPlayerTurnLeftWithCurrentOrientationWest_thenGoSouth() {
        Coordinate coordinate = new Coordinate(1, 1);
        Player player = new Player(coordinate, Orientation.WEST, "");

        Orientation orientationExpectedBeforeTurn = Orientation.WEST;
        assertEquals(orientationExpectedBeforeTurn, player.getOrientation());

        player.rotate(new RotateToLeft(player.getOrientation()));

        Orientation orientationExpectedAfterTurn = Orientation.SOUTH;
        assertEquals(orientationExpectedAfterTurn, player.getOrientation());
    }

    @Test
    public void whenPlayerTurnLeftWithCurrentOrientationSouth_thenGoEst() {
        Coordinate coordinate = new Coordinate(1, 1);
        Player player = new Player(coordinate, Orientation.SOUTH, "");

        Orientation orientationExpectedBeforeTurn = Orientation.SOUTH;
        assertEquals(orientationExpectedBeforeTurn, player.getOrientation());

        player.rotate(new RotateToLeft(player.getOrientation()));

        Orientation orientationExpectedAfterTurn = Orientation.EST;
        assertEquals(orientationExpectedAfterTurn, player.getOrientation());
    }


    @Test
    public void whenPlayerTurnRightWithCurrentOrientationEst_thenGoNorth() {
        Coordinate coordinate = new Coordinate(1, 1);
        Player player = new Player(coordinate, Orientation.EST, "");

        Orientation orientationExpectedBeforeTurn = Orientation.EST;
        assertEquals(orientationExpectedBeforeTurn, player.getOrientation());

        player.rotate(new RotateToRight(player.getOrientation()));

        Orientation orientationExpectedAfterTurn = Orientation.SOUTH;
        assertEquals(orientationExpectedAfterTurn, player.getOrientation());
    }


    @Test
    public void whenPlayerTurnRightWithCurrentOrientationNorth_thenGoWest() {
        Coordinate coordinate = new Coordinate(1, 1);
        Player player = new Player(coordinate, Orientation.NORTH, "");

        Orientation orientationExpectedBeforeTurn = Orientation.NORTH;
        assertEquals(orientationExpectedBeforeTurn, player.getOrientation());

        player.rotate(new RotateToRight(player.getOrientation()));

        Orientation orientationExpectedAfterTurn = Orientation.EST;
        assertEquals(orientationExpectedAfterTurn, player.getOrientation());
    }

    @Test
    public void whenPlayerTurnRightWithCurrentOrientationWest_thenGoSouth() {
        Coordinate coordinate = new Coordinate(1, 1);
        Player player = new Player(coordinate, Orientation.WEST, "");

        Orientation orientationExpectedBeforeTurn = Orientation.WEST;
        assertEquals(orientationExpectedBeforeTurn, player.getOrientation());

        player.rotate(new RotateToRight(player.getOrientation()));

        Orientation orientationExpectedAfterTurn = Orientation.NORTH;
        assertEquals(orientationExpectedAfterTurn, player.getOrientation());
    }


    @Test
    public void whenPlayerTurnRightWithCurrentOrientationSouth_thenGoEst() {
        Coordinate coordinate = new Coordinate(1, 1);
        Player player = new Player(coordinate, Orientation.SOUTH, "");

        Orientation orientationExpectedBeforeTurn = Orientation.SOUTH;
        assertEquals(orientationExpectedBeforeTurn, player.getOrientation());

        player.rotate(new RotateToRight(player.getOrientation()));

        Orientation orientationExpectedAfterTurn = Orientation.WEST;
        assertEquals(orientationExpectedAfterTurn, player.getOrientation());
    }


    @Test
    public void whenPlayerForwardWithCurrentOrientationNorth_thenGoUp() throws ProhibitedPositionException {
        // init universe
        final Dimension dimension = new Dimension(2, 3);
        Universe universe = new Universe(dimension);
        universe.initMap();

        // init player
        Coordinate coordinate = new Coordinate(1, 1);
        Player player = new Player(coordinate, Orientation.NORTH, "");

        Coordinate expectedPos = new Coordinate(0, 1);
        player.move(universe, new Forward(player.getOrientation(), player.getCoordinate()));

        assertEquals(expectedPos.toString(), player.getCoordinate().toString());

    }

    @Test
    public void whenPlayerForwardWithCurrentOrientationEst_thenGoLeft() throws ProhibitedPositionException {
        // init universe
        final Dimension dimension = new Dimension(3, 5);
        Universe universe = new Universe(dimension);
        universe.initMap();

        // init player
        Coordinate coordinate = new Coordinate(1, 1);
        Player player = new Player(coordinate, Orientation.EST, "Rani");

        Coordinate expectedPos = new Coordinate(1, 2);
        player.move(universe, new Forward(player.getOrientation(), player.getCoordinate()));

        assertEquals(expectedPos.toString(), player.getCoordinate().toString());

    }


    @Test
    public void whenPlayerForwardWithCurrentOrientationWest_thenGoRight() throws ProhibitedPositionException {
        // init universe
        final Dimension dimension = new Dimension(3, 5);
        Universe universe = new Universe(dimension);
        universe.initMap();

        // init player
        Coordinate coordinate = new Coordinate(1, 1);
        Player player = new Player(coordinate, Orientation.WEST, "Rani");

        Coordinate expectedPos = new Coordinate(1, 0);
        player.move(universe, new Forward(player.getOrientation(), player.getCoordinate()));

        assertEquals(expectedPos.toString(), player.getCoordinate().toString());

    }
}
