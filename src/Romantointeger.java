
public class Romantointeger {
	
	public int c2n(char c)
	{
		switch(c){
		
		case 'I': return 1;
		case 'V': return 5;
		case 'X': return 10;
		case 'L': return 50;
		case 'C': return 100;
		case 'D': return 500;
		case 'M': return 1000;
		
		default: return 0;
		
		
		}
		
	}
	
	public int romanToInt(String s) {
		int result = 0;
	    int temp = 0;
	    int prev = -1;
		for (int i = s.length()-1; i>=0; i--)
		{
			temp = c2n(s.charAt(i));
			if (temp >= prev)
			{
				result += temp;
				prev = temp;
			}
			else 
				result -= temp;
			
			
			
		}
		
		return result;
		
	}

}
