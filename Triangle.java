public class Triangle extends Shape{

	public Triangle(int boundingRectangle) {
		super(boundingRectangle);
	}

	public double computeArea() {
		return getBoundingRectangle()/2.0;
	}

	public String getType() {
		return "Triangle";
	}
}