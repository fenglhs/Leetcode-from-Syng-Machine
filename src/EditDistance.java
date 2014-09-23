
public class EditDistance {
public int minDistance(String word1, String word2) {
	
	int len1 = word1.length();
	int len2 = word2.length();
	
	int[][] dp = new int[len1+1][len2+2];
	
	for(int i = 0; i<len1; i++)
		dp[i][0] = i;
	for(int j =0; j<len2; j++)
		dp[0][j] = j;
	
	for(int i = 0; i<len1; i++)
	{
		for(int j =0; j<len2; j++)
		{
			if(word1.charAt(i+1)==word2.charAt(j+1))
				dp[i+1][j+1] = dp[i][j];
			else
			{
				int insert = dp[i+1][j]+1;
				int replace = dp[i][j]+1;
				int delete = dp[i][j+1]+1;
				int min = Math.min(insert, replace);
				min = Math.min(min, delete);
				dp[i+1][j+1] = min;				
			}		
			
		}
    }
	return dp[len1][len2];
}
}