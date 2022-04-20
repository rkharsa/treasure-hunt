package org.treasurehunt.player;

import org.treasurehunt.player.movement.Movement;
import org.treasurehunt.player.orientation.Orientation;
import org.treasurehunt.player.orientation.Rotate;
import org.treasurehunt.universe.Cell;
import org.treasurehunt.universe.ProhibitedPositionException;
import org.treasurehunt.universe.Universe;
import org.treasurehunt.universe.CellItem;

public class Player {
  private Coordinate coordinate;
  private Orientation orientation;
  private  String name;
  private int numberOfTreasureFound ;

  public Player(Coordinate coordinate, Orientation orientation, String name) {
    this.coordinate = coordinate;
    this.orientation = orientation;
    this.name = name;
  }


  public void setNewPositionToPlayer(Universe universe,Coordinate oldCoordinate, Coordinate newCoordinate) throws ProhibitedPositionException {
    if(!universe.isValidCoordinate(newCoordinate) || isMountain(universe, newCoordinate)) {
      return;
    }
    Cell oldPos = universe.getCell(oldCoordinate);
    oldPos.setPlayer(null);
    Cell newPos =universe.getCell(newCoordinate);
    newPos.setPlayer(this);
    this.setCoordinate(newCoordinate);
    newPos.actionOnCell(newPos.getPlayer());
  }

  private boolean isMountain(Universe universe, Coordinate newCoordinate) {
    return CellItem.MOUNTAIN.equals(universe.getCell(newCoordinate).getCellItem());
  }

  public void move(Universe universe, Movement movement) throws ProhibitedPositionException {
    setNewPositionToPlayer(universe,movement.getCurrentPos(),movement.move());
  }

  public void rotate(Rotate rotate) {
    orientation= rotate.rotate();
  }

  public void findTreasure(){
      this.numberOfTreasureFound++;
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
