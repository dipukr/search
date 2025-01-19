import java.util.List;

public interface Problem {
	public State getStartState();
	public boolean isGoalState(State state);
	public List<State> getSuccessors(State state);
}