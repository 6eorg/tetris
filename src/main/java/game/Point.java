package game;

public class Point {
    private int x;
    private int y;
    private boolean isEmpty = true;

    private ConsoleColors color;

    private String symbol;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        color = ConsoleColors.RESET;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public ConsoleColors getColor() {
        return color;
    }

    public void setColor(ConsoleColors color) {
        this.color = color;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}