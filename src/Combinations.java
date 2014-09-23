import java.util.ArrayList;

public class Combinations {

    public ArrayList<ArrayList<Integer>> combine(int n, int k) {

    	ArrayList<ArrayList<Integer>> cur = new ArrayList<ArrayList<Integer>>();
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> row = new ArrayList<Integer>();
    	if(n == 0 || k == 0 || k>n)
    		return res;
    	
    	if(n == k)
    	{
    		for (int i = 1; i<=n; i++)
    			row.add(i);
    		res.add(row);
    		return res;
    	}
    	
    	else
    		helper(cur, res, n, k, 0);
    	
    	
        return res;	
    }
    
    public void helper(ArrayList<ArrayList<Integer>> cur, ArrayList<ArrayList<Integer>> res, int n, int k, int c)
    {
    	
    	if(c==k)
        {
            return;
    	}
        res.clear();
    	
    	int endnumber = 0;
    	
    	if(c == 0)
    	{
    		ArrayList<Integer> temp = new ArrayList<Integer>();
    		cur.add(temp);
    	}
    	for(int i = 0; i<cur.size(); i++)
    	{
    		ArrayList<Integer> temp = new ArrayList<Integer>();
    		if(cur.size()>0)
    		{
    			temp = cur.get(i);
    			if(temp.size()>0)
    				endnumber = temp.get(temp.size()-1);
    			else 
    				endnumber = 0;
    		}
    		
    		else 
    			endnumber = 0;
    		
    		for(int j = endnumber+1; j<=n; j++)
    		{
    			temp.add(j);
    			ArrayList<Integer> newtemp = new ArrayList<Integer>(temp);
    			res.add(newtemp);
    			temp.remove(temp.size()-1);
    		}  		
    		
    	}
    	
    	cur = (ArrayList<ArrayList<Integer>>) res.clone();
    	    	
    	helper(cur, res, n, k, c+1);
    	
    }
    
    public void test()
    {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	res = combine(3,2);
    }
    

}
