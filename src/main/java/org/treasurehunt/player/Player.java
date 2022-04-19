package org.treasurehunt.player;

import org.treasurehunt.universe.Universe;
import org.treasurehunt.universe.Cell;
import org.treasurehunt.universe.CellItem;

import java.util.List;
import java.util.Arrays;

public class Player {
  private Coordinate coordinate;
  private Orientation orientation;
  private  String name;
  private int numberOfTreasureFound ;

  public Player(Coordinate coordinate, Orientation orientation,String name) {
    this.coordinate = coordinate;
    this.orientation = orientation;
    this.name = name;
  }

  public void turnLeft() {
    List<Orientation> orientations = Arrays.asList(Orientation.values());
    int indexOfOrientation = orientations.indexOf(orientation);
    orientation = orientations.get((indexOfOrientation + 1) % 4);
  }

  public void turnRight() {
    List<Orientation> orientations = Arrays.asList(Orientation.values());
    int indexOfOrientation = orientations.indexOf(orientation);
    orientation = orientations.get(((indexOfOrientation - 1 % 4) + 4) % 4);
  }

  public void setNewPositionToPlayer(Universe universe, Coordinate newCoordinate){
    if(!universe.isValidCoordinate(newCoordinate) ||  universe.getCell(newCoordinate).isMountain()) {
      return;
    }
    universe.getCell(newCoordinate).setPlayer(this);
    this.setCoordinate(newCoordinate);
  }

  public void forward(Universe universe) {
    int x = coordinate.getX();
    int y = coordinate.getY();
    switch (orientation){
      case EST:
        y +=1;
        break;
      case WEST:
        y-=1;
        break;
      case NORTH:
        x-=1;
        break;
      case SOUTH:
        x+=1;
        break;
    }
    setNewPositionToPlayer(universe,new Coordinate(x,y));
  }

  void findTreasure(Cell cell){
    if(cell.getCellItem()== CellItem.TREASURE){
      cell.removeTreasure();
      this.numberOfTreasureFound++;
    }
  }

  public Orientation getOrientation() {
    return orientation;
  }

  public void setOrientation(Orientation orientation) {
    this.orientation = orientation;
  }

  public Coordinate getCoordinate() {
    return coordinate;
  }

  public void setCoordinate(Coordinate coordinate) {
    this.coordinate = coordinate;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getNumberOfTreasureFound() {
    return numberOfTreasureFound;
  }

  public void setNumberOfTreasureFound(int numberOfTreasureFound) {
    this.numberOfTreasureFound = numberOfTreasureFound;
  }
}
