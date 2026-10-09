/*
 * Ogod926
 * GameBoard
 * Contains the GameBoard class used by the Meowdoku game 
 */
class GameBoard {
    private int size;
    private Cell[][] board;
    private int[] solution;
    private Colour[] colours;
    public GameBoard(int size) {
        this.size = size;
        this.board = new Cell[size][size];
        this.solution = new int[] {2, 0, 3, 1};
        this.colours = new Colour[] {Colour.BLUE, Colour.RED, Colour.GREEN, Colour.YELLOW};
        initialiseBoard();
        
    }
    private void initialiseBoard() {
        placeInitialColours();
        for(int row = 0; row < size; row++) { 
            expandRegion(row, solution[row], colours[row]); 
        }
    }
    private void placeInitialColours() {
        for(int row = 0; row < size; row++) {
            board[row][solution[row]] = new Cell(colours[row]); 
        }
    }
    private void expandRegion(int row, int column, Colour colour) { 
        for(int r = row - 1; r <= row + 1; r++) { 
            for(int c = column - 1; c <= column + 1; c++)  {
                if(r >= 0 && r < size && c >= 0 && c < size && board[r][c] == null) { 
                    board[r][c] = new Cell(colour); 
                } 
            } 
        } 
    }
    public GuessResult checkGuess(Position position) {
        int row = position.getRow();
        int column = position.getColumn();
    
        Cell cell = board[row][column];
    
        if(cell.getState() != CellState.HIDDEN) {
            return GuessResult.ALREADY_GUESSED;
        }
    
        if(column == solution[row]) {
            cell.setState(CellState.FOUND_CAT);
            return GuessResult.CORRECT;
}

    cell.setState(CellState.WRONG_GUESS);
    return GuessResult.WRONG;
}

    @Override 
    public String toString() { 
        String result = ""; 
        for (int row = 0; row < size; row++) { 
            for (int column = 0; column < size; column++) { 
                result += board[row][column];
            } 
            if (row < size - 1) {
                result += "\n"; 
            } 
        } 
        return result; }
}