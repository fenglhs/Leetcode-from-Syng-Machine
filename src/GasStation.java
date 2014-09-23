// 这题简单，gas[i] - cost[i] 就是当前加油站到下一个能存下的油，少于0就说明不行。

/*我是一个一个station作为start去尝试，后来想其实没必要，因为假如一旦有一个route走不通，
我们重新开始的station应该是我们中断的下一个，因为前面的任何一个开始都不会可以，可以证明出来
不细说了，自己想想就可以知道。
*/
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
    	
    	
    	if(gas == null || cost == null)
    		return -1;
    	
    	if(gas.length != cost.length || gas.length == 0)
    		return -1;
    	
    	
    	int sum = 0;
    	for(int i = 0; i<gas.length; i++)
    	{
    		sum = gas[i] - cost[i];
    		
    		if(sum < 0)
    			continue;    		
    		for (int j = i+1; j<gas.length; j++)
    		{
    			sum = sum + gas[j]-cost[j];
    			if(sum < 0)
    			{
    				i = j;        // any number between original i and j won't work, so set i to j.
    				break;
    			}
    		}
    		
    		if(sum >= 0)
    		{
    			for(int j = 0; j<i;j++)
    			{	sum = sum + gas[j]-cost[j];
        			if(sum < 0)
        				break;
    			}
    		}
    		
    		if(sum>=0)
    			return i;
    	}
    		
    	return -1;
    	
        
    }
}