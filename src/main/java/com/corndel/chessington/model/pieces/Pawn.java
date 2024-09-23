package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;
import java.util.ArrayList;
import java.util.List;

public class Pawn implements Piece {

  private final Piece.PieceType type;
  protected final PlayerColour colour;

  public Pawn(PlayerColour colour) {
    this.type = PieceType.PAWN;
    this.colour = colour;
  }

  @Override
  public Piece.PieceType getType() {
    return type;
  }

  @Override
  public PlayerColour getColour() {
    return colour;
  }

  @Override
  public String toString() {
    return colour.toString() + " " + type.toString();
  }

  @Override
  public List<Move> getAllowedMoves(Coordinates from, Board board) {
    var allowedMoves = new ArrayList<Move>();

    // basic ability to move one square forwards
    if (getColour().equals(PlayerColour.WHITE)) {
      Coordinates proposed = from.plus(-1, 0);
      if(board.isSpaceEmpty(proposed)) {
        allowedMoves.add(new Move(from, proposed));
      }
    } else {
      Coordinates proposed = from.plus(1, 0);
      if(board.isSpaceEmpty(proposed)) {
        allowedMoves.add(new Move(from, proposed));
      }
    }

    // pawns can only move forwards, so if it is on the starting row that means
    // it has not been moved --> is allowed to move 2 spaces forward
    if (getColour().equals(PlayerColour.WHITE) &&
            (from.getRow() == 6)) {
      Coordinates proposed = from.plus(-2, 0);
      if(board.isSpaceEmpty(proposed)){
        allowedMoves.add(new Move(from, proposed));
      }
    } else if (getColour().equals(PlayerColour.BLACK) &&
            (from.getRow() == 1)){
      Coordinates proposed = from.plus(2, 0);
      if(board.isSpaceEmpty(proposed)) {
        allowedMoves.add(new Move(from, proposed));
      }
    }

    // pawns capture diagonally
    // check if there is a piece there
    if (getColour().equals(PlayerColour.WHITE)) {
      Coordinates proposed = from.plus(-1, 1);
      if(!board.isSpaceEmpty(proposed)) {
        allowedMoves.add(new Move(from, proposed));
      }
      proposed = from.plus(-1, -1);
      if(!board.isSpaceEmpty(proposed)) {
        allowedMoves.add(new Move(from, proposed));
      }
    } else {
      Coordinates proposed = from.plus(1, 1);
      if(!board.isSpaceEmpty(proposed)) {
        allowedMoves.add(new Move(from, proposed));
      }
      proposed = from.plus(1, -1);
      if(!board.isSpaceEmpty(proposed)) {
        allowedMoves.add(new Move(from, proposed));
      }
    }
    // TODO Implement this!
    return allowedMoves;
  }
}
