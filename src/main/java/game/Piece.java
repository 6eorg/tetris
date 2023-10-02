package game;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece {

    //this classes will get overriden from child classes
    public abstract void initialize();

    public abstract List<List<Point>> getShapes();


    public List<Point> getActiveShape() {
        return this.getShapes().get(this.getActiveShapeNr());
    }


    public void rotate() {
        int shapeNr = getActiveShapeNr();
        shapeNr++;
        if (shapeNr > getShapes().size() - 1) {
            shapeNr = 0;
        }
        setActiveShapeNr(shapeNr);
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
        if (!isCanShapeMoveToTheDirection(findRighestOrLeftestPointsOfPiece(currentActiveShape, "r"), "r")) {
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
        if (!isCanShapeMoveToTheDirection(findRighestOrLeftestPointsOfPiece(currentActiveShape, "l"), "l")) {
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

    public int getActiveShapeNr() {
        return 0;
    }

    public void setActiveShapeNr(int activeShapeNr) {

    }

    private List<Point> findRighestOrLeftestPointsOfPiece(List<Point> shape, String side) {
        int rightestX = 0;
        int leftestX = Field.getInstance().FIELD_WIDTH;
        for (Point point : shape
        ) {
            if (side.equals("r") && point.getX() >= rightestX) {
                rightestX = point.getX();
            }
            else if (side.equals("l") && point.getX() < leftestX) {
                leftestX = point.getX();
            }
        }
        List<Point> rightestPoints = new ArrayList<>();
        List<Point> leftestPoints = new ArrayList<>();
        for (Point point : shape
        ) {
            if (side.equals("r") && point.getX() == rightestX){
                rightestPoints.add(point);
            }else if (side.equals("l") && point.getX() == leftestX) {
                leftestPoints.add(point);
            }

        }

        return side.equals("r") ? rightestPoints : leftestPoints;
    }

    private boolean isCanShapeMoveToTheDirection(List<Point> pointsToCheck, String direction) {
        //1. step: check borders. if touches border no other checks are needed
        boolean isBorderContactFound = false;
        for (Point point: pointsToCheck
             ) {
            if (direction.equals("r") && point.getX() == Field.getInstance().FIELD_WIDTH){
                isBorderContactFound = true;
                break;
            }
            else if (direction.equals("l") && point.getX() == 0){
                isBorderContactFound = true;
                break;
            }
        }
        if (isBorderContactFound){
            return false;
        }

        //2. check field
        boolean isCanMoveToTheRight = true;
        boolean isCanMoveToTheLeft = true;
        Point[][] fieldPoints = Field.getInstance().getField();
        for (Point point: pointsToCheck
             ) {
            //check if the field on the left/right of the exposed points is free
            if (direction.equals("r") && !(fieldPoints[point.getY()][point.getX() + 1].isEmpty())){
                isCanMoveToTheRight = false;
                break;
            }
            else if (direction.equals("l") && !(fieldPoints[point.getY()][point.getX()-1].isEmpty())){
                isCanMoveToTheLeft = false;
                break;
            }

        }
        return direction.equals("r") ? isCanMoveToTheRight : isCanMoveToTheLeft;

    }



}


