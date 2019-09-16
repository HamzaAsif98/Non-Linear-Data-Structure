import java.text.DecimalFormat;

public class RobotMoving {

	double right = 1.1;
	 double down = 1.3;
	 double diagonal = 2.5;
	double matrix [][];
	String path [][];
	double cost = 0;	
	public RobotMoving(int n) {
	
		matrix=new double [n][n];
		this.path = new String [n][n];
	}

public void robo(int n) {
		
		matrix[0][0] = 0.0;
		path [0][0] = "-";
		for (int j = 1; j < n; j ++) {
			matrix[0][j] = matrix[0][j-1] + right;
			path [0][j] = "r";
		}
		for (int i = 1; i < n; i ++) {
			matrix [i][0] = matrix[i-1][0] + down;
			path [i][0] = "b";
			for(int j= 1; j < n; j++) {
				matrix [i][j] = min(matrix[i][j-1] + right,
						matrix[i-1][j] + down,
						matrix[i-1][j-1] + diagonal, i, j);
				
			}
		}
		cost = matrix[n-1][n-1];
		
	}
public double min(double r, double d, double dia, int i, int j) {
		double res = 0;
		if (r < d && r < dia) {
			path[i][j] = "r";
			res = r;
		}
		else if (d < r && d < dia) {
			path[i][j] = "b";
			res = d;
		}
		else { 
			path[i][j] = "d";
			res = dia;
		}
		return res;
		}
		
	
	
public void print () {
	DecimalFormat DF = new DecimalFormat("0.0");	
	
		for (int row = 0; row < matrix.length; row ++) {
			for (int col = 0; col < matrix.length; col ++) {
				System.out.print(DF.format(matrix[row][col]) + " ");
			}
			System.out.println();
		}
		System.out.println("\nTotal Path: ");
		for (int row = 0; row < path.length; row ++) {
			for (int col = 0; col < path.length; col ++) {
				System.out.print(path[row][col] + " ");
			}
			System.out.println();
		}
	}

public void path () {
	
	int i = matrix.length - 1;
	int j = matrix.length - 1;
	
	System.out.println("\nThe total cost from point:"+ i +", " + j +
			" to point: 0, 0 is €" + matrix[i][j]);
	
	while (i != -1 && j != -1) {
		if (path [i][j] == "r") {
			j--;
			System.out.println("We reached point:" + i +", " + j + " from point: " 
					+ i +", "+ (j+1) 
					+ ". With a cost of €" + right);
			}
		else if (path [i][j] == "b") {
			i--;
			System.out.println("We reached point:" + i +", " + j + " from point: " 
					+ (i+1) +", "+ j 
					+ ". With a cost of €" + down);
			}
		else if (path [i][j] == "d") {
			i--;
			j--;
			System.out.println("We reached point:" + i +", " + j + " from point: " 
					+ (i+1) +", "+ (j+1) 
					+ ". With a cost of €" + diagonal);
		
		}
		
	}
	
	
}
	
	
	public static void main(String[] args) {
		RobotMoving rm=new RobotMoving (5);
		
		rm.robo(5);
		rm.print();
		rm.path();
	

	}

}
