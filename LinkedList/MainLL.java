class MainLL{
	public static void main(String[] ar){
		LL list = new LL();
		LL list2 = new LL();
		list.insertLast(24);
		list.insertLast(11);
		list.insertLast(5);
		list.insertLast(22);
		list.insertLast(25);
		list.insertLast(26);
		list.insertLast(20);
		list.insertLast(6);
		list.insertLast(29);



		list.display();

		System.out.println(list.getMid().value);



	}
	// // //Reverse Linked List 2 LeetCode question
	// public ListNode reverseBetween(ListNode head, int left, int right) {
	// 	ListNode current = head;
	// 	ListNode prev = null;
	// 	for(int i=0;i<left-1&&current!=null;i++){
	// 		prev=current;
	// 		current=current.next;
	// 	}
	// 	ListNode next = new ListNode();
	// 	ListNode last = prev;
	// 	ListNode newEnd = current;
	// 	next=current.next;
	// 	for(int i=0;i<right-left+1&&current!=null;i++){
	// 		current.next=prev;
	// 		prev=current;
	// 		current=next;
	// 		if(next!=null)
	// 			next=next.next;

	// 	}
	// 	if(last!=null){
	// 		last.next=prev;
	// 	}else{
	// 		head=prev;
	// 	}
	// 	return head;  
 //    }

 //    //Pallindrome LinkedList
 //     public boolean isPalindrome(ListNode head) {
 //        if(head.next==null){
 //            return true;
 //        }
 //        ListNode mid = getMid(head);
 //        ListNode prev=head;
 //        while(prev.next!=mid){
 //        	prev=prev.next;
 //        }
 //        ListNode current=mid;
 //        if(current.next!=null){ 
 //        	ListNode last=prev;
 //        	ListNode newEnd = current;
 //        	ListNode next = current.next;
 //        	while(current!=null){
 //        		prev=current.next;
 //        		prev=current;
 //        		current=next;
 //        		if(next!=null)
 //        			next=next.next;

 //        	}
 //        	last.next=prev;
 //        	newEnd.next=null;
 //        	ListNode first =head;
 //        	ListNode second=mid;
 //        	while(first.next!=mid){
 //        		if(first.val!=second.val)
 //        			return false;
 //        	first=first.next;
 //        	second= second.next;
 //        	}
 //        }
 //        if(head.val!=mid.val)
 //        	return false;
        
 //        return true;

 //    }
 //    public ListNode getMid(ListNode head){
 //        ListNode fast = head;
 //        ListNode slow=head;
 //        while(fast!=null){
 //            fast=fast.next.next;
 //            slow=slow.next;
 //        }
 //        return slow;
 //    }

 //    //Reorder List
 //     public void reorderList(ListNode head) {
 //        ListNode first = head;
 //        ListNode mid = getMid(head);
 //        ListNode second = reverse(mid);
 //        while(first!=null&&second!=null){
 //        	ListNode temp = first.next;
 //        	first.next=second;
 //        	first=temp;

 //        	temp=second.next;
 //        	second.next=first;
 //        	second=temp;
 //        }
 //    }
 //    public ListNode reverse(ListNode head){
 //    	ListNode prev = null;
 //    	ListNode current = head;
 //    	ListNode next= head.next;
 //    	while(current!=null){
 //    		prev=current.next;
 //    		prev=current;
 //    		current=next;
 //    		if(next!=null)
 //    			next=next.next;
 //    	}
 //    	return prev;
 //    }
}