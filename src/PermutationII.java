import java.util.ArrayList;
import java.util.Arrays;

//这题可以利用原来NextPermutation的code，但不确定这么做是否efficient.
// http://yucoding.blogspot.com/2013/04/leetcode-question-70-permutations-ii.html
// 参考上面这个link，算法比较neat.

public class PermutationII {
	 public ArrayList<ArrayList<Integer>> permuteUnique2(int[] num) {
	     
		 ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		 
		 ArrayList<Integer> ans = new ArrayList<Integer>();
		 Arrays.sort(num);
			
		 res = helper(num, num.length-1);
		 return res;

	 }
	 
	 public ArrayList<ArrayList<Integer>> helper(int[] num, int end)
	 {
		 ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		
		 ArrayList<ArrayList<Integer>> lastres = new ArrayList<ArrayList<Integer>>();
		 
		 ArrayList<Integer> temp = new ArrayList<Integer>();
		 if(num.length == 0 || end<0)
			 return res;
		 
		 if(end == 0)
		 {
			temp.add(num[0]);
			res.add(temp);
			return res;
		 }
		 
		 lastres = helper(num, end-1);
		 
		 for(ArrayList<Integer> lastans : lastres)
		 {
			 
			 if(num[end]!=num[end-1])
			 {
				 for(int i=0; i<=lastans.size(); i++)
				 {
					 ArrayList<Integer> ans = new ArrayList<Integer>(lastans);
					 ans.add(i, num[end]);
					 res.add(ans);					 
				 }
			 }
			 
			 if(num[end]==num[end-1])
			 {
				 ArrayList<Integer> ans = new ArrayList<Integer>(lastans);
				 ans.add(lastans.size(), num[end]);
				 res.add(ans);
				 if(lastans.get(lastans.size()-1)!=num[end])
				 {
					 ArrayList<Integer> ans2 = new ArrayList<Integer>(lastans);
					 ans2.add(0,num[end]);
					 res.add(ans2);				 
					 
				 }
				 
			 }
			 
			 
		 }
		 
		 
		 
		 
		 
		 return res;
		 
	 }
	 
	 public void test()
	 {
		 int[] num = {1,1,2,2,3,4,5,5};
		 ArrayList<ArrayList<Integer>> res =  permuteUnique(num);
		 
		 System.out.println(res.size());
		 
	 }
	 
	 
	    public void nextPermutation(int[] num) {
	        if(num.length<=1)
	            return;
	        int start = num.length-2;
	        int end = num.length-1;
	        
	        while(start>=0)
	        {
	            if(!isHighest(num, start, end))
	            {
	                helper(num, start, end);
	                return;
	            }
	            else
	                start--;
	        }
	        
	        reverse(num, 0, num.length-1);      
	      }
	    
	      public void helper(int[] input, int start, int end)
	    {
	        int temp = 0;
	        int i = start + 1;
	           while(i<=end){
	            if(input[i]>input[start])
	                i++;
	            else
	                break;
	              
	        }
	        
	        temp = input[start];
	        input[start] = input[i-1];
	        input[i-1] = temp;      
	        
	        reverse(input, start+1, end);
	    }
	    
	    public boolean isHighest(int[] input, int start, int end) 
	    {
	        if (input.length == 0 || start>end || end>=input.length || start<0)
	            return true;   
	        
	        else
	        {
	            for (int i = start; i<end; i++)
	            {
	                if(input[i]<input[i+1])
	                    return false;
	            }
	        }
	        return true;
	    }
	    
	    public void reverse(int[] input, int start, int end){
	        int temp = 0;
	        while(start<end)
	        {
	            temp = input[start];
	            input[start] = input[end];
	            input[end] = temp;
	            start++;
	            end--;
	        }
	    }
	   
		 public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		     
			 ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
			 
			 
			 Arrays.sort(num);
			
			 while(isHighest(num, 0, num.length-1)!=true)
			 {
				 ArrayList<Integer> ans = new ArrayList<Integer>();
				 for(int i = 0; i<num.length; i++)
					 ans.add(num[i]);
				 res.add(ans);
				 nextPermutation(num);
				 
			 }
			 ArrayList<Integer> temp = new ArrayList<Integer>();
			 for(int i = 0; i<num.length; i++)
				 temp.add(num[i]);
			 res.add(temp);
			 
			 return res;

		 }
	    
	  }
