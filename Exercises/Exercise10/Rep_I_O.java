import becker.robots.*;
import java.util.Scanner;


/**
 * This is rep_i_o
 * @author Sangeet Satpathy*/
public class Rep_I_O extends Object
{
    public static void main(String[] args)
    {
        City toronto = new City();
        Robot jo = new Robot(toronto, 3, 0, Direction.EAST, 0);
        new Thing(toronto, 3, 2);

        /* Your code should after here: */
        int userChoice = 0;
        Scanner keyboard = new Scanner(System.in);

        while (userChoice != 5)
        {
            System.out.println("What would you like the robot to do?");
            System.out.println("Type 1 to turn left.");
            System.out.println("Type 2 to move forwards one intersection.");
            System.out.println("Type 3 to pick a Thing up.");
            System.out.println("Type 4 to put a Thing down.");
            System.out.println("Type 5 to exit the program.");

            if (keyboard.hasNextInt())
            {
                userChoice = keyboard.nextInt();
                System.out.println("You chose option: " + userChoice);

                if (userChoice == 1)
                {
                    jo.turnLeft();
                } else if (userChoice == 2)
                {
                    jo.move();
                } else if (userChoice == 3)
                {
                    if (jo.canPickThing())
                    {
                        jo.pickThing();
                    } else
                    {
                        System.out.println("There is nothing here to pick.");
                    }
                } else if (userChoice == 4)
                {
                    if (jo.countThingsInBackpack() > 0)
                    {
                        jo.putThing();
                    } else
                    {
                        System.out.println("There are no Things to place.");
                    }
                } else if (userChoice == 5)
                {
                    break;
                } else
                {
                    System.out.println("Please only choose from the above choices.");
                }
            } else
            {
                System.out.println("Please only enter integers.");
            }
            keyboard.nextLine();
        }
        System.exit(0);
    }
}
