import java.util.ArrayList;
import java.util.Stack;




public class Binarytreepostorder {

	 public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	}
	  public ArrayList<Integer> postorderTraversal(TreeNode root) {
	      
		  if(root == null)
			  return null;
		  
		  ArrayList<Integer> result = new ArrayList<Integer>();
		  
		  Stack<TreeNode> path = new Stack<TreeNode>();
		  
		  path.add(root);
		  
		 
		  
		  //first build path.
		  TreeNode lastnode = new TreeNode(0);
		  
		  while(path.size()>0)
		  {
			  TreeNode currentroot = new TreeNode(0);
		
			  currentroot = path.peek();
			  
			  if(currentroot.left == null && currentroot.right == null)
			  {
				  result.add(currentroot.val);
				  lastnode = currentroot;
			  	  path.pop();
			  	  continue;
			  }
			  

			  else if(currentroot.left!=null && lastnode!=currentroot.left && lastnode != currentroot.right)
			  {
				  path.add(currentroot.left);
				  continue;
			  }
			  
			  else if(currentroot.right!=null && lastnode != currentroot.right)
			  {
				  path.add(currentroot.right);
				  continue;
			  }
			  
			  else if(currentroot.right == lastnode && lastnode!=null)
			  {
				  lastnode = path.pop();
				  result.add(lastnode.val);
				  continue;
			  }
			  
			  else if(currentroot.left == lastnode && currentroot.right == null)
			  {
				  lastnode = path.pop();
				  result.add(lastnode.val);
				  continue;
			  }
			  
			  
			  
			  
		  }
		  
		  
		  
		  
		  
		  
		  return result;
		  
	    }
	  
	  
	  void test()
	  {
		  TreeNode node1 = new TreeNode(1);
		  TreeNode node2 = new TreeNode(2);
		  
		  node1.left = node2;
		  ArrayList<Integer> result = postorderTraversal(node1);
		  
	  }
	}