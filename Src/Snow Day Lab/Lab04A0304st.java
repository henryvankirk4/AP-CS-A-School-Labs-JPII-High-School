// Lab04A0304st.java
// The Sieve of Eratosthenes
// 100 Point Version

import java.util.Scanner;

public class Lab04A0304st
{
   private static boolean[] primes;

   public static void main(String[] args)
   {
      heading();
      computePrimes();
      displayPrimes();
   }

   public static void heading()
   {
      System.out.println("***********************************");
      System.out.println("Lab for Unit 4, Part A, Topics 1-4");
      System.out.println("100 Point Version");
      System.out.println("By: Henry Van Kirk"); // <-- put your name
      System.out.println("***********************************\n");
   }

   public static void computePrimes()
   {
      Scanner input = new Scanner(System.in);

      System.out.print("Enter the size of the primes array.  --> ");
      int size = input.nextInt();
      System.out.println();

      primes = new boolean[size];

      if (size > 0) primes[0] = false;
      if (size > 1) primes[1] = false;

      for (int i = 2; i < primes.length; i++)
         primes[i] = true;

      for (int i = 2; i * i < primes.length; i++)
      {
         if (primes[i])
         {
            for (int j = i * i; j < primes.length; j += i)
               primes[j] = false;
         }
      }
   }

   public static void displayPrimes()
   {
      int count = 0;
      for (int i = 2; i < primes.length; i++)
      {
         if (primes[i])
         {
            System.out.printf("%5d", i);
            count++;

            if (count % 10 == 0)
               System.out.println();
         }
      }
      System.out.println();
   }
}
