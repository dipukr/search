package search;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class State {
	
	public byte[][] maze;
	public Action action;
	public int row, col;

	public State(byte[][] maze) {
		this.row = maze.length;
		this.col = maze[0].length;
		this.maze = new byte[row][col];
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				this.maze[i][j] = maze[i][j];
	}

	public boolean isGoal(State goal) {
		for (int i = 0; i < row; i++)
			if (Arrays.equals(maze[i], goal.maze[i]) == false)
				return false;
		return true;
	}

	public List<Action> getActions() {
		var actions = new ArrayList<Action>();
		if (row != 0) actions.add(Action.UP);
		if (row != 2) actions.add(Action.DOWN);
		if (col != 0) actions.add(Action.LEFT);
		if (col != 2) actions.add(Action.RIGHT);
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