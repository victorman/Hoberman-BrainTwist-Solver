package braintwist;

import java.util.*;
import java.io.*;

public class Triangle {
	private Point p0;
	private Point p1;
	private Point p2;
	
	public Triangle(Point p0, Point p1, Point p2){
		this.p0 = p0;
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public void rotateCW(){
		Point t = new Point(p0.petal);
		p0.petal = p1.petal;
		p1.petal = p2.petal;
		p2.petal = t.petal;
	}
	public void rotateCCW(){
		Point t = new Point(p0.petal);
		p0.petal = p2.petal;
		p2.petal = p1.petal;
		p1.petal = t.petal;
	}
}