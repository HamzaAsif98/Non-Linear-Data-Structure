import java.util.LinkedList;

/*
 *  Implementation of the interface Graph with adjacency matrix.
*/

 
public class GraphAdjMatrix implements Graph{

	// ATTRIBUTES: 
    //TO-DO
	private int[][] mat;
	
	private int E;
	private int nv;
	
	private boolean dir;
    
	
    // CONSTRUCTOR: Creates a directed/undirected graph with V vertices and no edges
    public GraphAdjMatrix(int V, boolean directed) {
    	this.nv=V;
    	this.dir = directed;
    	
    	this.mat = new int[V][V];

    }


    // 1. IMPLEMENTATION METHOD numVerts: 
    public int numVerts() {
		return nv;
    //TO-DO
    }
    
   
    // 2. IMPLEMENTATION METHOD numEdges:
    public int numEdges() {
    	 E=0;
    	for(int i = 0;i<mat.length;i++) {
		for(int j =0;j<mat.length;j++) {
			if (mat[i][j]>0) {
				E++;
			}	
		}
	}
	
	return E;
    }
    	
    


   //  3. IMPLEMENTATION METHOD addEdge:
    public void addEdge(int v1, int v2, int w) {
    	
    	try 
        {	if(dir==true) 
            mat[v1][v2] = w;
        } catch (ArrayIndexOutOfBoundsException indexBounce)
        {
            System.out.println("Error Fails");
        }
    	try 
        {	if(dir==false) {
            mat[v1][v2] = w;
        	mat[v2][v1] = w;
        }
        } catch (ArrayIndexOutOfBoundsException indexBounce)
        {
            System.out.println("Error Fails");
        }
    
    	
   } 
   // 4. IMPLEMENTATION METHOD removeEdge:
   public void removeEdge (int v1, int v2)
   {
	  
	   try 
       {	if(dir==true) {
           mat[v1][v2] = 0;
       }else if(dir==false) {
    	   mat[v1][v2] = 0;
          	mat[v2][v1] = 0;
       }
       } catch (ArrayIndexOutOfBoundsException indexBounce)
       {
           System.out.println("Error Fails");
       }
   }
    // 5. IMPLEMENTATION METHOD hasEdge:
    public boolean hasEdge(int v1, int v2) {
		if(mat[v1][v2]>0) {
			return true;
		}else {
			return false;
		}
      
    }
    
    // 6. IMPLEMENTATION METHOD getWeightEdge:
	public int getWeightEdge(int v1, int v2) {
		int res=mat[v1][v2];
		return res;
	
		//TO-DO
	}

    
	// 7. IMPLEMENTATION METHOD getNeighbors:
	public LinkedList getNeighbors(int v)
	{
		
		LinkedList<Integer> neighbors = new LinkedList<Integer>();
	    for (int i = 0; i < mat.length; i++){
	        if(mat[v][i]>0) {
	            neighbors.add(i);
	        }
	    }
	    return neighbors;
		
    	//TO-DO
	}
   	
	// 8. IMPLEMENTATION METHOD getDegree:
	public int getDegree(int v) 
	{
		int degree = 0; 
        for (int i = 0; i < mat.length; i++) { 
            if (mat[v][i]>0) 
                degree++; 
        } 
        return degree; 
	}
	

	// 9. IMPLEMENTATION METHOD toString:
   	public String toString()
    {
   		String res="";
   		for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat.length; j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }

		return res;
    //TO-DO
    }    
}