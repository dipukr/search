package search;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class State {

	public static final byte[][] goal = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};

	public byte[][] maze;
	public Action action;
	public int row, col;

	public State(byte[][] maze) {
		this.maze = new byte[3][3];
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				this.maze[i][j] = maze[i][j];
	}

	public boolean isGoal() {
		for (int i = 0; i < 3; i++)
			if (Arrays.equals(maze[i], goal[i]) == false)
				return false;
		return true;
	}

	public List<Action> getActions() {
		List<Action> actions = new ArrayList<Action>();
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

	public String toString() {
		var buf = new StringBuilder();
		for (byte[] a: maze) {
			for (byte b: a)
				buf.append(b).append(' ');
			buf.append('\n');
		}
		return buf.toString();
	}
}