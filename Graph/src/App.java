import java.util.ArrayList;

/*
 * Projected and implemented by: Júlio Bengtson Neves (J-Bengtson)
 * Projetado e implementado por: Júlio Bengtson Neves (J-Bengtson)
 * Available on Github: github.com/J-Bengtson
 * 
 */
public class App { //04/09/2019
	
	public static void main(String[]args) {
		Graph g = new Graph(true);
		
		Vertex v1 = new Vertex("v1");
		Vertex v2 = new Vertex("v2");
		Vertex v3 = new Vertex("v3");
		Vertex v4 = new Vertex("v4");
		Vertex v5 = new Vertex("v5");
		Vertex v6 = new Vertex("v6");
		Vertex v7 = new Vertex("v7");
		
		g.addVertex(v1);
		g.addVertex(v2);
		g.addVertex(v3);
		g.addVertex(v4);
		g.addVertex(v5);
		g.addVertex(v6);
		g.addVertex(v7);
		

		g.addEdge(new Edge(v1 , v2 , 1));
		g.addEdge(new Edge(v2 , v3 , 1));
		g.addEdge(new Edge(v2 , v5 , 1));
		g.addEdge(new Edge(v3 , v6 , 1));
		g.addEdge(new Edge(v4 , v1 , 1));
		g.addEdge(new Edge(v5 , v6 , 1));
		g.addEdge(new Edge(v5 , v4 , 1));
		g.addEdge(new Edge(v6 , v3 , 1));
		g.addEdge(new Edge(v7 , v4 , 1));
		g.addEdge(new Edge(v7 , v5 , 1));
		g.addEdge(new Edge(v7 , v6 , 1));

		g.showGraph();
		
		System.out.println("1)"+g.largestPathWithRoot(Algorithm.DFS, v2));
		System.out.println("2)"+g.pathWithLargestDistance(Algorithm.DFS));
		System.out.println("3)"+g.pathWithLargestDistanceBetween(Algorithm.DFS, v7, v5));
		System.out.println("4)"+g.pathWithSmallestDistanceBetween(Algorithm.DFS,v7 , v2));

		
		
	}
	
}
