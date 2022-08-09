import becker.robots.*;

class CountingRobot extends Robot {
	CountingRobot(City c, int st, int ave, Direction dir, int num) {
		super(c, st, ave, dir, num);
	}

	public void move2() {
		int howManyTimes;
		howManyTimes = 0; // programmers like to start counting at 0 :)

		while (howManyTimes < 2) // this loop will be run a total of 2 times
		{
			this.move();
			howManyTimes = howManyTimes + 1;	// same as "++howManyTimes;"
												// This will increase
												// "howManyTimes" by one
		}
	}
}

public class ICE_06_Demo_CountingLoops extends Object {
	public static void main(String[] args) {
		City wallville = new City(10, 10);
		CountingRobot rob = new CountingRobot(wallville, 7, 0, Direction.EAST, 0);

		// new Thing(wallville, 7, 0);
		// new Thing(wallville, 7, 2);
		// new Thing(wallville, 2, 2);

		rob.move2();

		rob.turnLeft();

		// Instead of giving rob 5 separate "move" commands,
		// simply tell it that you want it to move 5 times
		int counter = 0;
		// counter = 0;

		while (counter < 5) {
			rob.move();
			counter = counter + 1;	// counter is assigned the current value of
									// i, plus 1
		}
		rob.turnLeft();

		counter = 0;	// If we want to, we can re-set and
						// re-use 'counter' again in another counting loop
	}
}
