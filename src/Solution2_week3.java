



public class Solution2_week3 {
	
	 public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  	public boolean isLeaf()
		{
			return left==null||right==null;
		}
	 }
	 
	public boolean isSymmetric(TreeNode root) {
		
		   
   	    if (root == null)
   	    return true;
   	    
   	    if (root.left==null&&root.right==null)
   	         return true;
   	    else if (root.left==null||root.right==null)
   	         return false;
		
		return isSymmetric(root.left, root.right);
	}
	
	public boolean isSymmetric(TreeNode n1, TreeNode n2)
	{
		if(n1 == null&&n2==null)
		    return true;
		else if(n1 == null||n2==null)
			return false;
		if (n1.val!=n2.val)
		    return false;
		if((n1.left==null&&n1.right==null)&&(n2.left==null&&n2.right==null))  //can also use function isLeaf();
			return n1.val==n2.val;
		
		boolean isSymOutside = false;
		boolean isSymInside = false;
		
		isSymOutside = isSymmetric(n1.left, n2.right);
		isSymInside = isSymmetric(n1.right, n2.left);
		return isSymOutside&&isSymInside;
	}
}
