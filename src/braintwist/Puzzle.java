package braintwist;

import java.util.*;
import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;

import static braintwist.ColorCode.*;

public class Puzzle {
	private Petal[] pet;
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
		
		pet = new Petal[12];
//		pet[0]  = new Petal(Red, Yellow);
//		pet[1]  = new Petal(Red, Lime);
//		pet[2]  = new Petal(Red, Cyan);
//		pet[3]  = new Petal(Blue, Lime);
//		pet[4]  = new Petal(Blue, Cyan);
//		pet[5]  = new Petal(Blue, Green);
//		pet[6]  = new Petal(Magenta, Green);
//		pet[7]  = new Petal(Magenta, Yellow);
//		pet[8]  = new Petal(Magenta, Cyan);
//		pet[9]  = new Petal(Orange, Green);
//		pet[10] = new Petal(Orange, Yellow);
//		pet[11] = new Petal(Orange, Lime);
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
