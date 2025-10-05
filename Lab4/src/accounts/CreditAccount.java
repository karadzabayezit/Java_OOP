package accounts;

public class CreditAccount implements AccountOperations {
    private String identifier;
    private int balance;
    private int interest;
    private int creditLimit;

    public void setCreditLimit(int amount) {
        this.creditLimit = amount;
    }

    public int getCreditLimit() {
        return this.creditLimit;
    }

    // Base operations:
    @Override
    public void deposit(int amount) {
        this.balance += amount;
    }

    @Override
    public void withdraw(int amount) {
        int accessibleBalance = this.balance + (-this.creditLimit);

        if (amount > accessibleBalance) {
            System.err.println("Err: The limit achieved");
            return;
        }

        this.balance -= amount;
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
        this.interest = interest;
    }

    @Override
    public int getInterest() {
        return this.interest;
    }

    @Override
    public void increaseBalance() {
        if (this.balance <= 0) {
            System.err.println("No Enough Money");
            return;
        }

        this.balance += this.balance * (this.interest / 100);
    }

    @Override
    public String toJsonString() {
        return this.toJsonString(String.format("\"creditLimit\": %d,", this.getCreditLimit()));
    }
}
