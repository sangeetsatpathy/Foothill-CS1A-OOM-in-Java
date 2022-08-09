import becker.robots.*;
import java.util.Scanner;

public class Basic_Keyboard_IO extends Object {
	public static void main(String[] args) {
		System.out.println("THE PROGRAM STARTS HERE!!");

		int numMoves = 0;
		int counter = 0;

		Scanner keyboard = new Scanner(System.in);

		City sf = new City();
		Robot mary = new Robot(sf, 1, 1, Direction.EAST, 0);
		System.out.println("mary.getAvenue():" + mary.getAvenue());

		System.out.println("How many intersections forward would you like the robot to go?");
		System.out.println("Scanner has a next int?: "+keyboard.hasNextInt());//log whether it has an integer as a next
		if (keyboard.hasNextInt()) {
			numMoves = keyboard.nextInt(); // nextInt actually gets the input
			System.out.println("You asked to move " + numMoves + " spaces");
			counter = 0;
			while (counter < numMoves) {
			    System.out.println("counter: "+counter);
			    System.out.println(counter+" < "+ numMoves + ": true");
				mary.move();
				System.out.println("mary.getAvenue():" + mary.getAvenue());
				System.out.println("counter has been updated to:" + ++counter);
			}
			System.out.println(counter+" < "+ numMoves + ": false");
		} else {
			System.out.println("You did NOT type in a whole number!");
		}
		System.out.println("counter is finally:" + counter);

		keyboard.nextLine(); // DON'T FORGET TO CLEAR ANY REMAINING INPUT!!
		keyboard.close(); // You don't have to close the Scanner resource, but
		// it is good practice to do so
		System.out.println("THE PROGRAM ENDS HERE!!");
	}
}
