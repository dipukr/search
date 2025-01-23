package search;

import java.util.List;

public class Main {
	public static void main(final String[] args) throws Exception {
		byte[][] maze = {{0, 1, 3},
						 {4, 2, 5},
						 {7, 8, 6}};
		byte[][] goal = {{0, 1, 2},
						 {3, 4, 5},
						 {6, 7, 8}};
		State state = new State(maze);
		state.row = 0; state.col = 1;
		Problem problem = new EightPuzzle(state);
		List<Action> solution = Search.depthFirst(problem);
		System.out.println(solution);
	}
}