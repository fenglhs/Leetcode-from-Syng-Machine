import java.util.Stack;

//Unix path

public class SimplifyPath {
	
	  public String simplifyPath(String path) {
		  
		  Stack<String> stack = new Stack<String>();
		  
		  String[] string = path.split("/");
		  
		  for(int i = 0; i< string.length; i++)
		  {
			  if(!string[i].equals(".") && !string[i].isEmpty())
			  {
				  if(string[i] != "..")
					  stack.push(string[i]);
				  else if(!stack.isEmpty())
					  stack.pop();
			  }			  
		  }
		  
		  StringBuilder sb = new StringBuilder("/");
		  while(!stack.isEmpty())
		  {
			  sb.insert(0, stack.pop());
     	      sb.insert(0, "/");
		  }
		  
		  return sb.length() == 0 ? "/" : sb.toString();
		  
		  
	        
	    }
	  
	  public void test()
	  {
		  String s = "/.";
		  String s1 = simplifyPath(s);
		  System.out.println(s1);
		  
		  String test = new String("a");
		  boolean b1 = (test=="a");

		  boolean b2 = test.equals("a");
		  
		  System.out.println(b1);
		  System.out.println(b2);


	  }
	

}
