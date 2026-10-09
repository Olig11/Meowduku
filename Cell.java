/*
 * Ogod926
 * Cell
 * Contains the Cell class used by the Meowdoku game 
 */
class Cell {
    private Colour colour;
    private CellState state;
    public Cell(Colour colour) {
        this.colour = colour;
        this.state = CellState.HIDDEN;
    }
    public CellState getState() {
        return state;
    }
    public void setState(CellState state) {
        this.state = state;
    }
    public String toString() {
        if(state == CellState.HIDDEN)
            return colour.toString().substring(0, 1);
        return String.valueOf(state.getSymbol());
    }
}