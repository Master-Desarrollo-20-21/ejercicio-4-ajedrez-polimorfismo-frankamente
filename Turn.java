public class Turn {

    private int who;

    public Turn() {
        who = 0;
    }

    public int actual() {
        return who;
    }

    public void change() {
        who = notActual();
    }

    public int notActual() {
        return (who + 1) % 2;
    }
}
