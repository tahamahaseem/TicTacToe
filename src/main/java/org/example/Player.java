package org.example;

public class Player {
    private String symbol;

    public Player(String type) {
        setSymbol(type);
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return getSymbol();
    }

}
