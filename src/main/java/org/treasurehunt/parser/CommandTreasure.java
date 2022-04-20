package org.treasurehunt.parser;

import org.treasurehunt.player.Coordinate;
import org.treasurehunt.universe.Universe;

public class CommandTreasure implements CommandHandlerStrategy {
  Universe universe ;
  public CommandTreasure(Universe universe) {
    this.universe = universe;
  }


  @Override
  public void execute(String line) throws CommandLineInvalidArgumentException {
    String[] command = line.split("-");
    if (command.length != 4)  { throw new CommandLineInvalidArgumentException();}
    int x = Integer.parseInt(command[1]);
    int y = Integer.parseInt(command[2]);
    int numberOfTreasure = Integer.parseInt(command[3]);
    //universe.getCell(new Coordinate(x,y))..setTreasure(numberOfTreasure);
    //TODO verifier si c pas une montagne
  }
}
