import java.util.*;
/*
 * Projected and implemented by: Júlio Bengtson Neves (J-Bengtson)
 * Projetado e implementado por: Júlio Bengtson Neves (J-Bengtson)
 * Available on Github: github.com/J-Bengtson
 * 
 */
public class Graph {

	
	private Boolean isDirected;
	private final List<Vertex> vertices;
	private final List<Edge> edges;

	Graph(Boolean isDirected) { // OK
		this();
		this.isDirected = isDirected;
		
	}

	private Graph() { // OK
		this.isDirected = new Boolean(false);
		this.vertices = new LinkedList<Vertex>();
		this.edges = new LinkedList<Edge>();
	}

	public boolean addVertices(List<Vertex> vertices) {
		return this.vertices.addAll(vertices);
	}
	
	public boolean addVertex(Vertex vertex) { // OK
		if (this.vertices.contains(vertex))
			return false;
		else {
			this.vertices.add(vertex);
			return true;
		}
	}
	
	
	public boolean addEdge(Vertex v1 , Vertex v2 , Integer degree) {
		return this.addEdge(new Edge(v1,v2,degree));
	}
	public boolean addEdge(Edge edge) { // OK
		if (this.edges.contains(edge))
			return false;
		else {
			this.edges.add(edge);
			return true;
		}
	}

	public Graph getInducedSubgraph(Iterator<Vertex> vertices) { // OK
		/*
		 * (EN) A vertex-induced subgraph (sometimes simply called an
		 * "induced subgraph") is a subset of the vertices of a graph together with any
		 * edges whose endpoints are both in this subset.
		 * 
		 * (PT-BR) Um subgráfico induzido por vértice (às vezes chamado simplesmente de
		 * "subgráfico induzido") é um subconjunto dos vértices de um gráfico,
		 * juntamente com as arestas cujos pontos finais estão nesse subconjunto.
		 */

		Graph inducedSubgraph = new Graph(this.isDirected());

		while (vertices.hasNext()) {
			inducedSubgraph.addVertex(vertices.next());
		}

		for (Edge edge : this.getEdges()) {
			if (inducedSubgraph.getVertices().contains(edge.getVertex1())
					&& inducedSubgraph.getVertices().contains(edge.getVertex2()))
				inducedSubgraph.addEdge(edge);
		}

		return inducedSubgraph;
	}

	// __________________________ALGORITHMS________________________________
	
	
	

	public List<Vertex> largestPathWithRoot(Algorithm algorithm, Vertex initialVertex){
		return algorithm.getAlgorithm(this).largestPathWithRoot(initialVertex);
	}
	public List<Vertex> pathWithLargestDistanceBetween(Algorithm algorithm, Vertex initialVertex , Vertex terminalVertex){
		return algorithm.getAlgorithm(this).pathWithLargestDistanceBetween(initialVertex, terminalVertex);
	}
	public List<Vertex> pathWithLargestDistance(Algorithm algorithm){
		return algorithm.getAlgorithm(this).pathWithLargestDistance();
	}
	public List<Vertex> pathWithSmallestDistanceBetween(Algorithm algorithm ,Vertex initialVertex, Vertex terminalVertex) {
		return algorithm.getAlgorithm(this).pathWithSmallestDistanceBetween(initialVertex, terminalVertex);
	}

		
	
	//________________________________
	

	public boolean hasEdge( Vertex V, List<Boolean> visited) { // OK
		List<List<Integer>> matriz = this.buildAdjacencyMatriz();
		for (int x = 0; x < matriz.get(this.getVertices().indexOf(V)).size(); x++) {
			if (matriz.get(this.getVertices().indexOf(V)).get(x) != 0 && !visited.get(x))
				return true;
		}
		return false;
	}

	public List<List<Integer>> buildAdjacencyMatriz() { // OK

		List<List<Integer>> matrizAdjacency = new ArrayList<List<Integer>>();

		for (int x = 0; x < vertices.size(); x++) {
			matrizAdjacency.add(new ArrayList<Integer>());
			for (int y = 0; y < vertices.size(); y++) {
				matrizAdjacency.get(x).add(0);
			}
		}
		if (this.isDirected()) { // directed graph

			for (Edge edge : this.getEdges()) {

				int x = vertices.indexOf(edge.getVertex1());
				int y = vertices.indexOf(edge.getVertex2());
				int degree = edge.getDegree();
				matrizAdjacency.get(x).set(y, degree);

			}

		} else { // undirected graph

			for (Edge edge : this.getEdges()) {

				int x = vertices.indexOf(edge.getVertex1());
				int y = vertices.indexOf(edge.getVertex2());
				int degree = edge.getDegree();
				matrizAdjacency.get(x).set(y, degree);
				matrizAdjacency.get(y).set(x, degree);

			}

		}

		// System.out.println(matrizAdjacency);

		return matrizAdjacency;
	}

	public void showGraph() { // OK
		System.out.println("The graph is " + (this.isDirected ? "directed" : "undirected"));
		System.out.println("vertex: " + this.vertices);
		System.out.println("edges: " + this.edges);

		new JGraphVisualizator(this);
	}
	

	// ____________________________________________ GETTERS e SETTERS

	public List<Vertex> getVertices() {
		return this.vertices;
	}

	public List<Edge> getEdges() {
		return this.edges;
	}

	public boolean isDirected() {
		return this.isDirected;
	}

	
	
	
}
