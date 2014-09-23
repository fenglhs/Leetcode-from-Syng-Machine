

// pre-order, 先保存右支，接着flatten左支，然后接上右支（这里要用一个指针从当前root一直找到末端）
//一遍无bug通过。:) 3/21/2014
public class FlattenBinaryTreetoLinkedlist {
	
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	}
	

	
	 public void flatten(TreeNode root) {
		 
		  if(root == null)
			  return;
		  
		  TreeNode temp = new TreeNode(0);
		  if (root.right != null)
		  {
			  temp = root.right;
			  flatten(temp);
		  }
		  else 
			  temp = null;
		  if(root.left != null)
		  	  flatten(root.left);
		
		  root.right = root.left;
		  root.left = null;
		  
		  TreeNode current = new TreeNode(0);
		  current = root;
		  while(current.right != null)
			  current = current.right;
		  
		  current.right = temp;
		  		  

		 
	        
	    }

	 
}