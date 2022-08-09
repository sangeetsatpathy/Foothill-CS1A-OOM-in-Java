//import java.util.*;

class ArrayHelper2 extends Object
{

    // Copy this from the previous in class exercise
    public void PrintArray(int[] arr)
    {
        // Your code goes here - use
        // the "process all elements" pattern, where the work
        // to be done is printing each element
        for(int i=0; i<arr.length;i++)
        {
            System.out.println(arr[i]);
        }
    }

	 // This is the code you need to fill in
    public void FindMaxInArray(int[] myArr)
    {
        int max = myArr[0];
        int locationOfMax = 0;
        for(int i=0; i<myArr.length; i++)
        {
            if(myArr[i]>max)
            {
                max = myArr[i];
                locationOfMax = i;
            }
            
        }
        
        
        System.out.println("The largest value in the array is: " + max );
        System.out.println("The location of the largest value in the array is: " + locationOfMax );
    }
}

public class ICE_18_FindMaxInArray extends Object
{
    public static void main(String[] args)
    {
        ArrayHelper2 ah = new ArrayHelper2();
    
        // Now set up the array stuff, which is more interesting:
        int [] shortArray = new int[4];
        int i;
        for(i = 0; i < shortArray.length; i++)
        {
            shortArray[i] = (i + 1) * 2;
        }
        
        int [] longArray = new int[14];
        // We want to put numbers into the long array in reverse order
        // we should thus count DOWN through the slot numbers, 
        // and simultaneously have counter count UP
        int counter = 0;
        for(i = longArray.length-1; i >= 0; i--)
        {
            longArray[i] = (counter + 1) * 3;
            counter++;
        }
        System.out.println("Short Array: " );
        ah.PrintArray(shortArray);
        System.out.println("Long Array:  " );
        ah.PrintArray(longArray);
        ah.FindMaxInArray(shortArray);
        ah.FindMaxInArray(longArray);
    }
}