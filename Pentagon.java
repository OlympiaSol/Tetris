public class Pentagon extends Shape{

	public Pentagon(int boundingRectangle) {
		super(boundingRectangle);
	}

	public double computeArea() {
		return (3*getBoundingRectangle())/4.0;
	}

	public String getType() {
		return "Pentagon";
	}
}