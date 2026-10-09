/*
 * Ogod926
 * Player
 * Contains the Player class used by the Meowdoku game 
 */
abstract class Player {
    private String name;
    private int guesses;
    private int catsFound;
    private int score;
    protected int size;
    public Player(String name, int size) {
        this.name = name;
        this.size = size;
        this.catsFound = 0;
        this.score = 0;
        this.guesses = 0;
    }
    public int getScore() {
        return score;
    }
    public void recordGuess(GuessResult guess) {
        guesses++;
        score += guess.getScore();
        if(guess == GuessResult.CORRECT) {
            catsFound++;
        }
    }
    public boolean allCatsFound(int numberOfCats) {
        return catsFound == numberOfCats;
    }
    public void printStatistics() {
        System.out.printf("Player: %s\nNumber of guesses: %d\nCats found: %d\nScore: %d\n", name, guesses, catsFound, score);
    }
    public abstract Position makeGuess();
    public String toString() {
        return String.format("%s (Score: %d)", name, score);
    }
}