import java.util.*;
class Rating{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int z=0;z<t;z++){
			int x= sc.nextInt();
			int k= sc.nextInt();
			if(k>0&&(k-x)<=200&&(k-x)>=0){
				System.out.println("YES");

			}
			else
				System.out.println("NO");
		}
	}
}