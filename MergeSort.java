import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr={1,2,1,2,2,3,3};
        System.out.println(Arrays.toString(mergeSort(arr)));
    }
    public static int[] mergeSort(int[] arr){
        if(arr.length==1)
            return arr;
        int mid = arr.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int [] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left,right);
    }
    private static int[] merge(int[] left, int[] right) {
        int[] newMerged = new int[left.length+right.length];;
        int i=0;
        int j=0;
        int k=0;
        while(i<left.length&&j<right.length){
            if(left[i]<right[j]){
                newMerged[k]=left[i];
                i++;
            }
            else{
                newMerged[k]=right[j];
                j++;
            }
            k++;
        }
        while(i<left.length){
            newMerged[k]=left[i];
            k++;
            i++;
        }
        while(j<right.length){
            newMerged[k]=right[j];
            j++;
            k++;
        }
        return newMerged;
    }
}
