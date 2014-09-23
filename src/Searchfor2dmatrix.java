//递归中只要有任何一步return了，整个方程就return了。
//本题中我先找出所在row，然后找该row，这个不是最好的办法。
//可以把整个matrix当成一个sorted array，然后二分法找。参考 http://www.programcreek.com/2013/01/leetcode-search-a-2d-matrix-java/



public class Searchfor2dmatrix {
	   int row_index;
	   boolean value_exist;
	   

    public boolean searchMatrix(int[][] matrix, int target) {
        
    	row_index = -1;
    	value_exist = false;
    	
    	if(matrix.length == 0)
    		return false;
    	if(matrix[0].length == 0)
    		return false;
    	if(target < matrix[0][0] || target > matrix[matrix.length-1][matrix[0].length-1])
    		return false;
    	
    	identify_row_index(matrix, target, 0, matrix.length-1);
    	
    	if (row_index < 0)
    		return false;
    	
    	value_exist = checkValue(matrix[row_index], target, 0, matrix[row_index].length-1);
    	
        return value_exist;
    		
    	}
    	
	private boolean identify_row_index(int [][]matrix, int target, int start, int end)
	
	{
		if(start>end)
			return false;
		
		if(start == end)
		{
			if(target<matrix[start][0] || target>matrix[start][matrix[start].length-1])
				return false;
			
			else 
				{
				     row_index = start;
				     return true;
				
				}
				
		}
		
		int middle = (start+end)/2;
		
		if(target>=matrix[middle][0]&&target<=matrix[middle][matrix[middle].length-1])
		{
			row_index = middle;
		    return true;
		}
			
		else if (target>matrix[middle][0])
			identify_row_index(matrix, target, middle, end);
		
		else
			identify_row_index(matrix, target, start, middle-1);
		
		return false;
		
    	
    }
	
	
	public boolean checkValue(int[] matrix, int target, int start, int end)
	{
		if (start>end)
			return false;
		if(start == end)
			
			return target == matrix[start];
		
		int middle = (start+end)/2;
		
		if (target == matrix[middle])
			value_exist = true;
		else if (target>matrix[middle])
			value_exist = checkValue(matrix, target, middle+1, end);
		else 
			value_exist = checkValue(matrix, target, start, middle-1);
		
		return false;
			
			
		
	}
	
	void test()
	{
		
		int [] matrix = {1};
		int [] matrix2 = {3};
		
		int [][] matrix3 = {matrix,matrix2};
		
		boolean result = searchMatrix(matrix3, 1);
		
		System.out.println(result);
		
		
		
		
	}
}