public class King extends Piece {
    public King(Square square, Color color) {
        super(square, color);
    }

    @Override
    public boolean isValidMovement(Square newSquare) {
        return columnMoved1(newSquare) && rowMoved1(newSquare) ||
                columnMoved1(newSquare) && rowNotMoved(newSquare) ||
                columnNotMoved(newSquare) && rowMoved1(newSquare);
    }

    @Override
    public void show() {
        System.out.print("KING"+color.toString().charAt(0));
    }

    private boolean columnMoved1(Square newSquare) {
        return square.getColumn() - 1 == newSquare.getColumn() ||
                square.getColumn() + 1 == newSquare.getColumn();
    }

    private boolean columnNotMoved(Square newSquare) {
        return square.getColumn() == newSquare.getColumn();
    }

    private boolean rowMoved1(Square newSquare) {
        return square.getRow() - 1 == newSquare.getRow() ||
                square.getRow() + 1 == newSquare.getRow();
    }

    private boolean rowNotMoved(Square newSquare) {
        return square.getRow() == newSquare.getRow();
    }
}
