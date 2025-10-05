import accounts.*;

public class Main {
    public static void main() {
        CheckingAccount checkingAccount = new CheckingAccount();

        checkingAccount.setIdentifier("12344-1244-12414");
        checkingAccount.deposit(576);
        checkingAccount.setCommission(10);
        checkingAccount.setInterest(5);
        checkingAccount.increaseBalance();
        checkingAccount.increaseBalance();

        System.out.println(checkingAccount.toJsonString());
    }
}