import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.*;
import java.awt.*;
import javax.swing.JFrame;
/*
 * Projected and implemented by: Júlio Bengtson Neves (J-Bengtson)
 * Projetado e implementado por: Júlio Bengtson Neves (J-Bengtson)
 * Available on Github: github.com/J-Bengtson
 * 
 */

public class JGraphVisualizator extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private static final int WIDTH = 400 , HEIGHT = 400;
	
	JGraphVisualizator(Graph graph){
		super("JGraph");
		this.setSize(WIDTH, HEIGHT);
		this.setAlwaysOnTop(true);
		
		//System.out.println(graph.getVertex().size());
		this.getContentPane().add(new JCanvas(graph));

		
		this.setVisible(true);
		//this.pack();
	}
	
	
	private class JCanvas extends Canvas{
		private Graph graph;
		JCanvas(Graph graph){
			super();
			
			this.graph = graph;
			
			repaint();
		}
		
		
		@Override
		public void paint(Graphics g) {
			Collection<Vertex> vertices = graph.getVertices();
			Collection<Edge> edges = graph.getEdges();

			g.setColor(Color.RED);
			
			Map<Vertex, Point> map = new TreeMap<Vertex,Point>();
			
			
			for( Vertex v : vertices) {
				
				int x = (int) (Math.random() * JGraphVisualizator.HEIGHT) + 1;
				int y = (int) (Math.random() * JGraphVisualizator.WIDTH) + 1;
				
				map.put( v , new Point(x,y));
				g.fillOval(x , y  , 4 , 4);
				g.drawString(v.getId() , x  ,y );
				
			}
			
			g.setColor(Color.BLACK);
			for( Edge e : edges) {
				
				Point pV1 = null , pV2 = null ;
				
				for(Map.Entry<Vertex, Point> entry : map.entrySet()) {
					if(entry.getKey().compareTo(e.getVertex1())) {
						pV1 = entry.getValue();
						break;
					}
						
				}
				
				for(Map.Entry<Vertex, Point> entry : map.entrySet()) {
					if(entry.getKey().compareTo(e.getVertex2())) {
						pV2 = entry.getValue();
						break;
					}
						
				}

				
			
				if(graph.isDirected()) {
					
					this.drawArrow(g , pV1.x , pV1.y , pV2.x  , pV2.y  );
		
				}
				else {
					g.drawLine(pV1.x + 5, pV1.y + 5  , pV2.x + 5 , pV2.y + 5);	
				}
				
				g.drawString(String.valueOf(e.getDegree()), (int)(pV1.x+pV2.x)/2,(int)(pV1.y+pV2.y)/2);

			}
			
			g.dispose();
		}
		

        void drawArrow(Graphics g1, int x1, int y1, int x2, int y2) {
            Graphics2D g = (Graphics2D) g1.create();
            
            int ARR_SIZE = 4;
            
            double dx = (x2 - x1), dy = y2 - y1;
            double angle = Math.atan2(dy, dx);
            int len = (int) Math.sqrt(dx*dx + dy*dy);
            AffineTransform at = AffineTransform.getTranslateInstance(x1, y1);
            at.concatenate(AffineTransform.getRotateInstance(angle));
            g.transform(at);

            // Draw horizontal arrow starting in (0, 0)
            g.drawLine(0, 0, len, 0);
            g.fillPolygon(new int[] {len + 4, len-ARR_SIZE - 2, len-ARR_SIZE - 2, len + 4},
                          new int[] {0, -ARR_SIZE, ARR_SIZE, 0}, 4);
        }
		
	}

}
