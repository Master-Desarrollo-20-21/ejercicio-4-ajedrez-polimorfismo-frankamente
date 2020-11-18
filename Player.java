public class Player {

    private final Board board;
    private final Color color;

    public Player(Board board, Color color) {
        this.board = board;

        this.color = color;
    }

    public void move() {
        System.out.println("Mueven las " + this.color.toString());
        Piece piece = choosePieceToMove();
        Square newSquare;
        do {
            newSquare = chooseSquareToMove();
        } while (!piece.isValidMovement(newSquare) || !board.canMove(piece, newSquare));
        board.move(piece, newSquare);
    }

    private Piece choosePieceToMove() {
        Square square;
        do {
            System.out.println("Elige las coordenadas de la pieza que desea mover: ");
            square = new Square();
        } while (!board.hasPiece(square, this.color));
        return board.getPiece(square);
    }

    private Square chooseSquareToMove() {
        System.out.println("Elige las coordenadas hacia la que mover: ");
        return new Square();
    }

    public void announceWin() {
        System.out.println(color.toString() + " win!");
    }
}
