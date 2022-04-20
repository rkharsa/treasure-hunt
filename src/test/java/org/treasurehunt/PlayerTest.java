package org.treasurehunt;

import org.junit.Test;
import org.treasurehunt.player.Coordinate;
import org.treasurehunt.player.movement.Forward;
import org.treasurehunt.player.orientation.Orientation;
import org.treasurehunt.player.Player;
import org.treasurehunt.player.orientation.RotateToLeft;
import org.treasurehunt.player.orientation.RotateToRight;
import org.treasurehunt.universe.Dimension;
import org.treasurehunt.universe.ProhibitedPositionException;
import org.treasurehunt.universe.Universe;

import static org.junit.Assert.*;

public class PlayerTest {

  @Test
  public void should_go_north_when_player_turn_left_with_current_orientation_est() {
    Coordinate coordinate = new Coordinate(1, 1);
    Player player = new Player(coordinate, Orientation.EST,"Rani");

    Orientation orientationExpectedBeforeTurn = Orientation.EST;
    assertEquals(orientationExpectedBeforeTurn, player.getOrientation());

    player.rotate(new RotateToLeft(player.getOrientation()));

    Orientation orientationExpectedAfterTurn = Orientation.NORTH;
    assertEquals(orientationExpectedAfterTurn, player.getOrientation());
  }

  @Test
  public void should_go_west_when_player_turn_left_with_current_orientation_north() {
    Coordinate coordinate = new Coordinate(1, 1);
    Player player = new Player(coordinate, Orientation.NORTH,"");

    Orientation orientationExpectedBeforeTurn = Orientation.NORTH;
    assertEquals(orientationExpectedBeforeTurn, player.getOrientation());

    player.rotate(new RotateToLeft(player.getOrientation()));

    Orientation orientationExpectedAfterTurn = Orientation.WEST;
    assertEquals(orientationExpectedAfterTurn, player.getOrientation());
  }

  @Test
  public void should_go_south_when_player_turn_left_with_current_orientation_west() {
    Coordinate coordinate = new Coordinate(1, 1);
    Player player = new Player(coordinate, Orientation.WEST,"");

    Orientation orientationExpectedBeforeTurn = Orientation.WEST;
    assertEquals(orientationExpectedBeforeTurn, player.getOrientation());

    player.rotate(new RotateToLeft(player.getOrientation()));

    Orientation orientationExpectedAfterTurn = Orientation.SOUTH;
    assertEquals(orientationExpectedAfterTurn, player.getOrientation());
  }

  @Test
  public void should_go_est_when_player_turn_left_with_current_orientation_south() {
    Coordinate coordinate = new Coordinate(1, 1);
    Player player = new Player(coordinate, Orientation.SOUTH,"");

    Orientation orientationExpectedBeforeTurn = Orientation.SOUTH;
    assertEquals(orientationExpectedBeforeTurn, player.getOrientation());

    player.rotate(new RotateToLeft(player.getOrientation()));

    Orientation orientationExpectedAfterTurn = Orientation.EST;
    assertEquals(orientationExpectedAfterTurn, player.getOrientation());
  }

  @Test
  public void should_go_north_when_player_turn_right_with_current_orientation_est() {
    Coordinate coordinate = new Coordinate(1, 1);
    Player player = new Player(coordinate, Orientation.EST,"");

    Orientation orientationExpectedBeforeTurn = Orientation.EST;
    assertEquals(orientationExpectedBeforeTurn, player.getOrientation());

    player.rotate(new RotateToRight(player.getOrientation()));

    Orientation orientationExpectedAfterTurn = Orientation.SOUTH;
    assertEquals(orientationExpectedAfterTurn, player.getOrientation());
  }

  @Test
  public void should_go_west_when_player_turn_right_with_current_orientation_north() {
    Coordinate coordinate = new Coordinate(1, 1);
    Player player = new Player(coordinate, Orientation.NORTH,"");

    Orientation orientationExpectedBeforeTurn = Orientation.NORTH;
    assertEquals(orientationExpectedBeforeTurn, player.getOrientation());

    player.rotate(new RotateToRight(player.getOrientation()));

    Orientation orientationExpectedAfterTurn = Orientation.EST;
    assertEquals(orientationExpectedAfterTurn, player.getOrientation());
  }

  @Test
  public void should_go_south_when_player_turn_right_with_current_orientation_west() {
    Coordinate coordinate = new Coordinate(1, 1);
    Player player = new Player(coordinate, Orientation.WEST,"");

    Orientation orientationExpectedBeforeTurn = Orientation.WEST;
    assertEquals(orientationExpectedBeforeTurn, player.getOrientation());

    player.rotate(new RotateToRight(player.getOrientation()));

    Orientation orientationExpectedAfterTurn = Orientation.NORTH;
    assertEquals(orientationExpectedAfterTurn, player.getOrientation());
  }

  @Test
  public void should_go_est_when_player_turn_right_with_current_orientation_south() {
    Coordinate coordinate = new Coordinate(1, 1);
    Player player = new Player(coordinate, Orientation.SOUTH,"");

    Orientation orientationExpectedBeforeTurn = Orientation.SOUTH;
    assertEquals(orientationExpectedBeforeTurn, player.getOrientation());

    player.rotate(new RotateToRight(player.getOrientation()));

    Orientation orientationExpectedAfterTurn = Orientation.WEST;
    assertEquals(orientationExpectedAfterTurn, player.getOrientation());
  }


  @Test
  public void should_go_up_when_player_has_current_orientation_north() throws ProhibitedPositionException {
    // init universe
    final Dimension dimension = new Dimension(2, 3);
    Universe universe = new Universe(dimension);
    universe.initMap();

    // init player
    Coordinate coordinate = new Coordinate(1, 1);
    Player player = new Player(coordinate, Orientation.NORTH,"");

    Coordinate expectedPos =  new Coordinate(0,1);
    player.move(universe,new Forward(player.getOrientation(),player.getCoordinate()));

    assertEquals(expectedPos.toString(),player.getCoordinate().toString());

  }

  @Test
  public void should_go_down_when_player_has_current_orientation_south() throws ProhibitedPositionException {
    // init universe
    final Dimension dimension = new Dimension(3, 5);
    Universe universe = new Universe(dimension);
    universe.initMap();

    // init player
    Coordinate coordinate = new Coordinate(1, 1);
    Player player = new Player(coordinate, Orientation.SOUTH,"");

    Coordinate expectedPos =  new Coordinate(2,1);
    player.move(universe,new Forward(player.getOrientation(),player.getCoordinate()));

    assertEquals(expectedPos.toString(),player.getCoordinate().toString());

  }
}
