package org.treasurehunt.universe;

import org.treasurehunt.player.Coordinate;
import org.treasurehunt.universe.cell.Cell;
import org.treasurehunt.universe.cell.CellPlain;

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
                this.map[row][col] = new CellPlain(pos, null);
            }
        }
    }

    public void display() {
        for (int row = 0; row < dimension.getRow(); row++) {
            for (int col = 0; col < dimension.getColumn(); col++) {
                System.out.print("|"+this.map[row][col].getCellItem());
                if(this.map[row][col].getPlayer()!=null){
                    System.out.print(this.map[row][col].getPlayer().getName()+"("+this.map[row][col].getPlayer().getNumberOfTreasureFound()+")");
                }
            }
            System.out.println();
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
