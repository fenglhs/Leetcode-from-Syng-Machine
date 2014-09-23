
public class SingleNumber2 {
	 
		 public int singleNumber(int[] A) {       
			 if (A==null||A.length==0){
				 return -1; 
				 }  
			 int[] bits=new int[32];
			 int result=0; 
			 for (int i=0; i<32; i++){  
				 for(int j=0; j<A.length; j++){ 
					 bits[i]+=A[j]>>i&1; 
				 bits[i]%=3;      
				 }        
				 result|=(bits[i]<<i);
				 }     
			 return result;
			 }
		 public void test()
		 {
			 int[] A = {2,3,4,5,5,4,3,2,6,5,4,2,3};
			 int s = singleNumber(A);
			 System.out.println(s);
		 }
}
		