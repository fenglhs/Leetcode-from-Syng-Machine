
public class SpiralMatrixII {
	int currentnumber;
	public int[][] generateMatrix(int n) {
		
		int[][] matrix = new int[n][n];
		if (n==0)
			return matrix;
		
	
			
		int currentring = 0;
		int totalring = n/2+n%2;
		System.out.println("n=");
		System.out.println(n);
		System.out.println("totalring =");
		System.out.println(totalring);
        		
	    currentnumber = 1;
		
		while (currentring<totalring)
		{
			
			currentnumber = fillcurrentring(currentnumber, matrix, currentring, n);
			currentnumber++;
			
			currentring++;		
			
		}
		
		return matrix; 
    
		
		
    }
	
	public int fillcurrentring(int currentnumber, int[][] matrix, int m, int n)
	{
		matrix[m][m] = currentnumber;
		
		
		
		for(int j = m+1; j< n-m; j++ )
			matrix[m][j] = matrix[m][j-1] + 1;
		
		for(int i= m+1; i < n-m; i++)
			matrix[i][n-1-m] = matrix[i-1][n-1-m]+1;
		
		for(int j = n-m-2; j>=m; j--)
			matrix[n-1-m][j] = matrix[n-1-m][j+1]+1;
		
		currentnumber = matrix[n-1-m][m];
		
		for (int i = n-m-2; i>=m+1; i--)
		{
			if(i>m)
			{
				matrix[i][m] = matrix[i+1][m]+1;
			    currentnumber = matrix[i][m];
			}
		}
		
		return currentnumber;
		
		
	}
	
	void test()
	{
		int n = 4;
		int[][] matrix = generateMatrix(n);
		
		for (int i = 0; i<n; i ++)
			for (int j = 0; j<n; j++)
				System.out.println(matrix[i][j]);
			
		
 	}
	
	
}


