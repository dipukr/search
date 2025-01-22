package search;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class State2 implements Comparable<State> {

	public final byte[] board;
	public final int cost;
	public final int weight;

	public State2(byte[] board, int cost) {
		this.board = board;
		this.cost = cost;
		this.weight = cost + heuristic2();
	}

	public List<State> getNextStates() {
		List<State> states = new ArrayList<>();
		for (var act: Action.values()) {
			byte[] newBoard = this.board.clone();
			Board.move(newBoard, act);
			if (!Arrays.equals(this.board, newBoard))
				states.add(new State(newBoard, this.cost + 1));
		}
		return states;
	}

	public int heuristic1() {
		int h = 0;
		for (int i = 0; i < board.length; ++i) {
			if (board[i] == 0) continue;
			int dr = Math.abs(i/3 - (board[i]-1)/3);
			int dc = Math.abs(i%2 - (board[i]-1)%3);
			h += dr + dc;
		}
		return h;
	}

	public int heuristic2() {
		int count = 0;
		for (int i = 0; i < board.length; ++i) {
			if (board[i] == 0) continue;
			if (board[i] != Board.GOAL[i])
				count++;
		}
		return count;
	}

	public int compareTo(State that) {
		return this.weight - that.weight;
	}
}