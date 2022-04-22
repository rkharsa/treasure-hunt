package org.treasurehunt.player.orientation;

public abstract class Rotate {

    protected Orientation orientation;

    protected Rotate(Orientation orientation) {
        this.orientation = orientation;
    }

    public abstract Orientation rotate();

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

}
