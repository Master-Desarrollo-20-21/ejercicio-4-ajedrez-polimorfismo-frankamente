import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Board {

    private List<Piece> pieces;

    public Board() {
        this.pieces = new ArrayList<>();
    }

    public void setup() {
        pieces.add(new Pawn(new Square(7, 0), Color.White));
        pieces.add(new Pawn(new Square(7, 7), Color.White));
        pieces.add(new Pawn(new Square(0, 0), Color.Black));
        pieces.add(new Pawn(new Square(0, 7), Color.Black));
    }

    public void show() {
        for (int row = 0; row < Game.BOARD_DIMENSION; row++) {
            for (int column = 0; column < Game.BOARD_DIMENSION; column++) {
                if (row == 0) {
                    System.out.print("    " + column + "  ");
                }
            }
            if (row == 0) {
                System.out.println();
            }
            System.out.println();
            for (int column = 0; column < Game.BOARD_DIMENSION; column++) {
                if (column == 0) {
                    System.out.print(row + " ");
                }
                final Square square = new Square(row, column);
                if (hasPiece(square)) {
                    getPiece(square).show();
                } else {
                    System.out.print("-----");
                }
                System.out.print("  ");
            }
            System.out.println();
            System.out.println();
        }
    }

    public boolean checkmate() {
        return false;
    }

    public boolean canMove(Piece piece, Square newSquare) {
        if (!hasPiece(newSquare)) {
            return true;
        }
        return getPiece(newSquare).color != piece.color;
    }

    public void move(Piece piece, Square newSquare) {
        piece.move(newSquare);
    }

    private boolean hasPiece(Square square) {
        return getPiece(square) != null;
    }

    public boolean hasPiece(Square square, Color color) {
        if (!hasPiece(square)) {
            return false;
        }
        return getPiece(square).color == color;
    }

    public Piece getPiece(Square square) {
        final List<Piece> pieces = this.pieces.stream().filter(piece -> piece.square.equals(square)).collect(Collectors.toList());
        return pieces.isEmpty() ? null : pieces.get(0);
    }
}
