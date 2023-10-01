package game.pieces;

import game.Piece;
import game.Point;

import java.util.ArrayList;
import java.util.List;

public class Trapez extends Piece {

    private List<List<Point>> shapes = new ArrayList<>();

    private int activeShape = 0;


    public Trapez() {
    }

    public void initialize() {
        shapes = new ArrayList<>();
        ArrayList<Point> shape1 = new ArrayList();
        shape1.add(new Point(4, 0));
        shape1.add(new Point(3, 1));
        shape1.add( new Point(4, 1));
        shape1.add( new Point(5, 1));
        shapes.add(shape1);

        ArrayList<Point> shape2 = new ArrayList();
        shape2.add(new Point(4, 0));
        shape2.add(new Point(4, 1));
        shape2.add( new Point(5, 1));
        shape2.add( new Point(4, 2));
        shapes.add(shape2);

        ArrayList<Point> shape3 = new ArrayList();
        shape3.add(new Point(4, 0));
        shape3.add(new Point(5, 0));
        shape3.add( new Point(5, 1));
        shape3.add( new Point(6, 0));
        shapes.add(shape3);


        ArrayList<Point> shape4 = new ArrayList();
        shape4.add(new Point(4, 0));
        shape4.add(new Point(4, 1));
        shape4.add( new Point(3, 1));
        shape4.add( new Point(4, 2));
        shapes.add(shape4);

    }

    public void rotate(){
        this.activeShape++;
        //todo change to 4
        if (this.activeShape > 3){
            this.activeShape = 0;
        }

    }



    public List<Point> getActiveShape(){
        return shapes.get(activeShape);
    }


    public List<List<Point>> getShapes() {
        return shapes;
    }

}
