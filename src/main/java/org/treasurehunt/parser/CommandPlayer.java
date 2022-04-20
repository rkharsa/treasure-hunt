package org.treasurehunt.parser;

import org.treasurehunt.parser.exceptions.CommandLineInvalidArgumentException;
import org.treasurehunt.player.Coordinate;
import org.treasurehunt.player.Move;
import org.treasurehunt.player.Player;
import org.treasurehunt.player.movement.Forward;
import org.treasurehunt.player.orientation.Orientation;
import org.treasurehunt.player.orientation.RotateToLeft;
import org.treasurehunt.player.orientation.RotateToRight;
import org.treasurehunt.universe.ProhibitedPositionException;
import org.treasurehunt.universe.Universe;

import java.util.Objects;
import java.util.logging.Logger;

public class CommandPlayer implements CommandHandlerStrategy {

    @Override
    public void execute(String line, Universe universe) throws CommandLineInvalidArgumentException {
        String[] command = line.split("-");
        if (command.length != 6) {
            throw new CommandLineInvalidArgumentException();
        }
        String name = command[1];
        int x = Integer.parseInt(command[2]);
        int y = Integer.parseInt(command[3]);
        Coordinate pos = new Coordinate(x, y);
        Orientation orientation = Orientation.fromString(command[4]);
        String movementSequence = command[5];

        Player player = new Player(pos, orientation, name);
        universe.getCell(pos).setPlayer(player);
        try {
            movePlayer(movementSequence,player,universe);
        }catch (Exception e){
            System.out.printf("erreur");
        }

    }

    void movePlayer(String moveSequence, Player player, Universe universe) throws ProhibitedPositionException {
        char[] moveSequenceArray = moveSequence.toCharArray();

        for (char move : moveSequenceArray) {
            switch (Objects.requireNonNull(Move.fromString(String.valueOf(move)))) {
                case F:
                    player.move(universe, new Forward(player.getOrientation(), player.getCoordinate()));
                    break;
                case L:
                    player.rotate(new RotateToLeft(player.getOrientation()));
                    break;
                case R:
                    player.rotate(new RotateToRight(player.getOrientation()));
                    break;
            }
        }
    }
}
