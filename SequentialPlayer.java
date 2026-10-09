/*
 * Ogod926
 * Sequential Player
 * Contains the  SequentialPlayer class used by the Meowdoku game 
 */
class SequentialPlayer extends Player {
    private int nextPosition = 0;
    public SequentialPlayer(String name, int size) {
        super(name, size);
    }
    @Override
    public Position makeGuess() {
        int row = nextPosition / size;
        int column = nextPosition % size;
        nextPosition = (nextPosition + 1) % (size * size);
        return new Position(row, column);
    }
}