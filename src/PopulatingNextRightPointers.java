
public class PopulatingNextRightPointers {
	
	public class TreeLinkNode {
		      int val;
		      TreeLinkNode left, right, next;
		      TreeLinkNode(int x) { val = x; }
		  }
	
     public void connect(TreeLinkNode root) {

    	 TreeLinkNode parent;
    	 TreeLinkNode current;
    	 TreeLinkNode first = null;
    	 
    	 parent = root;
    	 
    	 if(root == null)
    		 return;
    	 
    	 parent.next = null;
    	     	 
         first = findfirstchild(parent);

	 
        	 
    	 while(first != null)
    	 {
    		
    		 current = first;
    		 
    		 while(current!=null)
    		 {
    			current.next = findnextchild(parent, current);
    			current = current.next;
    			   				 
    		 }
    		 
    		 parent = first;
    		 
    		 
    		 first = findfirstchild(parent);  		 
    		 
    	 }
    	 
    	   	 
    	 
     }
     
     public TreeLinkNode findfirstchild(TreeLinkNode parent)
     {
    	 TreeLinkNode first = new TreeLinkNode(0);
    	 while(parent != null)
    	 {
    		 if(parent.left!=null)
    	 
    		 {
    			 first = parent.left;
    			 return first;
    		 }
    		 
    		 if(parent.right!=null)
    		 {
    			 first = parent.right;
    			 return first;
    		 }
    		 parent = parent.next;
    	 }
    	 return null;
     }
     
     public TreeLinkNode findnextchild(TreeLinkNode parent, TreeLinkNode first)
     {
    	 TreeLinkNode second = new TreeLinkNode(0);
    	 
    	 while (parent!=null)
    	 {
    		 if(parent.left == first)
    			 break;
    		 if(parent.right == first)
    			 break;
    		 parent = parent.next;
    	 }
    	 
    	 
    	 while(parent != null)
    	 {
    		 if(parent.left!=null && parent.left != first )
    	 
    		 {
    			 second = parent.left;
    			 return second;
    		 }
    		 
    		 if(parent.right!=null && parent.right != first)
    		 {
    			 second = parent.right;
    			 return second;
    		 }
    		 parent = parent.next;
    	 }
    	 return null;
    	 
     }
     
}


