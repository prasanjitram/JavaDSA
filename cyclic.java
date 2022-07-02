import java.util.ArrayList;
import java.util.Arrays;

public class cyclic {
    public static void main(String[] args) {
        int[] arr = { 7, -1, 4, 5, -3, 1 };
        // sort(arr);
        System.out.println(missingNumbers(arr).toString());
    }

    public static int missingNumber(int[] arr) {
        int num = -1;
        sort(arr,0);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                num = i + 1;
            }
        }
        return num;
    }

    public static ArrayList<Integer> missingNumbers(int[] arr) {
        ArrayList<Integer> missing = new ArrayList<>();
        sort(arr,0);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                missing.add(i + 1);
            }
        }
        return missing;
    }

    public void cyclic(int[] arr) {
        int i = 0;
        if (i > arr.length)
            return;

    }

    public static void sort(int[] arr,int i) {
        if (i>=arr.length)
            return;
        // System.out.println("inside while");
        if (arr[i] <= arr.length && arr[i] > 0) {
            if (arr[i] != arr[arr[i] - 1]) {
                swap(arr, arr[i]-1, i);
                // System.out.println(i+" "+arr[i]);
            } else {
                i++;
            }
        } else
            i++;
        sort(arr, i);
    }

    public static void swap(int[] arr,int first, int second) {
        int tmp = arr[first];
        arr[first] = arr[second];
        arr[second] = tmp;
        // System.out.println(first+" "+second);
    }
}
