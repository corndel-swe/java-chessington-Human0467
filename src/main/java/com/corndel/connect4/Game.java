package com.corndel.connect4;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {

        var board = Board.newGameBoard();

        board.printBoard(board);

        boolean winner = false;
        int currentPlayer = 1;
        int turns = 0;

        System.out.println("Welcome to Connect-4!");
        Scanner input = new Scanner(System.in);

        while(turns < 10){
            // select shape to drop
            char playerShape = currentPlayer == 1 ? 'o' : 'x';

            // ask which column
            System.out.println("Player" + currentPlayer + " (" + playerShape + "), " +
                    "which column would you like to drop in? : ");
            // convert from ascii code to int
            // https://stackoverflow.com/questions/46343616/how-can-i-convert-a-char-to-int-in-java
            int col = input.nextLine().charAt(0) - '0';

            // add the piece
            board.dropPiece(board, col, playerShape);

            // print new board state
            board.printBoard(board);

            // swap players
            currentPlayer = currentPlayer == 1 ? 2 : 1;

            board.checkIfWinner(board);
            turns++;
        }
    }
}
