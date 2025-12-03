// Lab03B0405st.java
// The Rational Class Program I
// This is the student, starting version of the Lab03B0405 assignment.

import java.util.Scanner;

public class Lab03B0405st
{
	public static void main (String[] args)
	{
		System.out.println("***********************************");
      System.out.println("Lab for Unit 3, Part B, Topics 4-5");
      System.out.println("100 Point Version");
      System.out.println("By: John Smith");   // Substitute your own name here.
      System.out.println("***********************************\n");
         
      Scanner input = new Scanner(System.in);
		System.out.print("\nEnter the numerator ----> ");
		int num = input.nextInt();
		System.out.print("\nEnter the denominator --> ");
		int den = input.nextInt();
		Rational3B r = new Rational3B(num,den);
		r.displayData();
	}
}


class Rational3B
{
	private int num;  // numerator
	private int den;  // denominator

   // Complete implementation required for the 80-Point Version.
	public Rational3B(int n, int d)
	{
        num = n;
        den = d;
	}

   // Complete implementation required for the 80-Point Version.
	public double getDecimal() 
   { 
      return num/ ((float) den);
   }
   
   // Complete implementation required for the 80-Point Version.
   public String getRational() 
   {
       return num + "/" + den;
   }

   // Complete implementation required for the 100-Point Version.
   // NOTE: This method MUST call method <getGCF>.
	public String getReduced() 
   {
      int gcf = getGCF(num,den);
      int reducedNum = num/gcf;
      int reducedDen = den/gcf;
      return reducedNum + "/" + reducedDen;
   }

   // Method provided for the 80-Point Version.
   // Additional code required for the 100-Point Version.
	public void displayData()
	{
		System.out.println();
		System.out.println(getRational() + " equals " + getDecimal());
        System.out.println();
        System.out.println("and reduces to "  + getReduced());
	}

   // Complete implementation required for the 100-Point Version.
	public int getGCF(int n1,int n2)
	{
		int num1 = num;
        int num2 = den;
        int remainder = num1 % num2;
        while (remainder != 0){
            num1 = num2;
            num2 = remainder;
            remainder = num1 % num2;
        }
        return num2;
	}
}