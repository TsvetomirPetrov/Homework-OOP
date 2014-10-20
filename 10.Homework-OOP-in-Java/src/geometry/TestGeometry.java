package geometry;

public class TestGeometry {

	public static void main(String[] args) {
		Vertex2D vertexA = new Vertex2D(13.2, 12.02);
		Vertex2D vertexB = new Vertex2D(10.2, 10.02);
		Vertex2D vertexC = new Vertex2D(15.2, 14.02);
		
		Triangle triangle = new Triangle(vertexA, vertexB, vertexC);
		printPlaneShapeData(triangle);
		
		Rectangle rectangle = new Rectangle(vertexA, 10.50, 15.01);
		printPlaneShapeData(rectangle);
		
		Circle circle = new Circle(vertexA, 10.05);
		printPlaneShapeData(circle);
		
		Vertex3D vertex3D = new Vertex3D(13.2, 12.02, 4);
		
		System.out.println();
		
		SquarePyramid piramid = new SquarePyramid(vertex3D, 4.5, 5.9);
		printSpaceShapeData(piramid);
		
		Cuboid cuboid = new Cuboid(vertex3D, 4.5, 5.9, 7.4);
		printSpaceShapeData(cuboid);
		
		Sphere sphere = new Sphere(vertex3D, 4.5);
		printSpaceShapeData(sphere);
				
		
	}
	
	private static void printPlaneShapeData(PlaneShape shape) {		
		System.out.println(shape);
		System.out.println(String.format("Perimeter: %.2f", shape.calculatePerimeter()));
		System.out.println(String.format("Area: %.2f",shape.calculateArea()));
	}
	
	private static void printSpaceShapeData(SpaceShape shape) {		
		System.out.println(shape);	
		System.out.println(String.format("Area: %.2f",shape.calculateArea()));
		System.out.println(String.format("Valume: %.2f", shape.calculateVolume()));
	}
}
