package org.treasurehunt.universe.cell;

import org.treasurehunt.player.Player;
import org.treasurehunt.player.enums.Coordinate;
import org.treasurehunt.universe.exceptions.ProhibitedPositionException;

import java.util.List;

public class CellMountain extends Cell {


    public CellMountain(Coordinate coordinate, List<Player> players) {
        super(CellItem.MOUNTAIN, coordinate, players);
    }

    @Override
    public void actionOnCell(Player player) throws ProhibitedPositionException {
        throw new ProhibitedPositionException("You can't climb the mountain");
    }

    @Override
    public String result() {
        return "M-" + getCoordinate().getY() + "-" + getCoordinate().getX();
    }
}
