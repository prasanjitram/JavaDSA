class DLL{
	private Node head;
	private Node tail;
	int size;
	class Node{
		private Node next;
		private Node prev;
		private int value;
		public Node(int val){
			value=val;
		}
		public Node(int val, Node n,Node p){
			value=val;
			next=n;
			prev=p;
		}
	}
	public void display(){
		Node temp = head;
		//System.out.println(head.value);
		while(temp!=null){
			//System.out.println("Inside Loop");
			System.out.print(temp.value+" -> ");
			temp= temp.next;
		}
		System.out.println("END");
	}
	public void insertFirst(int val){
		Node node = new Node(val);
		node.next = head;
		node.prev=null;
		if(head!=null){
			head.prev=node;
		}
		head=node;
		//
		tail=head;
		size+=1;
	}
	public void insertLast(int val){
		if(head==null){
			insertFirst(val);
			return;
		}
		Node node = new Node(val);
		Node temp = head;
		while(temp.next!=null){
			temp=temp.next;
		}
		temp.next=node;
		node.prev=temp;
		node.next=null;
		size+=1;
	}
}