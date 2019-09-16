import java.util.Arrays;
import java.util.Scanner;

public class Bishops {
	  static int n;
	    static int count = 1;
	    static char chess[][];
	    
	    public Bishops(int v) {
	    	this.n=v;
	    	chess=new char [v][v];
	    }


	    private static boolean isSafe(char chess[][], int row, int col)
	    {
	    
	    for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (chess[i][j] == 'B')
                return false;


        for (int i = row, j = col; i >= 0 && j < n; i--, j++)
            if (chess[i][j] == 'B')
                return false;


        return true;
	    }

	    private static void bishop(char chess[][], int row)
	    {
	    	  if (row == n)
	          {
	              System.out.println(count++);
	              for (int i = 0; i < n; i++){
	                  for (int j = 0; j < n; j++)
	                      System.out.print(chess[i][j] + " ");                       
	                  System.out.println();    
	              }
	              System.out.println();
	              System.out.println(count++);

	              for (int i = 0; i < n; i++){
	                  for (int j = 0; j < n; j++)
	                      System.out.print(chess[j][i] + " ");                       
	                  System.out.println();    
	              }
	              System.out.println();
	              return;
	          }
	          for (int i = 0; i < n; i++){
	              if (isSafe(chess, row, i)){
	                  chess[row][i] = 'B';
	                  bishop(chess, row + 1);
	                  chess[row][i] = '*';
	              }else if (!isSafe(chess,row,i)) {
	            	  chess[row][i] = '*';
	              }

	          }
	    }


	    public static void main(String[] args)
	    {
		
	    	Bishops b = new Bishops (3);

	        for (int i = 0; i < n; i++) {

	            Arrays.fill(chess[i], '*');
	        }


	        bishop(chess, 0);

	    }

	}
