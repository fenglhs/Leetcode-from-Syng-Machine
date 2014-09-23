
// 一次通过。:) 两个指针，一个用于记录当前排序到的位置，另一个用于找插入位置。

public class InsertSortList {
	
	 public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; next = null; }
	  }

    public ListNode insertionSortList(ListNode head) {
    	
    	if(head == null)
    		return head;
    	if(head.next == null)
    		return head;
    	
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	
    	ListNode current = new ListNode(0);
    	ListNode current2 = new ListNode(0);
    	current = head;
    	ListNode temp = new ListNode(0);
    	
    	while(current.next!=null)
    	{
    		if(current.next.val > current.val)
    			current = current.next;
    		else
    		{
    			temp = current.next;
    			current.next = current.next.next;
    			current2 = dummy;
    			
    			while(current2.next.val<temp.val)
    				current2 = current2.next;
    			temp.next = current2.next;
    			current2.next = temp;
    			
    		}
    			
    	}
    	
    		
        return dummy.next;
    }
}
