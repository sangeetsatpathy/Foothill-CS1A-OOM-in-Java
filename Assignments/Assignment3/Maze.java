import becker.robots.*;

/**
 * CS1A - Assignment 3 - "The Maze" <br>
 * Quarter: 1 <br>
 * To navigate through the maze, the MazeBot class has been implemented so that
 * it can follow the left wall of the maze, which allows it to eventually find
 * the end of the maze.
 * 
 * At each step, the MazeBot will check if there is a wall to the left of it,
 * then determine its next action.<br>
 * 
 * @author Sangeet Satpathy
 */
class MazeBot extends RobotSE
{
    // TODO: Instance Variables will be declared and initialized here
    // one each for totalMoves, movesWest, movesEast, movesSouth, and MovesNorth
    private int totalMoves = 0;
    private int movesWest = 0;
    private int movesEast = 0;
    private int movesSouth = 0;
    private int movesNorth = 0;

    /**
     * Constructs a MazeBot robot, utilizing the RobotSE constructor.
     * 
     * @param theCity   The city in which the robot will be instantiated in.
     * @param str       The robot's initial street.
     * @param ave       The robot's initial avenue.
     * @param dir       The direction the robot will be facing when instantiated
     * @param numThings The number of Things that the robot will be holding when
     *                  instantiated.
     */
    public MazeBot(City theCity, int str, int ave, Direction dir, int numThings)
    {
        super(theCity, str, ave, dir, numThings);
    }

    /**
     * Overrides becker.Robot's move() function. This function moves 1 space in the
     * direction the robot is facing, counting the number of movements along the
     * way. To count the number of movements, the function increments the instance
     * variables assigned for each direction by 1 every time it moves in said
     * direction.
     */
    @Override
    public void move()
    {

        super.move();
        if (this.getDirection() == Direction.WEST)
        {
            movesWest = movesWest + 1;
        } else if (this.getDirection() == Direction.EAST)
        {
            movesEast = movesEast + 1;
        } else if (this.getDirection() == Direction.SOUTH)
        {
            movesSouth = movesSouth + 1;
        } else if (this.getDirection() == Direction.NORTH)
        {
            movesNorth = movesNorth + 1;
        }
        totalMoves = totalMoves + 1;
    }

    /**
     * The putThing() method overrides becker.Robot's putThing() function. It has
     * the added functionality that allows it to avoid crashing if there is nothing
     * to put down and it is still called. If there are no things to be put down, it
     * does nothing.
     */
    @Override
    public void putThing()
    {
        if (this.countThingsInBackpack() > 0 && !this.canPickThing())
        {
            super.putThing();
        }
    }

    /**
     * The printEverything() function prints out the number of spaces in each
     * direction the robot moved. It also prints out a tally of the total number of
     * spaces moved.
     */
    public void printEverything()
    {
        System.out.println("Robot moved: " + totalMoves + " spaces in total.");
        System.out.println("The robot moved " + movesWest + " spaces West.");
        System.out.println("The robot moved " + movesEast + " spaces East.");
        System.out.println("The robot moved " + movesSouth + " spaces South.");
        System.out.println("The robot moved " + movesNorth + " spaces North.");
    }

    // The isAtEndSpot() method below is what's called a 'helper method' It
    // exists just to make another command (in this case, NavigateMaze) easier
    // to understand. It does this by replacing some code that otherwise would
    // be in NavigateMaze with it's name, and doing that work here, instead.
    // Declaring it "private" means that only the MazeBot is allowed to call
    // upon it.
    private boolean isAtEndSpot()
    {
        return getAvenue() == 9 && getStreet() == 10;
    }

    /**
     * The method used to navigate from the start of a maze to the end of the maze.
     * This method utilizes other methods defined in this class and in the RobotSE
     * class.
     */
    public void navigateMaze()
    {
        while (!isAtEndSpot())// While the robot has not reached the end spot,
        {

            this.putThing();// the robot will place a Thing at each move

            // Robot will check if there is a wall to the left of the robot.
            this.turnLeft();
            if (!this.frontIsClear())
            {
                // If there is a wall, that means that the robot has followed the wall correctly
                while (!this.frontIsClear())
                {
                    this.turnRight();
                    // Robot will turn right till its front is clear to continue its movement
                    // This allows it to not crash at corners.
                }

            }
            // If there is no wall to the left of the robot, the robot will not turn right,
            // but will instead move down that in order to continue down the left wall.

            // After verifying it is following the left wall, the robot will move forward
            this.move();
        }

        this.printEverything();// prints the number of spaces moved in total and in each direction.
    }

}

