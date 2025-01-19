import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Search {

	public static int count = 0;

	public static final Map<String, byte[]> astar(byte[] start) {
		PriorityQueue<State> pq = new PriorityQueue<>();
		Map<String, byte[]> parent = new HashMap<>();
		Map<String, Integer> dist = new HashMap<>();
		dist.put(make(start), 0);
		pq.add(new State(start, 0));
		while (!pq.isEmpty()) {
			State curr = pq.poll();
			count++;
			if (Arrays.equals(curr.board, Board.GOAL)) break;
			for (State child: curr.getNextStates()) {
				if (dist.getOrDefault(make(child.board), Integer.MAX_VALUE) > child.cost) {
					parent.put(make(child.board), curr.board);
					dist.put(make(child.board), child.cost);
					pq.add(child);
				}
			}
		}
		return parent;
	}

	public static final Map<String, byte[]> dfs(byte[] start) {
		Stack<State> stack = new Stack<>();
		Set<String> visited = new HashSet<>();
		Map<String, byte[]> parent = new HashMap<>();
		stack.push(new State(start, 0));
		while (!stack.isEmpty()) {
			State curr = stack.pop();
			count++;
			visited.add(make(curr.board));
			if (Arrays.equals(curr.board, Board.GOAL)) break;
			for (State child: curr.getNextStates()) {
				if (visited.contains(make(child.board))) continue;
				parent.put(make(child.board), curr.board);
				stack.push(child);
			}
		}
		return parent;
	}



	public static String make(byte[] a) {
		String s = "";
		for (int i=0; i<a.length; ++i)
			s += String.valueOf(a[i]);
		return s;
	}
}