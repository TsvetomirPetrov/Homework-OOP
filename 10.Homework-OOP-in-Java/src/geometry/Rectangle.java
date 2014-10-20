package geometry;

public class Rectangle extends PlaneShape implements AreaMeasurable, PerimeterMeasurable {
	private Vertex a;
	private double width;
	private double height;
	
	public Rectangle(Vertex2D a, double width, double heigth) {
		super(new Vertex[]{a});
		this.setA(a);
		this.setWidth(width);
		this.setHeight(heigth);
	}

	public Vertex getA() {
		return a;
	}

	public void setA(Vertex a) {
		this.a= a ;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		if (width > 0) {
			this.width = width;
		}else {
			throw new IllegalArgumentException("Width must be positive number!");
		}
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		if (height > 0) {
			this.height = height;
		}else {
			throw new IllegalArgumentException("Height must be positive number!");
		}
	}
	
	@Override
	public double calculatePerimeter() {
		double perimeter = this.width * 2 + this.height * 2;
		
		return perimeter;
	}

	@Override
	public double calculateArea() {
		double area = this.width * this.height;
		
		return area;
	}
	
	@Override
	public String toString() {
		
		return String.format(
				"A %s: width = %.2f and height = %.2f", 
				this.getClass().getSimpleName().toLowerCase(),
				this.width,
				this.height);
	}
}
