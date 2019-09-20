import java.util.*;
/*
 * Projected and implemented by: Júlio Bengtson Neves (J-Bengtson)
 * Projetado e implementado por: Júlio Bengtson Neves (J-Bengtson)
 * Available on Github: github.com/J-Bengtson
 * 
 */
public class DFS implements AlgorithmInterface {
	private final Graph graph;

	DFS(Graph graph) {
		this.graph = graph;
	}
	
	
	
	
	
	public List<Vertex> pathWithLargestDistanceBetween(Vertex initialVertex, Vertex terminalVertex) {

	
		List<Boolean> visited = new ArrayList<Boolean>();
		for (int x = 0; x < this.graph.getVertices().size(); x++)
			visited.add(false);

		visited.set(this.graph.getVertices().indexOf(initialVertex), true); 
		
		List<Vertex> path = pathWithLargestDistanceBetween(this.graph.buildAdjacencyMatriz(), visited, initialVertex, terminalVertex);
		if(path.isEmpty()) {
			return new ArrayList<Vertex>();
		}else {
			path.add(0,initialVertex);
			return path;
		}
	}
	
	
	
	public List<Vertex> pathWithLargestDistanceBetween(List<List<Integer>> matriz, List<Boolean> visited, Vertex V, Vertex terminalVertex) {
		
		Iterator<Integer> i = matriz.get(this.graph.getVertices().indexOf(V)).iterator();
		List<Vertex> path = new ArrayList<Vertex>();
		int count = 0, sum = 0;
		while (i.hasNext()) {
			int degreeEdge = i.next();
			if (degreeEdge != 0 && !visited.get(count) && hasPathBetween(matriz, new ArrayList<Boolean>(visited), this.graph.getVertices().get(count) , terminalVertex )) {
				visited.set(count, new Boolean(true));
				
				List<Vertex> subPath = pathWithLargestDistanceBetween(matriz,visited,this.graph.getVertices().get(count),terminalVertex);
				subPath.add(0, this.graph.getVertices().get(count));
				int sum_prev = sum;
				sum = Math.max(degreeEdge + 
						summationOfSubPath(subPath) , sum);
				
				if(sum_prev < sum) {
					path = new ArrayList<Vertex>(subPath);
				}

				visited.set(count, new Boolean(false));
			}

			++count;
		}
		return path;
	}
	
	public int summationOfSubPath(List<Vertex> path) {
		List<List<Integer>> matriz = this.graph.buildAdjacencyMatriz();
		int sum = 0;
		for(int x = 0 ; x < path.size() - 1 ; x++) {
			sum +=matriz.get(this.graph.getVertices().indexOf(path.get(x))).get(this.graph.getVertices().indexOf(path.get(x + 1)));
		}
		return sum;
	}



	@Override
	public List<Vertex> largestPathWithRoot(Vertex initialVertex) {
		ArrayList<Boolean> visited = new ArrayList<Boolean>(this.graph.getVertices().size());
		for (int x = 0; x < this.graph.getVertices().size(); x++)
			visited.add(new Boolean(false));

		visited.set(this.graph.getVertices().indexOf(initialVertex), new Boolean(true));
		List<Vertex> path = pathWithLargestDistance(this.graph.buildAdjacencyMatriz(), visited, initialVertex);
		path.add(0 , initialVertex);
		return path;
	}


	@Override
	public List<Vertex> pathWithLargestDistance() {
		List<Vertex> path = new ArrayList<Vertex>(); int max = 0;
		for( int x = 0 ; x < this.graph.getVertices().size() ; x++) {
			
			
			ArrayList<Boolean> visited = new ArrayList<Boolean>(this.graph.getVertices().size());
			for (int y = 0; y < this.graph.getVertices().size(); y++)
				visited.add(new Boolean(false));
			
			visited.set(x, true);
			
		
			List<Vertex> tmp = pathWithLargestDistance(this.graph.buildAdjacencyMatriz() , visited , this.graph.getVertices().get(x));
			
			int summationOfSubPath = this.summationOfSubPath(tmp);
			if( summationOfSubPath  > max) {
				max = summationOfSubPath;
				path = new ArrayList<Vertex>(tmp);
				path.add(0 , this.graph.getVertices().get(x));
			}
		}
		return path.isEmpty() ? new ArrayList<Vertex>() : path;
	}
	
	public int count = 0;

