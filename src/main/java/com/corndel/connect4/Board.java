package com.corndel.connect4;

public class Board {

    private int width = 7;
    private int height = 6;

    private char[][] board = new char[height][width];

    private Board() {}

    public static Board newGameBoard(){
        Board board = new Board();
        for (int i = 0; i < board.height; i++) {
            for (int j = 0; j < board.width; j++) {
                board.getBoard()[i][j] = ' ';
            }
        }
        return board;
    }

    public char[][] getBoard(){ return board; }

    public void printBoard (Board board){
        StringBuilder boardToPrint = new StringBuilder();
        for (int i = 0; i < board.height; i++) {
            for (int j = 0; j < board.width; j++) {
                if(board.getBoard()[i][j] != ' '){
                    boardToPrint.append("[" + board.getBoard()[i][j] + "]");
                } else {
                    boardToPrint.append("[ ]");
                }
            }
            boardToPrint.append("\n");

        }
        System.out.println(boardToPrint);
    }

    public void dropPiece(Board board, int col, char shape){
        // start from the bottom
        for (int i = board.height-1; i > 0; i--) {
            if(board.getBoard()[i][col] == ' '){
                board.getBoard()[i][col] = shape;
                break;
            }
        }
    }

    public boolean checkIfWinner(Board board){

        // check horizontal
        for (int i = 0; i < board.height; i++) {
            int lineLength = 1;
            for (int j = 1; j < board.width; j++) {
                if((board.getBoard()[i][j] == board.getBoard()[i][j-1]) &&
                        board.getBoard()[i][j] != ' '){
                    lineLength++;
                    System.out.println(lineLength);
                    if(lineLength == 4){
                        System.out.println("winner!");
                        break;
                    }
                }
            }
        }

        // check vertical
        for (int i = 0; i < board.width; i++) {
            int lineLength = 1;
            for (int j = 1; j < board.height; j++) {
                if((board.getBoard()[j][i] == board.getBoard()[j-1][i]) &&
                        board.getBoard()[j][i] != ' '){
                    lineLength++;
                    System.out.println(lineLength);
                    if(lineLength == 4){
                        System.out.println("winner!");
                        break;
                    }
                }
            }
        }
        return false;
    }
}


