
//先简单比较左值是否大于根值，右值是否小于根值
//然后找出左树种最大值 和 右数中最小值再与根值比较

public class Solution4_week3 {

	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	}
	
    public boolean isValidBST(TreeNode root) {
    	
    	boolean isValid = false;
    	
    	if(root == null)
    		return true;
    	else if(root.left==null && root.right==null)
    		return true;
    	
    	if(root.left!=null)
    	{
    		if(root.left.val >= root.val)
    			return false;
    		else
    			isValid = isValidBST(root.left);
    		if (isValid == false)
    			return false;
    	}
    	
    	if(root.right!=null)
    	{
    		if(root.right.val <= root.val)
    			return false;
    		else
    			isValid = isValidBST(root.right);
    		if (isValid == false)
    			return false;
    		
    	}
    	
    	int leftMax = root.val-1;
    	int rightMin = root.val+1;
    	
    	TreeNode node1 = root.left;
    	TreeNode node2 = root.right;
    	
    	while(node1!=null)
    	{
    		leftMax = node1.val;
    		node1 = node1.right;
    	}
    	
    	while(node2!=null)
    	{
    		rightMin = node2.val;
    		node2 = node2.left;
    	}
    	
    	if(leftMax >= root.val)
    		return false;
    	else if (rightMin <= root.val)
    		return false;
    	else 
    		return true;
    
    	
    }
}