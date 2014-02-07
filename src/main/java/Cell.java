package main.java;

import main.java.piece.Piece;

/**
 * Represents a cell of a chess board. Each cell consists of a {@link Piece}
 * User: pratyush
 * Date: 4/21/13
 * Time: 7:31 PM
 */
class Cell {

    private Piece piece;

    public Cell(Piece piece) {
        setPiece(piece);
    }

    public Piece getPiece() {
        return piece;
    }

    void setPiece(Piece piece) {
        this.piece = piece;
    }


}
