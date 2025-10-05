import accounts.*;

public class Main {
    public static void main() {
        System.out.println("\n===== Checking CheckingAccount functionality =====");
        CheckingAccount checkingAccount = new CheckingAccount();
        checkingAccount.setIdentifier("12344-124dsf4-12414");
        checkingAccount.deposit(576);
        checkingAccount.setInterest(5);
        checkingAccount.setCommission(-10);
        checkingAccount.setCommission(10);
        checkingAccount.withdraw(600);
        checkingAccount.deposit(100);
        checkingAccount.increaseBalance();
        System.out.println(checkingAccount.toJsonString());
        System.out.println("---------------------------------------------------");

        System.out.println("\n===== Checking CreditAccount functionality =====");
        CreditAccount creditAccount = new CreditAccount();
        creditAccount.setIdentifier("12AD-1G44-1241");
        creditAccount.deposit(576);
        creditAccount.setInterest(-5);
        creditAccount.setInterest(5);
        creditAccount.setCreditLimit(146);
        creditAccount.withdraw(750);
        creditAccount.deposit(100);
        creditAccount.increaseBalance();
        System.out.println(creditAccount.toJsonString());
        System.out.println("---------------------------------------------------");

        System.out.println("\n===== Checking SavingsAccount functionality =====");
        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.setIdentifier("12f4-1244-12as");
        savingsAccount.deposit(576);
        savingsAccount.setInterest(5);
        savingsAccount.withdraw(-300);
        savingsAccount.withdraw(750);
        savingsAccount.deposit(100);
        savingsAccount.increaseBalance();
        System.out.println(savingsAccount.toJsonString());
        System.out.println("---------------------------------------------------");

    }
}