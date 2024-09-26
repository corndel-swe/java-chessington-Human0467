package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Queen extends AbstractPiece {

  public Queen(PlayerColour colour) {
    super(PieceType.QUEEN, colour);
  }

  @Override
  public List<Move> getAllowedMoves(Coordinates from, Board board) {
    var allowedMoves = new ArrayList<Move>();

    String[] directions = {"U", "UR", "R", "DR", "D", "DL", "L", "UL"};
    int maxDistance = 8;

    allowedMoves = board.getMoves(directions, maxDistance, this.getColour(), from);

    return allowedMoves;
  }
}
