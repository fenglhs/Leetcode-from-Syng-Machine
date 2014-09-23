// Given a binary tree, determine if it is height-balanced. 

// For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 


public class balancedbinarytree {
	
	boolean balanced = true;
	
	 public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	}
	 
	
     public boolean isBalanced(TreeNode root) 
     {
    	 if(balanced == false)
    		 return false;
    	 if(root == null)
    		 return true;
    	 if(root.left == null && root.right == null)
    		 return true;
    	 
    	
    	 int left = getHeightofTree(root.left);
    	 int right = getHeightofTree(root.right);
    	 
    	 if(Math.abs(left-right)>1)
    	     return false;
    	 
    	 if(isBalanced(root.left) && isBalanced(root.right) )
    			 return true;
     	 
    	 
    	 
    	 
    	 return false;
     }
	 
     public int getHeightofTree(TreeNode root)
     {
    	 if (root == null) return 0;

    	    return Math.max(getHeightofTree(root.left), getHeightofTree(root.right)) + 1;

    	 
     }
    

}
