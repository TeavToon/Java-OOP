public class Account {
    private final String id;
    private final String name;
    private int balance = 0;

    // 1. ใช้ Constructor Chaining
    public Account(String id, String name) {
        this(id, name, 0);
    }

    public Account(String id, String name, int balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public int credit(int amount) {
        if (amount <= 0) {
            System.out.println("Amount must be greater than zero");
            return balance;
        }
        balance += amount;
        return balance;
    }

    public int debit(int amount) {
        if (amount <= 0) {
            System.out.println("Amount must be greater than zero");
        } else if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Amount exceeded balance");
        }
        return balance;
    }

    public int transferTo(Account another, int amount) {
        if (another == null) {
            System.out.println("Target account does not exist");
            return balance;
        }
        if (amount <= 0) {
            System.out.println("Amount must be greater than zero");
            return balance;
        }

        if (amount <= balance) {
            balance -= amount;
            another.credit(amount);
        } else {
            System.out.println("Amount exceeded balance");
        }
        return balance;
    }

    @Override
    public String toString() {
        return String.format("Account[id=%s,name=%s,balance=%d]", id, name, balance);
    }
}