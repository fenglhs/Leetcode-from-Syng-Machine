import java.util.ArrayList;
public class Triangle {
//从下往上，一行一行消掉，把最下面一行的值加回到上一行去。加到最后只剩最后top一行，答案就出来了。
	
	
public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
	
	int[] total = new int[triangle.size()];
	int l = triangle.size() - 1;
 
	for (int i = 0; i < triangle.get(l).size(); i++) {
		total[i] = triangle.get(l).get(i);
	}
 
	// iterate from last second row
	for (int i = triangle.size() - 2; i >= 0; i--) {
		for (int j = 0; j < triangle.get(i + 1).size() - 1; j++) {
			total[j] = triangle.get(i).get(j) + Math.min(total[j], total[j + 1]);
		}
	}
 
	return total[0];
}
        
   
}