package org.treasurehunt.universe;

import org.treasurehunt.player.Coordinate;

import java.lang.reflect.Array;

public class Universe {
  private Dimension dimension;
  private Cell[][] map;

  public Universe(Dimension dimension) {

    this.dimension = dimension;
    this.map = new Cell[dimension.getRow()][dimension.getColumn()];
  }

  public Universe(){

  }
  public void initMap() {
    for (int row = 0; row < dimension.getRow(); row++) {
      for (int col = 0; col < dimension.getColumn(); col++) {
        Coordinate pos = new Coordinate(row, col);
        this.map[row][col] = new Cell(0, CellItem.PLAIN, pos, null);
      }
    }
  }

  public boolean isValidCoordinate(Coordinate coordinate) {
      return coordinate.getX() >= 0
              && coordinate.getX() < dimension.getRow()
              && coordinate.getY() >=0
              && coordinate.getY() < dimension.getColumn();
  }

  public Dimension getDimension() {
    return dimension;
  }

  public void setDimension(Dimension dimension) {
    this.dimension = dimension;
  }

  public Cell getCell(Coordinate coordinate){
    int x = coordinate.getX();
    int y = coordinate.getY();
    if(!isValidCoordinate(new Coordinate(x,y))) {throw new ArrayIndexOutOfBoundsException();}
    return map[x][y];
  }
  public Cell[][] getMap() {
    return map;
  }

  public void setMap(Cell[][] map) {
    this.map = map;
  }
}
