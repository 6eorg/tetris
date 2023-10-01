package game;

public class Game {

    public Game() throws InterruptedException {
        start();
    }

    public void start() throws InterruptedException {
        Field field = new Field();
        field.initialize();
        field.addPiece();
        boolean gameOver = false;
        do {
            field.rotatePiece();

            clearConsole();
            field.addPieceToField();
            field.print();

            if (!field.isPieceTouchesGround()){
                field.removePieceFromField();
                field.fallDown();

            }else {
                field.addPiece();
                if (field.isPieceTouchesGround()){
                    gameOver = true;
                    field.addPieceToField();
                    field.print();
                }
            }


            Thread.sleep(500);


        }while (!gameOver);
        System.out.println("GAME OVER");
    }

    public static void clearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}