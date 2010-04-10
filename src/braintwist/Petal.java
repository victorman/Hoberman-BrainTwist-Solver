package braintwist;

import java.util.*;
import java.io.*;
import static braintwist.ColorCode.*;

public class Petal {
	public final byte ID;
	
	public static final byte p0  = code(Red, Yellow);    
	public static final byte p1  = code(Red, Lime);      
	public static final byte p2  = code(Red, Cyan);      
	public static final byte p3  = code(Blue, Lime);     
	public static final byte p4  = code(Blue, Cyan);     
	public static final byte p5  = code(Blue, Green);    
	public static final byte p6  = code(Magenta, Green); 
	public static final byte p7  = code(Magenta, Yellow);
	public static final byte p8  = code(Magenta, Cyan);  
	public static final byte p9  = code(Orange, Green);  
	public static final byte p10 = code(Orange, Yellow); 
	public static final byte p11 = code(Orange, Lime);   
	
	public Petal(byte c1, byte c2){
		ID = code(c1, c2);
	}
	
	public static byte code(byte c1, byte c2){
		return (byte) (c1 ^ c2);
	}
}
