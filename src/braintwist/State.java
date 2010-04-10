package braintwist;

import java.util.*;
import java.io.*;

public class State {
	byte[] state = new byte[12];
	int steps;
	LinkedList<Integer> instructions;
	
	public State(State s){
		/*for(int i = 0; i < s.length; i++){
			state[i] = s[i];
		}*/
		state = s.state.clone();
		instructions = (LinkedList<Integer>) s.instructions.clone();
		steps = s.steps+1;
		
	}
	
	public State(Petal[] p){
		for(int i = 0; i < p.length; i++){
			state[i] = p[i].ID;
		}
		steps = 0;
		instructions = new LinkedList<Integer>();
	}
	
	public State[] getSuccessors(Triangle[] t){
		State[] ss = new State[16];
		for(int i = 0; i < 16; i++){
			ss[i] = new State(this);
			if((i&1) == 0){
				ss[i].rotateCW(t[i>>1]);
			}
			else{
				ss[i].rotateCCW(t[i>>1]);
			}
			ss[i].instructions.add(i);
		}
		
//		System.out.println("---A call to get successors---");
//		for(int i = 0; i < 16; i++){
//			System.out.println(ss[i]);
//		}
//		System.out.println("---End call---");
		
		return ss;
	}
	
	public boolean isGoal(Triangle[] t){
		byte mask1 = (byte)0x11110000;
		byte mask2 = (byte)0x00001111;
		
		for(int i = 0; i < t.length; i++){
			byte mask = 0;
			if(i < (t.length>>1)){
				mask = mask1;
			}
			else{
				mask = mask2;
			}
			
			byte a = (byte) (state[t[i].points[0]]&mask);
			byte b = (byte) (state[t[i].points[1]]&mask);
			byte c = (byte) (state[t[i].points[2]]&mask);
			if((a&b&c) != a){
				return false;
			}
		}
		
		return true;
	}
	
	public void rotateCW(Triangle t){
		byte a = state[t.points[0]];
		//System.out.println("--b  "+this);
		state[t.points[0]] = state[t.points[1]];
		state[t.points[1]] = state[t.points[2]];
		state[t.points[2]] = a;
		//System.out.println("--a  "+this);
	}
	
	public void rotateCCW(Triangle t){
		byte a = state[t.points[0]];
		state[t.points[0]] = state[t.points[2]];
		state[t.points[2]] = state[t.points[1]];
		state[t.points[1]] = a;
	}
	
	public boolean equals(Object obj){
		State other = (State) obj;
		//System.out.println(other+"=other");
		//System.out.println(this+"==this");
		for(int i = 0; i < state.length; i++){
			if(this.state[i] != other.state[i]){
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
	
	public String toString(){
		String s = "";
		
		for(int i = 0; i < state.length; i++){
			s += state[i] + ",";
		}
		
		s += " steps="+steps;
		
		return s;
	}
}
