import java.util.LinkedList;
import java.util.Scanner;

public class Player{
	private double points;
	private LinkedList<Shape> stack;
	private int size;
	
	public Player(int size){
		this.points = 0;
		this.stack = new LinkedList<Shape>();
		this.size = size;
	}
	
	public void playShape(Shape shape) {
		System.out.println("Incoming " + shape);
		System.out.println("Do you want to accept? (y/n)");
		
		Scanner input = new Scanner(System.in);
		String answer = input.nextLine();
		
		if (answer.equals("y")) {
			if(stack.size() == 0) {
				stack.addFirst(shape);
				points+=shape.computeArea();
				System.out.println("Added " + shape.computeArea() + " points");
			} else if (stack.getFirst().computeArea() == shape.computeArea() && stack.getFirst().getType().equals(shape.getType())) {
				stack.removeFirst();
				points+=shape.computeArea()*10;
				System.out.println("10X points!");
				System.out.println("Top shapes removed");
				System.out.println("Added " + shape.computeArea()*10 + " points");
			} else if(stack.getFirst().computeArea() == shape.computeArea()) {
				stack.addFirst(shape);
				points+=shape.computeArea()*10;
				System.out.println("10X points!");
				System.out.println("Added " + shape.computeArea()*10 + " points");
			} else if(stack.getFirst().getType().equals(shape.getType())){
				stack.removeFirst();
				points+=shape.computeArea();
				System.out.println("Added " + shape.computeArea() + " points");
				System.out.println("Top shapes removed");
			} else {
				stack.addFirst(shape);
				points+=shape.computeArea();
				System.out.println("Added " + shape.computeArea() + " points");
			}
			System.out.println("Player has " + points + " points\n");
		} else {
			System.out.println("Player has " + points + " points\n");
		}
	}
	
	public boolean isStackFull() {
		return size == stack.size();
	}
	
	public void printStack() {
		System.out.println("Current stack:");
		for (int i = 0; i < stack.size(); i++) {
			System.out.println("\t" + (stack.size() - i) + ":" + stack.get(i));
		}
		System.out.println();
	}
	
	public double getPoints() {
		return points;
	}
}