	private List<Vertex> pathWithLargestDistance(List<List<Integer>> matriz, List<Boolean> visited, Vertex V) {
		count++;
		//verifica se NAO há arestas não visitadas posteriores ao vertice V
		if (!this.graph.hasEdge( V, visited)) {
			//se sim então retorne lista vazia
			return new ArrayList<Vertex>();
		}
		//caso contrário continue
		/*lógicamente apartir desse ponto existe(m) um ou vários sub-caminho(s) não nulo(s)
		que a priori deve(m) ser computado(s) e comparado(s) para que se obtenha o caminho mais largo
		e servir como retorno da chamada 
		*/
		
		Iterator<Integer> i = matriz.get(this.graph.getVertices().indexOf(V)).iterator();
		
		// lista de vertices que representa o caminho com maior distancia
		List<Vertex> path = new ArrayList<Vertex>(); 	
		// variaveis temporarias
		int count = 0, sum = 0; 
		while (i.hasNext()) {
			int degreeEdge = i.next();
			// verifica se aresta entre vertices V e ponteiro é NAO nula e NAO visitada
			if (degreeEdge != 0 && !visited.get(count)) {
				// se sim, seta como visitada
				visited.set(count, new Boolean(true)); 
				//realiza combinacoes das arestas adjacentes de V com algoritmo bakctracking até que encontre no caso base
				List<Vertex> subPath = pathWithLargestDistance(matriz,visited,this.graph.getVertices().get(count));
				// adiciona vertice atual como parte da solução
				subPath.add(0, this.graph.getVertices().get(count));
				//instancia-se variavel temporaria para armazenar o valor das somas das arestas anteriores
				int sum_prev = sum;
				//armazena o valor do somatorio das arestas atual e compara com a anterior
				sum = Math.max(degreeEdge + 
						summationOfSubPath(subPath) , sum);
				
				if(sum_prev < sum) {
					path = new ArrayList<Vertex>(subPath);
				}

				visited.set(count, new Boolean(false));
			}
			//incrementa ponteiro
			++count;
		}
		return path;
	}
	
	
	public List<Vertex> pathWithSmallestDistanceBetween(Vertex initialVertex, Vertex terminalVertex) {

		
		List<Boolean> visited = new ArrayList<Boolean>();
		for (int x = 0; x < this.graph.getVertices().size(); x++)
			visited.add(false);

		visited.set(this.graph.getVertices().indexOf(initialVertex), true); 
		
		List<Vertex> path = pathWithSmallestDistanceBetween(this.graph.buildAdjacencyMatriz(), visited, initialVertex, terminalVertex);
		if(path.isEmpty()) {
			return new ArrayList<Vertex>();
		}else {
			path.add(0,initialVertex);
			return path;
		}
	}
	
	
	private List<Vertex> pathWithSmallestDistanceBetween(List<List<Integer>> matriz, List<Boolean> visited, Vertex V, Vertex terminalVertex) {
		if (!this.graph.hasEdge( V, visited)) {
			return new ArrayList<Vertex>();
		}

		Iterator<Integer> i = matriz.get(this.graph.getVertices().indexOf(V)).iterator();
		List<Vertex> path = new ArrayList<Vertex>();
		int count = 0, sum = Integer.MAX_VALUE;
		while (i.hasNext()) {
			int degreeEdge = i.next();
			if (degreeEdge != 0 && !visited.get(count) && hasPathBetween(matriz, new ArrayList<Boolean>(visited), this.graph.getVertices().get(count) , terminalVertex )) {
				visited.set(count, new Boolean(true));
				
				
				List<Vertex> subPath = pathWithSmallestDistanceBetween(matriz,visited,this.graph.getVertices().get(count),terminalVertex);
				subPath.add(0, this.graph.getVertices().get(count));
				int sum_prev = sum;
				sum = Math.min(degreeEdge + 
						summationOfSubPath(subPath) , sum);
				
				if(sum_prev > sum) {
					path = new ArrayList<Vertex>(subPath);
				}

				visited.set(count, new Boolean(false));
			}

			++count;
		}
		return path;
	}
	
	
	
	
	
	
	//____________FIM _______TESTE______________________
	
	
//	//OK
//	@Override
//	public int maxDistanceBetween(Vertex initialVertex, Vertex terminalVertex) {
//
//		/*
//		 * Algoritmo calcula o valor máximo das combinações geradas entre dois vertíces de um grafo
//		 * 
//		 * O(n!)
//		 * 
//		 */
//		List<Boolean> visited = new ArrayList<Boolean>();
//		for (int x = 0; x < this.graph.getVertices().size(); x++)
//			visited.add(false);
//
//		visited.set(this.graph.getVertices().indexOf(initialVertex), true); 
//		
//		// marca vertíce inicial como visitada
//
//		return maxDistanceBetween(this.graph.buildAdjacencyMatriz(), visited, initialVertex, terminalVertex);
//
//	}
//	//OK
	@Override
	public boolean hasPathBetween(List<List<Integer>> matriz, List<Boolean> visited, Vertex V, Vertex terminalVertex) {
		
		/*
		 * Algoritmo verifica se há sub-árvore adjacente entre ambos os vertíces
		 */
		
		if (terminalVertex.equals(V)) {
			return true;
		}
		if (!this.graph.hasEdge( V, visited )) {
			return false;
		}

		Iterator<Integer> i = matriz.get(this.graph.getVertices().indexOf(V)).iterator();

		int count = 0;
		while (i.hasNext()) {
			int degreeEdge = i.next();

			if (degreeEdge != 0 && !visited.get(count)) {
				visited.set(count, new Boolean(true));
				if (hasPathBetween(matriz, visited, this.graph.getVertices().get(count), terminalVertex)) {
					return true;
				}
				visited.set(count, new Boolean(false));
			}
  
			++count;
		}
		return false;
	}
//	// OK
//	
//	private int maxDistanceBetween(List<List<Integer>> matriz, List<Boolean> visited, Vertex V, Vertex terminalVertex) {
//		if (!this.graph.hasEdge(matriz, V, visited)) {
//			return 0;
//		}
//
//		Iterator<Integer> i = matriz.get(this.graph.getVertices().indexOf(V)).iterator();
//
//		int count = 0, sum = 0;
//		while (i.hasNext()) {
//			int degreeEdge = i.next();
//			if (degreeEdge != 0 && !visited.get(count) && hasPathBetween(matriz, new ArrayList<Boolean>(visited), this.graph.getVertices().get(count) , terminalVertex )) {
//				visited.set(count, new Boolean(true));
//				sum = Math.max(degreeEdge + 
//						maxDistanceBetween(matriz, visited, this.graph.getVertices().get(count), terminalVertex),sum);
//
//				visited.set(count, new Boolean(false));
//			}
//
//			++count;
//		}
//		return sum;
//	}
//	
//
//	// ____________________________________________________________________________________________________________________________________________________________________________________________________________________________________________
//
//	 // OK
//	public int largestPath() {
//		List<List<Integer>> matriz = this.graph.buildAdjacencyMatriz();
//		
//		int result = 0;
//		for (int i = 0; i < matriz.size(); i++) {
//			
//			result = Math.max(largestPathWithRoot(this.graph.getVertices().get(i)), result);
//
//		}
//		return result;
//	}
//
//	public int largestPathWithRoot(Vertex initialVertex) { // OK
//
//		ArrayList<Boolean> visited = new ArrayList<Boolean>(this.graph.getVertices().size());
//		for (int x = 0; x < this.graph.getVertices().size(); x++)
//			visited.add(new Boolean(false));
//
//		visited.set(this.graph.getVertices().indexOf(initialVertex), new Boolean(true));
//		return largestPath(this.graph.buildAdjacencyMatriz(), visited, initialVertex);
//	}
//
//	
//	//OK
//	private int largestPath(List<List<Integer>> matriz, List<Boolean> visited, Vertex V) {
//		if (!this.graph.hasEdge(matriz, V, visited)) {
//			return 0;
//		}
//
//		Iterator<Integer> i = matriz.get(this.graph.getVertices().indexOf(V)).iterator();
//
//		int count = 0, sum = 0;
//		while (i.hasNext()) {
//			int degreeEdge = i.next();
//			if (degreeEdge != 0 && !visited.get(count)) {
//
//				visited.set(count, new Boolean(true));
//				sum = Math.max(degreeEdge + largestPath(matriz, visited, this.graph.getVertices().get(count)), sum);
//				visited.set(count, new Boolean(false));
//			}
//
//			++count;
//		}
//		return sum;
//	}
//	
//	


	
	
	
	
}
