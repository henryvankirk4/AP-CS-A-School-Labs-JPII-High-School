// Lab04Lst.java
// This is the student, starting version of the Lab04L assignment.

import java.util.*;

public class Lab04Lst
{   
	public static void main (String[] args)
	{
      heading();
      int size = getMagicSquareSize();        // for 60 & 70 Point Versions
      MagicSquare ms = new MagicSquare(size); // for 50 Point Version
      ms.displayMatrix();                     // for 50 Point Version
      //ms.displayExpectedTotal();              // for 80 Point Version
      //ms.rowCheck();                          // for 90, 100 & 110 Point Versions
      //ms.columnCheck();                       // for 90, 100 & 110 Point Versions
      //ms.diagonalCheck();                     // for 90, 100 & 110 Point Versions
	}
   
   public static void heading()
   {
		System.out.println("*************************");
      System.out.println("Lab for Unit 4, Lesson L");
      System.out.println("50 Point Version");
      System.out.println("By: John Smith");   // Substitute your own name here.
      System.out.println("*************************\n");  
   }
   
   public static int getMagicSquareSize()
   {
      
      

      return 0;
   }
}      


class MagicSquare
{
   private int size;
   private int[][] msMatrix;
   private int expectedTotal;
   
   public MagicSquare(int s)
   {
      
      
        
   }
   
   public void displayMatrix()
   {
      System.out.println("\n" + size + " by " + size + " Magic Square:\n");

   
   
   }
   
   public void displayExpectedTotal()
   {


      
      System.out.println("\nAll rows, all columns and both diagonals");
      System.out.println("should add up to " + expectedTotal);
   }   
   
   public void rowCheck()
   {
      System.out.println("\nRow Check:\n");



   }
   
   public void columnCheck()
   {
      System.out.println("\nColumn Check:\n");



   }
   
   public void diagonalCheck()
   {
      System.out.println("\nDiagonal Check:\n");


   
   }     
}                  
         
