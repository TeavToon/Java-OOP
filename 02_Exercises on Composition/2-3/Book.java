public class Book {
    private String isbn;
    private String name;
    private Author author;
    private double price;
    private int qty;

    // ใช้ Constructor Chaining เรียก constructor ตัวล่าง
    public Book(String isbn, String name, Author author, double price) {
        this(isbn, name, author, price, 0);
    }

    public Book(String isbn, String name, Author author, double price, int qty) {
        if (author == null) {
            throw new IllegalArgumentException("Author cannot be null");
        }
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        setPrice(price);
        setQty(qty);
    }

    public String getIsbn() {
        return isbn;
    }

    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        if (qty < 0) {
            throw new IllegalArgumentException("Qty cannot be negative");
        }
        this.qty = qty;
    }

    public String getAuthorName() {
        return author.getName();
    }

    @Override
    public String toString() {
        // ใช้ author หรือ author.toString() แทนการแกะ name/email เอง และแก้ Another -> Author
        return "Book[isbn=%s,name=%s,%s,price=%.1f,qty=%d]"
                .formatted(isbn, name, author, price, qty);
    }
}