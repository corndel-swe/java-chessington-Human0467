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

  @Override
  public List<Move> getAllowedMoves(Coordinates from, Board board) {

    var allowedMoves = new ArrayList<Move>();

    // rook can move = vertical, horizontal
    String[] directions = {"U", "R", "D", "L"};
    int maxDistance = 8;

    allowedMoves = board.getMoves(directions, maxDistance, this.getColour(), from);

    return allowedMoves;
  }
}
