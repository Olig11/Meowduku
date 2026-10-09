/*
 * Ogod926
 * Human Player
 * Contains the HumanPlayer class used by the Meowdoku game 
 */
class HumanPlayer extends Player {
    private Scanner scanner;
    public HumanPlayer(String name, int size) {
        super(name, size);
        scanner = new Scanner(System.in);
    }

    @Override
    public Position makeGuess() {
        int row = getValidPosition("Enter Row: ", size);
        int column = getValidPosition("Enter Column: ", size);

        return new Position(row, column);
    }

    private int getValidPosition(String prompt, int size) {
        System.out.print(prompt);

        while(!scanner.hasNextInt()) {
            scanner.next();
            System.out.print(prompt);
        }

        int position = scanner.nextInt();

        while(position < 0 || position >= size) {
            System.out.print(prompt);
            position = scanner.nextInt();
        }

        return position;
    }
}