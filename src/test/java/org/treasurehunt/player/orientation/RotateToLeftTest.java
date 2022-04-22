package org.treasurehunt.player.orientation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RotateToLeftTest {

    @Test
    public void whenRotateToLeftWithCurrentOrientationEst_thenGoNorth() {
        Orientation orientationBeforeTurn = Orientation.EST;
        RotateToLeft rotateToLeft = new RotateToLeft(orientationBeforeTurn);
        Orientation orientationResultAfterTurn = rotateToLeft.rotate();

        Orientation orientationExpectedAfterTurn = Orientation.NORTH;
        assertEquals(orientationExpectedAfterTurn, orientationResultAfterTurn);
    }

    @Test
    public void whenRotateToLeftWithCurrentOrientationNorth_thenGoWest() {

        Orientation orientationBeforeTurn = Orientation.NORTH;
        RotateToLeft rotateToLeft = new RotateToLeft(orientationBeforeTurn);
        Orientation orientationResultAfterTurn = rotateToLeft.rotate();

        Orientation orientationExpectedAfterTurn = Orientation.WEST;
        assertEquals(orientationExpectedAfterTurn, orientationResultAfterTurn);

    }

    @Test
    public void whenRotateToLeftWithCurrentOrientationWest_thenGoSouth() {

        Orientation orientationBeforeTurn = Orientation.WEST;
        RotateToLeft rotateToLeft = new RotateToLeft(orientationBeforeTurn);
        Orientation orientationResultAfterTurn = rotateToLeft.rotate();

        Orientation orientationExpectedAfterTurn = Orientation.SOUTH;
        assertEquals(orientationExpectedAfterTurn, orientationResultAfterTurn);

    }

    @Test
    public void whenRotateToLeftWithCurrentOrientationSouth_thenGoEst() {

        Orientation orientationBeforeTurn = Orientation.SOUTH;
        RotateToLeft rotateToLeft = new RotateToLeft(orientationBeforeTurn);
        Orientation orientationResultAfterTurn = rotateToLeft.rotate();

        Orientation orientationExpectedAfterTurn = Orientation.EST;
        assertEquals(orientationExpectedAfterTurn, orientationResultAfterTurn);

    }


}