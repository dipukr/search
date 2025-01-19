import java.util.List;
import java.util.ArrayList;

public class Puzzle implements Problem {

	private State start;

	public EightPuzzle(State start) {
		this.start = start;
	}

	public State getStartState() {
		return start;
	}

	public boolean isGoalState(State state) {
		return state.isGoal();
	}

	public List<State> getSuccessors(State state) {
		List<State> successors = new ArrayList<>();
		for (Action action: state.getActions())
			successors.add(state.result(action));
		return successors;
	}
}