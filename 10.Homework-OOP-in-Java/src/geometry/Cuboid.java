package geometry;

public class Cuboid extends SpaceShape {

	private Vertex a;
	private double width;
	private double height;
	private double depth;
	
	public Cuboid(Vertex3D a, double width, double heigth, double depth) {
		super(new Vertex[]{a});
		this.setA(a);
		this.setWidth(width);
		this.setHeight(heigth);
		this.setDepth(depth);
	}

	public Vertex getA() {
		return a;
	}

	public void setA(Vertex a) {
		this.a = a ;
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
	
	public double getDepth() {
		return depth;
	}

	public void setDepth(double depth) {
		this.depth = depth;
	}

	@Override
	public double calculateArea() {
		double area = this.width * 2 + this.height * 2 + this.depth * 2;
		return area;
	}

	@Override
	public double calculateVolume() {
		double volume = this.width * this.height * this.depth;
		return volume;
	}
	
	@Override
	public String toString() {
		
		return String.format(
				"A %s: width = %.2f, height = %.2f  and depth = %.2f", 
				this.getClass().getSimpleName().toLowerCase(),
				this.width,
				this.height,
				this.depth);
	}
}
