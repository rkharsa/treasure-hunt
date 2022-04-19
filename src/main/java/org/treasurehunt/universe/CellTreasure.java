package org.treasurehunt.universe;

import org.treasurehunt.player.Coordinate;
import org.treasurehunt.player.Player;

public class CellTreasure extends Cell{
    private  int treasure;

    public CellTreasure(int treasure, CellItem symbol, Coordinate coordinate, Player player) {
        super(treasure, symbol, coordinate, player);
    }
}
