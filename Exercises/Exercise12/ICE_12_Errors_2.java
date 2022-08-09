import becker.robots.*;

// This robot will be able to keep track of how many
// moves it's made, and then be able to print a message to
// the user saying that.
class MoveRobot extends Robot
{
    int numberOfMovesMade = 0;// Error: the type of value hasn't been defined (int). Also best practice to
                              // make it a private var.
    int numTurns = 0;

    MoveRobot(City c, int st, int ave, Direction dir, int num)
    {
        super(c, st, ave, dir, num);
    }

    public void moveCounted()
    {
        this.move();
        this.numberOfMovesMade = this.numberOfMovesMade + 1;
        // Error: Doesn't stop the program from running, but this multiplies the
        // numMoves by 2 instead of adding by 1 - Fixed.
    }

    public void printNumberOfMoves()
    {
        System.out.println("Since I started counting, I moved:");
        System.out.println(this.numberOfMovesMade);
        System.out.println("times!");
    }

    public void leftTurnCounted()
    {
        this.turnLeft();
        this.numTurns += 1;
    }

    public void printNumberOfLeftTurns()
    {
        System.out.println("Since I started counting, I turned: " + this.numTurns + " times.");
    }
}

public class ICE_12_Errors_2 extends Object
{
    public static void main(String[] args)
    {
        City ForgetsVille = new City();
        MoveRobot mary = new MoveRobot(ForgetsVille, 4, 1, Direction.EAST, 0);
        new Wall(ForgetsVille, 2, 5, Direction.NORTH);
        // Error: CityFrame frame = new CityFrame(ForgetsVille); - City Frame isn't a
        // class anymore.
        // In addition it isn't used in the code, since City replaces it, so I just
        // deleted the line.

        // First keep track of these 4
        mary.moveCounted();
        mary.moveCounted();
        mary.moveCounted();
        mary.moveCounted();
        mary.printNumberOfMoves();

        mary.leftTurnCounted();

        while (mary.frontIsClear())// Error: there is a semicolon here.
        {
            mary.moveCounted();// Error: Forgot to put parentheses after moveCounted to indicate that it's a
                               // function.
        }
        mary.printNumberOfMoves();// Error: There is no dot (.) b/ween mary and printNumberOfMoves()
        mary.printNumberOfLeftTurns();
    }
}
