class CustomStack{
	int[] arr;
	private int ptr=-1;
	//private int size;
	private static int DEFAULT_SIZE=10;
	public CustomStack(){
		this(DEFAULT_SIZE);
	}
	public CustomStack(int size){
		this.arr= new int[size];
	}
	public void push(int val){
		//ptr++;
		if(isFull()){
			System.out.println("Stack is full");
			//ptr--;
			return;
		}
		ptr++;
		arr[ptr]=val;
	}
	public int pop(){
		return arr[ptr--];
	}
	public boolean isFull(){
		//ptr++;
		if(ptr==arr.length-1){
			return true;
		}
		return false;
	}
}