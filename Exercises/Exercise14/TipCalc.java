
// notice that we don't have "import becker.robots.*;" anymore
import java.util.Scanner;

public class TipCalc extends Object
{
    public static void main(String[] args)
    {
        // Notice how we don't need to setup the city anymore

        // create a new Scanner
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please type in the cost of the meal");

        // double precision floating point number
        double costOfMeal;

        while (!keyboard.hasNextDouble())
        {
            System.out.println("Please enter only a number, the cost of the meal.");
            keyboard.nextLine();
        }
        // go and get the number
        costOfMeal = keyboard.nextDouble();

        System.out.println("Cost of the meal is: " + costOfMeal);

        double tip15 = costOfMeal * 0.15;
        double tip20 = costOfMeal * 0.20;
        double tip30 = costOfMeal * 0.30;
        // print out tip15, tip20, tip30
        System.out.println("A tip of 15% would be make the tip cost: $" + tip15);
        System.out.println("A tip of 20% would be make the tip cost: $" + tip20);
        System.out.println("A tip of 30% would be make the tip cost: $" + tip30);

        // boolean - true/false
        boolean mealIsPricey = (costOfMeal > 20);

//		Examples of assigning a true/false value to a boolean variable:
//		mealIsPricey = false;
//		mealIsPricey = 1 < 4;

        // You'll need to fill in what you really want to assign
        // to mealIsPricey here:

        // We now use the boolean variable:
        if (mealIsPricey)
        {
            System.out.println("The meal is expensive");
        }
    }
}
