package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class QueenTest_copy {

  private Board board;
  private Queen queen = new Queen(PlayerColour.WHITE);

  @BeforeEach
  public void setup() {
    board = Board.empty();
  }

  //@Disabled
  @Test
  public void queenCanMoveLaterally() {
    // set up board
    Queen queen = new Queen(PlayerColour.WHITE);
    // where to place piece
    Coordinates coords = new Coordinates(3, 3);
    // put the piece there
    board.placePiece(coords, queen);

    // get allowed moves
    List<Move> allowedMoves = queen.getAllowedMoves(coords, board);

    assertThat(allowedMoves).contains(
            new Move(coords, new Coordinates(2,3)),
            new Move(coords, new Coordinates(1,3)),
            new Move(coords, new Coordinates(0,3)),
            new Move(coords, new Coordinates(4,3)),
            new Move(coords, new Coordinates(5,3)),
            new Move(coords, new Coordinates(6,3)),
            new Move(coords, new Coordinates(7,3)),
            new Move(coords, new Coordinates(3,0)),
            new Move(coords, new Coordinates(3,1)),
            new Move(coords, new Coordinates(3,2)),
            new Move(coords, new Coordinates(3,4)),
            new Move(coords, new Coordinates(3,5)),
            new Move(coords, new Coordinates(3,6)),
            new Move(coords, new Coordinates(3,7))
    );
  }

  //@Disabled
  @Test
  public void queenCanMoveDiagonally() {
    // set up board
    Queen queen = new Queen(PlayerColour.WHITE);
    // where to place piece
    Coordinates coords = new Coordinates(3, 3);
    // put the piece there
    board.placePiece(coords, queen);

    // get allowed moves
    List<Move> allowedMoves = queen.getAllowedMoves(coords, board);

    assertThat(allowedMoves).contains(
            new Move(coords, new Coordinates(0,0)),
            new Move(coords, new Coordinates(1,1)),
            new Move(coords, new Coordinates(2,2)),
            new Move(coords, new Coordinates(4,4)),
            new Move(coords, new Coordinates(5,5)),
            new Move(coords, new Coordinates(6,6)),
            new Move(coords, new Coordinates(7,7)),
            new Move(coords, new Coordinates(6,0)),
            new Move(coords, new Coordinates(5,1)),
            new Move(coords, new Coordinates(4,2)),
            new Move(coords, new Coordinates(2,4)),
            new Move(coords, new Coordinates(1,5)),
            new Move(coords, new Coordinates(0,6)),
            new Move(coords, new Coordinates(3,7))
    );

  }

  //@Disabled
  @Test
  public void queenOnlyAllowsDiagonalAndLateralMoves() {
    // set up board
    Queen queen = new Queen(PlayerColour.WHITE);
    // where to place piece
    Coordinates coords = new Coordinates(3, 3);
    // put the piece there
    board.placePiece(coords, queen);

    // get allowed moves
    List<Move> allowedMoves = queen.getAllowedMoves(coords, board);

    assertThat(allowedMoves).containsExactlyInAnyOrder(
            new Move(coords, new Coordinates(2,3)),
            new Move(coords, new Coordinates(1,3)),
            new Move(coords, new Coordinates(0,3)),
            new Move(coords, new Coordinates(4,3)),
            new Move(coords, new Coordinates(5,3)),
            new Move(coords, new Coordinates(6,3)),
            new Move(coords, new Coordinates(7,3)),
            new Move(coords, new Coordinates(3,0)),
            new Move(coords, new Coordinates(3,1)),
            new Move(coords, new Coordinates(3,2)),
            new Move(coords, new Coordinates(3,4)),
            new Move(coords, new Coordinates(3,5)),
            new Move(coords, new Coordinates(3,6)),
            new Move(coords, new Coordinates(3,7)),
            new Move(coords, new Coordinates(0,0)),
            new Move(coords, new Coordinates(1,1)),
            new Move(coords, new Coordinates(2,2)),
            new Move(coords, new Coordinates(4,4)),
            new Move(coords, new Coordinates(5,5)),
            new Move(coords, new Coordinates(6,6)),
            new Move(coords, new Coordinates(7,7)),
            new Move(coords, new Coordinates(6,0)),
            new Move(coords, new Coordinates(5,1)),
            new Move(coords, new Coordinates(4,2)),
            new Move(coords, new Coordinates(2,4)),
            new Move(coords, new Coordinates(1,5)),
            new Move(coords, new Coordinates(0,6))
    );
  }

  //@Disabled
  @Test
  public void queenCanCaptureOpposingPieces() {
    // make pieces
    Queen queen = new Queen(PlayerColour.WHITE);
    Pawn enemyPawn = new Pawn(PlayerColour.BLACK);

    // where to place piece
    Coordinates coords = new Coordinates(3, 3);
    Coordinates pawn_coords = new Coordinates(2,2);
    // put the piece there
    board.placePiece(coords, queen);
    // place enemy piece
    board.placePiece(pawn_coords, enemyPawn);

    // check if allowed moves includes the square with the enemy piece
    // get allowed moves
    List<Move> allowedMoves = queen.getAllowedMoves(coords, board);

    assertThat(allowedMoves).contains(
            new Move(coords, pawn_coords));
    };

  //@Disabled
  @Test
  public void queenCannotPassThroughOpposingPieces() {
    // make pieces
    Queen queen = new Queen(PlayerColour.WHITE);
    Pawn enemyPawn = new Pawn(PlayerColour.BLACK);

    // where to place piece
    Coordinates coords = new Coordinates(3, 3);
    Coordinates pawn_coords = new Coordinates(2,2);
    // put the piece there
    board.placePiece(coords, queen);
    // place enemy piece
    board.placePiece(pawn_coords, enemyPawn);

    // check if allowed moves includes the square with the enemy piece
    // get allowed moves
    List<Move> allowedMoves = queen.getAllowedMoves(coords, board);

    assertThat(allowedMoves).doesNotContain(
            new Move(coords, new Coordinates(0,0)),
            new Move(coords, new Coordinates(1,1))
    );
  }

  //@Disabled
  @Test
  public void queenIsBlockedByFriendlyPieces() {
    // make pieces
    Queen queen = new Queen(PlayerColour.WHITE);
    Pawn friendlyPawn = new Pawn(PlayerColour.WHITE);

    // where to place piece
    Coordinates coords = new Coordinates(3, 3);
    Coordinates pawn_coords = new Coordinates(2,2);
    // put the piece there
    board.placePiece(coords, queen);
    // place enemy piece
    board.placePiece(pawn_coords, friendlyPawn);

    // check if allowed moves includes the square with the enemy piece
    // get allowed moves
    List<Move> allowedMoves = queen.getAllowedMoves(coords, board);

    assertThat(allowedMoves).doesNotContain(
            new Move(coords, new Coordinates(0,0)),
            new Move(coords, new Coordinates(1,1)),
            new Move(coords, new Coordinates(2,2))
    );
 }
}
