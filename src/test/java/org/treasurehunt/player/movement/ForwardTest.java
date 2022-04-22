package org.treasurehunt.player.movement;

import org.junit.Test;
import org.treasurehunt.player.enums.Coordinate;
import org.treasurehunt.player.orientation.Orientation;
import org.treasurehunt.universe.exceptions.ProhibitedPositionException;

import static org.junit.Assert.assertEquals;

public class ForwardTest {
    @Test
    public void whenMoveForwardWithCurrentOrientationNorth_thenGoUp() {
        Orientation orientation = Orientation.NORTH;
        Coordinate coordinate = new Coordinate(1, 1);
        Forward forward = new Forward(orientation, coordinate);
        Coordinate coordinateResult = forward.move();
        Coordinate coordinateExpectedAfterMove = new Coordinate(0, 1);
        assertEquals(coordinateExpectedAfterMove.toString(), coordinateResult.toString());

    }

    @Test
    public void whenMoveForwardWithCurrentOrientationSouth_thenGoDown() throws ProhibitedPositionException {
        Orientation orientation = Orientation.SOUTH;
        Coordinate coordinate = new Coordinate(1, 1);
        Forward forward = new Forward(orientation, coordinate);
        Coordinate coordinateResult = forward.move();
        Coordinate coordinateExpectedAfterMove = new Coordinate(2, 1);
        assertEquals(coordinateExpectedAfterMove.toString(), coordinateResult.toString());


    }


    @Test
    public void whenMoveForwardWithCurrentOrientationEst_thenGoLeft() throws ProhibitedPositionException {
        Orientation orientation = Orientation.EST;
        Coordinate coordinate = new Coordinate(1, 1);
        Forward forward = new Forward(orientation, coordinate);
        Coordinate coordinateResult = forward.move();
        Coordinate coordinateExpectedAfterMove = new Coordinate(1, 2);
        assertEquals(coordinateExpectedAfterMove.toString(), coordinateResult.toString());

    }


    @Test
    public void whenMoveForwardWithCurrentOrientationWest_thenGoRight() throws ProhibitedPositionException {
        Orientation orientation = Orientation.WEST;
        Coordinate coordinate = new Coordinate(1, 1);
        Forward forward = new Forward(orientation, coordinate);
        Coordinate coordinateResult = forward.move();
        Coordinate coordinateExpectedAfterMove = new Coordinate(1, 0);
        assertEquals(coordinateExpectedAfterMove.toString(), coordinateResult.toString());

    }
}