package org.treasurehunt.universe.cell;

import org.treasurehunt.player.Player;
import org.treasurehunt.player.enums.Coordinate;
import org.treasurehunt.universe.exceptions.ProhibitedPositionException;

import java.util.List;

public class CellPlain extends Cell {
    public CellPlain(Coordinate coordinate, List<Player> players) {
        super(CellItem.PLAIN, coordinate, players);
    }

    @Override
    public void actionOnCell(Player player) throws ProhibitedPositionException {

    }


}
