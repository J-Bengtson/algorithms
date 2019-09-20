/*
 * Projected and implemented by: Júlio Bengtson Neves (J-Bengtson)
 * Projetado e implementado por: Júlio Bengtson Neves (J-Bengtson)
 * Available on Github: github.com/J-Bengtson
 * 
 */
public class Vertex implements Comparable{
	private final String id;
	public Vertex(String id) {
		this.id = id;
	}
	
	
	public String getId() {
		return this.id;
	}


	@Override
	public int compareTo(Object otherVertex) {
		if(this.getId().equals(((Vertex) otherVertex).getId()))
			return 0;
		return -1;
	}
	
	public boolean compareTo(Vertex otherVertex) {
		return (this.equals(otherVertex))? true : false;
	}
	
	@Override
	public String toString() {
		return this.id;
	}
}
