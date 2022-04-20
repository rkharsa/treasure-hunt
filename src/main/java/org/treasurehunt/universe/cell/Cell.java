package org.treasurehunt.universe.cell;

import org.treasurehunt.player.Coordinate;
import org.treasurehunt.player.Player;
import org.treasurehunt.universe.ProhibitedPositionException;

public abstract class Cell {
    private Coordinate coordinate;
    private CellItem cellItem;
    private Player player;

    protected Cell( CellItem cellItem, Coordinate coordinate, Player player) {
        this.cellItem = cellItem;
        this.coordinate=coordinate ;
        this.player = player;
    }

    public abstract void  actionOnCell(Player player) throws ProhibitedPositionException;


    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    public CellItem getCellItem() {
        return cellItem;
    }

    public void setCellItem(CellItem cellItem) {
        this.cellItem = cellItem;
    }


    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "coordinate=" + coordinate +
                ", cellItem=" + cellItem +
                ", player=" + player +
                '}';
    }
}
