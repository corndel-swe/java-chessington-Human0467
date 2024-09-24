package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;

import java.util.List;

public abstract class AbstractPiece implements Piece {

  private final Piece.PieceType type;
  protected final PlayerColour colour;

  protected AbstractPiece(Piece.PieceType type, PlayerColour colour) {
    this.type = type;
    this.colour = colour;
  }

  public PieceType getType() {
    return type;
  }

  public PlayerColour getColour() {
    return colour;
  }

  public String toString() {
    return colour.toString() + " " + type.toString();
  }

  // already in Piece interface
  //abstract List<Move> getAllowedMoves(Coordinates from, Board board);

}
