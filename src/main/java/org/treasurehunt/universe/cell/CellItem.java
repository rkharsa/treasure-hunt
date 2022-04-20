package org.treasurehunt.universe.cell;

public enum CellItem {
    MOUNTAIN("M"),
    PLAIN("."),
    TREASURE("T");

    String symbol;
    CellItem(String  str) {
        symbol = str;
    }


    public String getSymbol() {
        return symbol;
    }
}
