package Assignment3;
import java.lang.Math;
import java.util.List;
public class MoveToWoodAction implements StripsAction{
	public MoveToWoodAction(){
	}
	// Has no wood
	public boolean precondition(State state){
		Peasant p = state.getPeasant();
		Forest f = state.findClosestForest();
		return !state.getPeasant().hasCargo() && ((Math.abs(f.getX() - p.getX()) + Math.abs(f.getX() - p.getY()))>2);
	}
	// Moves to the nearest Forest
	public State postcondition(State state){
		State newState = state.clone();
		Peasant p = newState.getPeasant();
		Forest forest = state.findClosestForest();
		p.setPosition(forest.getX(), forest.getY());
		return newState;
	}
	// Pass in same state as precondition
	// Calculate distance to nearest Forest
	public int getMakespan(State state){
		Peasant p = state.getPeasant();
		Forest forest = state.findClosestForest();
		int makespan = Math.abs(forest.getX()-p.getX());
		if(Math.abs(forest.getY()-p.getY()) < makespan){
			makespan = Math.abs(forest.getY()-p.getY());
		}
		return makespan;
	}
	public String toString(){
		return "Move to nearest Forest, precondition: peasant has no cargo and peasant is not already at the forest, postcondition: peasant is at Forest";
	}

}