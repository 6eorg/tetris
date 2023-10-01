package game;

import game.pieces.Trapez;

import java.util.List;

public class Field {
    private static Field INSTANCE;

    final int FIELD_WIDTH = 20;
    final int FIELD_HEIGHT = 15;

    private Point[][] field;


    private Piece activePiece;



    public Field() {
        this.field = new Point[FIELD_HEIGHT][FIELD_WIDTH];

    }

    public static Field getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Field();
        }

        return INSTANCE;
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


    public void addPieceToField(){
        for (Point point: activePiece.getActiveShape()
             ) {

            field[point.getY()][point.getX()].setEmpty(false);
            //set color
            field[point.getY()][point.getX()].setColor(point.getColor());

        }
    }

    public void removePieceFromField(){
        for (Point point: activePiece.getActiveShape()
        ) {
            field[point.getY()][point.getX()].setEmpty(true);
            //remove color
            field[point.getY()][point.getX()].setColor(ConsoleColors.RESET);

        }
    }

    //todo only test usage. remove
    public void rotatePiece(){
        activePiece.rotate();
    }

    public void fallDown(){
        this.activePiece.move();
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
                Point point = field[i][j];


                if (point.isEmpty()){
                    System.out.printf(point.getColor().getCode() + "_" + ConsoleColors.RESET.getCode());
                }else {
                    System.out.printf(point.getColor().getCode() + "*" + ConsoleColors.RESET.getCode());
                }
            }
            //left border
            System.out.print("#\n");
        }

    }

    public Piece getActivePiece() {
        return activePiece;
    }

    public void setActivePiece(Piece activePiece) {
        this.activePiece = activePiece;
    }
}