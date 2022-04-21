package org.treasurehunt.universe.map;

import org.treasurehunt.player.Player;
import org.treasurehunt.player.enums.Coordinate;
import org.treasurehunt.universe.cell.Cell;
import org.treasurehunt.universe.cell.CellItem;
import org.treasurehunt.universe.cell.CellPlain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class Universe {
    private Dimension dimension;
    private Cell[][] map;

    public Universe(Dimension dimension) {
        this.dimension = dimension;
        this.map = new Cell[dimension.getRow()][dimension.getColumn()];
    }

    public Universe() {
        this.dimension = new Dimension(3, 5);
        this.map = new Cell[dimension.getRow()][dimension.getColumn()];
    }

    public void initMap() {
        for (int row = 0; row < dimension.getRow(); row++) {
            for (int col = 0; col < dimension.getColumn(); col++) {
                Coordinate pos = new Coordinate(row, col);
                this.map[row][col] = new CellPlain(pos, new ArrayList<>());
            }
        }
    }

    public void displayGrid() {
        for (int row = 0; row < dimension.getRow(); row++) {
            for (int col = 0; col < dimension.getColumn(); col++) {
                Cell cell = this.map[row][col];
                if (!cell.getPlayers().isEmpty()) {
                    for (int i = 0 ; i< cell.getPlayers().size();i++) {
                        System.out.println(cell.getPlayers().get(i).result());
                    }
                } else {
                    System.out.print(cell.getCellItem().getSymbol());
                }
                System.out.print("                   ");
            }
            System.out.println();
        }
    }

    public void displayList() {
        System.out.println("C-" + dimension.getColumn() + "-" + dimension.getRow());
        for (int row = 0; row < dimension.getRow(); row++) {
            for (int col = 0; col < dimension.getColumn(); col++) {
                Cell cell = this.map[row][col];
                if (!cell.getPlayers().isEmpty()) {
                    for (int i = 0 ; i< cell.getPlayers().size();i++) {
                        System.out.println(cell.getPlayers().get(i).result());
                    }
                } else {
                    if (!CellItem.PLAIN.equals(cell.getCellItem())) {
                        System.out.println(cell.result());
                    }


                }

            }

        }
    }

    public boolean isValidCoordinate(Coordinate coordinate) {
        return coordinate.getX() >= 0
                && coordinate.getX() < dimension.getRow()
                && coordinate.getY() >= 0
                && coordinate.getY() < dimension.getColumn();
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public Cell getCell(Coordinate coordinate) {
        int x = coordinate.getX();
        int y = coordinate.getY();
        if (!isValidCoordinate(new Coordinate(x, y))) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return map[x][y];
    }

    public void setCell(Coordinate coordinate, Cell cell) {
        int x = coordinate.getX();
        int y = coordinate.getY();
        if (!isValidCoordinate(new Coordinate(x, y))) {
            throw new ArrayIndexOutOfBoundsException();
        }
        map[x][y] = cell;
    }

    public Cell[][] getMap() {
        return map;
    }

    public void setMap(Cell[][] map) {
        this.map = map;
    }
}
