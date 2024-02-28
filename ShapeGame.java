import java.util.Scanner;

public class ShapeGame {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		System.out.println("Give the number of shapes per type");
		int numberShapes = input.nextInt();
		System.out.println("Give the size of the stack for the player");
		int sizeStack = input.nextInt();
		System.out.println();
		ShapeGenerator shapeGenerator = new ShapeGenerator(numberShapes);
		Player player = new Player(sizeStack);
		
		while(shapeGenerator.hasShape() && !player.isStackFull()) {
			Shape shape = shapeGenerator.nextShape();
			player.playShape(shape);
			if(shapeGenerator.hasShape() && !player.isStackFull()) {
				player.printStack();
			}
		}
		
		System.out.println("GAME OVER");
	}
}