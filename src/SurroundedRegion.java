
public class SurroundedRegion {
	
	 public void solve(char[][] board) {
		 if(board == null)
			 return;
		 if(board.length == 0)
			 return;
		 if(board[0].length == 0)
			 return;
		 
		 
		 int m = board.length;
		 int n = board[0].length;
		 int[][] breath = new int[m][n];
				 
		 for(int i=0; i<m; i++)
		 {
			 for(int j=0; j<n; j++)
			 {
				 breath[i][j] = -1;
			 }
		 }
      
		 int round = Math.min(m,n)/2 + Math.min(m,n)%2;
		 
		 for(int r=0; r<round; r++)
		 {
			 for(int j=r; j<n-r; j++)
			 {
				 if(r==0)
				 {
					 if(board[r][j]=='o')
				     	 breath[r][j] = 1;	
				     if(board[m-1-r][j]=='o')
					     breath[m-1-r][j] = 1;
				 }
				 else
				 {
					 
				 }
				 
				 
			 }
			 
			 
			 
			 
			 
		 }

		

	 }	 
	 
	 public 
	   
}
