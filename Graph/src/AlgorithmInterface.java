import java.util.List;

/*
 * Projected and implemented by: Júlio Bengtson Neves (J-Bengtson)
 * Projetado e implementado por: Júlio Bengtson Neves (J-Bengtson)
 * Available on Github: github.com/J-Bengtson
 * 
 */
public interface AlgorithmInterface {
	public List<Vertex> largestPathWithRoot(Vertex initialVertex);
	public List<Vertex> pathWithLargestDistanceBetween(Vertex initialVertex , Vertex terminalVertex);
	public List<Vertex> pathWithLargestDistance();
	public List<Vertex> pathWithSmallestDistanceBetween(Vertex initialVertex, Vertex terminalVertex);
	public boolean hasPathBetween(List<List<Integer>> matriz, List<Boolean> visited, Vertex V, Vertex terminalVertex);


}
