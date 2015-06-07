import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ClosestPairDC {

	public final static double INF = java.lang.Double.POSITIVE_INFINITY;
	public static XYPoint minPoint = new XYPoint(); 
	public static XYPoint minPoint1 = new XYPoint(); 
	public static double minDistance = INF; 
	public static XYPoint pointsByX[];

	 

	public static void findClosestPair(XYPoint pointsByX[], 
			XYPoint pointsByY[])
	{	
		
		List<XYPoint> pointsByXArray = new ArrayList<XYPoint>(Arrays.asList(pointsByX));
		List<XYPoint> pointsByYArray = new ArrayList<XYPoint>(Arrays.asList(pointsByY));
	
		divideAndConquer(pointsByXArray, pointsByYArray, pointsByX.length); 
		 
		if (minPoint.x < minPoint1.x) { 
			System.out.println("(" + minPoint.x + ", "+ minPoint.y + ") (" + minPoint1.x +", " + minPoint1.y + ") " + minDistance);
		}
		else if (minPoint.x > minPoint1.x)  { 
			System.out.println("(" + minPoint1.x + ", "+ minPoint1.y + ") (" + minPoint.x +", " + minPoint.y + ") " + minDistance);
		}
		else { 
			if (minPoint.y < minPoint1.y ) {
				System.out.println("(" + minPoint.x + ", "+ minPoint.y + ") (" + minPoint1.x +", " + minPoint1.y + ") " + minDistance);
			}
			else if (minPoint.y > minPoint1.y ) {
				System.out.println("(" + minPoint1.x + ", "+ minPoint1.y + ") (" + minPoint.x +", " + minPoint.y + ") " + minDistance);
			}
				else {
					System.out.println("(" + minPoint.x + ", "+ minPoint.y + ") (" + minPoint1.x +", " + minPoint1.y + ") " + minDistance);
				}
			} 
		} 
	
	public static double divideAndConquer (List<XYPoint> pointsByX,List<XYPoint> pointsByY, int numPoints ) {
		if (numPoints==1 || numPoints==0) { 
			return INF; 
		}
		
		else if (numPoints == 2) { 
			double tempD = findDistance(pointsByX.get(0), pointsByX.get(1));
			if (tempD < minDistance) { 
				minDistance = tempD;
				minPoint = pointsByX.get(0); 
				minPoint1 = pointsByX.get(1);

			}
			return tempD;
		}
		else{
			int  mid =  (numPoints/2)-1; 
			List<XYPoint> pointsByXLeft = pointsByX.subList(0,  mid +1);
			List<XYPoint> pointsByXRight = pointsByX.subList( mid + 1, numPoints); 
			
			List<XYPoint> pointsByYLeft = new  ArrayList<XYPoint>();
			List<XYPoint> pointsByYRight = new  ArrayList<XYPoint>();
			
			for (XYPoint point : pointsByY) { 
				if (point.x  <= pointsByXLeft.get(pointsByXLeft.size() -1 ).x){
					pointsByYLeft.add(point);
				}
				else { 
					pointsByYRight.add(point);
				}
			}
			

			double distLeft = divideAndConquer(pointsByXLeft, pointsByYLeft, numPoints/2);
			double distRight = divideAndConquer(pointsByXRight, pointsByYRight, numPoints/2);
			double minDistanceLR = Math.min(distLeft, distRight);

			return combine(pointsByY, pointsByX.get(mid), numPoints,  minDistanceLR); 
		}
	}
	public static double combine(List<XYPoint> pointsByY, XYPoint  midPoint, double n, double minDistanceLR ) {
		List<XYPoint> strip = new ArrayList<XYPoint>();
		for (XYPoint xy : pointsByY ) {
			if (Math.abs(xy.x -midPoint.x) < minDistanceLR) { 
				strip.add(xy);
			}
		}
		double temporary = INF;
		for (int j =0; j < (strip.size()-1); ++j) {
			int k = j+1; 
			while ((k < (strip.size())) && (Math.abs(pointsByY.get(j).y - pointsByY.get(k).y) < minDistanceLR)) {
				temporary = findDistance(strip.get(k), strip.get(j)); 
				if (temporary < minDistance) { 
					minDistance = temporary; 
					minPoint = strip.get(j);
					minPoint1 = strip.get(k);
				}
				k++;
			}
		}
	
	return temporary; 

}

public static double findDistance(XYPoint point1, XYPoint point2) {
	double xdist = (Math.abs(point1.x - point2.x)); 
	double ydist = (Math.abs(point1.y - point2.y)); 
	double squareXdist = xdist*xdist; 
	double squareYdist = ydist*ydist; 
	double sumSquare = squareXdist + squareYdist; 
	double dist = Math.sqrt(sumSquare);

	return dist; 
}
}


