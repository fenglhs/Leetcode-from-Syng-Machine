import java.util.ArrayList;


public class SpiralMatrix {
	 public ArrayList<Integer> spiralOrder(int[][] matrix) {
		 
		 ArrayList<Integer> result = new ArrayList<Integer>();
		 
		 
		 
	
			if(matrix == null || matrix.length == 0)
				return result;
				
			int m = matrix.length;
			int n = matrix[0].length;
				
			int currentring = 0;
			int totalring = (Math.min(n, m)+1)/2;
			 		
		   		
			while (currentring<totalring)
			{
				
				readcurrentring(result, matrix, currentring, m, n);
						
				currentring++;		
				
			}
			
			
			return result; 
	    
			
			
	    }
	 
	 public void readcurrentring(ArrayList<Integer> result, int[][] matrix, int currentring, int m, int n)
		{
			int cr = currentring;
			
			for(int j = cr; j< n-cr; j++ )
				result.add(matrix[cr][j]);
				
			//	matrix[cr][j] = matrix[cr][j-1] + 1;
			
			for(int i= cr+1; i < m-cr; i++)
			//	matrix[i][n-1-cr] = matrix[i-1][n-1-cr]+1;
			    result.add(matrix[i][n-1-cr]);
			for(int j = n-cr-2; j>=cr; j--)
			//	matrix[n-1-cr][j] = matrix[n-1-cr][j+1]+1;
			{
				if(m-1-cr>cr)
				    result.add(matrix[m-1-cr][j]);
			}
						
			for (int i = m-cr-2; i>=cr+1; i--)
			{
				if(n-1-cr>cr)
				{
				//	matrix[i][cr] = matrix[i+1][cr]+1;
				
					result.add(matrix[i][cr]);
				}
			}
			
			return;
			
			
		}
		
		void test()
		{
			
			int[][] matrix = {{2,3}, {4,5},{6,7}};
			
			
			
			ArrayList<Integer> result = new ArrayList<Integer>();
			result = spiralOrder(matrix);
			
			int m = matrix.length;
			int n = matrix[0].length;
			
			for (int i = 0; i<n*m-1; i ++)
				System.out.println(result.get(i));
			
				
			
	 	}
		
}
		