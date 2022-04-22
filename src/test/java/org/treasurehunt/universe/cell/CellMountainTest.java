package org.treasurehunt.universe.cell;

import org.junit.Test;
import org.treasurehunt.player.Player;
import org.treasurehunt.player.enums.Coordinate;
import org.treasurehunt.player.orientation.Orientation;
import org.treasurehunt.universe.exceptions.ProhibitedPositionException;

import static org.junit.Assert.assertThrows;

public class CellMountainTest {

    @Test
    public void whenActionOnCellIsCalled_thenThrowProhibitedPositionException() {
        Coordinate coordinate = new Coordinate(0, 0);
        Player player = new Player(coordinate, Orientation.SOUTH, "Rani");

        CellMountain cellMountain = new CellMountain(coordinate, null);


        assertThrows(ProhibitedPositionException.class, () -> {
            cellMountain.actionOnCell(player);
        });
    }
}