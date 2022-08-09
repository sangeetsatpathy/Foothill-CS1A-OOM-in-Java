import java.util.Scanner;
public class ArrayPart2
{
    public static void part2(double[] myArr)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();
        for(int k = 0; k<myArr.length; k++)
        {
            if(myArr[k] == num)
            {
                System.out.println("The grade was found at the index " + k + ".");
            }
        }
    }
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        double[] myArr = new double[5];
        System.out.println("Please enter 5 grades.");
        for(int i=0; i<5; i++)
        {
            myArr[i] = sc.nextInt();
            sc.nextLine();
        }
        
        for(int i=0; i<myArr.length; i++)
        {
            System.out.println(myArr[i]);
        }
        
        double total = 0;
        
        for(int i=0; i<myArr.length; i++)
        {
            total+= myArr[i];
        }
        System.out.println("Average of the grades:" + total/5);
        
        //Part 2.2
        ArrayPart2.part2(myArr);
        
    }
}
