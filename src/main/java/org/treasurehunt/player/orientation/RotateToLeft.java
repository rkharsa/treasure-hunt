package org.treasurehunt.player.orientation;

public class RotateToLeft extends Rotate {

    public RotateToLeft(Orientation orientation) {
        super(orientation);
    }

    @Override
    public Orientation rotate() {
        Orientation newOrientation = null;
        switch (orientation){
            case EST:
               newOrientation=Orientation.NORTH;
                break;
            case WEST:
                newOrientation = Orientation.SOUTH;
                break;
            case NORTH:
                newOrientation =Orientation.WEST;
                break;
            case SOUTH:
                newOrientation = Orientation.EST;
                break;
        }
        return  newOrientation;
    }
}
