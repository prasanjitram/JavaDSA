import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int len = arr.length;
        int n = factorial(len);
        for(int i=0;i<n;i++){
            nextPermutation(arr);
            System.out.println(Arrays.toString(arr));
        }
    }
    private static int factorial(int len) {
        if(len==0)
            return 1;
        return len*factorial(len-1);
        
    }
    static void permutationNumber(List<List<Integer>> ans, int[] nums, int index){
        if(index==nums.length){
            List<Integer> ds = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=index;i<nums.length;i++){
            swap(nums,i,index);
            permutationNumber(ans, nums, index+1);
            swap(nums, i, index);
        }

    }
    static void swap(int[] nums, int i,int j){
        int t = nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
    static void nextPermutation(int[] nums){
        int i = nums.length-2;
        
        while(i>=0&&nums[i]>=nums[i+1]) i--;
        //System.out.println("Hiiiii");
        if(i>=0){
            int j=nums.length-1;
            while(nums[j]<=nums[i])j--;
            swap(nums, i, j);
        }
        reverse(nums,i+1,nums.length-1);
        
    }
    public static void reverse(int[]nums , int i,int j){
        while(i<j)swap(nums,i++,j--);
    }
    static void permutation(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        //System.out.println(ch);
        for(int i=0;i<=p.length();i++){
            System.out.println("up: "+up+" p: "+p);
            String f = p.substring(0, i);
            String s = p.substring(i,p.length());
            String fi = f+ch+s;
            System.out.println(fi+" :fi"+" i:"+i);
            permutation(fi, up.substring(1));
            System.out.println("One function call over");
        }
    }
    static ArrayList<String> permutationList(String p, String up){
        ArrayList<String> ans = new ArrayList<>();
        if(up.isEmpty()){
            ans.add(p);
            return ans;
        }
        char ch = up.charAt(0);
        for(int i=0;i<=p.length();i++){
            String f= p.substring(0, i);
            String s = p.substring(i,p.length());
            ans.addAll(permutationList(f+ch+s, up.substring(1)));

        }
        return ans;
    }
    static int permutationCount(String p, String up){
        if(up.isEmpty()){
            return 1;
        }
        int count =0;
        char ch= up.charAt(0);
        for(int i=0;i<=p.length();i++){
            String f = p.substring(0,i);
            String s = p.substring(i,p.length());
            count = count+permutationCount(f+ch+s, up.substring(1));
        }
        return count;
    }
}
