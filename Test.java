class Test{
	public static void main(String[] ar){
		int count =0;
		System.out.println(getLucky("avzdbcvvxusa",5));
		
	}
	public static int getLucky(String s, int k) {
        String str="";
        for(int i=0;i<s.length();i++){
        	
        	int digit = s.charAt(i)-96;
        	System.out.println(digit);
            str=str+digit;
        }
        //System.out.println(str.trim());
        long num = Long.parseLong(str);
        System.out.println(num);
        int sum=0;
        for(int i=0;i<k;i++){
        	System.out.println("HI");
            int tmp=num;
            while(tmp!=0){
                int digit = tmp%10;
                sum=sum+digit;
                tmp/=10;
            }
            num=sum;
            sum=0;
            
        }
        return num;
    }
}