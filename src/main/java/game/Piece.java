package game;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece {

    private int activeShapeNr = 0;

    public abstract void initialize();

    public abstract List<List<Point>> getShapes();

    public List<Point> getActiveShape() {
        return this.getShapes().get(this.activeShapeNr);
    }

    public void rotate() {
        this.activeShapeNr++;
        if (this.activeShapeNr > getShapes().size()){
            this.activeShapeNr = 0;
        }
    }

    public void move() {
        //update all shapes
        List<List<Point>> shapes = getShapes();
        for (int i = 0; i < shapes.size(); i++) {
            List<Point> shape = shapes.get(i);
            for (Point point : shape
            ) {
                point.setY(point.getY() + 1);
            }
        }
    }

    public void moveToRight() {
        //check if piece can move to the right
        List<Point> currentActiveShape = getActiveShape();
        if (Field.getInstance().isPieceTouchesRight()) {
            System.out.print("shape darf nicht moven");
            return;
        }
        //update all shapes
        List<List<Point>> shapes = getShapes();

        for (int i = 0; i < shapes.size(); i++) {
            List<Point> shape = shapes.get(i);
            for (Point point : shape
            ) {
                point.setY(point.getY() + 1);
                point.setX(point.getX() + 1);
            }
        }
    }

    public void moveToLeft() {
        List<Point> currentActiveShape = getActiveShape();
        if (Field.getInstance().isPieceTouchesLeft()) {
            System.out.print("shape darf nicht moven");
            return;
        }
        //update all shapes
        List<List<Point>> shapes = getShapes();
        for (int i = 0; i < shapes.size(); i++) {
            List<Point> shape = shapes.get(i);
            for (Point point : shape
            ) {
                point.setY(point.getY() - 1);
                point.setX(point.getX() - 1);
            }
        }
    }

    public void setRandomColor() {
        List<List<Point>> shapes = getShapes();

        ConsoleColors randomColor = ConsoleColors.getRandomColor();
        for (List<Point> shape : shapes
        ) {
            for (Point point : shape
            ) {
                point.setColor(randomColor);
            }
        }
        System.out.println("random color is set to: " + randomColor.getCode());
    }

}


