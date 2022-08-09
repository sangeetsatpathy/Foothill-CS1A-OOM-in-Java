import java.util.Scanner;

public class Arrays_With_Loops extends Object {
	public static void main(String[] args) {
		// First: Create an array
	    System.out.println("Part 1:");
        double[] dubArray = new double[5];
       
		// Second: Use a while loop to set the array elements' values
        int counter = 0;
        while(counter<dubArray.length)
        {
            dubArray[counter] = counter+1;
            ++counter;
        }
        
		// Third: Use a for loop to print out the array
        for(int k=0; k<dubArray.length; k++)
        {
            System.out.println(dubArray[k]);
        }
	}
}