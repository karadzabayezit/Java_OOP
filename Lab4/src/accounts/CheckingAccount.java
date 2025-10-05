package accounts;

public class CheckingAccount implements AccountOperations {
    private String identifier;
    private int balance;
    private int commission;
    private int interest;

    public void setCommission(int amount) {
        this.commission = amount;
    }

    public int getCommission() {
        return this.commission;
    }

    // Base operations:
    @Override
    public void deposit(int amount) {
        this.balance += amount;
    }

    @Override
    public void withdraw(int amount) {
        this.balance -= amount;

        if (this.balance < 0) {
            this.balance -= this.commission;
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
        this.interest = interest;
    }

    @Override
    public int getInterest() {
        return this.interest;
    }

    @Override
    public void increaseBalance() {
        if (this.balance <= 0) {
            System.err.println("No enough money");
            return;
        }

        this.balance += this.balance * (this.interest / 100.0);
    }

    @Override
    public String toJsonString() {
        return this.toJsonString(String.format("\"commission\": %d,", this.getCommission()));
    }
}
