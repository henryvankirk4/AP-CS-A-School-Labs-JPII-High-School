// Lab03E06PlusST.java
// Overdraft Protection
// This is the student, starting version of the Lab03E06Plus assignment.

import java.util.Calendar;

public class Lab03E06PlusST
{
    public static void main (String[] args)
    {
        System.out.println("**********************************");
        System.out.println("Lab for Unit 3, Parts E, Topic 6+");
        System.out.println("100 Point Version");
        System.out.println("By: John Smith");   // Substitute your own name here.
        System.out.println("**********************************");

        Bank accountAJ = new Bank("Arthur James",2025,800,8000);
        accountAJ.displayData();
        accountAJ.checkingWithdrawal(500);
        accountAJ.displayData();
        accountAJ.checkingWithdrawal(500);
        accountAJ.displayData();
        accountAJ.checkingWithdrawal(5000);
        accountAJ.displayData();
        accountAJ.checkingWithdrawal(5000);
        accountAJ.displayData();
    }
}


class Bank
{
    private String name;
    private int memberSinceYear;
    private double checkingBalance;
    private double savingsBalance;
    private boolean joint;

    public void checkingWithdrawal(double withdrawal)
    {
        if (accountIsNotValid("Checking Withdrawal"))
            return;

        checkingBalance -= withdrawal;
        System.out.printf("\n$%,.2f",withdrawal);
        System.out.println(" has been withdrawn from " + name + "'s Checking Account.");
    }

    public Bank (String n, int msy, double cb, double sb)
    {
        name = new String(n);
        memberSinceYear = msy;
        checkingBalance = cb;
        savingsBalance  = sb;
        joint = false;
    }

    public Bank (String n, int msy)
    {
        name = new String(n);
        memberSinceYear = msy;
        checkingBalance = 0.00;
        savingsBalance  = 0.00;
        joint = false;
    }

    public Bank (String n)
    {
        name = new String(n);
        memberSinceYear = Calendar.getInstance().get(Calendar.YEAR);
        checkingBalance = 0.00;
        savingsBalance  = 0.00;
        joint = false;
    }

    public Bank ()
    {
        name = ">>> NO NAME <<<";
        memberSinceYear = 1895;
        checkingBalance = -999999.99;
        savingsBalance  = -999999.99;
        joint = false;
    }

    public Bank (Bank original)
    {
        name = new String(original.name);
        memberSinceYear = original.memberSinceYear;
        checkingBalance = original.checkingBalance;
        savingsBalance  = original.savingsBalance;
        joint = original.joint;
    }

    public void displayData()
    {
        System.out.println();
        System.out.println("Name:              " + name);
        System.out.println("Member Since:      " + memberSinceYear);
        System.out.printf( "Checking Balance:  $%,.2f\n",checkingBalance);
        System.out.printf( "Savings Balance:   $%,.2f\n",savingsBalance);
        System.out.printf( "Combined Balance:  $%,.2f\n",getCombinedBalance());
    }

    public String  getName()             { return name;            }
    public int     getMemberSinceYear()  { return memberSinceYear; }
    public double  getCheckingBalance()  { return checkingBalance; }
    public double  getSavingsBalance()   { return savingsBalance;  }
    public boolean isJoint()             { return joint;           }

    public double getCombinedBalance()
    {
        double combined = checkingBalance + savingsBalance;
        return combined;
    }

    public void setName(String n)              { name = new String(n);  }
    public void setMemberSinceYear(int msy)    { memberSinceYear = msy; }
    public void setCheckingBalance(double cb)  { checkingBalance = cb;  }
    public void setSavingsBalance(double sb)   { savingsBalance  = sb;  }
    public void setJoint(boolean j)            { joint = j;             }

    public void checkingDeposit(double deposit)
    {
        if (accountIsNotValid("Checking Deposit"))
            return;
        checkingBalance += deposit;
        System.out.printf("$%,.2f",deposit);
        System.out.println(" has been deposited in " + name + "'s Checking Account.");
        if (deposit >= 10000)
            System.out.println("Contact IRS and report large deposit.");
    }

