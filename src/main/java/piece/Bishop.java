package main.java.piece;

import main.java.ChessBoard;

import java.util.ArrayList;
import java.util.List;

/**
 * User: pratyush
 * Date: 4/21/13
 * Time: 6:07 PM
 */
public class Bishop extends Piece {

    public Bishop(Location location, Color color) {
        this.location = location;
        this.color = color;
        this.name = PieceName.BISHOP;
    }

    @Override
    public List<Location> validMoves(ChessBoard board) {
        List<Location> validMoves = new ArrayList<Location>();

        Location newLocation = new Location(location.getRow(), location.getColumn());

        //check diagonal UP RIGHT
        while (true) {
            try {
                newLocation.rowDown();
                newLocation.columnUp();
                if (validateMove(board, newLocation)) {
                    validMoves.add(new Location(newLocation.getRow(), newLocation.getColumn()));
                }

            } catch (Exception e) {
                break;
            }

        }



        //check diagonal UP LEFT
        reset(newLocation);
        while (true) {
            try {
                newLocation.rowDown();
                newLocation.columnDown();
                if (validateMove(board, newLocation)) {
                    validMoves.add(new Location(newLocation.getRow(), newLocation.getColumn()));
                }

            } catch (Exception e) {
                break;
            }

        }

        //check diagonal DOWN RIGHT
        reset(newLocation);
        while (true) {
            try {
                newLocation.rowUp();
                newLocation.columnUp();
                if (validateMove(board, newLocation)) {
                    validMoves.add(new Location(newLocation.getRow(), newLocation.getColumn()));
                }

            } catch (Exception e) {
                break;
            }

        }

        //check diagonal DOWN LEFT
        reset(newLocation);
        while (true) {
            try {
                newLocation.rowUp();
                newLocation.columnDown();
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

    /*

    public void moveDiagonalUpLeft() throws Exception {
        this.location.columnDown();
        this.location.rowUp();
    }

    public void moveDiagonalUpRight() throws Exception {
        this.location.columnUp();
        this.location.rowUp();
    }

    public void moveDiagonalDownLeft() throws Exception {
        this.location.columnDown();
        this.location.rowDown();
    }

    public void moveDiagonalDownRight() throws Exception {
        this.location.columnUp();
        this.location.rowDown();
    }*/


}
