package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class King extends AbstractPiece {

  private final Piece.PieceType type;
  protected final PlayerColour colour;
  protected boolean moved = false;

  public King(PlayerColour colour) {
//    this.type = PieceType.KING;
//    this.colour = colour;
    super(PieceType.KING, colour);
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

    String[] directions = {"U", "UR", "R" "DR", "D", "DL", "L", "UL"};
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
    return allowedMoves;
  }
}
