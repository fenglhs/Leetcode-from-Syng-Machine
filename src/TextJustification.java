//完全自己搞定！

//思路不难， 实现很tricky, 很多边角情况。
import java.util.ArrayList;


public class TextJustification {
    public ArrayList<String> fullJustify(String[] words, int L) {
	  ArrayList<String> res = new ArrayList<String>();
	   if(words == null)
		   return res;
	   if(words.length == 0)
		   return res;
	   if(L==0 && words!=null)
		{
		    res.add(words[0]);
		    return res;
		}
	   if(words.length == 1 && words[0].equals("") && L == 0)
	   {
		   res.add(words[0]);
		   return res;
	   }
	   
	   if(words.length == 1 && L>words[0].length())
	   {
		   addWordsLeft(0, 0, L, res, words);
		   return res;
	   }
	   
	   
	   
	   int l_words = 0;
	   int p_words = 0;
	   for(int i=0; i<words.length; i++)
		   p_words+=words[i].length();
	   
	   l_words = p_words + words.length-1;
	   
	   int n = 0;
	   
	   if(l_words%L == 0)
		   n = l_words/L;
	   else 
		   n = l_words/L+1;
	   
	   if(l_words-n+2 < (n-1)*L)
		   n--;
	   
	   int p_words_each_line = p_words/n;
	   if(p_words%n>0)
		   p_words_each_line++;
      int i = 0;
      
      int current_length = 0;
      int last = 0;
      
      if(n==1)
      {
   	   addWords(0, words.length-1, L, res, words);
   	   return res;
      }
      while(i<words.length)
      {
   	   if(i!=last)
   	   {
   		   current_length = current_length+words[i].length()+1;
   	   
   
   	       if(current_length>=L+1)
   	       {
   		       addWords(last, i-1, L, res, words);
   		       last = i;
   		       current_length = words[i].length();
   		   
   	       }
   	   }
   	   else 
   	   {
   		   current_length = words[i].length();
   		   if(current_length>L)
   			   return res;
   		   else if(current_length == L)
   		   {
   			    addWords(last, last, L, res, words);
   			    last = i+1;
   			    current_length = 0;
   		   }
   	   }
   	   i++;
      }
      addWordsLeft(last, i-1, L, res, words);
      
      return res;
   }
   
  public void addWords(int last, int end, int L, ArrayList<String> res, String[] words)
  {
	  if(end<last)
		  return;
	  if(last == end || end == words.length-1)
	   {
		   addWordsLeft(last, end, L, res, words);
		   return;
	   }
	   int words_length = 0;
	   for(int i=last; i<=end; i++)
		   words_length += words[i].length();
	   int space_length = L-words_length;
	   int space_number = end-last;
	   int space_avg = space_length/space_number;
	   int space_extra = space_length%space_number;
	   
	   String s = "";
	   for(int i=last; i<last+space_extra; i++)
	   {
		   s = s + words[i];
		   for(int j=0; j<=space_avg; j++)
			   s = s+" ";
	   }
	   for(int i=last+space_extra; i<end; i++)
	   {
		   s = s + words[i];
		   for(int j=0; j<space_avg; j++)
			   s = s + " ";
	   }
	   s = s + words[end];
	   res.add(s);
  }
  
  public void addWordsLeft(int last, int end, int L, ArrayList<String> res, String[] words)
  {
	  if(end<last)
		  return; 
	  int words_length = 0;
	   for(int i=last; i<=end; i++)
		   words_length += words[i].length();
	   int space_length = L-words_length;
	   int space_number = end-last;
	   
	   String s = "";
	   for(int i=last; i<=end; i++)
		   s = s + words[i] + " ";
	   int currentlength = s.length();
	   if(currentlength>L)
	   {
		   s = s.substring(0, L);
		   currentlength = L;
	   }
	   for(int i=currentlength; i<=L; i++)
		   s = s + " ";
	   if(s.length()>L)
		   s = s.substring(0, L);
	   
	   res.add(s);
		   
  }
  
  public void test()
  {
	   String[] words = {"a","b","c","d","e"};
	   ArrayList<String> res = fullJustify(words, 1);
//	   int a = res.get(0).length();
//	   int b = res.get(1).length();
//	   int c = res.get(2).length();
	   System.out.println(res.size());
	   

  }
  
}