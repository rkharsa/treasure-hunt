package org.treasurehunt.universe.cell;

import org.treasurehunt.player.Player;
import org.treasurehunt.player.enums.Coordinate;
import org.treasurehunt.universe.exceptions.ProhibitedPositionException;

import java.util.List;

public abstract class Cell {
    private Coordinate coordinate;
    private CellItem cellItem;

    private List<Player> players;

    protected Cell(CellItem cellItem, Coordinate coordinate, List<Player> players) {
        this.cellItem = cellItem;
        this.coordinate = coordinate;
        this.players = players;
    }

    public abstract void actionOnCell(Player player) throws ProhibitedPositionException;

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Player getPlayerByName(String name) {
        return this.players.stream().filter(player -> name.equals(player.getName())).findFirst().orElse(null);
    }

    public void addPlayer(Player player) {
        if (players.contains(player)) {
            return;
        }
        this.players.add(player);
    }

    public void removePlayer(String name) {
        this.players.removeIf(player -> name.equals(player.getName()));
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

    public String result() {
        return "";
    }

    @Override
    public String toString() {
        return "Cell{" +
                "coordinate=" + coordinate +
                ", cellItem=" + cellItem +
                ", player=" + players +
                '}';
    }
}
