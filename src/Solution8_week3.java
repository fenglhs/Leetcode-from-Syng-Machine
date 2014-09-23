
public class Solution8_week3 {
	 public int numTrees(int n) {
	     
		 int res = 0;
		 
		 if (n==0)
			 return 0;
		 if (n==1)
			 return 1;
		 int left = 0;
		 int right = 0;
		 
		 for (int i = 1; i<=n; i++)
		 {
			 left = numTrees(i-1);
			 right = numTrees(n-i);
			 
			 if (left == 0)
				 res+=right;
			 else if (right == 0)
				 res+=left;
			 else 
				 res+=left*right;
		 }
		 	 
		 
		 return res;
	    }

}
