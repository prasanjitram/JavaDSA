class Kaden{
    public static void main(String[] args) {
        int sum =0;
        int[] arr={-2,-3,4,-1,-2,1,5,-3};
        int maxSum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum<0){
                sum=0;
            }
            else{
                if(maxSum<sum){
                    maxSum=sum;
                }
            }
        }
        System.out.println(maxSum);
    }
}