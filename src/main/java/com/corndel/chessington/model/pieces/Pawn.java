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

    int direction = getColour().equals(PlayerColour.WHITE) ? -1 : 1;
    // basic ability to move one square forwards
      Coordinates proposed = from.plus(direction, 0);
      if(board.isSpaceEmpty(proposed)) {
        allowedMoves.add(new Move(from, proposed));
      }


    // pawns can only move forwards, so if it is on the starting row that means
    // it has not been moved --> is allowed to move 2 spaces forward
    boolean isFirstMove = (from.getRow() == 6 && direction == -1 ) ||
            (from.getRow() == 1 && direction == 1);
    if (isFirstMove) {
      proposed = from.plus(direction * 2, 0);
      if (board.isSpaceEmpty(proposed)) {
        allowedMoves.add(new Move(from, proposed));
      }
    }

    // pawns capture diagonally
    // check if there is an ENEMY piece there
    int[] possibleDiagonals = {1,-1};
    for (int possibleDiagonal : possibleDiagonals) {
      proposed = from.plus(direction, possibleDiagonal);
      if (!board.isSpaceEmpty(proposed) &&
              // since we've negated the first test, need to explicitly
              // check this too
              board.isSpaceOnBoard(proposed) &&
              // is the piece an enemy piece?
              !board.get(proposed).getColour().equals(getColour())) {
        allowedMoves.add(new Move(from, proposed));
      }
    }

    return allowedMoves;
  }
}
