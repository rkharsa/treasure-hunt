package org.treasurehunt.player.movement;

import org.treasurehunt.player.Coordinate;
import org.treasurehunt.player.orientation.Orientation;

public abstract class Movement {
   Orientation orientation;
   Coordinate currentPos;

   public Movement(Orientation orientation, Coordinate currentPos) {
      this.orientation = orientation;
      this.currentPos = currentPos;
   }

   public abstract Coordinate move();

   public Orientation getOrientation() {
      return orientation;
   }

   public void setOrientation(Orientation orientation) {
      this.orientation = orientation;
   }

   public Coordinate getCurrentPos() {
      return currentPos;
   }

   public void setCurrentPos(Coordinate currentPos) {
      this.currentPos = currentPos;
   }

}
