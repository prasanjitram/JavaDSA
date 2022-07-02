import java.util.*;
class Playlist{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc= new Scanner(System.in);
		int t = sc.nextInt();
		for(int z=0;z<t;z++){
			int n = sc.nextInt();
			int x = sc.nextInt();
			int m = n/x;
			System.out.println(m/3);
		}
	}
}