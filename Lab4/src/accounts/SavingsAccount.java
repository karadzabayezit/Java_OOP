package accounts;

public class SavingsAccount implements AccountOperations {
    private String identifier;
    private int balance;
    private int interest;

    // Base operations:
    @Override
    public void deposit(int amount) {
        if (amount < 0) {
            System.err.println("You cannot deposit negative amount of money!");
            return;
        }

        this.balance += amount;
    }

    @Override
    public void withdraw(int amount) {
        if (amount < 0) {
            System.err.println("You cannot withdraw negative amount of money!");
        }

        if (amount > this.balance) {
            System.err.println("Limit achieved: Withdraw amount is bigger than you can withdraw");
        } else {
            this.balance -= amount;
        }
    }

    @Override
    public int getBalance() {
        return this.balance;
    }

    @Override
    public void setIdentifier(String identifier) {
        if (!identifier.matches("[A-Za-z0-9]{4}-[A-Za-z0-9]{4}-[A-Za-z0-9]{4}")) {
            System.err.println("Invalid ID format: " + identifier + ". Expected format: XXXX-XXXX-XXXX");
            return;
        }
        this.identifier = new String(identifier);
    }

    @Override
    public String getIdentifier() {
        if (this.identifier == null)
            return null;
        return new String(this.identifier);
    }

    @Override
    public void setInterest(int interest) {
        if (interest < 0) {
            System.err.println("You cannot set negative interest!");
            return;
        }

        this.interest = interest;
    }

    @Override
    public int getInterest() {
        return this.interest;
    }

    @Override
    public void increaseBalance() {
        if (balance <= 0) {
            System.err.println("No Enough Money");
            return;
        }

        if (this.balance < 1000) {
            this.balance += this.balance * (this.interest / 100.0);
        } else {
            this.balance += this.balance * 0.01;
        }
    }
}
