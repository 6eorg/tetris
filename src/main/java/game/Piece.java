package game;

import java.util.List;

public class Piece {

    //this class will get overriden from child classes
    public List<Point> getActiveShape(){
        return null;
    }



    //this class will get overriden from child classes
    public void initialize(){
    }

    //this class will get overriden from child classes
    public void rotate(){
    }

    public List<List<Point>> getShapes(){
        return null;
    }


    public void move() {
        //update all shapes
        List<List<Point>> shapes = getShapes();
        for(int i = 0; i<4;i++) {
            List<Point> shape = shapes.get(i);
            for (Point point : shape
            ) {
                point.setY(point.getY() + 1);
            }
        }

    }

    public void moveToRight() {
        //update all shapes
        List<List<Point>> shapes = getShapes();
        for(int i = 0; i<4;i++) {
            List<Point> shape = shapes.get(i);
            for (Point point : shape
            ) {
                point.setY(point.getY() + 1);
                point.setX(point.getX() + 1);
            }
        }
    }

    public void moveToLeft() {
        //update all shapes
        List<List<Point>> shapes = getShapes();
        for(int i = 0; i<4;i++) {
            List<Point> shape = shapes.get(i);
            for (Point point : shape
            ) {
                point.setY(point.getY() - 1);
                point.setX(point.getX() - 1);
            }
        }
    }

}


