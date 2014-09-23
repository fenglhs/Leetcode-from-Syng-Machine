import java.util.Arrays;

//http://yucoding.blogspot.com/2013/01/leetcode-question-43-longest-common.html

public class LongestCommonPrefix {

	  public String longestCommonPrefix(String[] strs) {
		  
		 if(strs == null||strs.length == 0)
			 return "";
		 
		 StringBuilder str = new StringBuilder(strs[0]);
		 
		 int i;
		 
		 for(i = 0; i<str.length(); i++)
		 {
			 boolean fl = true;
			 for (int j = 0; j<strs.length; j++)
			 {
				 if(i>=strs[j].length())
					 break;
				 if(strs[j].charAt(i)!=str.charAt(i))
				 {
					 fl = false;
					 break;
				 }
			 }
			 if (fl ==false) 
				 return str.substring(0,i);
		 }
		 return str.substring(0,i);
	  }	
}
