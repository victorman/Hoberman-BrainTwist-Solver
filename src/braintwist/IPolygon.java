package braintwist;

import java.awt.Color;

/**
 *
 * @author GZwaan
 */
public interface IPolygon extends Comparable<IPolygon> {
    // queries -----------------------------------------------------------------

    public Color getColor();
    // pre: true
    // ret: number of points on the polygon
    public int getNPoints();

    // pre: getNPoints() == N
    // ret: integer array containing the N x-coordinates of
    //      the points on this polygon
    public int[] getXPoints();

    // pre: getNPoints() == N
    // ret: integer array containing the N y-coordinates of
    //      the points on this polygon
    public int[] getYPoints();

    // pre: true
    // ret: x-coordinate of the centre of gravity (centroid) of this polygon
    public int getXCenter();

    // pre: true
    // ret: y-coordinate of the centre of gravity (centroid) of this polygon
    public int getYCenter();

    // pre: true
    // ret: point (x,y) is within this polygon
    public boolean containsPoint(int x, int y);

    // pre: true
    // ret: area enclosed by this polygon
    public double getArea();

    // pre: true
    // ret: perimeter of this polygon
    public double getPerimeter();
}
