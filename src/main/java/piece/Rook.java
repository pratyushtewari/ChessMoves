package main.java.piece;

import main.java.ChessBoard;

import java.util.ArrayList;
import java.util.List;

/**
 * User: pratyush
 * Date: 4/21/13
 * Time: 6:07 PM
 */
public class Rook extends Piece {

    public Rook(Location location, Color color) {
        this.location = location;
        this.color = color;
        this.name = PieceName.ROOK;
    }


    @Override
    public List<Location> validMoves(ChessBoard board) {
        List<Location> validMoves = new ArrayList<Location>();

        Location newLocation = new Location(location.getRow(), location.getColumn());

        //Check UP
        while (true) {
            try {
                newLocation.rowUp();
                if (validateMove(board, newLocation)) {
                    validMoves.add(new Location(newLocation.getRow(), newLocation.getColumn()));
                }
            } catch (Exception e) {
                break;
            }
        }

        //Check DOWN
        reset(newLocation);
        while (true) {
            try {
                newLocation.rowDown();
                if (validateMove(board, newLocation)) {
                    validMoves.add(new Location(newLocation.getRow(), newLocation.getColumn()));
                }
            } catch (Exception e) {
                break;
            }
        }

        //Check LEFT
        reset(newLocation);
        while (true) {
            try {
                newLocation.columnDown();
                if (validateMove(board, newLocation)) {
                    validMoves.add(new Location(newLocation.getRow(), newLocation.getColumn()));
                }
            } catch (Exception e) {
                break;
            }
        }

        //Check UP
        reset(newLocation);
        while (true) {
            try {
                newLocation.columnUp();
                if (validateMove(board, newLocation)) {
                    validMoves.add(new Location(newLocation.getRow(), newLocation.getColumn()));
                }
            } catch (Exception e) {
                break;
            }
        }

        return validMoves;
    }

    private void reset(Location newLocation) {
        newLocation.setColumn(location.getColumn());
        newLocation.setRow(location.getRow());
    }

}
