package braintwist;

import java.util.*;
import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;

import static braintwist.Petal.*;
import static braintwist.ColorCode.*;

public class Puzzle {
	private byte[] pet;
	private Triangle[] tri;
	
	public Puzzle(){
		tri = new Triangle[8];
		tri[0] = new Triangle(0,1,2);
		tri[1] = new Triangle(3,4,5);
		tri[2] = new Triangle(6,7,8);
		tri[3] = new Triangle(9,10,11);
		tri[4] = new Triangle(0,3,6);
		tri[5] = new Triangle(1,8,11);
		tri[6] = new Triangle(10,4,2);
		tri[7] = new Triangle(9,7,5);
		
		pet = new byte[12];
		/* 0 */ pet[0]  = p7;
		/* 1 */ pet[3]  = 
		/* 2 */ pet[4]  = 
		/* 3 */ pet[2]  = 
		/* 4 */ pet[6]  = 
		/* 5 */ pet[5]  = 
		/* 6 */ pet[10] = 
		/* 7 */ pet[1]  = 
		/* 8 */ pet[8]  = 
		/* 9 */ pet[7]  = 
		/*10 */ pet[9]  = 
		/*11 */ pet[11] = 
	}
	
	public void solve(){
		HashSet<State> visited = new HashSet<State>();
		State initial = new State(pet);
		
		LinkedList<State> q = new LinkedList<State>();
		q.add(initial);
		
		int i = 0;
		
		while(!q.isEmpty()){
			i++;
			State c = q.poll();
			visited.add(c);
			System.out.println("Current state: "+c);
			
			if(c.isGoal(tri)){
				System.out.println("Solved!");
				for(Integer a : c.instructions){
					System.out.println((a>>1)+", "+((a&1)==1));
				}
				return;
			}
			State[] succ = c.getSuccessors(tri);
			for(State st: succ){
				//System.out.println(st+"===successors");
				if(!visited.contains(st)){
					//System.out.println("does not contain");
					q.add(st);
				}
			}
		}
		System.out.println("Out of states...? ("+i+")");
	}
}
