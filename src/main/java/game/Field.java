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

    public void fallDown() {
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

    public boolean isPieceTouchesGround(){
        //check if piece can fall further
        List<Point> activeShape = activePiece.getActiveShape();
        boolean isTouchung = false;
        for (Point point: activeShape
             ) {
            System.out.println("point gets checked");
            //point to check
            int y = point.getY() + 1;
            int x = point.getX(); //x stays the same, important is the point below
            System.out.println("x: " + x + " y: " + y);

            if (y < FIELD_HEIGHT && !field[y][x].isEmpty() && !isCoordinatePartOfThePiece(x,y) ){
                System.out.println("Piece does not touch the ground");
                isTouchung = true;
                break;
            }

            if (FIELD_HEIGHT  <= y){
                System.out.println("ground reached");
                isTouchung = true;
                break;
            }

        }
        return isTouchung;
    }

    public boolean isCoordinatePartOfThePiece(int x, int y){
        List<Point> activeShape = this.activePiece.getActiveShape();
        for (Point shapePoints: activeShape
             ) {
            if (x == shapePoints.getX() && y == shapePoints.getY()){
                return true;
            }
        }
        return false;

    }






    public void print(){
        for(int e = 0; e< 5;e++){
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