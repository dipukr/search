package search;

import java.util.Arrays;
import java.util.Random;

public class Board {

	private static final byte[] goal = {1,2,3,4,5,6,7,8,0};
	private byte[] board;

	public Board(byte[] board) {
		this.board = board;
	}
	
	public byte[] getBoard() {return board;}
	public void setBoard(byte[] board) {this.board = board;}
	public Board clone() {return new Board(board.clone());}
	public boolean isGoal() {return Arrays.equals(board, goal);}

	public void move(Action act) {
		int b = blankIndex();
		switch (act) {
		case UP: if (b / 3) swap(i, i-3); break;
		case DOWN: if (b / 3) swap(i, i-3); break;
		case LEFT: if (b / 3) swap(i, i-3); break;
		case RIGHT:	 if (b / 3) swap(i, i-3); break;
		}
	}

	public int blankIndex() {
		for (int i = 0; i < board.length; i++)
			if (board[i] == 0)
				return i;
		return -1;
	}

	public void shuffle() {
		var rand = new Random();
		for (int i = board.length - 1; i > 0; i--)
			swap(i, rand.nextInt(board.length));
	}

	public void newBoard() {
		shuffle();
		while (!isSolvable())
			shuffle();		
	}

	public void reset() {
		for (int i = 0; i < board.length-1; i++)
			board[i] = (byte)(i + 1);
		board[board.length-1] = 0;
	}

	public boolean isSolvable() {
		int inv = 0;
		for (int i = 0; i < board.length; i++) {
			if (board[i] == 0) continue;
			for (int j = i + 1; j < board.length; j++)
				if (board[j] != 0 && board[i] > board[j])
					inv++;
		}
		return inv % 2 == 0;
	}

	public void swap(int i, int j) {
		byte tmp = board[i];
		board[i] = board[j];
		board[j] = tmp;
	}

	public int heuristic() {
		int h = 0;
		for (int i = 0; i < board.length; i++)
			if (board[i] == 0) continue;
		return h;	
	}

	public String toString() {
		var s = new StringBuffer("[");
		for (int i = 1; i <= board.length; i++) {
			if (i % 3 == 1 && i > 1)
				s.append("]\n[");
			s.append(board[i-1]);
		}
		s.append(']');
		return s.toString();
	}

	public static void main(String[] args) throws Exception {
		Board board = new Board(goal);
		System.out.println(board);
		System.out.println(board.isSolvable());
		board.newBoard();
		System.out.println(board);
		System.out.println(board.isSolvable());
		board.newBoard();
		System.out.println(board);
		System.out.println(board.isSolvable());
	}
}