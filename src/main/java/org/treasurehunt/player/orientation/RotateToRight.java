package org.treasurehunt.player.orientation;

public class RotateToRight extends Rotate {

    public RotateToRight(Orientation orientation) {
        super(orientation);
    }

    @Override
    public Orientation rotate() {
        Orientation newOrientation = null;
        switch (orientation) {
            case EST:
                newOrientation = Orientation.SOUTH;
                break;
            case WEST:
                newOrientation = Orientation.NORTH;
                break;
            case NORTH:
                newOrientation = Orientation.EST;
                break;
            case SOUTH:
                newOrientation = Orientation.WEST;
                break;
        }
        return newOrientation;
    }
}
