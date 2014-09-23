
public class Solution3_week3 {
	 public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  	public boolean isLeaf()
		{
			return left==null||right==null;
		}

	    public boolean isSameTree(TreeNode p, TreeNode q) {
	    	
	    	if(p == null && q==null)
			    return true;
			else if(p == null||q==null)
				return false;
			if (p.val!=q.val)
			    return false;
			if((p.left==null&&p.right==null)&&(q.left==null&&q.right==null))  //can also use function isLeaf();
				return true;
			
			boolean isSameLeft = false;
			boolean isSameRight = false;
			
			isSameLeft = isSameTree(p.left, q.left);
			isSameRight = isSameTree(p.right, q.right);
			return isSameLeft && isSameRight;
	    }
	}
}