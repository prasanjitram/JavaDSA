class MainDLL{
	public static void main(String[] ar){
		DLL list = new DLL();
		// list.insertFirst(10);
		// list.insertFirst(20);
		// list.insertFirst(15);
		// list.insertFirst(29);
		list.insertLast(34);
		list.display();
		System.out.println(list.size);
	}
}