public class LL{
	public class Node{
		public int value;
		public Node next;
		public Node(int val){
			value=val;

		}
		public Node(int val, Node node){
			value=val;
			next=node;
		}
	}
	Node head;
	private Node tail;
	int size;
	public LL(){
		this.size=0;
	}
	int getValue(Node node){
		return node.value;
	}
	
	void displayTail(){
		System.out.println("Tail= "+tail.value);
	}
	void displayHead(){
		System.out.println("Head= "+head.value);
	}

	void display(){
		Node temp = head;
		//System.out.println(head.value);
		while(temp!=null){
			//System.out.println("Inside Loop");
			System.out.print(temp.value+" -> ");
			temp= temp.next;
		}
		System.out.println("END");
	}
	void insertFirstElement(int v){
		Node node = new Node(v);
		
		node.next=head;
		head=node;
		//System.out.println("Inserted"+head.value);
		if(tail==null){
			tail=head;

		}
		size+=1;

	}
	void insertLast(int val){
		if(tail==null){
			insertFirstElement(val);
		}
		else{
			Node node = new Node(val);
			tail.next=node;
			tail=node;
			if(head==null){
				head=tail;
			}
			size+=1;
		}
	}
	void deleteFirst(){
		if(head==null)
			System.out.println("List is empty");
		head= head.next;
		size-=1;
	}
	void deleteLast(){
		if(tail==null){
			System.out.println("List is Empty");
			return;
		}
		tail=get(size-2);
		tail.next=null;
		size-=1;
	}
	void delete(int val){
		Node temp = head;
		if((temp.next).value!=val&&temp!=null){
			temp=temp.next;
		}
		temp.next=(temp.next).next;
		size-=1;


	}
	void insert(int val,int n){
		Node node = new Node(val);
		Node temp=head;
		for(int i=1;i<n;i++){
			temp=temp.next;
		}
		node.next=temp.next;
		temp.next=node;
		//tail=node;
		//node.next=null;
		size+=1;

	}
	Node getNode(int val){
		Node temp = head;
		while(temp.value!=val){
			temp=temp.next;
		}
		return temp;
	}
	public Node get(int index){
		Node temp = head;
		for(int i=1;i<=index;i++){
			temp = temp.next;
		}
		return temp;
	}
	public void keepDistinct(){
		Node dummy = new Node(0);
		Node node=head;
		dummy.next=head;
		Node prev = dummy;
		prev.next=node;
		int count=0;
		while(node.next!=null){
			if(node.value==node.next.value){
				node.next=node.next.next;
				count+=1;
			}
			else{
				if(count>0){
					prev.next=node.next;
					node=prev.next;
					count=0;
				}
				else{
					prev=node;
					node=node.next;
				}
			}
		}
		if(count>0){
			prev.next=node.next;
		}
		head= dummy;
	}
	// public LL merge(Node f,Node s){
	// 	Node head = new Node(0);
	// 	while(f!=null && s!= null){
	// 		if(f.value<s.value){
	// 			ans.insertLast(f.value);
	// 			f= f.next;
	// 		}else{
	// 			ans.insertLast(s.value);
	// 			s= s.next;
	// 		}
	// 	}
	// 	while(f!=null){
	// 		ans.insertLast(f.value);
	// 		f= f.next;
	// 	}
	// 	while(s!=null){
	// 		ans.insertLast(s.value);
	// 		s= s.next;
	// 	}
	// 	return ans;
	// }
	public Node getMid(){
		Node fast = head.next;
        Node slow = head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
	}
	// public void sortList(Node head){
	// 	if(head==null||head.next==null){
	// 		return head;
	// 	}
	// 	Node mid=getMid(head);
	// 	LL left = 
	// }
}