    public void savingsDeposit(double deposit)
    {
        if (accountIsNotValid("Savings Deposit"))
            return;
        savingsBalance += deposit;
        System.out.printf("$%,.2f",deposit);
        System.out.println(" has been deposited in " + name + "'s Savings Account.");
        if (deposit >= 10000)
            System.out.println("Contact IRS and report large deposit.");
    }

    public void savingsWithdrawal(double withdrawal)
    {
        if (accountIsNotValid("Savings Withdrawal"))
            return;
        if (withdrawal <= savingsBalance)
        {
            savingsBalance -= withdrawal;
            System.out.printf("$%,.2f",withdrawal);
            System.out.println(" has been withdrawn from " + name + "'s Savings Account.");
        }
        else
        {
            System.out.println("Insufficient Funds in " + name + "'s Savings Account.");
            System.out.println("$40 Fee Charged.");
            savingsBalance -= 40;
        }
    }

    public boolean accountIsNotValid(String action)
    {
        if (name.equals(">>> NO NAME <<<"))
        {
            System.out.println("\nThis is not a valid account.");
            System.out.println(action + " process terminated.");
            return true;
        }
        return false;
    }

    public void transferToChecking(double amount)
    {
        if (amount <= savingsBalance)
        {
            savingsBalance  -= amount;
            checkingBalance += amount;
            System.out.printf(name + " transferred $%,.2f",amount);
            System.out.println(" from Savings to Checking.");
        }
        else
        {
            System.out.println("Insufficient Funds in " + name + "'s Savings Account.");
            System.out.println("Transfer process terminated.");
        }
    }

    public void transferToSavings(double amount)
    {
        if (amount <= checkingBalance)
        {
            checkingBalance -= amount;
            savingsBalance  += amount;
            System.out.printf(name + " transferred $%,.2f",amount);
            System.out.println(" from Checking to Savings.");
        }
        else
        {
            System.out.println("Insufficient Funds in " + name + "'s Checking Account.");
            System.out.println("Transfer process terminated.");
        }
    }

    public void closeAccount()
    {
        name = ">>> NO NAME <<<";
        memberSinceYear = 1895;
        checkingBalance = -999999.99;
        savingsBalance  = -999999.99;
        joint = false;
    }

    public void combineAccounts(Bank other)
    {
        if (accountIsNotValid("Combine Accounts") || other.accountIsNotValid("Combine Accounts"))
            return;

        if (alreadyJointAccount() || other.alreadyJointAccount())
            return;

        checkingBalance += other.checkingBalance;
        savingsBalance  += other.savingsBalance;

        if (other.memberSinceYear < memberSinceYear)  // based on who joined first
            memberSinceYear = other.memberSinceYear;

        name = new String(name + " & " + other.name);
        System.out.println("\nThe accounts for " + name +
                " have been combined into 1 account.");
        joint = true;
        other.closeAccount();
    }

    public boolean alreadyJointAccount()
    {
        if (joint)
        {
            System.out.println("\n" + name + " already have a joint account,");
            System.out.println("which cannot be combine with another account.");
            return true;
        }
        return false;
    }

    public String toString()
    {
        String conjugate1 = " has been a member since ";
        String conjugate2 = "\nand has $";

        if (joint)
        {
            conjugate1 = " have been members since ";
            conjugate2 = ".\nThey have $";
        }

        String bankAccountInfo = "\n" + name + conjugate1 +
                memberSinceYear + conjugate2 +
                checkingBalance + " in checking and $" +
                savingsBalance  + " in savings.";
        return bankAccountInfo;
    }

    public void swap(Bank other)
    {
        String temp1 = name;
        name = other.name;
        other.name = temp1;

        int temp2 = memberSinceYear;
        memberSinceYear = other.memberSinceYear;
        other.memberSinceYear = temp2;

        double temp3 = checkingBalance;
        checkingBalance = other.checkingBalance;
        other.checkingBalance = temp3;

        double temp4 = savingsBalance;
        savingsBalance = other.savingsBalance;
        other.savingsBalance = temp4;

        boolean temp5 = joint;
        joint = other.joint;
        other.joint = temp5;
    }
}