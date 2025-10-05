package accounts;

public interface AccountOperations {
    public void deposit(int amount);

    public void withdraw(int amount);

    public int getBalance();

    public void setIdentifier(String identifier);

    public String getIdentifier();

    public void setInterest(int interest);

    public int getInterest();

    public void increaseBalance();

    default String toJsonString() {
        return String.format(
                "{\n  \"accountId\": \"%s\", \n  \"balance\": %d, \n  \"interest\": %d, \n  \"type\": \"%s\"\n}",
                this.getIdentifier(), this.getBalance(), this.getInterest(), this.getClass().getSimpleName());
    }

    default String toJsonString(String args) {
        return String.format(
                "{\n  \"accountId\": \"%s\", \n  \"balance\": %d, \n  \"interest\": %d,\n  %s\n  \"type\": \"%s\"\n}",
                this.getIdentifier(), this.getBalance(), this.getInterest(), args, this.getClass().getSimpleName());
    }
}