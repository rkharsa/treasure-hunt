package org.treasurehunt.universe;

import org.treasurehunt.player.Coordinate;
import org.treasurehunt.player.Player;

public class CellPlain extends  Cell{
    public CellPlain( Coordinate coordinate, Player player) {
        super(CellItem.PLAIN, coordinate, player);
    }

    @Override
    public void actionOnCell(Player player) throws ProhibitedPositionException {

    }
}
