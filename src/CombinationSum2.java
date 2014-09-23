// 先排序，然后用for loop依次确定从第i位开始的集合。接着再用一个递归确定之后的位。 
// 一点需要注意，每次在调用 helper 之前， 判断下当前位是否和前一位重复。

import java.util.ArrayList;
import java.util.Arrays;


public class CombinationSum2 {
	 public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
	 
		 ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		 
		 ArrayList<Integer> can = new ArrayList<Integer>();
		 
		 if(num == null || num.length == 0)
			 return res;
		 Arrays.sort(num);
		 
		 for(int i = 0; i<num.length; i++)
		 {
		 	 can.clear();
		 	 if(i>0 && num[i] == num[i-1])
		 		 continue;
			 if(num[i]<=target)
			     helper(res, can, target, num, i);
		 }
		 
	     return res;
		 
	    }
	 
	 
	 public void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> can, int target, int[] num, int step)
	 {
		 if(step == num.length)
		 {
			// can.clear();
			 return;
		 }
		 if(target < num[step])
		 {
		//	 can.clear();
			 return;
		 }
		 if(target == num[step])
		 {
			 can.add(num[step]);
			 res.add(can);
//			 can = new ArrayList<Integer>();
			 return;
		 }
		 
		 else
		 {
			 for(int i = step+1; i<num.length; i++)
			 {
				 ArrayList<Integer> newcan = (ArrayList<Integer>) can.clone();
				 newcan.add(num[step]);
				 
				 if(i> step+1 && num[i] == num[i-1])
					 continue;
			     helper(res, newcan, target-num[step], num, i);	 
//			     System.out.println(res.get(res.size()).toString());
		 
			 }
		 }
	 }
	 
	 public void test()
	 {
		 int[] num = {1};
		 
		 ArrayList<ArrayList<Integer>> res = combinationSum2(num, 1);
		 
		 System.out.println(res.size());
		 
	 }
	}