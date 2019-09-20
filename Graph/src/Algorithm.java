/*
 * Projected and implemented by: J�lio Bengtson Neves (J-Bengtson)
 * Projetado e implementado por: J�lio Bengtson Neves (J-Bengtson)
 * Available on Github: github.com/J-Bengtson
 * 
 */
public enum Algorithm{
	DFS() {
		@Override
		public AlgorithmInterface getAlgorithm(Graph graph) {
			return new DFS(graph);
		}
	},BFS(){

		@Override
		public AlgorithmInterface getAlgorithm(Graph graph) {
			return new BFS(graph);
		}
		
	};

	
	public abstract AlgorithmInterface getAlgorithm(Graph graph);
}
