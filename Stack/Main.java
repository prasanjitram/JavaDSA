class Main{
	public static void main(String[] ar){
		//CustomStack ds = new CustomStack(5);
		// ds.push(56);
		// System.out.println("First added");
		// ds.push(54);
		// ds.push(57);
		// ds.push(53);
		// ds.push(52);
		// ds.push(60);
		// ds.push(34);
		// System.out.println(ds.pop());
		// System.out.println(ds.pop());
		// System.out.println(ds.pop());
		// System.out.println(ds.pop());
		// System.out.println(ds.pop());
		DynamicStack ds = new DynamicStack(5);
		ds.push(54);
		ds.push(57);
		ds.push(53);
		ds.push(52);
		ds.push(60);
		ds.push(34);
		System.out.println(ds.pop());
		System.out.println(ds.pop());
		System.out.println(ds.pop());
		System.out.println(ds.pop());
		System.out.println(ds.pop());
		System.out.println(ds.pop());

	}
}