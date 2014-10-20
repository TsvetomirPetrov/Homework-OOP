package geometry;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class SpaceShape extends Shape implements AreaMeasurable, VolumeMeasurable  {

	private final int MAX_VETEX_COUNT = 1;
	private Vertex[] vertexArray = new Vertex3D[MAX_VETEX_COUNT];
	
	public SpaceShape(Vertex[] vertexArray) {
		super(new ArrayList<Vertex>(Arrays.asList(vertexArray)));		
	}

	public Vertex[] getVertexArray() {
		return vertexArray;
	}

	public void setVertexArray(Vertex[] vertexArray) {
		this.vertexArray = vertexArray;
	}		
}