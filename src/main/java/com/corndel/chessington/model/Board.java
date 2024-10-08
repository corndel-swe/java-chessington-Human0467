package com.corndel.chessington.model;

import com.corndel.chessington.model.pieces.*;

import java.awt.*;
import java.util.ArrayList;

public class Board {

  public static final int BOARD_SIZE = 8;

  private Piece[][] board = new Piece[BOARD_SIZE][BOARD_SIZE];

  private Board() {}

  public static Board forNewGame() {
    Board board = new Board();
    board.setBackRow(0, PlayerColour.BLACK);
    board.setBackRow(7, PlayerColour.WHITE);

    for (int col = 0; col < BOARD_SIZE; col++) {
      board.board[1][col] = new Pawn(PlayerColour.BLACK);
      board.board[6][col] = new Pawn(PlayerColour.WHITE);
    }

    return board;
  }

  public Piece[][] getBoard() {
    return board;
  }

  public static Board empty() {
    return new Board();
  }

  private void setBackRow(int rowIndex, PlayerColour colour) {
    board[rowIndex][0] = new Rook(colour);
    board[rowIndex][1] = new Knight(colour);
    board[rowIndex][2] = new Bishop(colour);
    board[rowIndex][3] = new Queen(colour);
    board[rowIndex][4] = new King(colour);
    board[rowIndex][5] = new Bishop(colour);
    board[rowIndex][6] = new Knight(colour);
    board[rowIndex][7] = new Rook(colour);
  }

  public Piece get(Coordinates coords) {
    return board[coords.getRow()][coords.getCol()];
  }

  public void move(Coordinates from, Coordinates to) {
    Piece piece = board[from.getRow()][from.getCol()];
    board[to.getRow()][to.getCol()] = piece;
    board[from.getRow()][from.getCol()] = null;
  }

  public void placePiece(Coordinates coords, Piece piece) {
    board[coords.getRow()][coords.getCol()] = piece;
  }

  // maybe split into two - containsOwnPiece / containsEnemyPiece?
  public boolean isSpaceEmpty(Coordinates coords){
    // check if its on the board first to avoid potential
    // index out of range errors
    if(this.isSpaceOnBoard(coords)) {
      return this.get(coords) == null;
    } else {
      return false;
    }
  }

  public boolean isSpaceOnBoard(Coordinates coords){
    return (coords.getRow() >= 0 &&
            coords.getRow() < Board.BOARD_SIZE &&
            coords.getCol() >= 0 &&
            coords.getCol() < Board.BOARD_SIZE);
  }

  public Coordinates getNextMove(Coordinates from, String direction){
    switch(direction){

      case "U":
        return from.plus(-1,0);
      case "UR":
        return from.plus(-1, 1);
      case "R":
        return from.plus(0,1);
      case "DR":
        return from.plus(1, 1);
      case "D":
        return from.plus(1, 0);
      case "DL":
        return from.plus(1, -1);
      case "L":
        return from.plus(0, -1);
      case "UL":
        return from.plus(-1, -1);
    }
    // needs a catch-all return / should throw an error
    return from;
  }

  public boolean isPieceFriendly(Coordinates target, PlayerColour colour){
    return this.get(target).getColour().equals(colour);
  }

  public ArrayList<Move> getMoves (String[] directions, int maxDistance, PlayerColour colour,
                                   Coordinates from){
    var allowedMoves = new ArrayList<Move>();

    for(String direction : directions){
      int moved = 0;
      Coordinates proposed = from;
      boolean stopped = false;
      // keep checking spaces in this direction until we get 'stopped'
      while(!stopped && moved < maxDistance){
        // get proposed next move
        proposed = this.getNextMove(proposed, direction);
        // check if on board?
        if(!this.isSpaceOnBoard(proposed)) {
          stopped = true;
          break;
        } else if(this.isSpaceEmpty(proposed)){
          allowedMoves.add(new Move(from, proposed));
          moved++;
          continue;
        } else if(this.isPieceFriendly(proposed, colour)){
          stopped = true;
          break;
        } else {
          stopped = true;
          allowedMoves.add(new Move(from, proposed));
          moved++;
          break;
        }
      }
    }

    return allowedMoves;
  }

}
