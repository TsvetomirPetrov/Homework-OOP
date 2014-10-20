package geometry;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class PlaneShape extends Shape implements PerimeterMeasurable, AreaMeasurable {
	private final int MAX_VETEX_COUNT = 3;
	private Vertex[] vertexArray = new Vertex2D[MAX_VETEX_COUNT];
	
	public PlaneShape(Vertex[] vertexArray) {
		super(new ArrayList<Vertex>(Arrays.asList(vertexArray)));
		
	}

	public Vertex[] getVertexArray() {
		return vertexArray;
	}

	public void setVertexArray(Vertex[] vertexArray) {
		this.vertexArray = vertexArray;
	}

	public static double calculateDistance(Vertex2D a, Vertex2D b) {
		double distanceX = a.getCoordX() - b.getCoordX();
		double distanceY = a.getCoordY() - b.getCoordY();
		double distance = Math.sqrt((distanceX * distanceX) + (distanceY * distanceY));
		
		return distance;
	}		
}
