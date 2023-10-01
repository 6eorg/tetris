package game;

import game.pieces.Trapez;

import java.util.List;

public class Field {

    final int FIELD_WIDTH = 20;
    final int FIELD_HEIGHT = 15;

    private Point[][] field;

    private Piece activePiece;

    public Field() {
        this.field = new Point[FIELD_HEIGHT][FIELD_WIDTH];
    }

    public void initialize(){
        for(int i = 0; i < FIELD_HEIGHT; i++){
            for(int j = 0; j < FIELD_WIDTH; j++){
                Point point = new Point(i, j);
                field[i][j] = point;
            }
        }
        System.out.println("field initialized");

    }

    public void addPiece(){
        //todo random piece

        //todo this is only test
        activePiece = new Trapez();
        activePiece.initialize();


    }

    public void moveField() {
        activePiece.move();
    }

    public void addPieceToField(){
        for (Point point: activePiece.getActiveShape()
             ) {
            field[point.getY()][point.getX()].setEmpty(false);
        }
    }

    public void removePieceFromField(){
        for (Point point: activePiece.getActiveShape()
        ) {
            field[point.getY()][point.getX()].setEmpty(true);
        }
    }

    //todo only test usage. remove
    public void rotatePiece(){
        activePiece.rotate();
    }






    public void print(){
        for(int e = 0; e< 100;e++){
            System.out.println("\n");
        }
        for(int i = 0; i< FIELD_HEIGHT; i++){
            //right border
            System.out.printf("#");
            for(int j = 0; j<FIELD_WIDTH;j++){

                if (field[i][j].isEmpty()){
                    System.out.printf("_");
                }else {
                    System.out.printf("*");
                }
            }
            //left border
            System.out.print("#\n");
        }

    }
}