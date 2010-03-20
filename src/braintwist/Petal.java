package braintwist;

import java.util.*;
import java.io.*;

public class Petal {
	public final byte ID;
	
	public Petal(byte c1, byte c2){
		ID = (byte) (c1 ^ c2);
	}
}
