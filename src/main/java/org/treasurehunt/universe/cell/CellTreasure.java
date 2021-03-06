package org.treasurehunt.universe.cell;

import org.treasurehunt.player.Player;
import org.treasurehunt.player.enums.Coordinate;
import org.treasurehunt.universe.exceptions.ProhibitedPositionException;

import java.util.List;

public class CellTreasure extends Cell {
    private int treasure;

    public CellTreasure(Coordinate coordinate, List<Player> players, int treasure) {
        super(CellItem.TREASURE, coordinate, players);
        this.treasure = treasure;
    }


    @Override
    public void actionOnCell(Player player) throws ProhibitedPositionException {
        if (treasure <= 0) {
            return;
        }
        treasure--;
        player.findTreasure();
    }

    public int getTreasure() {
        return treasure;
    }

    public void setTreasure(int treasure) {
        this.treasure = treasure;
    }

    @Override
    public String result() {
        return "T-" + getCoordinate().getY() + "-" + getCoordinate().getX() + "-" + treasure;
    }
}
