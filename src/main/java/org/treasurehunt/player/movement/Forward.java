package org.treasurehunt.player.movement;

import org.treasurehunt.player.Coordinate;
import org.treasurehunt.player.orientation.Orientation;

public class Forward extends Movement {

    public Forward(Orientation orientation, Coordinate currentPos) {
        super(orientation, currentPos);
    }

    @Override
    public Coordinate move() {
        int x = currentPos.getX();
        int y = currentPos.getY();
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
        return new Coordinate(x,y);
    }
}
