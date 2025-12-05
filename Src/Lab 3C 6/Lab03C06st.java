// Lab03C06st.java
// The Rational Class Program II
// This is the student, starting version of the Lab03C06 assignment.

import java.util.Scanner;

public class Lab03C06st
{
	public static void main (String[] args)
	{
        System.out.println("***********************************");
        System.out.println("Lab for Unit 3, Part C, Topics 4-6");
        System.out.println("100 Point Version");
        System.out.println("By: John Smith");   // Substitute your own name here.
        System.out.println("***********************************\n");
         
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter the 1st numerator ----> ");
	    int num1 = input.nextInt();
		System.out.print("\nEnter the 1st denominator --> ");
		int den1 = input.nextInt();
        while(den1 == 0) {
            System.out.println();
            System.out.println("You cannot have a denominator of 0.");
            System.out.print("Please try again.");
            System.out.println();
            System.out.print("\nEnter the 1st denominator --> ");
            den1 = input.nextInt();
        }
		System.out.print("\nEnter the 2nd numerator ----> ");
		int num2 = input.nextInt();
		System.out.print("\nEnter the 2nd denominator --> ");
		int den2 = input.nextInt();
        while(den2 == 0) {
            System.out.println();
            System.out.println("You cannot have a denominator of 0.");
            System.out.print("Please try again.");
            System.out.println();
            System.out.print("\nEnter the 2nd denominator --> ");
            den2 = input.nextInt();
        }
        System.out.println();

        input.close();

		Rational r1 = new Rational(num1,den1);
		Rational r2 = new Rational(num2,den2);
		Rational r3 = new Rational();

		r3.showMultiplication(r1,r2);    // required for 80-points
        r3.showDivision(r1,r2);          // required for 80-points
        r3.showAddition(r1,r2);          // required for 100-points
        r3.showSubtraction(r1,r2);       // required for 100-points
	}
}

class Rational
{
	private int num;  // numerator
	private int den;  // denominator

    // Complete implementation required for the 80-Point Version.
	public Rational()
	{
        num = 1;
        den = 1;
	}
    // Complete implementation required for the 80-Point Version.
	public Rational(int n, int d)
	{
        num = n;
        den = d;
	}
   
    // Complete implementation required for the 80-Point Version.
    public String getRational() 
    {
        return num + "/" + den;
    }

    // Complete implementation required for the 80-Point Version.
    private int getGCF(int n1,int n2)
	{
        int remainder = n1 % n2;
        while (remainder != 0){
            n1 = n2;
            n2 = remainder;
            remainder = n1 % n2;
        }
        return n2;
	}

    // Complete implementation required for the 80-Point Version.
    public String getReduced()
    {
        int gcf = getGCF(num,den);
        int reducedNum = num/gcf;
        int reducedDen = den/gcf;
        if (reducedDen < 0) {
            reducedNum *= -1;
            reducedDen *= -1;
        }
        if (reducedDen == 1) {
            return "" + reducedNum;
        }
        return reducedNum + "/" + reducedDen;
    }

    // Complete implementation required for the 80-Point Version.
	public void showMultiplication(Rational r1, Rational r2)
	{   
        Rational r1Copy = new Rational(r1.num,r1.den);
        Rational r2Copy = new Rational(r2.num,r2.den);
        int num = r1Copy.num * r2Copy.num;
        int den =  r1Copy.den * r2Copy.den;
        Rational multiplied = new Rational(num, den);
        System.out.println();
        System.out.println(r1.getRational() + " * " +  r2.getRational() + " = " + multiplied.getReduced());
 	}
   
    // Complete implementation required for the 80-Point Version.
    public void showDivision(Rational r1, Rational r2)
	{
        Rational r1Copy = new Rational(r1.num,r1.den);
        Rational r2Copy = new Rational(r2.num,r2.den);
        int num = r1Copy.num * r2Copy.den;
        int den = r1Copy.den * r2Copy.num;
        Rational divided = new Rational(num, den);
        System.out.println();
        System.out.println(r1.getRational() + " / " +  r2.getRational() + " = " + divided.getReduced());
 	}
   
    // Complete implementation required for the 100-Point Version.
    public void showAddition(Rational r1, Rational r2)
	{
        Rational r1Copy = new Rational(r1.num,r1.den);
        Rational r2Copy = new Rational(r2.num,r2.den);
        r1Copy.num *= r2Copy.den;
        r2Copy.num *= r1Copy.den;
        int num = r1Copy.num + r2Copy.num;
        int den =  r1Copy.den * r2Copy.den;
        Rational added = new Rational(num, den);
        System.out.println();
        System.out.println(r1.getRational() + " + " +  r2.getRational() + " = " + added.getReduced());
 	}

    // Complete implementation required for the 100-Point Version.
    public void showSubtraction(Rational r1, Rational r2)
    {
        Rational r1Copy = new Rational(r1.num,r1.den);
        Rational r2Copy = new Rational(r2.num,r2.den);
        r1Copy.num *= r2Copy.den;
        r2Copy.num *= r1Copy.den;
        int num = r1Copy.num - r2Copy.num;
        int den =  r1Copy.den * r2Copy.den;
        Rational subtracted = new Rational(num, den);
        System.out.println();
        System.out.println(r1.getRational() + " - " +  r2.getRational() + " = " + subtracted.getReduced());
    }
}