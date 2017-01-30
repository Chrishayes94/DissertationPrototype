package com.prototype.pathmyeducation.navigation;

/**
 * Created by Chris on 28/01/2017.
 */

public class Map {

    public static PointNode<Point> create() {
        final Point main = new Point();
        final PointNode<Point> base = createBase(main);


        return base;
    }

    private static PointNode<Point> createBase(Point main) {
        final PointNode<Point> base = new PointNode<Point>(main);
        {

        }
        return base;
    }
}
