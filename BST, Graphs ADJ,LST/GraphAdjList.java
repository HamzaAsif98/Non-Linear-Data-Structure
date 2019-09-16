
import java.util.LinkedList;
import java.util.Iterator;

/**
 * Graph implementation that uses Adjacency Lists to store edges. It
 * contains one linked-list for every vertex i of the graph. The list for i
 * contains one instance of VertexAdjList for every vertex that is adjacent to i.
 * For directed graphs, if there is an edge from vertex i to vertex j then there is
 * a corresponding element in the adjacency list of node i (only). For
 * undirected graphs, if there is an edge between vertex i and vertex j, then there is a
 * corresponding element in the adjacency lists of *both* vertex i and vertex j. The
 * edges are not sorted; they contain the adjacent nodes in *order* of
 * edge insertion. In other words, for a graph, the node at the head of
 * the list of some vertex i corresponds to the edge involving i that was
 * added to the graph least recently (and has not been removed, yet). 
 */

public class GraphAdjList  implements Graph {

	// ATTRIBUTES: 
	private LinkedList<Edge>[] g;
	private int numVertices;
	private boolean dir;

	//TO-DO

	/*
	 * CONSTRUCTOR: Creates a directed/undirected graph with V vertices and no edges.
	 * It initializes the array of adjacency edges so that each list is empty.
	 */

	public GraphAdjList(int V, boolean directed) {
		this.numVertices=V;
		this.dir=directed;
		g = new LinkedList[V];
		for(int i = 0; i < V;i++) {
			g[i] = new LinkedList <Edge>();
		}
	}


	// 1. IMPLEMENTATION METHOD numVerts: 
	public int numVerts() {
		return numVertices;
	}



	// 2. IMPLEMENTATION METHOD numEdges:
	public int numEdges() {
		int e = 0; 
	  
	    for (int i = 0 ; i < numVertices ; i++) 
	        e += g[i].size();
	    return e;
	} 


	//  3. IMPLEMENTATION METHOD addEdge:
	public void addEdge(int v1, int v2, int w) {
		try 
		{
			if(dir==true) {
				g[v1].add(new Edge (v2,w));
			}else if(dir==false) {
			g[v1].add(new Edge (v2,w));
			g[v2].add(new Edge (v1,w));
			}


		} catch (ArrayIndexOutOfBoundsException indexBounce)
		{
			System.out.println("Error Fails");
		}

	}

	// 4. IMPLEMENTATION METHOD removeEdge: 
	public void removeEdge(int v1, int v2) {
		try 
		{
			if(dir==true) {
				g[v1].remove(0);

			}else if(dir==false) {
			g[v2].remove(0);
			g[v1].remove(0);
			
			}


		} catch (ArrayIndexOutOfBoundsException indexBounce)
		{
			System.out.println("Error Fails");
		}
	
		
	}

	// 5. IMPLEMENTATION METHOD hasEdge:
	public boolean hasEdge(int v1, int v2) {
	boolean res=false;

	for(int i = 0 ;i<g[v1].size();i++) {
		if(g[v1].get(i).getVertex()==v2) {
			res=true;
		}
	}
	
	return res;
		}

	//TO-DO


	// 6. IMPLEMENTATION METHOD getWeightEdge:
	public int getWeightEdge(int v1, int v2) {
	
		if(dir==true) {
		for (int i= 0;i<g[v1].size();i++) {
			return g[v1].get(i).getWeight();		
			}
		}
		else if(dir==false) {
				for (int i= 0;i<g[v1].size();i++) {
				return g[v1].get(i).getWeight()+g[v1].get(i).getWeight();		
					}
			}
		return 0;
	
		
	
		//TO-DO
	}

	// 7. IMPLEMENTATION METHOD getNeighbors:
	public LinkedList getNeighbors(int v) {
		//not completed
		LinkedList <Integer> n = new LinkedList<Integer>();
	    return n;
	}

	// 8. IMPLEMENTATION METHOD getDegree:
	public int getDegree(int v) {
		//not completed 
		int degree = 0;
        return degree;
	}

	// 9. IMPLEMENTATION METHOD toString:
	public String toString() {
		String result="";
		for(int i =0;i<g.length;i++) 
			result+=i+"==>"+g[i]+"\n";		
		//TO-DO
		return result;
	}

}


