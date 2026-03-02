// Utility.java

/** This file contains useful methods that 
 *  can be used by several different programs.
 */
public class Utility
{
   /**  Precondition:  max is greater than min  <BR>
    *   Postcondition: A random integer between min and max 
    *                  (inclusive) is returned.
    */
	public static int random(int min, int max)
	{
      int range = max - min + 1;
      int randomNumber = (int)(Math.random() * range) + min;
	   return randomNumber;
	}

   /**  Precondition:  num is a non-negative real number  <BR>
    *   Postcondition: The principal square root of num is displayed.
    */
   public static void displaySquareRoot(double num)
	{
      System.out.println("\nThe square root of " + num + " is " + Math.sqrt(num));
	}
   
   /**  Precondition:  n is a non-negative int <BR>
    *   Postcondition: The program output will pause for n milli-seconds <BR>
    *   Example:       delay(3000); will pause the output for 3 seconds.
    */   
	public static void delay(int n)
	{
		long startDelay = System.currentTimeMillis();
		long endDelay = 0;
		while (endDelay - startDelay < n)
			endDelay = System.currentTimeMillis();
	}  
}
