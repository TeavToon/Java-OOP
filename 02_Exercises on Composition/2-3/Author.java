public class Author {
    private String name;
    private String email;

    public Author(String name, String email) {
        this.name = name;
        setEmail(email); // ใช้ setter เพื่อให้ผ่านการ validate
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email: " + email);
        }
        this.email = email;
    }

    @Override
    public String toString() {
        return "Author[name=" + name + ",email=" + email + "]";
    }
}