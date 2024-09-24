package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Rook extends AbstractPiece {

  public Rook(PlayerColour colour) {
    super(PieceType.ROOK, colour);
  }

//  @Override
//  public Piece.PieceType getType() {
//    return this.getType();
//  }

//  @Override
//  public PlayerColour getColour() {
//    return colour;
//  }

//  @Override
//  public String toString() {
//    return colour.toString() + " " + this.getType().toString();
//  }

  @Override
  public List<Move> getAllowedMoves(Coordinates from, Board board) {

    var allowedMoves = new ArrayList<Move>();

    // rook can move = vertical, horizontal
    String[] directions = {"U", "R", "D", "L"};

    // loop over every allowed direction
    for(String direction : directions){
      Coordinates proposed = from;
      boolean stopped = false;
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

    return allowedMoves;
  }
}
