import java.util.Arrays;

public class ToofanPermutation {
    public static void allPerm(int[] ar,String init,int count){
        if(count!=0&&Arrays.toString(ar).equals(init)){
            return;
        }
        int i  = ar.length-2;
        while(i >= 0 && ar[i] >= ar[i+1]) i--;
        if(i >= 0){
            int j = ar.length-1;
            while(ar[j] <= ar[i]) j--;
            ar = swap(ar,i,j);
            }
            reverse(ar, i+1, ar.length-1);
            if(!Arrays.toString(ar).equals(init)){
                System.out.println(Arrays.toString(ar));
                allPerm(ar,init,count+1);
        }
        //return;
    }
    public static int[] swap(int[] ar, int i, int j){
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
        return ar;
    }
    public static void reverse(int[]nums , int i,int j){
        while(i<j)swap(nums,i++,j--);
    }
    public static void main(String[] args) {
        //ToofanPermutation obj = new ToofanPermutation();
        int[] ar = {1,2,3};
        System.out.println(Arrays.toString(ar));

        allPerm(ar,Arrays.toString(ar),0);
    }
}
