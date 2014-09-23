import java.util.Arrays;

//http://www.programcreek.com/2013/02/leetcode-3sum-closest-java/


public class Threesumclosest {
	
    public int threeSumClosest(int[] num, int target) {
    	
    	if (num == null || num.length < 3)
    		return 0;
    	
    	int result = 0;
    	      	int min = Integer.MAX_VALUE;
      	Arrays.sort(num);
    	
    	for(int i = 0; i<num.length; i++)
    	{
    		int j = i+1;
		    int k = num.length-1;
    		while (j<k)
    		{  		
    		    int sum = num[i] + num[j] + num[k];
    		    int diff = Math.abs(sum - target);
				if (diff < min)
				{
				    result = sum;
				    min = diff;
				}
    	        
    	        if(sum <= target)
    	        	j++;
    	        else 
    	        	k--;
    		}
    	}
    	
    	return result;
        
    }
}