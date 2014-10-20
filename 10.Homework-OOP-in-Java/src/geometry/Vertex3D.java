package geometry;

public class Vertex3D extends Vertex {

	private double coordZ;

	public Vertex3D(double coordX, double coordY, double coordZ) {
		super(coordX, coordY);
		this.setCoordZ(coordZ);
	}

	public double getCoordZ() {
		return coordZ;
	}

	public void setCoordZ(double coordZ) {
		this.coordZ = coordZ;
	}

	@Override
	public String toString() {
		return super.toString() + ", coordZ=" + coordZ;
	}

}
