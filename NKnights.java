import java.util.*;
class NKnights{
	public static void main(String[] ar){
		boolean[][] board = new boolean[4][4];
		knights(board,0,0,4);
	}
	public static void knights(boolean[][] board, int rows, int col, int knight){
		if(knight==0){
			display(board);
			System.out.println();
			return;
		}
		if(rows==board.length-1&&col==board.length){
			return;
		}
		if(col==board.length){
			knights(board,rows+1,0,knight);
			return;
		}
		if(isSafe(board,rows,col)){
			board[rows][col]=true;
			knights(board,rows,col+1,knight-1);
			board[rows][col]=false;
		}
		knights(board,rows,col+1,knight);
	}
	public static boolean isSafe(boolean[][] board,int r, int c){
		if(isValid(board,r-2,c-1)&&board[r-2][c-1]){
			return false;
		}
		if(isValid(board,r-2,c+1)&&board[r-2][c+1]){
			return false;
		}
		if(isValid(board,r-1,c-2)&&board[r-1][c-2]){
			return false;
		}
		if(isValid(board,r-1,c+2)&&board[r-1][c+2]){
			return false;
		}
		return true;
	}
	public static boolean isValid(boolean[][] board,int r, int c){
		if(r>=0&&r<board.length&&c>=0&&c<board.length)
			return true;
		return false;
	}
	public static void display(boolean[][] board){
		for(boolean[] elements:board){
			for(boolean element:elements){
				if(element){
					System.out.print("K");
				}
				else{
					System.out.print("X");
				}
			}
			System.out.println("");
		}
	}
}