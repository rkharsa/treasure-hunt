package org.treasurehunt.player.orientation;

public enum Orientation {
    NORTH("N"),

    WEST("W"),
    SOUTH("S"),
    EST("E");
    private String orientationStr;
    Orientation(String orientationStr) {
        this.orientationStr = orientationStr;
    }

    public String getOrientationStr() {
        return orientationStr;
    }

    public static Orientation fromString(String text) {
        for (Orientation b : Orientation.values()) {
            if (b.orientationStr.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}
