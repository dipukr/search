package search;

import java.util.Set;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.ArrayList;

public class Search {
	
	public static List<Action> depthFirst(Problem problem) {
		var actions = new ArrayList<Action>();
		return actions;
	}

	public static List<Action> breadthFirst(Problem problem) {
		var visited = new TreeSet<String>();
		var solution = new Stack<Action>();
		var queue = new Queue<State>();
		queue.enqueue(problem.getStartState());
		while (!queue.empty()) {
			State state = queue.dequeue();
			if (problem.isGoalState(state)) break;
			if (!visited.contains(state.toString())) {
				visited.add(state.toString());
				for (State w: problem.getSuccessors(state)) {
					List<Action> newpath = new ArrayList<>();
					newpath.addAll(path);
					newpath.add(w.action);
					queue.enqueue(w);
					queue.enqueue(newpath);
				}
			}
		}
		return solution;
	}
}