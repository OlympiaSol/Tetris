public abstract class Shape {
	int boundingRectangle;
	
	public Shape(int boundingRectangle) {
		this.boundingRectangle = boundingRectangle;
	}
	
	public abstract double computeArea();
	
	public abstract String getType();
	
	public boolean sameArea(Shape other) {
		if(this.computeArea() == other.computeArea()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean sameType(Shape other) {
		if(this.getType() == other.getType()) {
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		return getType() + ":" + computeArea();
	}
	
	public int getBoundingRectangle() {
		return boundingRectangle;
	}
}