




public class Solution9_week3 {
	
	
	TreeNode first;    
    TreeNode second;
    TreeNode prev;
    int status;
    
    public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	}
    
	public void recoverTree(TreeNode root)
	{
		first=null;
        second=null;
        prev=null;
        status=0;

	    rec(root);
	    
	    if(first!=null && second!=null)
	    {
	        int temp = first.val;
	        first.val = second.val;
	        second.val = temp;
	    }
	}	
	

	
	void rec(TreeNode node){
		if (status == 2 || node == null)
			return;
		rec(node.left);
		
		if(prev!=null && prev.val>node.val && status == 0)
		{
			status = 1;
			first = prev;
			second = node;
		}
		
		else if(prev!=null && status == 1 && prev.val > node.val)
		{
			status = 2;
			second = node;
		}
		
		prev = node;
		rec(node.right);
		
		}
}


/*	 public void recoverTree(TreeNode root) {
	     
		 realroot = root;
		 checkTreeforFirstNode(root);
		 
		 if (node1 == null)
		 {
			 System.out.println("Can't find problem. This tree is good!");
			 return;
		 }
		 
		 else
	     {
			 checkTreeforSecondNode(problemroot);
			 if(node2 == null)
				 node2 = problemroot;
			 
		 }
		 
		 if (node1!=null && node2!=null)
		 {
			 temp1 = node1;
			 node1 = node2;
			 node2 = temp1;
			 System.out.println(node1.val);
			 System.out.println(node2.val);
		 }
			 
		 else
			 System.out.println("Can't find those two nodes that were swapped. Please check again!");
		 
		 
	    }
	 
	 public boolean checkTreeforFirstNode(TreeNode root)
	 {
		 temp1 = root;
		 if (temp1.left.val>root.val)
		 {
			 node1 = temp1.left;
			 
			 problemroot = realroot;
			 
			 if(temp1.val<problemroot.val)
			 {
				 while (temp1.val<realroot.val)
			 		 problemroot = problemroot.left;
			 }    
			 
			 else if(temp1.val>realroot.val)
			 {
				 while (temp1.val>realroot.val)
			 		 problemroot = problemroot.right;
			 }
			 return true; 	 
		 
		 }
		 
		 if(node1 == null)
			  checkTreeforFirstNode(temp1.left);
		 if(node1 == null)
			  checkTreeforFirstNode(temp1.right);
		  
		 return false;
	 }
	 
	 public boolean checkTreeforSecondNode(TreeNode root)
	 {
		 temp2 = root.right;
		 if (temp2.val<root.val)
		 {
			 node2 = temp2;
			  
			 return true; 	 
		 
		 }
		 
		 if(node2 == null)
			  checkTreeforFirstNode(temp2.left);
		 if(node2 == null)
			  checkTreeforFirstNode(temp2.right);
		  
		 return false;
		 
		
	 }
	

}
*/
