class HappyNumber{
	public static void main(String[] ar){
		HappyNumber num= new HappyNumber();
		System.out.println(num.	isHappy(2));
	}
	public boolean isHappy(int n){
		int fast=n;
		int slow=n;
		do{
			slow= sum(slow);
			fast=sum(sum(fast));

		}while(slow!=fast);
		if(slow==1)
			return true;
		return false;
	}
	public int sum(int n){
		int sum=0;
		while(n>0){
			int digit=n%10;
			sum= sum+(digit*digit);
			n/=10;
		}
		return sum;
	}
}