package geometry;

public class Circle extends PlaneShape implements AreaMeasurable, PerimeterMeasurable {
	private Vertex a;
	private double radius;
	
	public Circle(Vertex2D a, double radius) {
		super(new Vertex[]{a});
		this.setA(a);
		this.setRadius(radius);
	}

	public Vertex getA() {
		return a;
	}


	public void setA(Vertex a) {
		this.a = a;
	}


	public double getRadius() {
		return radius;
	}


	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	@Override
	public double calculatePerimeter() {
		double perimeter = Math.PI * this.radius * 2;
		return perimeter;
	}

	@Override
	public double calculateArea() {
		double area = Math.PI * this.radius * this.radius;
		return area;
	}

	@Override
	public String toString() {
		
		return String.format(
				"A %s: radius = %.2f", 
				this.getClass().getSimpleName().toLowerCase(),
				this.radius);
	}
}
