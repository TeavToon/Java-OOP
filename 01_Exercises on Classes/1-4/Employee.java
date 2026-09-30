public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private int salary;

    public Employee(int id, String firstName, String lastName, int salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        setSalary(salary); // ใช้ setter เพื่อให้ผ่าน validation ตั้งแต่ตอนสร้าง
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }
        this.salary = salary;
    }

    public int getAnnualSalary() {
        return salary * 12;
    }

    public int raiseSalary(int percent) {
        if (percent < 0) {
            throw new IllegalArgumentException("Percent cannot be negative");
        }
        this.salary += (this.salary * percent) / 100;
        return this.salary;
    }

    @Override
    public String toString() {
        return "Employee[id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary + "]";
    }
}