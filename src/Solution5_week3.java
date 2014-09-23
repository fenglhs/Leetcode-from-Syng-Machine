import java.util.ArrayList;


// 这道理我犯过同一个错误两次！ 就是把obejct 赋值给另一个 object，然后clear第一个object，孰不知第二个因为指着同一个object，也跟着clear了。
// 解决办法可以用clone。
//本体思路是建立三个queue，第一个queue存当前level的所有node，第二个queue存所有下一个level的node。
//依次取出第一个queue里的node value加入第三个queue。第三个queue加入result，代表当前level的值。
//接着第二个queue变成第一个，原第一个queue清零当作新的第二个queue。
//如此循环，一直到当前level没有child。

public class Solution5_week3 {
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	}
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<TreeNode> queue1 = new ArrayList<TreeNode>();
		ArrayList<TreeNode> queue2 = new ArrayList<TreeNode>();
		ArrayList<Integer> level = new ArrayList<Integer>();
		if(root == null)
			return result;
		
	//	result.add(new ArrayList<Integer>(root.val));
		
		queue1.add(root);
		int count1 = 1;
		int count2 = 0;
		int index=0;
		
		while (queue1.size()>0)
		{
			ArrayList<Integer> level2 = new ArrayList<Integer>();
			ArrayList<TreeNode> temp = new ArrayList<TreeNode>();
		while (index<queue1.size())
		{
			
			if(queue1.get(index).left!=null)
			     queue2.add(queue1.get(index).left);
			if(queue1.get(index).right!=null)
			     queue2.add(queue1.get(index).right);
			level.add(queue1.get(index).val);
		    index++;
		}
		level2 = (ArrayList<Integer>) level.clone();
		result.add(level2);
		level.clear();
		temp = queue1;
		queue1 = queue2;
		queue2 = temp;
		queue2.clear();
		index = 0;
		
		}
		
		return result;
		
		
		
		
		
	}
	
	public void test()
	{
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		root.left = left;
		
		ArrayList<ArrayList<Integer>> result = levelOrder(root);
	}
}
