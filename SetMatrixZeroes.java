import java.util.ArrayList;
import java.util.Arrays;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
        SetMatrixZeroes obj = new SetMatrixZeroes();
        System.out.println(matrix.length);
        obj.setZeroes(matrix);
        System.out.println(Arrays.toString(matrix[1]));
    }

    public void setZeroes(int[][] matrix) {
        if (matrix.length > 0 && matrix[0].length > 0) {
            ArrayList<ArrayList<Integer>> outer = new ArrayList<>();

            int k = 0;
            int l = 0;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    ArrayList<Integer> inner = new ArrayList<>();
                    if (matrix[i][j] == 0) {
                        inner.add(i);
                        inner.add(j);
                        outer.add(inner);
                    }

                }
            }
            System.out.println(outer);
            for (int i = 0; i < outer.size(); i++) {
                for (int j = 0; j < matrix[outer.get(i).get(0)].length; j++) {
                    matrix[outer.get(i).get(0)][j] = 0;
                }
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][outer.get(i).get(1)] = 0;
                }
            }
        }
    }
}
