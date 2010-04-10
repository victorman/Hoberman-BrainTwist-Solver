package braintwist;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

import static braintwist.ColorCode.*;

public class Puzzle {
	private Petal[] pet;
        private State curState;

        public static Triangle[] tri = {
            new Triangle(0, 1, 2), // 0
            new Triangle(3, 4, 5), // 1
            new Triangle(6, 7, 8), // 2
            new Triangle(9, 10, 11), // 3
            new Triangle(0, 3, 6), // 4
            new Triangle(5, 8, 10), // 5
            new Triangle(7, 1, 11), // 6
            new Triangle(2, 4, 9) // 7
        };

	public Puzzle(){

		
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

                pet[0]  = new Petal(Red, Yellow);
		pet[1]  = new Petal(Red, Lime);
		pet[2]  = new Petal(Red, Cyan);
		pet[3]  = new Petal(Magenta, Yellow);
		pet[4]  = new Petal(Magenta, Cyan);
		pet[5]  = new Petal(Magenta, Green);
		pet[6]  = new Petal(Orange, Yellow);
		pet[7]  = new Petal(Orange, Lime);
		pet[8]  = new Petal(Orange, Green);
		pet[9]  = new Petal(Blue, Cyan);
		pet[10] = new Petal(Blue, Green);
		pet[11] = new Petal(Blue, Lime);
                curState = new State(pet);
	}
	
	public State solve(){
		HashSet<State> visited = new HashSet<State>();
		State initial = curState;
		
		//LinkedList<State> q = new LinkedList<State>();
                PriorityQueue<State> q = new PriorityQueue<State>();
		q.add(initial);
		
		//int i = 0;
		
		while(!q.isEmpty()){
			//i++;
			State c = q.poll();
			visited.add(c);
//			System.out.println("Current state: "+c);
			
			if(c.isGoal(tri)){
				System.out.println("Solved!");
				for(Integer a : c.instructions){
					System.out.println((a>>1)+", "+((a&1)==1));
				}
				return c;
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
		//System.out.println("Out of states...? ("+i+")");
                return initial;
	}

    public void step() {
        //TODO: should do one step in the breadth first search?
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public TriangleP[] getTriangles() {
        return curState.getTriangles();
    }

    public void rotateCW(Triangle triangle) {
        curState.rotateCW(triangle);
    }

    public void solver() {
        curState = solve();
        curState.steps = 0;
        curState.instructions = new LinkedList<Integer>();
    }

}
