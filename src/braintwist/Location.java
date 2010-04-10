package braintwist;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lanzaa
 */
public class Location {
    public int x;
    public int y;
    public boolean up;

    public Location(int xp, int yp, boolean upp) {
        x = xp;
        y = yp;
        up = upp;
    }

    public static Location[] locs = {
        new Location(270,248,false), // 0
        new Location(300,196,false), // 1
        new Location(240,196,false), // 2
        new Location(240,196,true), // 3
        new Location(210,144,true), // 4
        new Location(180,196,true), // 5
        new Location(300,196,true), // 6
        new Location(330,144,true), // 7
        new Location(360,196,true), //8
        new Location(240,92,true), // 9
        new Location(270,40,true), // 10
        new Location(300,92,true), // 11

        new Location(270,340,true), // 12
        new Location(360,496,true), // 13
        new Location(180,496,true), // 14
        new Location(240,392,true), // 15
        new Location(210,444,true), // 16
        new Location(240,496,false), // 17
        new Location(300,392,true), // 18
        new Location(330,444,true), // 19
        new Location(300,496,false), // 20
        new Location(240,496,true), // 21
        new Location(270,548,false), // 22
        new Location(300,496,true), // 23
    };
    
    public static Location[] rots = {
        new Location(270,144,false), // 1
        new Location(270,144,true), // 2
        new Location(330,248,false), // 3
        new Location(210,248,false)

    };


}
