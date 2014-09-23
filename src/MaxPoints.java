import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class MaxPoints {
	 class Point {
		 int x;
		 int y;
		 Point() { x = 0; y = 0; }
		 Point(int a, int b) { x = a; y = b; }
	 }
	 
	 public int maxPoints(Point[] points) {
		 if(points == null)
			 return 0;
		 if(points.length == 0)
			 return 0;
		 if(points.length == 1)
			 return 1;
		 if(points.length == 2)
			 return 2;
		 
		 int max = 2;
		 
		 int n = points.length;
		 
		 ArrayList<Double> slo = new ArrayList<Double>();
		 
		 double[][] record = new double[n][n];
		 for(int i=0; i<n; i++)
			 for(int j=0; j<n; j++)
				 record[i][j] = 0;
		
 
		 for(int i=0; i<n; i++)
		 {
			 int dup = 1;
			 slo.clear();
			 for(int j=i; j<n; j++)
			 {
				 
				 if(record[i][j]!=0 )
				 {
					 slo.add(record[i][j]);
					 if(record[j][i]==0)
						 record[j][i] = record[i][j];					 
				 }
				 
				 else if(record[j][i]!=0)
				 {
					 slo.add(record[j][i]);
					 record[i][j] = record[j][i];
				 }
				 
			     else if(j!=i)
				 {
					 if(points[i].x-points[j].x==0)
				     {
						 if (points[i].y-points[j].y==0)
						 	 dup++;                          
						 else
						 {
							 slo.add(Double.MAX_VALUE);
							 record[i][j] = Double.MAX_VALUE;
							 record[j][i] = Double.MAX_VALUE;
						 }
						
					 }
					 else
					 {
						 slo.add((double) ((points[j].y - points[i].y)/(points[j].x - points[i].x)));
						 record[i][j] = (double) ((points[j].y - points[i].y)/(points[j].x - points[i].x));
						 record[j][i] = (double) ((points[j].y - points[i].y)/(points[j].x - points[i].x));
					 }
				 }
			 }
			 Collections.sort(slo);
			 int same = 1;
			 for(int j=1; j<slo.size(); j++)
			 {

				 if(slo.get(j).equals(slo.get(j-1)))
					 same++;
				 else
				 {
					 max = Math.max(max, same+dup);
					 same = 1;					 
				 }				 
			 }
			 if(dup==points.length)
				 same=0;
			 max = Math.max(max, same+dup);
		 }
		 
		 return max;
	        
	    }
	public void test()
	{
		Point[] points = new Point[3];
		points[0] = new Point(1,1);
		points[1] = new Point(1,1);
		points[2] = new Point(1,1);
		System.out.println(maxPoints(points));
	}

}
