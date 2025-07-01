package org.example;

public class Tile {
    private int position;
    private String type;

    public Tile(int position) {
        setPosition(position);
        setType(Utils.EMPTY_STRING);
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
