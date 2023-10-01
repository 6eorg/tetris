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
        ArrayList<Point> form1 = new ArrayList();
        form1.add(new Point(4, 0));
        form1.add(new Point(3, 1));
        form1.add( new Point(4, 1));
        form1.add( new Point(5, 1));
        shapes.add(form1);
    }

    public void move(){
        super.move(shapes.get(activeShape));
    }

    public List<Point> getActiveShape(){
        return shapes.get(activeShape);
    }

}
