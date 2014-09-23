
public class Solution1_week3 {
	
	//Definition for binary tree
	 public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	 
	public class Solution {
    public int minDepth(TreeNode root) {
        

	      	
	      	if(root == null)
	      	return 0;
	      	
	      	if(root.left==null&&root.right==null)
	      		return 1;
	      	
	      //	return min(minDepth(root.left),minDepth(root.right))+1; this is wrong. 
	      	
	    	 if(root.left==null){
            return 1+minDepth(root.right);
        }else if(root.right==null){
            return 1+minDepth(root.left);
        }else
            return 1+min(minDepth(root.left), minDepth(root.right)); 
	        
	    }

		private int min(int minDepth, int minDepth2) {
			// TODO Auto-generated method stub
			return minDepth>=minDepth2? minDepth2:minDepth;
			
		}
	}
}
