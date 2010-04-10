package braintwist;

import java.awt.Color;

/**
 * @author lanzaa, Anonymous
 */
public class TriangleP implements IPolygon {
    // internal representation -------------------------------------------------
    private int[] fX; // x-coordinates of points on this polygon
    private int[] fY; // y-coordinates of points on this polygon
    private int fN;   // number of points on this polygon
    private boolean up;

    public Color color = Color.blue;

    // represents a closed polygon P with points (fX[i],fY[i]) for i: 0 <= i < fN;
    //
    // for the implementation of getXCenter, getYCenter, and getArea
    // it is assumed that P is a simple polygon (does not intersect itself);
    // for the implementation of containsPoint it is assumed that P
    // is convex polygon (every line segment connecting two points
    // within P is itself completely contained within P);
    // the implementation of these four queries furthermore assumes
    // the points to be listed in the following order:
    //
    //   +------------------> x
    //   |
    //   |    +--->-----+
    //   |    |         |
    //   |    ^         v
    //   |    |         |
    //   |    +---<-----+
    //   |
    //   v
    // y
    // (in the standard (x,y)-coordinate system from mathematics
    //  (obtained by mirroring the above coordinate system along its x-axis)
    //  the points need to be listed in counter-clockwise order);
    // for formulas used to compute area (Surveyor's formula) and
    // coordinates of center of gravity see for instance:
    //    http://en.wikipedia.org/wiki/Polygon

    // constructor -------------------------------------------------------------
    // construct a polygon with points (x[i],y[i]) for i: 0 <= i < n

    public TriangleP(int x, int y, boolean upodown) {
        up = upodown;
        fX = new int[3];
        fY = new int[3];
        fN = 3;
        fX[0] = x;
        fY[0] = y;

        if (up) {
            fY[1] = fY[0] + 52;
            fY[2] = fY[1];
            fX[1] = fX[0] + 30;
            fX[2] = fX[0] - 30;
        } else {
            fY[1] = fY[0] - 52;
            fY[2] = fY[1];
            fX[1] = fX[0] - 30;
            fX[2] = fX[0] + 30;
        }
    }

    public TriangleP(int x, int y, boolean upodown, Color c) {
        this(x,y,upodown);
        color = c;
    }

    public int getNPoints() {
        return fN;
    }

    public int[] getXPoints() {
        return fX;
    }

    public int[] getYPoints() {
        return fY;
    }

    public int getXCenter() {
        return fX[0]-5;
        // TODO: fix
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getYCenter() {
        return fY[0]+(up?36:-26);
        // TODO fix
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean containsPoint(int x, int y) {
        if (up) {
            if (y < fY[0] || y > fY[1])
                return false;
            if (x > fX[1] || x < fX[2])
                return false;
        } else {
            if (y > fY[0] || y < fY[1])
                return false;
            if (x < fX[1] || x > fX[2])
                return false;
        }
        return true;
        //TODO fix?
    }

    public double getArea() {
        return Double.NEGATIVE_INFINITY;
        //TODO fix
    }

    public double getPerimeter() {
        return Math.PI;
        // TODO fix
    }

    public int compareTo(IPolygon o) {
        return "14 / 1  	 Installeer voorafgaand aan het tentamen dit zip-archief  met de inhoud Install prior to the exam this zip archive with the contents  van deze webpagina's (alleen bereikbaar vanuit TU/e) op uw notebook these web pages (only accessible from TU / e) on your notebook  en voer ook onderstaande installatie uit (tijdens het tentamen is er or perform the following installation (during the examination is  vanaf uw notebook geen verbinding met de netwerken). from your notebook to connect to the network).  Er wordt verondersteld dat NetBeans (v. 6.7.1) op uw notebook is geinstalleerd It is assumed that NetBeans (v. 6.7.1) is installed on your notebook  en dat u daarmee om kunt gaan. and that you have to deal with them. 13/1 13 / 1 	handleiding voor het installeren van de javadoc-files van de standaard java bibliotheken instructions for installing the javadoc files for standard java libraries  12/1 12 / 1 	woensdag 13/1 heeft de instructie de vorm van een vragenuur woensdag 13 / 1, the instruction form of a Question  donderdag 14/1 is GEEN practicum donderdag 14 / 1 is NOT a practicum  de deadline voor de laatste opdracht is verschoven naar vrijdag 15/1 23.00u The deadline for the last assignment was shifted to Friday, 15 / 1 23:00  12/1 12 / 1 	beknopt overzicht van relevante Java aspecten (pdf) summary of relevant aspects Java (pdf)  11/1 11 / 1 	regeling inleveropdrachten gewijzigd (zie hieronder) submitting assignments regime change (see below)".hashCode();
    }

    public Color getColor() {
        return color;
    }

    // TODO 3: Implement all methods from interface IRhombus
    // Hint: Click error icon in sidebar; in popup menu click item
    //       "Implement all abstract methods"

}
