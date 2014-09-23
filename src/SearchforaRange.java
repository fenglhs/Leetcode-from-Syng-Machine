import java.util.ArrayList;

// 二分法，找到之后分别往前往后找。


public class SearchforaRange {

    public int[] searchRange(int[] A, int target) {
        
    	ArrayList<Integer> temp = new ArrayList<Integer>();
    	int[] res = {-1, -1};
    	if(A == null || A.length == 0)
    		return res;
    	
    	if(target > A[A.length-1] || target < A[0])
    		return res;
    	
    	int start = 0; 
    	int end = A.length-1;
    	int mid = (start+end)/2;
    	
    	if(start == end && A[0] == target)
    	{
    		int[] newres = {0,0};
    		return newres;
    	}
    	
    	while(start <= end)
    	{
    		mid = (start+end)/2;
    		if (target == A[mid])
    		{
    			temp.add(mid);
    			break;
    		}
    			
    		else if (target > A[mid])
    			start = mid + 1;
    		
    		else 
    			end = mid - 1;
    	}

    	if(temp.isEmpty() == true)
    		return res;
    	else
    	{
    		int i = mid;
    		
    		while(i>=start+1 && A[i-1] == target)
    			i --;
    		start = i;
    		while(i<=end-1 && A[i+1] == target)
    			i ++;
    		end = i;
    		
    		int[] newres = {start, end};
    		return newres;
    	}
    	
   
    }
    
 	public void test()
	{
 		int[] data = {1,4};
 		
		int[] res = searchRange(data,4);
		
		System.out.println(res[0]);
		System.out.println(res[1]);	
		
	}

}