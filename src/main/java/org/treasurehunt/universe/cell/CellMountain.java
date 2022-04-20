package org.treasurehunt.universe.cell;

import org.treasurehunt.player.Coordinate;
import org.treasurehunt.player.Player;
import org.treasurehunt.universe.ProhibitedPositionException;

public class CellMountain extends  Cell{


    public CellMountain( Coordinate coordinate, Player player) {
        super(CellItem.MOUNTAIN, coordinate, player);
    }

    @Override
    public void actionOnCell(Player player) throws ProhibitedPositionException {
        throw new ProhibitedPositionException("You can't climb the mountain");
    }

    @Override
    public String result(){
        return "M-"+getCoordinate().getY()+"-"+getCoordinate().getX();
    }
}
