import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

//我的做法貌似和水印不谋而合。就是用HashMap，感觉不难。

//S: "barfoothefoobarman"
// L: ["foo", "bar"] 

//You should return the indices: [0,9].

public class SubstringwithConca {
	 public ArrayList<Integer> findSubstring(String S, String[] L) {
	  
		 ArrayList<Integer> res = new ArrayList<Integer>();
		 if(S==null || L==null)
			 return res;
			 
		 HashMap<String, Integer> lib = new HashMap<String, Integer>();
		 
		 int[] record = new int[L.length];
		 
		 for(int i=0; i<L.length; i++)
		 {
			 if(lib.containsKey(L[i]))
			 {
				 lib.put(L[i], lib.get(L[i])+1);
				
			 }
			 else
				 lib.put(L[i], 1);
		 }
		 
		 int length = L[0].length();
		 
		 if(S.length()<length*L.length)
			 return res;
		 
		 int i = 0;
		 
		 while(i<=S.length()-length*L.length)
		 {
			 HashMap<String, Integer> templib = (HashMap<String, Integer>) lib.clone();
			 if(isValid(S, L, i, templib))
			 {
				 res.add(i);
				 i = i + length*L.length;
			 }
			 else
				 i++;
			 
		 }
		 
		 return res;	 
		 
	    }
	 
	 public boolean isValid(String s, String[] L, int start, HashMap<String, Integer> lib)
	 {
		 int length = L[0].length();
		 for(int i=0; i<L.length; i++)
		 {
			 String temp = s.substring(start+i*length, start+(i+1)*length);
			 if(lib.containsKey(temp) && lib.get(temp)>1)
				 lib.put(temp, lib.get(temp)-1);
			 else if(lib.containsKey(temp) && lib.get(temp)==1)
				 lib.remove(temp);
			 else
				 return false;
		 }
				
		 return true;		 
		 
	 }
	 
	 public void test()
	 {
		 String s = "a";
		 String[] L = {"a"};
		 
		 ArrayList<Integer> b = findSubstring(s,L);
		 System.out.println(b.size());
	 }

}
