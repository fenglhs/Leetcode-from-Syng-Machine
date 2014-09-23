


public class Solution6_week3 {
	
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	}
public TreeNode buildTree(int[] preorder, int[] inorder) {
	
	      TreeNode root = new TreeNode(preorder[0]);
	      TreeNode current = root;
	      TreeNode currentparent = root;
	      
	      int i = 1;
	      
	      while (preorder[i]<preorder[i-1])
	      {
	    	  TreeNode temp = new TreeNode(preorder[i]);
	    	  current.left = temp;
	    	  currentparent = current;
	    	  current = temp;
	    	  i++;
	      }
	      
	      if (preorder[i]<preorder[0])
	      {
	    	  TreeNode another = new TreeNode(preorder[i]);
	    	  currentparent.right = another;
	    	  current = another;
	    	  i++;
	      }
	      
	      
	      while (preorder[i]<preorder[0])
	      {
         	  TreeNode next = new TreeNode(preorder[i]);
	          if (preorder[i]<preorder[i-1])
	        	  current.left = next;
	          else if (preorder[i]>preorder[i-1])
	      
	      
	      
	      
	      return root;
        
    }
		return root;
	      

}

}

