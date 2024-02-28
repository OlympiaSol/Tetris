public class Circle extends Shape{

	public Circle(int boundingRectangle) {
		super(boundingRectangle);
	}

	public double computeArea() {
		return (Math.PI*getBoundingRectangle())/4.0;
	}

	public String getType() {
		return "Circle";
	}
}