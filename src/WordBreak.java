import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

//自己的方法超时，参考
//http://fisherlei.blogspot.com/2013/11/leetcode-word-break-solution.html

public class WordBreak {
	
	 public boolean wordBreak(String s, Set<String> dict) {
		 
		 String s2 = "#" + s;
		 int len = s2.length();
		 boolean[] possible = new boolean[len];
		 for(int i =0; i<len; i++)
			 possible[i] = false;
		 possible[0] = true;
		 
		 for(int i = 1; i<len; ++i)
		 {
			 for(int k = 0; k<i; ++k)
			 {
				
				 possible[i] = possible[k] && dict.contains(s2.substring(k+1, i+1));
				 if(possible[i]) break;
			 }
		 }
		 
		 return possible[len-1];
				 
		 
	 
}
	 public boolean wordBreak1(String s, Set<String> dict) {
	       if(s == null || dict == null)
			   return false;
		   if(dict.contains(s))
		       return true;
		   
		  
			   int j = 0;
			   while(j<s.length()&&dict.contains(s.substring(0, j+1)))
			   	   j++;
			   while(j>=0 && j<s.length())
			   {
				   if(dict.contains(s.substring(0, j)) && wordBreak1(s.substring(j,s.length()), dict))
					 return true;
				   else
					   j--;
			   }
		
		   return false;
	        
	    }
	 public void test()
	 {
		 String s = "a";
		 System.out.println(s.length()); 
		 Set<String> dict = new HashSet<String>();
	//	 dict.add("a");
		 dict.add("a");
//		 dict.add("aaa");
	
//		 dict.add("aaaaa");
		
		 boolean b = wordBreak(s, dict);
		 
		 System.out.println(b);
		 
		 
	 }
	

}
