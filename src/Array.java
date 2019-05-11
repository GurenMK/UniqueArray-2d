//Alexander Urbanyak
//CS 1302

import java.util.Arrays;

public class Array {

   public int array[];
   public int array1[][];
 //Default constructor
   Array() {
   }
 //Create array wiht specified length
   Array(int newSize) {
      int size = newSize;
      array = new int [size];
         for (int i = 0; i < array.length; i++) {
             array[i] = 1 + (int)(Math.random() * 99999);  
            for (int j = 0; j < i; j++) {
                if (array[i] == array[j]){          
                 i--;    //if [i] is a duplicate run the outer loop again 
                 break;
                }
            }
         }
   }
   Array(int newRows, int newColumns) {
      int rows = newRows;
      int columns = newColumns;
      array1 = new int [rows][columns];
      for (int i = 0; i < rows; i++) {
       for (int j = 0; j < columns; j++) {
           int count = 1; //count duplicates generated 
           array1[0][j] = 1 + (int)(Math.random() * 99999);
          for (int m = 0; m < j; m++) {
              array1[1][0] = 1; //1st number wont have a double
           if (array1[0][j] == array1[0][m]) {
               array1[1][m] += count; //assign all duplicate counts of corersponding number to second row
             m--;
             j--;
             break;
           }
           else //if no duplicate is generated default to count = 1
               array1[1][j] = count;
          }
       }
      }
   }
   //print 2d array
  public void printArray1() {
       for (int i = 0; i < array1.length; i++) {
           for (int j = 0; j < array1[i].length; j++) {
           System.out.print(array1[i][j] + "\t");
           }
        System.out.println();
       }
  }
  //Print 1d array
  public void printArray() {
         for (int m = 0; m < array.length; m++) {         
                 System.out.println(array[m]);  
         }
  }
  //mean
  public double mean() {
      double total = 0;
      for (int i = 0; i < array.length; i++) {
         total += array[i];
      }
      double mean = total / array.length;
      return mean;
  }
    //mean for 2d array
  public double mean1() {
      double total = 0;
      for (int i = 0; i < 1; i++) { //only count 1st row
          for (int j = 0; j < array1[i].length; j++)
         total += array1[i][j];
      }
      double mean = total / array1[0].length;
      return mean;
  }
  //mode
  public int mode() {
      int max = 0;
      int result = 0;
      for (int i = 0; i < array.length; ++i) {
         int count = 0;
         for (int j= 0; j < array.length; ++j) {
          if (array[j] == array[i]) 
            ++count;
          }
         if (count > max) {
             max = count;
             result = array[i];
         }
      }
      return result;
  }  
  //mode for 2d array
     public int mode1() {
    int result = 1;
    int max = 0;
         for (int i = 0; i < array1.length; i++) { 
             for (int j = 0; j < array1[i].length; j++) {
             if (array1[1][j] > max) {
                 max = array1[1][j];
                 result = array1[0][j];
             }
             }
         }
      return result;
     }
   //median
  public double median() {
      double result;
      if (array.length % 2 == 0) {
             result = ((double)array[array.length / 2] + (double)array[array.length / 2 - 1]) / 2;
      }
      else
          result = array[array.length / 2];
      return result;
  }  
   //median for 2d array
  public double median1() {
      double result;
      if (array1[0].length % 2 == 0) {
             result = ((double)array1[0][array1[0].length / 2] + (double)array1[0][array1[0].length / 2 - 1]) / 2;
      }
      else
          result = array1[0][array1[0].length / 2];
      return result;
  }  
  //Minimum 
  public int min() {
      int result = Integer.MAX_VALUE;
         for (int i = 0; i < array.length; i++) { 
             if (array[i] < result)
                 result = array[i];
         }
      return result;
  }
  //Minimum for 2d array
  public int min1() {
      int result = Integer.MAX_VALUE;
         for (int i = 0; i < 1; i++) { 
            for (int j = 0; j < array1[i].length; j++) { 
             if (array1[i][j] < result)
                 result = array1[i][j];
            }
         }
      return result;
  }
  //Maximum
  public int max() {
      int result = Integer.MIN_VALUE;
         for (int i = 0; i < array.length; i++) { 
             if (array[i] > result)
                 result = array[i];
         }
      return result;
  }
  //Maximum for 2d array
  public int max1() {
      int result = Integer.MIN_VALUE;
         for (int i = 0; i < 1; i++) { 
            for (int j = 0; j < array1[i].length; j++) { 
             if (array1[i][j] > result)
                 result = array1[i][j];
            }
         }
      return result;
  }
  //check if number is in an array
  public boolean check(int newNumber) {
      int number = newNumber;
      boolean result = false;
         for (int i = 0; i < array.length; i++) { 
             if (array[i] == number)
                 result = true;
         }
      return result;
  }
   //check if number is in a 2d array
  public boolean check1(int newNumber) {
      int number = newNumber;
      boolean result = false;
         for (int i = 0; i < 1; i++) { 
            for (int j = 0; j < array1[i].length; j++) {
             if (array1[i][j] == number)
                 result = true;
            }
         }
      return result;
  }
  //return loop counter
  public int count(int newNumber) {
      Arrays.sort(array);
        int key = newNumber;
        int low = 0;
        int high = array.length - 1;
        int count = 1; //counter
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (key < array[mid]) 
                high = mid - 1;
            else if (key > array[mid]) 
                low = mid + 1;
            else 
                return count;
            count++;
        }
        return count;
  }
   //return loop counter for 2d array
    public int count1(int newNumber) {
        //sort arrays 1st row
        Arrays.sort(array1[0]);
        //binary sort
        int key = newNumber;
        int low = 0;
        int high = array1[0].length - 1;
        int count = 1; //counter
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (key < array1[0][mid]) 
                high = mid - 1;
            else if (key > array1[0][mid]) 
                low = mid + 1;
            else 
                return count;
            count++;
        }
        return count;
    }
}//end class
