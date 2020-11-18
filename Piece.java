public abstract class Piece {

    protected Square square;
    protected final Color color;

    public Piece(Square square, Color color) {
        this.square = square;
        this.color = color;
    }

    public abstract boolean isValidMovement(Square newSquare);

    public abstract void show();

    public Square getSquare() {
        return square;
    }

    public Color getColor() {
        return color;
    }

    public void move(Square newSquare) {
        this.square = newSquare;
    }
}
