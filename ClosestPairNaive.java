public class ClosestPairNaive {

	public final static double INF = java.lang.Double.POSITIVE_INFINITY;

	//
	// findClosestPair()
	//
	// Given a collection of nPoints points, find and ***print***
	//  * the closest pair of points
	//  * the distance between them
	// in the form "(x1, y1) (x2, y2) distance"
	//

	// INPUTS:
	//  - points sorted in nondecreasing order by X coordinate
	//  - points sorted in nondecreasing order by Y coordinate
	//

	public static void findClosestPair(XYPoint points[])
	{

		XYPoint dis1 = new XYPoint(0,0); 
		XYPoint dis2 = new XYPoint(0,0); 
		int n = points.length; 
		double minDist = INF;  
		if (n ==1 || n==0) { 
		}
		if (n==2) { 
			dis1 = points[0];
			dis2 = points[1];
			minDist = findDistance(dis1, dis2);
		}
		for (int i = 0; i <= points.length -2; ++i) {
			for (int j = i + 1; j < points.length; ++j) {
				double tempDist = findDistance(points[i], points[j]);
				if (tempDist < minDist) {
					minDist = tempDist; 
					dis1 = points[i];
					dis2 = points[j];

				}
			}
		}
		if (dis1.x < dis2.x) { 
			System.out.println("(" + dis1.x + ", "+ dis1.y + ") (" + dis2.x +", " + dis2.y + ") " + minDist);
		}
		else if (dis1.x > dis2.x)  { 
			System.out.println("(" + dis2.x + ", "+ dis2.y + ") (" + dis1.x +", " + dis1.y + ") " + minDist);
		}
		else { 
			if (dis1.y < dis2.y ) {
				System.out.println("(" + dis1.x + ", "+ dis1.y + ") (" + dis2.x +", " + dis2.y + ") " + minDist);
			}
			else if (dis1.y > dis2.y ) {
				System.out.println("(" + dis2.x + ", "+ dis2.y + ") (" + dis1.x +", " + dis1.y + ") " + minDist);
			}
				else {
					System.out.println("(" + dis1.x + ", "+ dis1.y + ") (" + dis2.x +", " + dis2.y + ") " + minDist);
				}
			} 
		} 

		// int nPoints = points.length;

		//
		// Your code goes here!
		//

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
