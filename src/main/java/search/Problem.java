package search;

import java.util.List;

public interface Problem {
	State getStartState();
	boolean isGoalState(State state);
	List<State> getSuccessors(State state);
}
