package main.java;

import main.java.piece.*;

import java.util.List;

/**
 * ChessBoard which consists of and array of {@link Cell}
 * User: pratyush
 * Date: 4/21/13
 * Time: 7:12 PM
 */
public class ChessBoard {

    private Cell[][] cells = new Cell[8][8];
    private int legalWihteMoves;
    private int legalblackMoves;
    StringBuilder allBlackMoves = new StringBuilder();
    StringBuilder allWhiteMoves = new StringBuilder();

    public ChessBoard(List<Piece> pieces) {
        for (Piece piece : pieces) {
            cells[piece.getLocation().getRow()][piece.getLocation().getColumn()] = new Cell(piece);
        }
    }

    public Piece getPiece(Location location) {
        if (cells[location.getRow()][location.getColumn()] != null) {
        return cells[location.getRow()][location.getColumn()].getPiece();
        } else return null;
    }

    public void printAllValidMoves() {
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (cells[i][j] != null) {

                    printValidMoves(cells[i][j].getPiece().validMoves(this), cells[i][j].getPiece());
                }
            }
        }

        if (allWhiteMoves.length() != 0) {
            System.out.println("There are " + legalWihteMoves + " legal move(s) for the WHITE. They are:");
            System.out.println(allWhiteMoves);

        }

        if (allBlackMoves.length() != 0) {
            System.out.println("There are " + legalblackMoves + " legal move(s) for the BLACK. They are:");
            System.out.println(allBlackMoves);

        }

    }

    private void printValidMoves(List<Location> validMoves, Piece piece) {
        StringBuilder validMovesString = new StringBuilder();

        validMovesString.append(piece.getColor().toString())
                .append(" ")
                .append(piece.getName().toString())
                .append(" starting on ")
                .append(piece.getLocation().getColumnAsChar())
                .append(piece.getLocation().getRow() + 1)
                .append(" can move to:\n");
        for (Location location : validMoves) {
            validMovesString.append(location.getColumnAsChar())
                    .append(location.getRow() + 1);
            if (getPiece(location) != null && getPiece(location).getColor() != piece.getColor()) {
                validMovesString.append(" (capturing ")
                        .append(getPiece(location).getColor().toString())
                        .append(" ")
                        .append(getPiece(location).getName().toString())
                        .append(").");
            }
            validMovesString.append("\n");
        }

        if(piece.getColor() == Color.WHITE) {
            legalWihteMoves += validMoves.size();
            allWhiteMoves.append(validMovesString);
        } else {
            legalblackMoves += validMoves.size();
            allBlackMoves.append(validMovesString);
        }
    }
}
