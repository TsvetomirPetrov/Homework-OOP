package geometry;

public abstract class Vertex {
	private double coordX;
	private double coordY;

	public Vertex(double coordX, double coordY) {	
		this.setCoordX(coordX);
		this.setCoordY(coordY);
	}

	
	public double getCoordX() {
		return coordX;
	}

	public void setCoordX(double coordX) {
		this.coordX = coordX;
	}

	public double getCoordY() {
		return coordY;
	}

	public void setCoordY(double coordY) {
		this.coordY = coordY;
	}

	@Override
	public String toString() {
		return "Vertex coordX=" + coordX + ", coordY=" + coordY;
	}
}
