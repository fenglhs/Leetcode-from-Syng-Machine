
public class FirstMissingPositive {
	 public int firstMissingPositive(int[] A) {
		 
		 if(A==null)
			 return 1;
		 if(A.length==0)
			 return 1;
		 int temp = 0;
		 int temp2 = 0;
		 
		 for(int i = 0; i<A.length; i++)
		 {
			 if(A[i] == -1)
				 A[i] = -2;
		 }
		 
		 
		 for(int i = 0; i<A.length; i++)
		 {
			 if(A[i]>A.length)
			    A[i] = -2;
			 if(A[i]<=A.length && A[i]>0)
			 {
				 temp = 0;
				 if(A[i]-1 != i-1)
				     temp = A[A[i]-1];
				 A[A[i]-1] = -1;
				 
				 
				    while(temp>0 && temp<A.length )
				    {
					    temp2 = A[temp-1];
					    A[temp-1] = -1;
					    temp = temp2;
				    }
				 
			 }
				 
		 }
		 
		 for(int i=0; i<A.length; i++)
		 {
			 if(A[i] >= 0)
				 return i+1;
		 }
	        
		 return A.length+1;
	    }
	}