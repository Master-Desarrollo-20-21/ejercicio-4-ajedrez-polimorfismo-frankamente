public class Game {

    private final Board board;
    private final Player[] players;
    private final Turn turn;

    public static int BOARD_DIMENSION = 8;
    public static int NUMBER_OF_PLAYER = 2;

    Game() {
        board = new Board();
        players = new Player[NUMBER_OF_PLAYER];
        players[0] = new Player(board, Color.White);
        players[1] = new Player(board, Color.Black);
        turn = new Turn();
    }

    public void play() {
        System.out.println("Empieza el juego");
        System.out.println();
        System.out.println();
        board.setup();
        do {
            board.show();
            players[turn.actual()].move();
            turn.change();
        } while (!board.checkmate());
        players[turn.notActual()].announceWin();
    }
}
