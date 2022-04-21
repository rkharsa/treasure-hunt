package org.treasurehunt.player.enums;

public enum Move {
    L("G"),
    R("D"),
    F("A");

    private final String moveStr;

    Move(String s) {
        moveStr = s;
    }

    public static Move fromString(String text) {
        for (Move b : Move.values()) {
            if (b.moveStr.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }

    public String getMoveStr() {
        return moveStr;
    }

}
