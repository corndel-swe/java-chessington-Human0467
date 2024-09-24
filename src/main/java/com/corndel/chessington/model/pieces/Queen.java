package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Queen extends AbstractPiece {

//  private final Piece.PieceType type;
//  protected final PlayerColour colour;

  public Queen(PlayerColour colour) {
//    this.type = PieceType.QUEEN;
//    this.colour = colour;
    super(PieceType.QUEEN, colour);
  }

//  @Override
//  public Piece.PieceType getType() {
//    return type;
//  }
//
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

    String[] directions = {"U", "UR", "R", "DR", "D", "DL", "L", "UL"};
    int maxDistance = 8;
    // loop over every allowed direction
    for(String direction : directions){
      int moved = 0;
      Coordinates proposed = from;
      boolean stopped = false;
      // keep checking spaces in this direction until we get 'stopped'
      while(!stopped && moved < maxDistance){
        // get proposed next move
        proposed = board.getNextMove(proposed, direction);
        // check if on board?
        if(!board.isSpaceOnBoard(proposed)) {
          stopped = true;
          break;
        } else if(board.isSpaceEmpty(proposed)){
          allowedMoves.add(new Move(from, proposed));
          moved++;
          continue;
        } else if(board.isPieceFriendly(proposed, this.getColour())){
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
