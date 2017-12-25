package algos.main;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class AdjacencyMatrix {
	
	int[][] graph;
	
   
	public void readGraph(){
		System.out.println(" Enter number of Vertices and Edges ");
		Scanner sc= new Scanner(System.in);
	    int nV = sc.nextInt();
		int nE = sc.nextInt();
	    
		graph = new int[nV+1][nV+1];
		
		for(int i=0;i<nV+1;i++)
		{
			for(int j=0;j<nV+1;j++)
			{
					
				graph[i][j]=0;
				
			}
			
			
		}
		
		System.out.println("Represent Edges with weights");
		
		for(int j=0;j<nE;j++)
		{
			
			int v1 = sc.nextInt();
		    

			int v2 = sc.nextInt();
		    
			int w = sc.nextInt();
			graph[v1][v2] = w ;
			
			
		}
		
	}
	
	
	
	void printGraph(){
		System.out.println(" Print Graph ");


		for(int i=0;i<graph.length;i++)
		{
			System.out.println("\n");
			for(int j=0;j<graph.length;j++)
					
				System.out.print(graph[i][j] +"  ");
				
	    }
			
			
	}

	
	
	public static void main(String[] args){
		
		System.out.println("Read Graph");
		
		AdjacencyMatrix adjacencyMatrix = new AdjacencyMatrix();
		
		adjacencyMatrix.readGraph();
		
		adjacencyMatrix.printGraph();
		
		
	}



	public int[][] getGraph() {
		return graph;
	}



	public void setGraph(int[][] graph) {
		this.graph = graph;
	}
	
	
	List<Integer> adjacentElements(int v){
		
		List<Integer> list = new ArrayList<Integer>();

		for( int i=0;i<graph.length;i++){
			
			if(graph[v][i]!=0){
				list.add(i);
			}
		}
		return list;
		
	}
	
	
	
	}
	
	


