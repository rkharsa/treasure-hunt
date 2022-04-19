package org.treasurehunt.universe;

import org.treasurehunt.player.Coordinate;
import org.treasurehunt.player.Player;

public class Cell {
    private  int treasure;
    private Coordinate coordinate;
    private CellItem cellItem;
    private Player player;

    public Cell(int treasure, CellItem cellItem, Coordinate coordinate, Player player) {
        this.treasure = treasure;
        this.cellItem = cellItem;
        this.coordinate=coordinate ;
        this.player = player;
    }
    public boolean isMountain(){
        return CellItem.MOUNTAIN.equals(cellItem);
    }

    public boolean isTreasure(){
        return CellItem.TREASURE.equals(cellItem);
    }


    public void removeTreasure(){
        if(treasure<0){return;}
        this.treasure--;
    }



    @Override
    public String toString() {
        return "Cell{" +
                "treasure=" + treasure +
                ", coordinate=" + coordinate.toString() +
                ", cellItem=" + cellItem +
                '}';
    }

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

    public int getTreasure() {
        return treasure;
    }

    public void setTreasure(int treasure) {
        this.treasure = treasure;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
}
