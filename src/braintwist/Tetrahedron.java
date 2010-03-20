package braintwist;

import java.util.*;
import java.io.*;

public class Tetrahedron {
	private Triangle tri0;
	private Triangle tri1;
	private Triangle tri2;
	private Triangle tri3;
	public Tetrahedron(Triangle tri0, Triangle tri1, Triangle tri2, Triangle tri3){
		this.tri0 = tri0;
		this.tri1 = tri1;
		this.tri2 = tri2;
		this.tri3 = tri3;
	}
}
