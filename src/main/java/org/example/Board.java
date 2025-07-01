package org.example;

public class Board {
    private Tile[] tiles = new Tile[9];

    public Board() {
        for (int i = 0; i < tiles.length; i++) {
            tiles[i] = new Tile(i + 1);
        }
    }

    public void printBoard() {
        System.err.println("\n   " + tiles[0].getType() + "   " + "|   " + tiles[1].getType() + "   |" + "   " + tiles[2].getType() + "   ");
        System.err.println("-------|-------|-------");
        System.err.println("   " + tiles[3].getType() + "   " + "|   " + tiles[4].getType() + "   |" + "   " + tiles[5].getType() + "   ");
        System.err.println("-------|-------|-------");
        System.err.println("   " + tiles[6].getType() + "   " + "|   " + tiles[7].getType() + "   |" + "   " + tiles[8].getType() + "   \n");
    }

    public Tile getTileState(int position) {
        return tiles[position - 1];
    }

    public void setTileState(int position, String type) {
        tiles[position - 1].setType(type);
    }

    public Tile[] getTiles() {
        return tiles;
    }

}

