/*
 * Projected and implemented by: Júlio Bengtson Neves (J-Bengtson)
 * Projetado e implementado por: Júlio Bengtson Neves (J-Bengtson)
 * Available on Github: github.com/J-Bengtson
 * 
 */
public class Edge {
	
	private final Integer degree;
	private final Vertex v1;
	private final Vertex v2;
	private String name;
	
	Edge(Vertex v1 , Vertex v2, Integer degree){
		this.v1 = v1;
		this.v2 = v2;
		this.degree = degree;
		this.name = new StringBuilder().append(v1).append(" -> ").append(v2).toString();
	}
	Edge(String name , Vertex v1 , Vertex v2 , Integer degree){
		this(v1, v2, degree);
		this.name = name;
	}
	
	
	public Vertex getVertex1() {
		return this.v1;
	}
	
	public Vertex getVertex2() {
		return this.v2;
	}
	
	public Integer getDegree() {
		return this.degree;
	}
	
	@Override
	public String toString() {
		return this.name + "("+this.degree+")";
	}
	
}
