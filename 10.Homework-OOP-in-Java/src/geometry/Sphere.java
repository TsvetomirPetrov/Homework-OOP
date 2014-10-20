package geometry;

public class Sphere extends SpaceShape {

	private Vertex a;
	private double radius;

	
	public Sphere(Vertex3D a, double radius) {
		super(new Vertex[]{a});
		this.setA(a);
		this.setRadius(radius);
	}

	public Vertex getA() {
		return a;
	}

	public void setA(Vertex a) {
		this.a = a ;
	}

	public double getRadius() {
		
		return radius;
	}

	public void setRadius(double radius) {
		if (radius> 0) {
			this.radius = radius;
		}else {
			throw new IllegalArgumentException("Radius must be positive number!");
		}
	}


	@Override
	public double calculateArea() {
		double area = Math.PI * this.radius * this.radius * 4;
		return area;
	}

	@Override
	public double calculateVolume() {
		double volume =  calculateArea() * this.radius / 3;
		return volume;
	}
	
	@Override
	public String toString() {		
		return String.format("A %s: radius = %.2f", this.getClass().getSimpleName().toLowerCase(), this.radius);
	}
}
