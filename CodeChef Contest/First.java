import java.util.*;
class First{
	static void leftRotate(int arr[], int d, int n)
    {
        /* To handle if d >= n */
        d = d % n;
        int i, j, k, temp;
        int g= gcd(d, n);
        for (i = 0; i < g; i++) {
            /* move i-th values of blocks */
            temp = arr[i];
            j = i;
            while (true) {
                k = j + d;
                if (k >= n)
                    k = k - n;
                if (k == i)
                    break;
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }
    }
 
    /*UTILITY FUNCTIONS*/
 
    /*Function to get gcd of a and b*/
    static int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    for(int z=0;z<t;z++){
	        int n=sc.nextInt();
	        int[] arr = new int[n];
	        for(int i=0;i<n;i++){
	            arr[i]=sc.nextInt();
	            
	        }
	        int maxSum=arr[0]+arr[n-1];
	        for(int i=0;i<n;i++){
	        	leftRotate(arr,1,n);
	        	System.out.println(Arrays.toString(arr));
	        	int sum = arr[0]+arr[n-1];
	        	if(maxSum<sum)
	        		maxSum=sum;
	        }
	        System.out.println(maxSum);
	    }
	    
	}
}