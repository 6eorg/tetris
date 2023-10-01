package game;

import game.pieces.Trapez;

import java.util.List;

public class Field {

    final int FIELD_WIDTH = 20;
    final int FIELD_HEIGHT = 15;

    private Point[][] field;
    private List<Point> activePiece;

    //todo only test replace with piece
    private Trapez trapez;

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
        trapez = new Trapez();
        trapez.initialize();
        activePiece = trapez.getActiveShape();

    }

    public void moveField() {
        //todo replace with figure/piece
        trapez.move();
    }

    public void addPieceToField(){
        for (Point point: activePiece
             ) {
            field[point.getY()][point.getX()].setEmpty(false);
        }
    }

    public void removePieceFromField(){
        for (Point point: activePiece
        ) {
            field[point.getY()][point.getX()].setEmpty(true);
        }
    }






    public void print(){
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