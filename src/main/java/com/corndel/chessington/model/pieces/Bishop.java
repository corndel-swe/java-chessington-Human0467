package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends AbstractPiece {

  public Bishop(PlayerColour colour) {
    super(PieceType.BISHOP, colour);
  }

  @Override
  public List<Move> getAllowedMoves(Coordinates from, Board board) {
    var allowedMoves = new ArrayList<Move>();

    String[] directions = {"UR", "DR", "UL", "DL"};
    int maxDistance = 8;

    allowedMoves = board.getMoves(directions, maxDistance, this.getColour(), from);

    return allowedMoves;
  }
}
