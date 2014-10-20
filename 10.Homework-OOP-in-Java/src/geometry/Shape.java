package geometry;

import java.util.ArrayList;

public abstract class Shape {
	private ArrayList<Vertex> vertecies = new ArrayList<>();
	
	public Shape(ArrayList<Vertex> vertecies) {
		this.setVertecies(vertecies);
	}

	public ArrayList<Vertex> getVertecies() {
		return vertecies;
	}

	public void setVertecies(ArrayList<Vertex> vertecies) {
		this.vertecies = vertecies;
	}
}
