package search;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class State {
	
	public byte[][] maze;
	public Action action;
	public int row;
	public int col;

	public State(byte[][] maze) {
		this.maze = maze.clone();
	}

	public boolean isGoal(State goal) {
		for (int i = 0; i < maze.length; i++)
			if (!Arrays.equals(this.maze[i], goal.maze[i]))
				return false;
		return true;
	}

	public List<Action> getActions() {
		var actions = new ArrayList<Action>();
		if (row != 0) actions.add(Action.UP);
		if (col != 0) actions.add(Action.LEFT);
		if (row != maze.length - 1) actions.add(Action.DOWN);
		if (col != maze[0].length - 1) actions.add(Action.RIGHT);
		return actions;
	}

	public State result(Action action) {
		int newrow = 0, newcol = 0;
		switch (action) {
		case UP: newrow = row - 1; newcol = col; break;
		case DOWN: newrow = row + 1; newcol = col; break;
		case LEFT: newrow = row; newcol = col - 1; break;
		case RIGHT: newrow = row; newcol = col + 1; break;
		}
		State state = new State(this.maze);
		state.maze[row][col] = this.maze[newrow][newcol];
		state.maze[newrow][newcol] = this.maze[row][col];
		state.action = action;
		state.row = newrow;
		state.col = newcol;
		return state;
	}

	@Override
	public String toString() {
		var buf = new StringBuilder();
		for (byte[] a: maze)
			for (byte b: a)
				buf.append(b);
		return buf.toString();
	}
}