// ###################################################################################################
// NO NEED TO TOUCH ANYTHING FROM HERE ON DOWN, EXCEPT TO CHANGE NUMBER OF
// THINGS IN BACKPACK IN MAIN AND ADDING JavaDoc
// The NavigateMaze() method is already set up and called by don the robot down
// in main
// ###################################################################################################
public class Maze extends Object
{
    private static void makeMaze(City theCity)
    {
        for (int i = 1; i < 11; i++)
        {
            // north wall
            new Wall(theCity, 1, i, Direction.NORTH);

            // Second to north wall
            if (i <= 9)
                new Wall(theCity, 1, i, Direction.SOUTH);

            // Third to north wall
            if (i >= 4)
                new Wall(theCity, 4, i, Direction.SOUTH);

            // south wall
            if (i != 9) // (9, 10, SOUTH), is where the 'exit' is
                new Wall(theCity, 10, i, Direction.SOUTH);

            // west wall
            if (i != 1) // (1, 1, WEST) is where the 'entrance' is
                new Wall(theCity, i, 1, Direction.WEST);

            // second to most western wall
            if (i >= 3 && i < 6)
                new Wall(theCity, i, 6, Direction.WEST);

            // east wall
            new Wall(theCity, i, 10, Direction.EAST);
        }

        // Cul de Sac
        new Wall(theCity, 3, 10, Direction.WEST);
        new Wall(theCity, 3, 10, Direction.SOUTH);

        new Wall(theCity, 2, 8, Direction.WEST);
        new Wall(theCity, 2, 8, Direction.SOUTH);

        new Wall(theCity, 10, 8, Direction.NORTH);
        new Wall(theCity, 10, 9, Direction.EAST);
        new Wall(theCity, 10, 9, Direction.NORTH);
        makeSpiral(theCity, 8, 9, 3);
        new Wall(theCity, 8, 10, Direction.SOUTH);

        makeSpiral(theCity, 10, 5, 4);
    }

    public static void makeSpiral(City theCity, int st, int ave, int size)
    {
        // We start out building the wall northward
        // the walls will be built on the east face of the current
        // intersection
        Direction facing = Direction.EAST;

        while (size > 0)
        {
            int spacesLeft = size;
            int aveChange = 0;
            int stChange = 0;
            switch (facing)
            {
            case EAST:
                stChange = -1;
                break;
            case NORTH:
                aveChange = -1;
                break;
            case WEST:
                stChange = 1;
                break;
            case SOUTH:
                aveChange = 1;
                break;
            }

            while (spacesLeft > 0)
            {
                new Wall(theCity, st, ave, facing);
                ave += aveChange;
                st += stChange;
                --spacesLeft;
            }
            // back up one space
            ave -= aveChange;
            st -= stChange;

            switch (facing)
            {
            case EAST:
                facing = Direction.NORTH;
                break;
            case NORTH:
                facing = Direction.WEST;
                size--;
                break;
            case WEST:
                facing = Direction.SOUTH;
                break;
            case SOUTH:
                facing = Direction.EAST;
                size--;
                break;
            }
        }
    }

    // ###########################################################################################
    // Main Method
    // ###########################################################################################
    public static void main(String[] args)
    {
        City calgary = new City(12, 12);
        MazeBot don = new MazeBot(calgary, 1, 1, Direction.EAST, 1000); // TODO: <-- YOU WILL NEED TO CHANGE THIS FROM
                                                                        // ZERO

        Maze.makeMaze(calgary);

        calgary.showThingCounts(true); // This will help you see if you incorrectly put more than 1 thing down in any
                                       // intersections

        don.navigateMaze(); // <-- HERE'S WHERE THE NavigateMaze() method is
        // called. NO NEED TO TOUCH AT ALL
        don.printEverything();
    }
}
