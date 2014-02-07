package main.java.piece;

/**
 * User: pratyush
 * Date: 4/21/13
 * Time: 6:09 PM
 */
public class Location {

    private int column;
    private int row;

    public Location(int row, int column) {
        this.column = column;
        this.row = row;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public String getColumnAsChar() {
        return Character.toString((char) (column + 97));
    }

    void rowUp() throws Exception {
        --row;
        if (row < 0) {
            throw new Exception("Reached boundary of the chess.");
        }
    }

    void rowDown() throws Exception {
        ++row;
        if (row > 7) {
            throw new Exception("Reached boundary of the chess.");
        }
    }

    void columnUp() throws Exception {
        --column;
        if (column < 0) {
            throw new Exception("Reached boundary of the chess.");
        }
    }

    void columnDown() throws Exception {
        ++column;
        if (column > 7) {
         throw new Exception("Reached boundary of the chess.");
        }
    }

}
