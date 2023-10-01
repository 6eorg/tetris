package game.pieces;

import game.Piece;
import game.Point;

import java.util.ArrayList;
import java.util.List;

public class Line extends Piece {

    private List<List<Point>> shapes = new ArrayList<>();

    private int activeShapeNr = 0;

    public Line() {
    }

    @Override
    public void initialize() {
        shapes = new ArrayList<>();
        ArrayList<Point> shape1 = new ArrayList();
        shape1.add(new Point(4, 0));
        shape1.add(new Point(4, 1));
        shape1.add( new Point(4, 2));
        shape1.add( new Point(4, 3));
        shapes.add(shape1);

        ArrayList<Point> shape2 = new ArrayList();
        shape2.add(new Point(2, 2));
        shape2.add(new Point(3, 2));
        shape2.add( new Point(4, 2));
        shape2.add( new Point(5, 2));
        shapes.add(shape2);

        setRandomColor();

    }



    @Override
    public List<Point> getActiveShape(){
        return shapes.get(activeShapeNr);
    }

    @Override
    public List<List<Point>> getShapes() {
        return shapes;
    }

    public void setShapes(List<List<Point>> shapes) {
        this.shapes = shapes;
    }

    @Override
    public int getActiveShapeNr() {
        return activeShapeNr;
    }

    @Override
    public void setActiveShapeNr(int activeShapeNr) {
        this.activeShapeNr = activeShapeNr;
    }
}
