package search;

import java.util.ArrayList;
import java.util.List;

public class State1 implements Comparable<State> {

	private final Board board;
	private final int cost;
	private final int weight;

	public State1(Board board, int cost) {
		this.board = board;
		this.cost = cost;
		this.weight = cost + heuristic();
	}

	public Board getBoard() {
		return board;
	}
	
	public int getCost() {
		return cost;
	}

	public int heuristic() {
		return board.heuristic();
	}

	public List<State> getNextStates() {
		var result = new ArrayList<State>();
		for (Action act: Action.values()) {
			Board b = board.clone();
			b.move(act);
			if (!board.equals(b))
				result.add(new State(b, cost + 1));
		}
		return result;
	}

	public int compareTo(State that) {
		return this.weight - that.weight;
	}
}
