package search;

import java.util.List;
import java.util.ArrayList;

public class EightPuzzle implements Problem {

	private State start;
	private State goal;

	public EightPuzzle(State start, State goal) {
		this.start = start;
		this.goal = goal;
	}

	public State getStartState() {
		return start;
	}

	public boolean isGoalState(State state) {
		return state.isGoal(goal);
	}

	public List<State> getSuccessors(State state) {
		List<State> successors = new ArrayList<>();
		for (Action action: state.getActions())
			successors.add(state.result(action));
		return successors;
	}
}