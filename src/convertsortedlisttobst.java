
public class convertsortedlisttobst {

// 如果是数组会很简单。 队列稍微麻烦点。 需要运用递归。
	

 // Definition for singly-linked list.
 public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; next = null; }
  }
 

 // Definition for binary tree
 public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
 
static ListNode head;
    public TreeNode sortedListToBST(ListNode head) {
    	
    if (head == null) return null;
    this.head = head;
    
    int len = 0;
    ListNode ln = head;
    while (ln!=null)
    {
    	len++;
    	ln = ln.next;
    }
    
    return sortedListToBST(0,len-1);
           
    }
    
    public TreeNode sortedListToBST(int start, int end)
    {
    	if(start > end)
    		return null;
    	
    	int mid = (start + end)/2;
    	
    	//build left tree
    	TreeNode left = sortedListToBST(start, mid-1);
    	//build root node
    	TreeNode root = new TreeNode(head.val);
    	
    	root.left = left;
    	
    	head = head.next;
    	root.right = sortedListToBST(mid+1, end);
    	
    	return root;
    	
    	
    }
}