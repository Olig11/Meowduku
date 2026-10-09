/*
 * Ogod926
 * MeowDoku Game
 * Contains the MeowdokuGame class used by the Meowdoku game 
 */
class MeowdokuGame {
    private int numberOfCats;
    private GameBoard board;
    private Player player;
    public MeowdokuGame(Player player, int size) {
        this.player = player;
        this.board = new GameBoard(size);
        this.numberOfCats = size;
    }
    public void play() {
        while(!player.allCatsFound(numberOfCats)) {
            System.out.println(board);

            Position position = player.makeGuess();
            GuessResult result = board.checkGuess(position);

            player.recordGuess(result);

            System.out.println(result.getMessage());
            System.out.println("Score: "+player.getScore());
        }

        System.out.println("Congratulations!");
        player.printStatistics();
    }
}