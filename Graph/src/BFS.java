import java.util.ArrayList;
import java.util.List;

/*
 * Projected and implemented by: Júlio Bengtson Neves (J-Bengtson)
 * Projetado e implementado por: Júlio Bengtson Neves (J-Bengtson)
 * Available on Github: github.com/J-Bengtson
 * 
 */
public class BFS implements AlgorithmInterface{
	private final Graph graph;
	BFS(Graph graph){
		this.graph = graph;
	}
	
	
	private List<Vertex> getVertices() {
		return this.graph.getVertices();
	}
	
	
	@Override
	public List<Vertex> largestPathWithRoot(Vertex initialVertex) {
		
		List<List<Integer>> adj = this.graph.buildAdjacencyMatriz();
		
		List<Vertex> queue = new ArrayList<Vertex>();
		List<Boolean> visited = new ArrayList<Boolean>();
		for( int x = 0 ; x < this.graph.getVertices().size() ; x++ )
			visited.add(new Boolean(false));
		visited.set(this.graph.getVertices().indexOf(initialVertex) , true);
		
		queue.add(initialVertex);
		
		while(!queue.isEmpty()) {

			Vertex v = queue.remove(queue.size()-1);

			
			for(int i = 0 ; i < this.graph.getVertices().size() ; i++) {
				if( adj.get(getVertices().indexOf(v)).get(i) != 0 && !visited.get(i)){
					visited.set(i, true);
					queue.add( this.getVertices().get(i));
				}
			}

		}
		
		
		
		
		
		return null;
	}
	
	
	
	@Override
	public List<Vertex> pathWithLargestDistanceBetween(Vertex initialVertex, Vertex terminalVertex) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Vertex> pathWithLargestDistance() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Vertex> pathWithSmallestDistanceBetween(Vertex initialVertex, Vertex terminalVertex) {
		// TODO Auto-generated method stub
		return null;
	}


	
	
	@Override
	public boolean hasPathBetween(List<List<Integer>> matriz, List<Boolean> visited, Vertex V, Vertex terminalVertex) {

		if(V.equals(terminalVertex))
			return true;

		List<Vertex> queue = new ArrayList<Vertex>();

		queue.add(V);
		
		while(!queue.isEmpty()) {

			Vertex v = queue.remove(queue.size()-1);

			for(int i = 0 ; i < this.graph.getVertices().size() ; i++) {
				if( matriz.get(getVertices().indexOf(v)).get(i) != 0 && !visited.get(i)){
					visited.set(i, true);
					queue.add( this.getVertices().get(i));
					
				}
			}

		}
		return false;
	}


}
