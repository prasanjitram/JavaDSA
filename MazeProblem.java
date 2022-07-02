import java.util.ArrayList;
import java.util.Arrays;

public class MazeProblem {
    public static void main(String[] args) {
        boolean[][] maze = new boolean[3][3];
        Arrays.fill(maze[0], true);
        Arrays.fill(maze[1], true);
        Arrays.fill(maze[2], true);
        //maze[1][1] = false;
        System.out.println(mazePathAll(maze, "", 0, 0));
    }

    static int mazeCount(int row, int column) {
        if (row == 1 || column == 1) {
            return 1;
        }
        int left = mazeCount(row - 1, column);
        int right = mazeCount(row, column - 1);
        return left + right;
    }

    static ArrayList<String> mazePath(String p, int rows, int columns) {

        if (rows == 1 && columns == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        if (rows > 1) {
            ans.addAll(mazePath(p + 'D', rows - 1, columns));

        }
        if (columns > 1)
            ans.addAll(mazePath(p + 'R', rows, columns - 1));
        return ans;
    }

    static ArrayList<String> mazeRestrictions(boolean[][] maze, int rows, int columns, String p, int restRow,
            int restColumn) {
        ArrayList<String> ans = new ArrayList<>();
        if (rows == 1 && columns == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        if (columns == restColumn && rows==restRow) {
            return ans;
        }

        if (rows > 1) {
            ans.addAll(mazeRestrictions(maze, rows - 1, columns, p + "D", restRow, restColumn));
        }
        if (columns > 1) {
            ans.addAll(mazeRestrictions(maze, rows, columns - 1, p + "R", restRow, restColumn));
        }
        return ans;
    }
    static ArrayList<String> mazePathAll(boolean[][]maze, String p,int r, int c){
        ArrayList<String> ans=new ArrayList<>();
        if(r==maze.length-1&&c==maze[0].length-1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        if(maze[r][c]==false)
            return ans;
        maze[r][c]=false;
        if(r<maze.length-1){
            ans.addAll(mazePathAll(maze, p+'D', r+1, c));
        }
        if(c<maze[0].length-1){
            ans.addAll(mazePathAll(maze, p+'R', r, c+1));
        }
        if(r>0){
            ans.addAll(mazePathAll(maze, p+'U', r-1, c));
        }
        if(c>0){
            ans.addAll(mazePathAll(maze, p+'L', r, c-1));
        }
        maze[r][c]=true;
        return ans;

    }
}
