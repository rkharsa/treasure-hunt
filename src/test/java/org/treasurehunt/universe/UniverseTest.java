package org.treasurehunt.universe;

import org.junit.Test;
import org.treasurehunt.player.enums.Coordinate;
import org.treasurehunt.universe.map.Dimension;
import org.treasurehunt.universe.map.Universe;

import static org.junit.Assert.*;

public class UniverseTest {

    @Test
    public void shloud_init_map_with_dimension_2x3() {
        final Dimension dimension = new Dimension(2, 3);
        Universe universe = new Universe(dimension);
        universe.initMap();
        int expectedRowDim = 2;
        int expectedColDim = 3;
        assertEquals(universe.getMap().length, expectedRowDim);
        assertEquals(universe.getMap()[0].length, expectedColDim);

    }

    @Test
    public void next_move_should_be_valid() {
        final Dimension dimension = new Dimension(2, 3);
        Universe universe = new Universe(dimension);
        universe.initMap();

        Coordinate coordinate = new Coordinate(1, 1);
        boolean nextMoveIsValid = universe.isValidCoordinate(coordinate);

        assertTrue(nextMoveIsValid);
    }

    @Test
    public void next_move_should_be_invalid_when_new_row_is_out_of_the_bound_end() {
        final Dimension dimension = new Dimension(2, 3);
        Universe universe = new Universe(dimension);
        universe.initMap();

        Coordinate coordinate = new Coordinate(100, 1);
        boolean nextMoveIsValid = universe.isValidCoordinate(coordinate);

        assertFalse(nextMoveIsValid);
    }

    @Test
    public void next_move_should_be_invalid_when_new_row_is_out_of_the_bound_start() {
        final Dimension dimension = new Dimension(2, 3);
        Universe universe = new Universe(dimension);
        universe.initMap();

        Coordinate coordinate = new Coordinate(-1, 1);
        boolean nextMoveIsValid = universe.isValidCoordinate(coordinate);

        assertFalse(nextMoveIsValid);
    }

    @Test
    public void next_move_should_be_invalid_when_new_col_is_out_of_the_bound_end() {
        final Dimension dimension = new Dimension(2, 3);
        Universe universe = new Universe(dimension);
        universe.initMap();

        Coordinate coordinate = new Coordinate(1, 100);
        boolean nextMoveIsValid = universe.isValidCoordinate(coordinate);

        assertFalse(nextMoveIsValid);
    }

    @Test
    public void next_move_should_be_invalid_when_new_col_is_out_of_the_bound_start() {
        final Dimension dimension = new Dimension(2, 3);
        Universe universe = new Universe(dimension);
        universe.initMap();

        Coordinate coordinate = new Coordinate(-1, 1);
        boolean nextMoveIsValid = universe.isValidCoordinate(coordinate);

        assertFalse(nextMoveIsValid);
    }
}
