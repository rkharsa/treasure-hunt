package org.treasurehunt.universe.cell;

import org.treasurehunt.player.Player;
import org.treasurehunt.player.enums.Coordinate;
import org.treasurehunt.universe.exceptions.ProhibitedPositionException;

public class CellPlain extends Cell {
    public CellPlain(Coordinate coordinate, Player player) {
        super(CellItem.PLAIN, coordinate, player);
    }

    @Override
    public void actionOnCell(Player player) throws ProhibitedPositionException {

    }


}
