package braintwist;

import java.util.*;
import java.io.*;

public class Puzzle {
	private Tetrahedron tetra1;
	private Tetrahedron tetra2;
	private Triangle[] tri;
	
	public Puzzle(Point[] p){
		tri = new Triangle[8];
		tri[0] = new Triangle(p[0],p[1],p[2]);
		tri[1] = new Triangle(p[3],p[4],p[5]);
		tri[2] = new Triangle(p[6],p[7],p[8]);
		tri[3] = new Triangle(p[9],p[10],p[11]);
		tri[4] = new Triangle(p[0],p[3],p[6]);
		tri[5] = new Triangle(p[1],p[8],p[11]);
		tri[6] = new Triangle(p[10],p[4],p[2]);
		tri[7] = new Triangle(p[9],p[7],p[5]);

		tetra1 = new Tetrahedron(tri[0],tri[1],tri[2],tri[3]);
		tetra2 = new Tetrahedron(tri[4],tri[5],tri[6],tri[7]);
	}
}
