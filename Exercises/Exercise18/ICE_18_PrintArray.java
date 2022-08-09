import java.util.*;


class ArrayHelper extends Object
{
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
    
    public void FindInArray(int[] arrToLookIn, int value)
    {
        boolean containsVal = false;
        for(int i=0; i<arrToLookIn.length; i++)
        {
            if(arrToLookIn[i] == value)
            {
                System.out.println("We found the value at index: " + i + ".");
                containsVal = true;
            }
        }
        if(containsVal==false)
        {
            System.out.println("This value was not found in the array.");
        }
    }
}

public class ICE_18_PrintArray extends Object
{
    public static void main(String[] args)
    {
        ArrayHelper ah = new ArrayHelper();
    
        // Now set up the array stuff, which is more interesting:
        int [] shortArray = new int[3];
        int i;
        for(i = 0; i < shortArray.length; i++)
        {
            shortArray[i] = (i + 1) * 2 - 1;
        }
        
        int [] longArray = {1, 2, 3, 5, 7};
        // print out both arrays
        System.out.println("Short Array: ");
        ah.PrintArray(shortArray);
        System.out.println("Long Array: ");
        ah.PrintArray(longArray);
        
        //Part 2
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an integer value to find in long array: ");
        int longvalue = sc.nextInt();
        ah.FindInArray(longArray, longvalue);
        System.out.println("Enter an integer value to find in short array: ");
        sc.nextLine();
        int shortvalue = sc.nextInt();
        ah.FindInArray(shortArray, shortvalue);
    }
}