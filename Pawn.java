public class Pawn extends Piece {

    public Pawn(Square square, Color color) {
        super(square, color);
    }

    @Override
    public boolean isValidMovement(Square newSquare) {
        if (color == Color.White) {
            if (square.getRow() == newSquare.getRow() + 1) {
                return columnMoved1(newSquare) || square.getColumn() == newSquare.getColumn();
            }
            return false;
        }
        if (square.getRow() == newSquare.getRow() - 1) {
            return columnMoved1(newSquare) || square.getColumn() == newSquare.getColumn();
        }
        return false;
    }

    @Override
    public void show() {
        System.out.print("PAWN"+color.toString().charAt(0));
    }

    private boolean columnMoved1(Square newSquare) {
        return square.getColumn() - 1 == newSquare.getColumn() ||
                square.getColumn() + 1 == newSquare.getColumn();
    }
}
