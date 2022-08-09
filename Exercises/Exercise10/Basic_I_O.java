import becker.robots.*;
import java.util.Scanner;
/*
Starting Template:
This file was created in order to provide you with a pre made 'starter' program
 */

public class Basic_I_O extends Object {
	public static void main(String[] args) {
		City toronto = new City();
		Robot jo = new Robot(toronto, 3, 0, Direction.EAST, 0);
		new Thing(toronto, 3, 2);

		/* Your code should after here: */
		int userChoice;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("What would you like the robot to do?");
		System.out.println("Type 1 to turn left.");
		System.out.println("Type 2 to move forwards one intersection.");
		System.out.println("Type 3 to pick a Thing up.");
		System.out.println("Type 4 to put a Thing down.");
		
		if(keyboard.hasNextInt())
		{
    		userChoice = keyboard.nextInt();
    		
    		if(userChoice==1) 
    		{
    		    jo.turnLeft();
    		}
    		else if(userChoice==2)
    		{
    		    jo.move();
    		}
    		else if(userChoice==3)
    		{
    		    if(jo.canPickThing())
    		    {
    		        jo.pickThing();
    		    }else 
    		    {
    		        System.out.println("There is nothing here to pick.");
    		    }
    		}
    		else if(userChoice==4)
    		{
    		    if(jo.countThingsInBackpack()>0)
    		    {
    		        jo.putThing();
    		    }else
    		    {
    		        System.out.println("There are no Things to place.");
    		    }
    		}
		}
		else 
		{
		    System.out.println("Please only enter integers.");
		}
		
	} 
}
