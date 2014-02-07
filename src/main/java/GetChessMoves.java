package main.java;

import main.java.piece.*;
import main.java.util.FileReaderUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * User: pratyush
 * Date: 4/21/13
 * Time: 10:40 PM
 */
public class GetChessMoves {

    public static void main(String[] args) {
        String input [] = null;

        FileReaderUtil fileReaderUtil = new FileReaderUtil();
        try {
            String filename ;
            if (args.length != 0 ) {
                filename = args[0];
            } else {
                System.out.println();
                System.out.println();
                System.out.println("Please Provide the file name in the class argument.");
                System.out.println("Using Default: src/main/resources/sampleInput.txt now.");
                filename = "src/main/resources/sampleInput.txt";
                System.out.println();
                System.out.println();
            }

            input = fileReaderUtil.readLines(filename);
        } catch (IOException e) {
            System.out.println("Could not read the filename: " + args[0] + e.getMessage());
            System.exit(0);
        }

        List<Piece> pieces = new ArrayList<Piece>(input.length);

        for (int i = 0; i < input.length; ++ i) {
            char inputArray[] = input[i].toLowerCase().toCharArray();
            char column = inputArray[0];
            char row = inputArray[1];
            char color = inputArray[2];
            char type = inputArray[3];


            Piece piece = null;
            switch (type) {
                case 'q':
                    piece = new Queen(getLocation(row, column), getColor(color));
                    break;
                case 'b':
                    piece = new Bishop(getLocation(row, column), getColor(color));
                    break;
                case 'r':
                    piece = new Rook(getLocation(row, column), getColor(color));
                    break;
                default:
                    System.out.println("Wrong type of piece entered. Please enter q,w or r only.");
                    System.exit(0);
            }

            pieces.add(piece);

        }

        ChessBoard board = new ChessBoard(pieces);
        board.printAllValidMoves();

    }

    private static Location getLocation(char charRow, char charColumn) {
        int row = Integer.parseInt(String.valueOf(charRow)) - 1;
        int column = (int)(charColumn) - 97;
        if (row > 8 || row < 0 || column > 8 || column < 0) {
            System.out.println("Wrong location Entered.");
            System.exit(0);
        }
        return new Location(row,column);
    }

    private static Color getColor(char charColor) {
        Color color = null;
        if ("b".equals(String.valueOf(charColor))) {
            return Color.BLACK;
        }  else if ("w".equals(String.valueOf(charColor))) {
            return Color.WHITE;
        } else {
            System.out.println("Wrong Color Entered: " + charColor);
            System.exit(0);
        }

        return color;
    }

}
