import java.util.Objects;

public class Square {

    private final int row;
    private final int column;

    public Square() {
        row = getValidCoordinate("Introduzca la fila: ");
        column = getValidCoordinate("Introduzca la columna: ");
    }

    public Square(int row, int column) {
        this.row = row;
        this.column = column;
    }

    private int getValidCoordinate(String message) {
        int coordinate;
        do {
            coordinate = new Console().readInt(message);

        } while (coordinate < 0 || coordinate > Game.BOARD_DIMENSION - 1);
        return coordinate;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return row == square.row &&
                column == square.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
