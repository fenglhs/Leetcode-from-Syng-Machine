
public class WilcardMatching {
	 public boolean isMatch(String s, String p) {
	     if(s == null && p == null)
	    	 return true;
	     if(s.equals("") && p.equals(""))
	    	 return true;
	     else if(s.equals(""))
	     {
	    	 if(p.charAt(p.length()-1)!='*' && p.charAt(p.length()-1)!='?')
	    		 return false;
	    	 else if(p.length()==1)
	    		 return true;
	     }
	     if(p.equals("") && s.length()>0)
	    	 return false;
	     
	     
	     boolean result = false;
	     
	     if(s.equals("") && p.charAt(0)!='*' && p.charAt(0)!='?')
	    	 return false;
	     else if(s.equals(""))
	     {
	    	 return isMatch(s, p.substring(1));
	     }
	     
	     if(s.charAt(0)==p.charAt(0) || p.charAt(0)=='?')
	    	 return isMatch(s.substring(1), p.substring(1));
	     else if(p.charAt(0)=='*')
	     {
	    	 if(s.length()>=2)
	    		 result = isMatch(s.substring(1), p);
	    	 else
	    	 {
	    		 result = isMatch(s.substring(1), p.substring(1));
	    		 if(result!=true)
	    			 result = isMatch(s, p.substring(1));
	    	 }	    			 
	     }
	    	return result;	 
	    }
	 
	
}
