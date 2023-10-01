package game;

public class Game {

    public Game() throws InterruptedException {
        start();
    }

    public void start() throws InterruptedException {
        Field field = new Field();
        field.initialize();
        field.addPiece();
        do {

            clearConsole();
            field.addPieceToField();
            field.print();
            field.removePieceFromField();
            field.moveField();
            Thread.sleep(1000);


        }while (true);
    }

    public static void clearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}