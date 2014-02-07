package main.java.piece;

import main.java.ChessBoard;

import java.util.ArrayList;
import java.util.List;

/**
 * User: pratyush
 * Date: 4/21/13
 * Time: 6:07 PM
 */
public class Queen extends Piece {

    public Queen(Location location, Color color) {
        this.location = location;
        this.color = color;
        this.name = PieceName.QUEEN;
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

        //Check UP
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

        //Check DOWN
        reset(newLocation);
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

        //Check RIGHT
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
