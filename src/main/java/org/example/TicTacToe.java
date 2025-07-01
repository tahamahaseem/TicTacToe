package org.example;

import java.util.Scanner;

public class TicTacToe {
    private Board board;
    private Player turn;
    private Player[] players = new Player[2];
    private Scanner scanner = new Scanner(System.in);

    public TicTacToe() {
        gameLoop();
    }

    public void reset() {
        board = new Board();
        players[0] = new Player(Utils.X);
        players[1] = new Player(Utils.O);
        turn = players[0];
    }

    public boolean checkForWinCondition(int position1, int position2, int position3) {
        String symbol1 = board.getTileState(position1).getType();
        String symbol2 = board.getTileState(position2).getType();
        String symbol3 = board.getTileState(position3).getType();
        return (!symbol1.equals(Utils.EMPTY_STRING) || !symbol2.equals(Utils.EMPTY_STRING) || !symbol3.equals(Utils.EMPTY_STRING))
                && (symbol1.equals(symbol2) && symbol2.equals(symbol3));
    }

    public boolean checkForDraw() {
        for (Tile tile : board.getTiles()) {
            if (tile.getType().equals(Utils.EMPTY_STRING)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkForWinner() {
        return checkForWinCondition(1, 2, 3) || checkForWinCondition(1, 4, 7)
                || checkForWinCondition(2, 5, 8) || checkForWinCondition(7, 8, 9)
                || checkForWinCondition(1, 5, 9) || checkForWinCondition(3, 5, 7)
                || checkForWinCondition(2, 5, 8) || checkForWinCondition(4, 5, 6);
    }


    public void printBoard() {
        board.printBoard();
    }

    public Player getTurn() {
        return turn;
    }

    public void setTurn(Player turn) {
        this.turn = turn;
    }

    public void placeSymbol(int position) {
        board.setTileState(position, turn.getSymbol());
    }

    public void changeTurn() {
        if (turn.equals(players[0])) {
            setTurn(players[1]);
        } else {
            setTurn(players[0]);
        }
    }

    public boolean isPositionTaken(int position) {
        return !board.getTileState(position).getType().equals(" ");
    }

    public boolean isInputValid(String input) {
        try {
            int position = Integer.parseInt(input);
            return position >= 1 && position <= 9;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean shouldContinueGame(String input) {
        return input.toUpperCase().trim().equals(Utils.YES);
    }

    public void gameLoop() {
        boolean keepPlaying = true;
        while (keepPlaying) {
            reset();
            String position;
            printBoard();
            while (true) {
                while (true) {
                    System.out.println("Player " + getTurn() + ", please pick a position from 1-9");
                    position = scanner.nextLine();
                    if (!isInputValid(position) || isPositionTaken(Integer.parseInt(position))) {
                        System.out.println("\nTry again! That position is either taken or you have given an invalid input! :(");
                        printBoard();
                    } else {
                        break;
                    }
                }

                placeSymbol(Integer.parseInt(position));
                printBoard();
                if (checkForWinner()) {
                    System.out.println("Player " + getTurn() + " wins! :)");
                    break;
                }
                if (checkForDraw()) {
                    System.out.println("Draw. No player won :/");
                    break;
                }
                changeTurn();
            }
            System.out.println("\nIf you would like to restart, type Y/y, otherwise enter anything to end the game. :D");
            String decision = scanner.nextLine();
            if (!shouldContinueGame(decision)) {
                keepPlaying = false;
            }
        }
        scanner.close();
    }
}
