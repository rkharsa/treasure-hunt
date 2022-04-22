package org.treasurehunt.universe.cell;

import org.junit.Test;
import org.treasurehunt.player.Player;
import org.treasurehunt.player.enums.Coordinate;
import org.treasurehunt.player.orientation.Orientation;
import org.treasurehunt.universe.exceptions.ProhibitedPositionException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CellTreasureTest {

    @Test
    public void whenActionOnCellIsCalledAnsTreasureIsEqualTo1_thenRemoveOneTreasure() throws ProhibitedPositionException {
        Coordinate coordinate = new Coordinate(0, 0);
        Player player = new Player(coordinate, Orientation.SOUTH, "Rani");
        List<Player> players = new ArrayList<>();
        players.add(player);
        CellTreasure cellTreasure = new CellTreasure(coordinate, players, 1);

        cellTreasure.actionOnCell(player);
        int numberOfTreasureExpected = 0;
        assertEquals(numberOfTreasureExpected, cellTreasure.getTreasure());
    }

    @Test
    public void whenActionOnCellIsCalledAnsTreasureIsEqualTo0_thenCannotRemoveTreasure() throws ProhibitedPositionException {
        Coordinate coordinate = new Coordinate(0, 0);
        Player player = new Player(coordinate, Orientation.SOUTH, "Rani");
        List<Player> players = new ArrayList<>();
        players.add(player);
        CellTreasure cellTreasure = new CellTreasure(coordinate, players, 0);

        cellTreasure.actionOnCell(player);
        int numberOfTreasureExpected = 0;
        assertEquals(numberOfTreasureExpected, cellTreasure.getTreasure());
    }
}