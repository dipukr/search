package search;

import java.util.List;
import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) throws Exception {
		byte[][] maze = {{0, 1, 3},
						 {4, 2, 5},
						 {7, 8, 6}};
		State state = new State(maze);
		state.row = 0; state.col = 1;
		Problem problem = new EightPuzzle(state);
		List<Action> solution = Search.depthFirst(problem);
		System.out.println(solution);
	}
}