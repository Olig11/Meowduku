/*
 * Ogod926
 * Random Player
 * Contains the RandomPlayer class used by the Meowdoku game 
 */
class RandomPlayer extends Player {
    private Random random;

    public RandomPlayer(String name, int size, long seed) {
        super(name, size);
        random = new Random(seed);
    }

    @Override
    public Position makeGuess() {
        int row = random.nextInt(size);
        int column = random.nextInt(size);

        return new Position(row, column);
    }
}