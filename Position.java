/*
 * Ogod926
 * Position
 * Contains the Position class used by the Meowdoku game 
 */
class Position {
    private int row;
    private int column;
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }
    public int getRow() {
        return row;
    }
    public int getColumn() {
        return column;
    }
    public String toString() {
        return String.format("(%s, %s)", row, column);
    }
}