import java.util.ArrayList;
import java.util.Arrays;

public class FourSum {
	 public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		 
 ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		 
		 
		 Arrays.sort(num);
		 
		 if(num == null)
			 return res;
		 if(num.length <=3)
			 return res;
		 int m = 0; int n = 0;
		 int sum = 0;
		 for(int i = 0; i<num.length-3; i++)
		 {
			 for(int j = num.length-1; j>i+2; j--)
			 {
				 m = i+1;
				 n = j-1;
				 while (m<n)
				 {
					sum = num[i] + num[j] + num[m] + num[n];
					if (sum == target)
					{
						ArrayList<Integer> can = new ArrayList<Integer>();
						can.add(num[i]); 
						can.add(num[m]);
						can.add(num[n]);
						can.add(num[j]);
						res.add(can);	
						m++;
						while(num[m] == num[m-1])
							m++;
						n--;
						while(num[n] == num[n+1])
							n--;
						
					}
					else if(sum<target)
					{
						m++;
						while(num[m] == num[m-1])
							m++;
					}
					else
					{
						n--;						
						while(num[n] == num[n+1])
							n--;
					}		
				 }
				  
				 
			 }
		 }
		 return res;
	        
	    }
	}