import java.util.Arrays;

public class MathematicsCP {
    public static void main(String[] args) {
        boolean[] checkPrime= eratosthenes(20);
        System.out.println(gcd(24,60));
        
    }
    public static int gcd(int a,int b){
        if(b==0)
            return a;
        return gcd(b,a%b);
    }
    public static boolean[] eratosthenes(int n){
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        isPrime[0]=false;
        isPrime[1]=false;
        for(int i=2;i*i<=n;i++){
            for(int j=2*i;j<=n;j+=i){
                isPrime[j]=false;
            }
        }
        return isPrime;
    }
}
