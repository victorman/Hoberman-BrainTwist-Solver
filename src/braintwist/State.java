package braintwist;

import java.util.*;
import java.io.*;

public class State {
	byte[] state = new byte[12];
	
	public State(byte[] s){
		state = s;
	}
	
	public void rotateCW(Triangle t){
		int a = t.points[0];
		t.points[0] = t.points[1];
		t.points[1] = t.points[2];
		t.points[2] = a;
	}
	
	public boolean equals(Object obj){
		for(int i = 0; i < state.length; i++){
			if(state[i] != ((State)obj).state[i]){
				return false;
			}
		}
		return true;
	}
	
	public int hashCode(){
		int hash = 0;
		
		for(int i = 0; i < state.length; i++){
			hash += state[i];
			hash *= 17;
		}
		
		return hash;
	}
}
