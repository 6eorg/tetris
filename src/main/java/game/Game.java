package game;

import java.io.IOException;

public class Game {

    public Game() throws InterruptedException, IOException {
        start();
    }

    public void start() throws InterruptedException, IOException {
        Field field = Field.getInstance();
        UserInput userInput = new UserInput();
        userInput.startListening();
        field.initialize();
        field.addPiece();
        boolean gameOver = false;
        do {

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