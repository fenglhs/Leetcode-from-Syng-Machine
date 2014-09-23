
// 递归，先算n-1的情况，由n-1的结果推出n的结果，
// 对于n-1的string，从后往前分析。
public class CountandSay {
	
public String countAndSay(int n) {
	return helper(n);
}

public String helper(int n){

	if (n<=0)
		return "";
	
	if (n == 1)
		return "1";
	
	String temp = helper(n-1);
	
	StringBuilder res = new StringBuilder();
	
	int i = temp.length()-1;
	
	int count = 1;
	
	while(i>=0)
	{
		if(i == 0)
		{
			res.insert(0, temp.charAt(i));
			res.insert(0, Integer.toString(count));
			break;
		}
		while(temp.charAt(i-1)==temp.charAt(i))
		{
			count++;
			i--;
			if(i==0)
			{
				
		//		res.insert(0, temp.charAt(i));
			//	res.insert(0, Integer.toString(count));
				break;
			}
		}
		res.insert(0, temp.charAt(i));
		res.insert(0, Integer.toString(count));
		
		count = 1;
		i -- ;
	
	}
	
	return res.toString();     
    
}


  public void test()
  {
	  String res = countAndSay(4);
	  
	  System.out.println(res);
  }
}
