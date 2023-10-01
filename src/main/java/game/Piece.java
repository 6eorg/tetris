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

    public void rotate(){
        int shapeNr = getActiveShapeNr();
        shapeNr++;
        if (shapeNr > getShapes().size()-1){
            shapeNr = 0;
        }
        setActiveShapeNr(shapeNr);
    }

    public List<List<Point>> getShapes(){
        return null;
    }


    public void move() {
        //update all shapes
        List<List<Point>> shapes = getShapes();
        for(int i = 0; i<shapes.size();i++) {
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

    public void setRandomColor(){
        List<List<Point>> shapes = getShapes();

        ConsoleColors randomColor = ConsoleColors.getRandomColor();
        for (List<Point> shape: shapes
             ) {
            for (Point point: shape
                 ) {
                point.setColor(randomColor);
            }

        }
        System.out.println("random color is set to: " + randomColor.getCode() );

    }

    public int getActiveShapeNr(){
        return 0;
    }

    public void setActiveShapeNr(int activeShapeNr) {

    }



}


