package io.riddles.tron;

import java.util.List;
import java.util.Optional;

import io.riddles.boardgame.model.Board;
import io.riddles.boardgame.model.Coordinate;
import io.riddles.boardgame.model.Move;
import io.riddles.boardgame.model.Piece;
import io.riddles.tron.TronPiece.PieceColor;
import io.riddles.boardgame.model.Field;
import io.riddles.boardgame.model.Direction;

public final class TronLogic {

	public static Move DirectionToMoveTransformer(TronState state, Direction direction) {
		/* TODO: implement this */
		PieceColor c = state.getActivePieceColor();
		
		Coordinate coord1 = getLightcycleCoordinate(state, c);
		Coordinate coord2 = coord1;
		
		switch (direction) {
			case UP:
				coord2 = new Coordinate(coord1.getX(), coord1.getY()-1);
				break;
			case RIGHT:
				coord2 = new Coordinate(coord1.getX()+1, coord1.getY());
				break;
			case DOWN:
				coord2 = new Coordinate(coord1.getX(), coord1.getY()+1);
				break;
			case LEFT:
				coord2 = new Coordinate(coord1.getX()-1, coord1.getY());
				break;
			default:
				coord2 = coord1;
				break;
		}
		return new Move(coord1, coord2);
	}
	
	/**
	 * Get Coordinate of Lightcycle piece with PieceColor
	 * @param args : Tronstate, PieceColor
	 * @return : Coordinate or null;
	 */
	
	public static Coordinate getLightcycleCoordinate(TronState state, PieceColor c) {
		Board b = state.getBoard();
		int size = b.size();
		
		List<Field> fields = b.getFields();
    	for (int i = 0; i < fields.size(); i++) {
    		Field f = fields.get(i);
    		if (f.getPiece().isPresent()) {
    			if (f.getPiece().get().getColor() == c) {
    				return new Coordinate(i%size, i/size);
    			}
    		}
    	}
		return null;
	}
	
	public static Coordinate transformCoordinate(Coordinate c, Direction d) {
		return new Coordinate(1, 1);
	}
	
}