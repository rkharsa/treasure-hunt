package org.treasurehunt.universe;

import org.treasurehunt.player.Coordinate;
import org.treasurehunt.player.Player;

public class CellTreasure extends Cell{
    private  int treasure;

    public CellTreasure(Coordinate coordinate, Player player, int treasure) {
        super(CellItem.TREASURE, coordinate, player);
        this.treasure = treasure;
    }


    @Override
    public void actionOnCell(Player player) throws ProhibitedPositionException {
        if(treasure<=0){return;}
        treasure--;
        player.findTreasure();
    }

    public int getTreasure() {
        return treasure;
    }

    public void setTreasure(int treasure) {
        this.treasure = treasure;
    }
}
