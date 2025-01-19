import java.util.Random;

public class Board {

	public static final byte[] GOAL = {1,2,3,4,5,6,7,8,0};
	public byte[] data = {0,1,3,4,2,5,7,8,6};
	public boolean solving = false;

	public static void move(byte[] board, Action act) {
		int blank = blankIndex(board);
		switch (act) {
		case UP: 
			if (blank/3 != 0)
			swap(board, blank, blank - 3);
			break;
		case DOWN:
			if (blank/3 != 2)
			swap(board, blank, blank + 3);
			break;
		case LEFT:
			if (blank%3 !=  0)
			swap(board, blank, blank - 1);
			break;
		case RIGHT:
			if (blank%3 != 2)
			swap(board, blank, blank + 1);
			break;
		}
	}

	public static void swap(byte[] board, int i, int j) {
		byte tmp = board[i];
		board[i] = board[j];
		board[j] = tmp;
	}

	public void reset() {
		for (int i = 0; i < data.length-1; ++i)
			data[i] = (byte)(i + 1);
		data[data.length-1] = 0;
	}

	public void randomize() {
		byte[] board;
		while (solvable(board = randomBoard())) {}
		data = board;
	}

	public byte[] randomBoard() {
		boolean[] flag = new boolean[data.length];
		byte[] board = new byte[data.length];
		Random rand = new Random();
		for (int i = 0; i < data.length; ++i) {
			byte t = 0;
			while (flag[t = (byte)rand.nextInt(9)]) {}
			flag[t] = true;
			board[i] = t;
		}
		return board;
	}

	public boolean solvable(byte[] board) {
		int counter = 0;
		for (int i = 0; i < board.length; ++i) {
			if (board[i] == 0) continue;
			for (int j = i + 1; j < board.length; ++j)
				if (board[i] != 0 && board[i] > board[j])
					counter++;
		}
		return (counter % 2) == 0;
	}

	public static int blankIndex(byte[] board) {
		for (int i = 0; i < board.length; ++i)
			if (board[i] == 0)
				return i;
		return -1;
	}

	public void print() {
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				byte val = data[3*i + j];
				if (val == 0) System.out.print("  ");
				else System.out.print(val+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}