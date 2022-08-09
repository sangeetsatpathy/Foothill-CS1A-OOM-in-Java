class PrintHelper extends Object
{

    public double[] getTemperatures()
    {
        double[] temps = new double[7];
        temps[0] = 5.6;
        temps[1] = 2;
        for (int i = 2; i < temps.length; i++)
            temps[i] = (i + 1) * 3 + 17;
        return temps;
    }

    public void printArray(double[] arr)
    {
        // // print out all the elements of the array that will be passed
        // // to this method.
        // // This method (and all the others) should be able operate on the
        // // array that getTemperatures produces

        // Made a quick for-each loop to print out every element in this array.
        for (double i : arr)
        {
            System.out.println(i);
        }
    }

    public double averageArray(double[] arr)// decided it should return a double to be as precise as possible
    {
        // total up the array, then return the average
        double sum = 0; // declared variable sum
        for (double i : arr)
        {
            sum += i; // at every index of the array, the value would be added to form the sum
        }
        return sum / arr.length; // divided the sum by the length of the array, or the average
    }

    public double[] clonePlusTwo(double[] arr)
    {
        // create a new array, each element is 2 higher than the original
        double[] newArr = new double[arr.length];
        for (int i = 0; i < arr.length; i++)
        {
            newArr[i] = arr[i] + 2;
        }
        return newArr;
    }

    public void upByTwo(double[] arr)
    {
        // This method will be given an array. The method will then increase
        // the value of each element of that array by two.
        for (int k = 0; k < arr.length; k++)
        {
            arr[k] += 2; //instead of creating a new array, the array passed in is 
            // directly pointed at, so any changes we make inside this method are transferred.
        }
    }

}

public class ParamReturnValuePractice extends Object
{
    public static void main(String[] args)
    {
        PrintHelper ph = new PrintHelper();

        double[] ts = new double[3];
        ts = ph.getTemperatures();
        System.out.println("Temperatures:");
        ph.printArray(ts);
        ph.upByTwo(ts);
        System.out.println("New Temperatures:");
        ph.printArray(ts);
        double[] clone2 = ph.clonePlusTwo(ts);
        ts[0] = 88;
        System.out.println("Cloned Temperatures");
        ph.printArray(clone2);
        System.out.println("Average of Cloned Temperatures" + ph.averageArray(clone2));
        
        
        double[] myArray = new double[5];
        int counter = 0;
        while(counter<5)
        {
            myArray[counter] = counter + 6;
            ++counter;
        }

        for(int i=0; i<5; i++)
        {
            System.out.println(myArray[i]);
        }
    }
}
