import java.util.HashSet;
import java.util.Hashtable;


public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
    	
    	Hashtable<Character, Integer> table = new Hashtable<Character, Integer>();
    	
    	int i = 0;
    	int max = 0;
    	int current = 0;
    	int start = 0;
    	while(i<s.length())
    	{
    		if(!table.contains(s.charAt(i)))
    		{
    			table.put(s.charAt(i),i);
    			current++;  
    			i++;
    		}
    		
    		else
    		{
    			start = table.get(s.charAt(i))+1;
    			table.put(s.charAt(i), i);
    			    			
    			max = Math.max(max, current);
    			current = i - start + 1;
    			i++;
    		}
    	}
        
    	return Math.max(current, max);
    }
    

}