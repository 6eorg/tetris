package game;

import game.pieces.Line;
import game.pieces.Trapez;

import java.util.List;
import java.util.Random;

public class Field {
    private static Field INSTANCE;

    final int FIELD_WIDTH = 20;
    final int FIELD_HEIGHT = 15;

    private Point[][] field;

    private Piece[] pieces = {new Trapez(), new Line()};

    private Piece activePiece;

    private boolean isChecking = false;



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
        //select random piece
        Random rnd = new Random();
        int randInt = rnd.nextInt(pieces.length);
        activePiece = pieces[randInt];

        activePiece.initialize();


    }


    public void addPieceToField(){
        isChecking = true;
        for (Point point: activePiece.getActiveShape()
             ) {
            field[point.getY()][point.getX()].setEmpty(false);
            //set color
            field[point.getY()][point.getX()].setColor(point.getColor());

        }
        isChecking = false;
    }

    public void removePieceFromField(){
        isChecking = true;
        for (Point point: activePiece.getActiveShape()
        ) {
            field[point.getY()][point.getX()].setEmpty(true);
            //remove color
            field[point.getY()][point.getX()].setColor(ConsoleColors.RESET);

        }
        isChecking = false;
    }


    public void fallDown(){
        this.activePiece.move();
    }

    public boolean isPieceTouchesGround(){
        isChecking = true;
        //check if piece can fall further
        List<Point> activeShape = activePiece.getActiveShape();
        boolean isTouching = false;
        for (Point point: activeShape
             ) {
            //point to check
            int y = point.getY() + 1;
            int x = point.getX(); //x stays the same, important is the point below
            System.out.println("x: " + x + " y: " + y);

            if (y < FIELD_HEIGHT && !field[y][x].isEmpty() && !isCoordinatePartOfThePiece(x,y) ){
                System.out.println("Piece does not touch the ground");
                isTouching = true;
                break;
            }

            if (FIELD_HEIGHT  <= y){
                System.out.println("ground reached");
                isTouching = true;
                break;
            }

        }
        isChecking = false;
        return isTouching;

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
                    System.out.printf(point.getColor().getCode() + "#" + ConsoleColors.RESET.getCode());
                }
            }
            //left border
            System.out.print("#");

            //print points
            if (i == FIELD_HEIGHT/2){
                System.out.printf("    POINTS: 0" );
            }
            System.out.print("\n");
        }

    }

    public Piece getActivePiece() {
        return activePiece;
    }

    public void setActivePiece(Piece activePiece) {
        this.activePiece = activePiece;
    }

    public boolean isChecking() {
        return isChecking;
    }

    public void setChecking(boolean checking) {
        isChecking = checking;
    }
}