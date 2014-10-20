package geometry;

public class Triangle extends PlaneShape {
	
	private Vertex2D a;
	private Vertex2D b;
	private Vertex2D c;
	
	private double siteAB;
	private double siteBC;
	private double siteCA;
	
	public Triangle(Vertex2D a, Vertex2D b, Vertex2D c) {
		super(new Vertex2D[]{a, b, c});
		this.setA(a);
		this.setB(b);
		this.setC(c);
		
		this.siteAB = PlaneShape.calculateDistance(this.a, this.b);
		this.siteBC = PlaneShape.calculateDistance(this.b, this.c);
		this.siteCA = PlaneShape.calculateDistance(this.c, this.a);
		
		boolean isTriangle = this.siteAB + this.siteBC > this.siteCA ||
				 this.siteAB + this.siteCA > this.siteBC ||
				 this.siteCA + this.siteBC > this.siteAB;
		if (!isTriangle) {
			throw new IllegalArgumentException(String.format("%s, %s and %s can not form triangle! ", a.toString(), b.toString(), c.toString()));
		}
	}

	public Vertex2D getA() {
		return a;
	}

	public void setA(Vertex2D a) {
		this.a = a;
	}

	public Vertex2D getB() {
		return b;
	}

	public void setB(Vertex2D b) {
		this.b = b;
	}

	public Vertex2D getC() {
		return c;
	}

	public void setC(Vertex2D c) {
		this.c = c;
	}

	@Override
	public double calculatePerimeter() {			
		double perimeter = this.siteAB + this.siteBC + this.siteCA;
		
		return perimeter;
	}

	@Override
	public double calculateArea() {
		double halfPerimeter = this.calculatePerimeter() / 2;
		
		double area = Math.sqrt(
				halfPerimeter * 
				(halfPerimeter - this.siteAB) *
				(halfPerimeter - this.siteBC) *
				(halfPerimeter - this.siteCA));
		
		return area;
	}
	
	@Override
	public String toString() {
		
		return String.format(
				"A %s: site AB = %.2f, site BC = %.2f and site CA = %.2f", 
				this.getClass().getSimpleName().toLowerCase(),
				this.siteAB,
				this.siteBC,
				this.siteCA);
	}
	
}
