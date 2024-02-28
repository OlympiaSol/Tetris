import java.util.Random;

public class ShapeGenerator {
	Shape[] shapes;
	int[] sizes = new int[] {1,2,3,4,8,12,16};
	int[] isIn; // 0--> einai to sxhma mesa, 1--> den einai
	
	public ShapeGenerator(int number) {
		shapes = new Shape[number*4];
		isIn = new int[number*4];
		initializeShapes();
	}
	
	private void initializeShapes() {
		Random random = new Random();
		for(int i = 0; i < shapes.length/4; i++) {
			int index_size = random.nextInt(sizes.length);
			int B = sizes[index_size];
			while(true) {
				int index = random.nextInt(shapes.length);
				if(shapes[index] == null) {
					shapes[index] = new Square(B);
					break;
				}
			}
		}
		
		for(int i = 0; i < shapes.length/4; i++) {
			int index_size = random.nextInt(sizes.length);
			int B = sizes[index_size];
			while(true) {
				int index = random.nextInt(shapes.length);
				if(shapes[index] == null) {
					shapes[index] = new Triangle(B);
					break;
				}
			}
		}
		
		for(int i = 0; i < shapes.length/4; i++) {
			int index_size = random.nextInt(sizes.length);
			int B = sizes[index_size];
			while(true) {
				int index = random.nextInt(shapes.length);
				if(shapes[index] == null) {
					shapes[index] = new Pentagon(B);
					break;
				}
			}
		}
		
		for(int i = 0; i < shapes.length/4; i++) {
			int index_size = random.nextInt(sizes.length);
			int B = sizes[index_size];
			while(true) {
				int index = random.nextInt(shapes.length);
				if(shapes[index] == null) {
					shapes[index] = new Circle(B);
					break;
				}
			}
		}
	}
	
	public Shape nextShape() {
		Random random = new Random();
		int index = random.nextInt(shapes.length);
		while(isIn[index] == 1){
			index = random.nextInt(shapes.length);
		}
		isIn[index] = 1;
		return shapes[index];
	}
	
	public boolean hasShape() {
		for(int i = 0; i < isIn.length; i++) {
			if(isIn[i] == 0) {
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		String temp = "";
		for(int i = 0; i < isIn.length; i++) {
			if(isIn[i] == 0) {
				temp+= i + ") " + shapes[i] + "\n";
			}
		}
		return temp;
	}
	
	public static void main(String args[]) {
		ShapeGenerator generator = new ShapeGenerator(2);
		System.out.println(generator.toString());
		while(generator.hasShape()) {
			Shape shape = generator.nextShape();
			System.out.println("Shape out: " + shape);
			System.out.println(generator.toString());
			System.out.println("------------------");
		}
	}
}