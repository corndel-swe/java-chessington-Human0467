package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Knight extends AbstractPiece {

  public Knight(PlayerColour colour) {
    super(PieceType.KNIGHT, colour);
  }

  @Override
  public List<Move> getAllowedMoves(Coordinates from, Board board) {

    var allowedMoves = new ArrayList<Move>();

    int[][] knightMoves = { {-2, 1}, {-2, -1}, {2, 1}, {2, -1},
            {-1, 2}, {-1, -2}, {1, 2}, {1, -2}};

    for(int[] moves : knightMoves){
      Coordinates proposed = from;
      proposed = from.plus(moves[0], moves[1]);
      if(board.isSpaceOnBoard(proposed)){
        if(board.isSpaceEmpty(proposed)){
          allowedMoves.add(new Move(from, proposed));
        }else if(!board.isPieceFriendly(proposed, colour)){
          allowedMoves.add(new Move(from, proposed));
        }
      }
      allowedMoves.add(new Move(from, proposed));
    }

    return allowedMoves;
  }
}
