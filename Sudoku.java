import java.util.Arrays;
//import java.Arrays;
class Sudoku{
	public static void main(String[] ar){
		char[][] board = {{'.','8','7','6','5','4','3','2','1'},
		{'2','.','.','.','.','.','.','.','.'},
		{'3','.','.','.','.','.','.','.','.'},
		{'4','.','.','.','.','.','.','.','.'},
		{'5','.','.','.','.','.','.','.','.'},
		{'6','.','.','.','.','.','.','.','.'},
		{'7','.','.','.','.','.','.','.','.'},
		{'8','.','.','.','.','.','.','.','.'},
		{'9','.','.','.','.','.','.','.','.'}};
		if(solve(board))
			display(board);
		else
			System.out.println("Cannot solve");
		

	}
	public static boolean solve(char[][] board){
		int rows = -1;
		int cols = -1;
		boolean isEmpty = true;
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board.length;j++){
				if(board[i][j]=='.'){
					rows=i;
					cols = j;
					isEmpty=false;
					break;
				}
			}
			if(isEmpty==false){
				break;
			}
		}
		if(isEmpty) //sudoku solved
			return true;
		for(int i =1;i<=9;i++){
			if(isSafe(board,rows,cols,i)){
				board[rows][cols]=(char)(i+'0');
				if(solve(board)){
					return true;
				}
				else{
					board[rows][cols]='.';
				}
			}
		}
		return false;
	}
	public static boolean isSafe(char[][] board,int rows,int col,int num){
		for(int i=0;i<board.length;i++){
			if(board[rows][i]==((char)(num+'0')))
				return false;
		}
		for(int i=0;i<board.length;i++){
			if(board[i][col]==((char)(num+'0')))
				return false;
		}
		int sqrt = (int) Math.sqrt(board.length);
		int rowStart = rows-(rows%sqrt);
		int colStart = col-(col%sqrt);
		for(int i=rowStart;i<rowStart+sqrt;i++){
			for(int j = colStart;j<colStart+sqrt;j++){
				if(board[i][j]==((char)(num+'0')))
					return false;
			}
		}
		return true;
	}
	public static void display(char[][] board){
		for(char[] rows:board){
			for(char num:rows){
				System.out.print(num+" ");
			}
			System.out.println();
		}
	}
}