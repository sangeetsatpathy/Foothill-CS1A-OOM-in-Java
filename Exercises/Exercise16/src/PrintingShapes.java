// TODO: Don't forget to import the Scanner class for Part 5
import java.util.Scanner;
/*
 * The PrintHelper class has the methods for printing various shapes
 */
class PrintHelper {
	// Your methods to print various shapes goes here
	public void printStars(int width) {
		System.out.println("Stars:");
		int whichCol = 0;
		while (whichCol < width) {
			System.out.print("*");
			++whichCol;
		}
		// Print just a new-line character
		System.out.println("");
	}

	public void printRectangle(int width, int height) {
		System.out.println("Rectangle:");
		for(int whichRow=0; whichRow<height; whichRow++)
		{
		    for(int whichCol=0; whichCol<width; whichCol++)
		    {
		        System.out.print("*");
		    }
		    System.out.println();
		}
		// Print just a new-line character
		System.out.println("");
	}
	// TODO: Add more methods for printing shapes here:
	public void printRectangleHollow(int width, int height) {
        System.out.println("Hollow Rectangle:");
        for(int whichRow=0; whichRow<height; whichRow++)
        {
            for(int whichCol=0; whichCol<width; whichCol++)
            {
                if(whichRow==0 || whichRow == height-1 || whichCol==0 || whichCol==width-1)
                {
                    System.out.print("*");
                    continue;
                }
                System.out.print(" ");
            }
            System.out.println();
        }
        // Print just a new-line character
        System.out.println("");
    }
	
	public void printLeftTriangle(int height)
	{
	    System.out.println("Triangle:");
	    for(int whichRow = height; whichRow>0; whichRow--)
	    {
	        for(int howMany=whichRow; howMany>0; howMany--)
	        {
	            System.out.print("*");
	        }
	        System.out.println();
	    }
	}
}

public class PrintingShapes extends Object {
	public static void main(String[] args) {
		// TODO: You will also add more code to this main method
		PrintHelper printer = new PrintHelper();
		Scanner sc = new Scanner(System.in);
		System.out.println("How many stars would you like me to print?");
		int numStars = sc.nextInt();
		sc.nextLine();
		printer.printStars(numStars);
		System.out.println("For a rectangle, how wide should it be?");
		int howWide = sc.nextInt();
		sc.nextLine();
		System.out.println("For a rectangle, how high should it be?");
		int howHigh = sc.nextInt();
		printer.printRectangle(howWide, howHigh);
		sc.nextLine();
		System.out.println("For a hollow rectangle, how wide should it be?");
        int howWideHollow = sc.nextInt();
        sc.nextLine();
        System.out.println("For a hollow rectangle, how high should it be?");
        int howHighHollow = sc.nextInt();
		printer.printRectangleHollow(howWideHollow, howHighHollow);
		sc.nextLine();
		System.out.println("For a left triangle, how high do you want it to be?");
		int triangleHeight = sc.nextInt();
		printer.printLeftTriangle(triangleHeight);

	}
}
