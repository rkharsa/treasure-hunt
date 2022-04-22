package org.treasurehunt.player.orientation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RotateToRightTest {
    @Test
    public void whenPlayerTurnRightWithCurrentOrientationEst_thenGoNorth() {

        Orientation orientationBeforeTurn = Orientation.EST;
        RotateToRight rotateToRight = new RotateToRight(orientationBeforeTurn);
        Orientation orientationResultAfterTurn = rotateToRight.rotate();

        Orientation orientationExpectedAfterTurn = Orientation.SOUTH;
        assertEquals(orientationExpectedAfterTurn, orientationResultAfterTurn);

    }

    @Test
    public void whenPlayerTurnRightWithCurrentOrientationNorth_thenGoWest() {
        Orientation orientationBeforeTurn = Orientation.NORTH;
        RotateToRight rotateToRight = new RotateToRight(orientationBeforeTurn);
        Orientation orientationResultAfterTurn = rotateToRight.rotate();

        Orientation orientationExpectedAfterTurn = Orientation.EST;
        assertEquals(orientationExpectedAfterTurn, orientationResultAfterTurn);

    }

    @Test
    public void whenPlayerTurnRightWithCurrentOrientationWest_thenGoSouth() {
        Orientation orientationBeforeTurn = Orientation.WEST;
        RotateToRight rotateToRight = new RotateToRight(orientationBeforeTurn);
        Orientation orientationResultAfterTurn = rotateToRight.rotate();

        Orientation orientationExpectedAfterTurn = Orientation.NORTH;
        assertEquals(orientationExpectedAfterTurn, orientationResultAfterTurn);

    }


    @Test
    public void whenPlayerTurnRightWithCurrentOrientationSouth_thenGoEst() {
        Orientation orientationBeforeTurn = Orientation.SOUTH;
        RotateToRight rotateToRight = new RotateToRight(orientationBeforeTurn);
        Orientation orientationResultAfterTurn = rotateToRight.rotate();

        Orientation orientationExpectedAfterTurn = Orientation.WEST;
        assertEquals(orientationExpectedAfterTurn, orientationResultAfterTurn);

    }

}