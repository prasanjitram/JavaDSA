public class HalfPrime {
    public static void main(String[] args) {
        System.out.println(isHalfPrime(45));
    }
    public static boolean isHalfPrime(int n){
        for(int i=1;i<n;i++){
            System.out.println(i+" "+(n-i));
            if(isSemiPrime(i)&&isSemiPrime(n-i))
            return true;
        }
        return false;
    }
    public static boolean isSemiPrime(int n){
        int cnt=0;
        for(int i=2;cnt<2&&i*i<=n;i++){
            while(n%i==0){
                n/=i;
                ++cnt;
            }
        }
        if(n>1)
            ++cnt;
        if(cnt==2)
        return true;
        return false;
    }
}
