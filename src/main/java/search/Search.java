import java.util.Set;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.ArrayList;

public class Search {

	public static List<Action> breadthFirst(Problem problem) {
		var visited = new TreeSet<String>();
		var solution = new Stack<Action>();
		var queue = new Queue<State>();
		queue.enqueue(problem.getStartState());
		while (!queue.empty()) {
			State state = queue.dequeue();
			if (problem.isGoalState(state)) break;
			if (!visited.contains(str(node.maze))) {
				visited.add(str(node.maze));
				for (State w: problem.getSuccessors(node)) {
					List<Action> newpath = new ArrayList<>();
					newpath.addAll(path);
					newpath.add(w.action);
					queue.enqueue(w);
					pqueue.enqueue(newpath);
				}
			}
		}
		return solution;
	}

	private static String str(byte[][] maze) {
		var buf = new StringBuilder();
		for (int i = 0; i < 3; i++)
			buf.append(String.valueOf(maze[i]));
		return buf.toString();
	}
}