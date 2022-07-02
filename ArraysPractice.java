
class ArraysPractice{
    public static void main(String[] ar){
        int[] nums1 = {1,2,5,3,10,8,9};
        int[] nums2 = {3,4};
        double d = findMedianSortedArrays(nums1, nums2);
        System.out.println(d);
        System.out.println(secondSmallest(nums1));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length+nums2.length];
        int n = arr.length;
        int i=0;
        int j=0;
        int k=0;
        while(i<nums1.length&&j<nums2.length){
            if(nums1[i]<nums2[j]){
                arr[k]=nums1[i];
                i++;
                k++;
            }
            else{
                arr[k]=nums2[j];
                j++;
                k++;
            }
        }
        while(i<nums1.length){
            arr[k]=nums1[i];
            i++;
            k++;
        }
        while(j<nums2.length){
            arr[k]=nums2[j];
            j++;
            k++;
        }
        double ans =0.0;
        int mid = n/2;
        if(n%2==0){
            
            ans=(double)(arr[mid]+arr[mid-1])/2;
        }
        else
            ans = arr[mid];
        return ans;
    }
    public static int secondSmallest(int[] nums){
        int small=Integer.MAX_VALUE;
        int second_smallest = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<small){
                second_smallest = small;
                small=nums[i];
                
            }
            else if(nums[i]<second_smallest&&nums[i]!=small){
                second_smallest=nums[i];
            }
        }
        return second_smallest;
    }
}