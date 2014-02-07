package main.java.piece;

import main.java.ChessBoard;

import java.util.List;

/**
 * User: pratyush
 * Date: 4/21/13
 * Time: 6:11 PM
 */
public abstract class Piece {

    Location location;
    Color color;

    public PieceName getName() {
        return name;
    }

    public void setName(PieceName name) {
        this.name = name;
    }

    PieceName name;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Return the valid moves for this board.
     *
     * @param board ChessBoard
     * @return List of Locations where this piece can move
     */
    public abstract List<Location> validMoves(ChessBoard board);


    boolean validateMove(ChessBoard board, Location newLocation) {

        Piece pieceAtNewLocation = board.getPiece(newLocation);

        if (pieceAtNewLocation == null) {
            return true;
        } else if (pieceAtNewLocation.color != this.color) {
            return true;
        }
        // Else
        return false;

    }

}
