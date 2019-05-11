//Alexander Urbanyak
//CS 1302

import java.util.Scanner;

public class Assignment1 {

    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
        Array one = new Array(4096);
        Array two = new Array(2,4096);
      //Methods to print both arrays
      //one.printArray();
      //two.printArray1();
      System.out.printf("\n%s %4.2f", "Mean for 1d array: ", one.mean());
      System.out.println("\nMode for 1d array: " + one.mode());
      System.out.println("Median for 1d array: " + one.median());
      System.out.println("Range for 1d array: " + one.min() + " - " + one.max());
      System.out.printf("\n%s %4.2f", "Mean for 2d array: ", two.mean1());
      System.out.println("\nMode for 2d array: " + two.mode1());
      System.out.println("Median for 2d array: " + two.median1());
      System.out.println("Range for 2d array: " + two.min1() + " - " + two.max1() + "\n");
      int count = 0;
      while (count < 5) {
        System.out.print("Enter an integer within range " +
                one.min() + " - " + one.max() + " to search 1d array (0 to stop search): ");
        int number = input.nextInt();
         if (number == 0)
             break;
           count++;
            if (one.check(number) == true)
               System.out.println("Number found in (loop count): " + one.count(number));
            else
               System.out.println("Number not found");
      } //while loop 
     //loop for 2d array
           int count1 = 0;
      while (count1 < 5) {
        System.out.print("Enter an integer within range " +
                two.min1() + " - " + two.max1() + " to search 2d array (0 to stop search): ");
        int number = input.nextInt();
         if (number == 0)
             break;
           count1++;
            if (two.check1(number) == true)
               System.out.println("Number found in (loop count): " + two.count1(number));
            else
               System.out.println("Number not found");
      } //while loop 
    }  //main
}
