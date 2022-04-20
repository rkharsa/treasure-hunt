package org.treasurehunt.universe;

import org.treasurehunt.player.Coordinate;
import org.treasurehunt.player.Player;

public class CellMountain extends  Cell{


    public CellMountain( Coordinate coordinate, Player player) {
        super(CellItem.MOUNTAIN, coordinate, player);
    }

    @Override
    public void actionOnCell(Player player) throws ProhibitedPositionException {
        throw new ProhibitedPositionException("You can't climb the mountain");
    }
}
