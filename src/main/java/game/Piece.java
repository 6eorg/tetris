package game;

import java.util.ArrayList;
import java.util.List;

public class Piece {

    List<Point> shapes = new ArrayList<>();


    public void move(List<Point> shape) {

        //todo implement general method for all pieves
        for (Point point: shape
        ) {
            point.setY(point.getY()+1);
        }
    }


}
