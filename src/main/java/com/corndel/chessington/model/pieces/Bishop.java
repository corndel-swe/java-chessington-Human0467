package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends AbstractPiece {

//  private final Piece.PieceType type;
//  protected final PlayerColour colour;

  public Bishop(PlayerColour colour) {
//    this.type = PieceType.BISHOP;
//    this.colour = colour;
    super(PieceType.BISHOP, colour);
  }

//  @Override
//  public Piece.PieceType getType() {
//    return type;
//  }

//  @Override
//  public PlayerColour getColour() {
//    return colour;
//  }
//
//  @Override
//  public String toString() {
//    return colour.toString() + " " + type.toString();
//  }

  @Override
  public List<Move> getAllowedMoves(Coordinates from, Board board) {
    var allowedMoves = new ArrayList<Move>();

    String[] directions = {"UR", "DR", "UL", "DL"};
    // loop over every allowed direction
    for(String direction : directions){
      Coordinates proposed = from;
      boolean stopped = false;
      System.out.println(direction);
      // keep checking spaces in this direction until we get 'stopped'
      while(!stopped){
        // get proposed next move
        proposed = board.getNextMove(proposed, direction);
        // check if on board?
        if(!board.isSpaceOnBoard(proposed)) {
          stopped = true;
          break;
        } else if(board.isSpaceEmpty(proposed)){
          allowedMoves.add(new Move(from, proposed));
          continue;
        } else if(board.isPieceFriendly(proposed, this.getColour())){
          stopped = true;
          break;
        } else {
          stopped = true;
          allowedMoves.add(new Move(from, proposed));
          break;
        }
      }
    }
//      // traverse every space of the board
//      int[] possibleDiagonals = {1,-1};
//      for(int possibleDiagonal : possibleDiagonals ) {
//        int intercept = from.getRow() - possibleDiagonal*(from.getCol());
//        for (int i = 0; i <= 7; i++) {
//          for (int j = 0; j <= 7; j++) {
//            // are the points on the line?
//            if (j - (possibleDiagonal*i) - intercept == 0) {
//              System.out.println("(" + i + "," + j + ") is on the line");
//              // record how to get there
//              int colDiff = i - from.getCol();
//              int rowDiff = j - from.getRow();
//              if (!(rowDiff == 0 && colDiff == 0)) {
//                // check here if space is occupied
//                //  - by friendly? blocked
//                //  - by enemy? can take
//                allowedMoves.add(new Move(from, from.plus(rowDiff, colDiff)));
//                System.out.println(new Move(from, from.plus(rowDiff, colDiff)).toString());
//              }
//            }
//          }
//        }
//      }

    return allowedMoves;
  }
}
