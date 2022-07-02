import java.util.Arrays;

public class Practice {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1,3,2,1};
        mergeSort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int start, int end) {
        if (end-start == 1)
            return;
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid, end);
        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int i = start;
        int j = mid;
        int k = 0;
        int[] merged = new int[end - start];
        while (i < mid && j < end) {
            if (arr[i] < arr[j]) {
                merged[k] = arr[i];
                i++;
                k++;
            } else {
                merged[k] = arr[j];
                j++;
                k++;
            }
        }
        while (i < mid) {
            merged[k] = arr[i];
            k++;
            i++;
        }
        while (j < end) {
            merged[k] = arr[j];
            k++;
            j++;
        }
        for (int s = 0; s < merged.length; s++) {
            arr[start + s] = merged[s];
        }
    }
}
