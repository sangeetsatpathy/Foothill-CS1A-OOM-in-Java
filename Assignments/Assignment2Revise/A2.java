import becker.robots.*;
import java.util.Random;

/*TunnelRobot extends robot
 * This is a specialized robot made to complete this program.*/
class TunnelRobot extends Robot
{
    public TunnelRobot(City c, int st, int ave, Direction dir, int num)
    {
        super(c, st, ave, dir, num);
    }

    public void moveTillEnd()
    /*
     * method used to have robot keep moving until it hits a wall, works by having a
     * while loop check if the space in front is clear, if it is, it moves the robot
     */
    {
        while (this.frontIsClear())
        {
            this.move();
        }

    }

    public void turnAround()
    // method used to turn robot around, works by turning the robot left twice
    {
        this.turnLeft();
        this.turnLeft();
    }

    public void returnToStart()
    {
        /*
         * method used to have robot return to start from the end, the end being the end
         * of the last tube.
         */
        this.turnAround();
        this.moveTillEnd();
        this.turnRight();
        this.moveTillEnd();
        this.turnRight();

    }

    public void turnRight()
    /*
     * method used to turn robot right, works by turning the robot around, then
     * turning it left once more
     */
    {
        this.turnAround();
        this.turnLeft();
    }

    public void doEverything()
    {
        /*
         * doEverything() is the method that moves the TunnelRobot down each pipe and
         * back, utilizing helper methods defined in this class.
         */
        while (this.countThingsInBackpack() < 4)
        {
            this.moveTillEnd();
            this.pickThing();
            this.turnAround();
            this.moveTillEnd();
            this.turnLeft();
            this.move();
            this.turnLeft();
        }
        // robot will move forward, then place an item, until it has run out of items.

        while (this.countThingsInBackpack() > 0)
        {
            this.move();
            this.putThing();
        }
        this.returnToStart();
    }

}

public class A2 extends Object
{
    public static void main(String[] args)
    {
        City wallville = new City(6, 12);
        TunnelRobot rob = new TunnelRobot(wallville, 1, 2, Direction.EAST, 0);
        // robot will keep running code below until it has picked up 4 items
        A2.buildCity(wallville); // this calls the "BuildCity" method, below
        
        /*
         * TODO: * * * * * Your code to race around the race track goes here! * * * *
         * HINT: Several while loops would work well for this particular exercise. One
         * possible solution would be to start with a while loop (for checking the
         * count) that contains two nested while loops used to check whether the front
         * is clear before performing some actions. Jumping through this initial while
         * loop might use additional while loops to continue checking whether the front
         * is clear before performing other actions in order to complete the tasks of
         * the maze.
         */
        rob.doEverything();

    }

    /////////////////////////////////////////////////////////////////////////////////////////
    // No need to touch any of the code below.
    // All it does is construct the maze in the city.
    /////////////////////////////////////////////////////////////////////////////////////////
    public static void buildCity(City wallville)
    {
        // Width and height must be at least 2 (each)
        // Feel free to change these numbers, and see how your race track changes

        Random randomNumberGenerator = new Random();
        int top = 1;
        int left = 2;
        int height = 4;
        int width = 4 + randomNumberGenerator.nextInt(7);

        int streetNumber = top;
        while (streetNumber <= height)
        {
            if (streetNumber == 1)
            {
                // the topmost line:
                new Wall(wallville, streetNumber, left, Direction.NORTH);
            } else if (streetNumber == height)
            {
                // generate the 'holding spot' thing at the bottom: the corner:
                new Wall(wallville, streetNumber + 1, left, Direction.WEST);
                new Wall(wallville, streetNumber + 1, left, Direction.SOUTH);
                int spotNum = left + 1;
                int counter = 0;
                while (counter < height)
                {
                    new Wall(wallville, streetNumber + 1, spotNum, Direction.NORTH);
                    new Wall(wallville, streetNumber + 1, spotNum, Direction.SOUTH);
                    // Uncomment the next line for a 'final state' picture (i.e., the second picture
                    // in the assignment)
                    // new Thing(wallville, streetNumber + 1, spotNum);
                    ++spotNum;
                    ++counter;
                }
                new Wall(wallville, streetNumber + 1, spotNum, Direction.WEST);
            }

            // the most western, vertical line:
            new Wall(wallville, streetNumber, left, Direction.WEST);
            // the most eastern, vertical line:
            new Wall(wallville, streetNumber, width, Direction.EAST);
            // the Thing at the end of the tunnel
            new Thing(wallville, streetNumber, width);

            int aveNum = left + 1;
            while (aveNum <= width)
            {
                new Wall(wallville, streetNumber, aveNum, Direction.NORTH);
                new Wall(wallville, streetNumber, aveNum, Direction.SOUTH);
                ++aveNum;
            }

            ++streetNumber;
        }
    }
}
