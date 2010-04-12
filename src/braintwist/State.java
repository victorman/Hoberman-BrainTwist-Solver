package braintwist;

import java.awt.Color;
import java.util.*;

public class State implements Comparable<State> {
    static final int MAX_MOVES = 11;
        int fitness;
	byte[] state = new byte[12];
	int steps;
//	LinkedList<Integer> instructions;
        Triangle triangle;
        boolean direction;
        State parent;
        private Color[] colors = {Color.BLUE, Color.RED, Color.MAGENTA};

        private void calcFitness(){
            int f = 0;

            byte mask2 = (byte)0xf0;
            byte mask1 = (byte)0x0f;

            for(int i = 0; i < Puzzle.tri.length; i++){
                byte mask = 0;
                if(i < (Puzzle.tri.length>>1)){
                        mask = mask1;
                }
                else{
                        mask = mask2;
                }

                byte a = (byte) (state[Puzzle.tri[i].points[0]]&mask);
                byte b = (byte) (state[Puzzle.tri[i].points[1]]&mask);
                byte c = (byte) (state[Puzzle.tri[i].points[2]]&mask);
                if((a&b&c) == a) {
                    f += 2;
                }
                else if(
                    ((a&b) == a) ||
                    ((a&c) == a) ||
                    ((b&c) == b)
                    )
                {
                    f += 1;
                }
            }

            f <<= 4;

            f -= steps;

            fitness = f;
        }

	public State(State s){
		/*for(int i = 0; i < s.length; i++){
			state[i] = s[i];
		}*/
		state = s.state.clone();
//		instructions = (LinkedList<Integer>) s.instructions.clone();
		steps = s.steps+1;
                parent = s;
		this.calcFitness();
	}

        public State(State s, Triangle t, boolean d) {
            this(s);
            triangle = t;
            direction = d;
            if (d) {
            this.rotateCW(t);
            } else {
                this.rotateCCW(t);
            }
        }
        
	public State(Petal[] p){
		for(int i = 0; i < p.length; i++){
			state[i] = p[i].ID;
		}
		steps = 0;
//		instructions = new LinkedList<Integer>();
                parent = null;
                this.calcFitness();
	}
	
	public State[] getSuccessors() {
                if(steps >= MAX_MOVES){
                    return new State[0];
                }
		State[] ss = new State[16];
                Triangle t;
		for(int i = 0; i < 8; i++){
                    t = Puzzle.tri[i];
                    ss[i] = new State(this, t, true);
                    ss[i+8] = new State(this, t, false);
		}
		
//		System.out.println("---A call to get successors---");
//		for(int i = 0; i < 16; i++){
//			System.out.println(ss[i]);
//		}
//		System.out.println("---End call---");
		
		return ss;
	}
	
	public boolean isGoal(Triangle[] t){
		byte mask2 = (byte)0xf0;
		byte mask1 = (byte)0x0f;
		
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
			if((a&b&c) != a) {
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

        public String getSolution() {
            if (parent == null)
                return "";
            return parent.getSolution()
                    + (triangle.toString() + ", " + direction + "\n");
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
		
		s += " steps="+steps+",";
                s += " fit="+fitness;
		
		return s;
	}

        public int compareTo(State c){

            return c.fitness - fitness;
        }

    public TriangleP[] getTriangles() {
        int magic = 24;
        TriangleP[] triArr = new TriangleP[magic];
        for (int i = 0; i < magic/2; i++) {
            triArr[i] = new TriangleP(Location.locs[i].x, Location.locs[i].y, Location.locs[i].up, ColorCode.getColorI(state[i]));
        }
        for (int i = 12; i < magic; i++) {
            triArr[i] = new TriangleP(Location.locs[i].x, Location.locs[i].y, Location.locs[i].up, ColorCode.getColorO(state[i%12]));
        }
        return triArr;
    }
}
