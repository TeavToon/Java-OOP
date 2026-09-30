public class Date {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        setDate(day, month, year);
    }

    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    public void setDate(int day, int month, int year) {
        validateDate(day, month, year);
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void setDay(int day) {
        validateDate(day, this.month, this.year);
        this.day = day;
    }

    public void setMonth(int month) {
        validateDate(this.day, month, this.year);
        this.month = month;
    }

    public void setYear(int year) {
        validateDate(this.day, this.month, year);
        this.year = year;
    }

    // เมธอดตรวจสอบความถูกต้องของวัน เดือน ปี
    private void validateDate(int day, int month, int year) {
        if (year < 1 || year > 9999) {
            throw new IllegalArgumentException("Year must be between 1 and 9999: " + year);
        }
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month must be between 1 and 12: " + month);
        }

        int maxDays = getDaysInMonth(month, year);
        if (day < 1 || day > maxDays) {
            throw new IllegalArgumentException(
                String.format("Invalid day %d for month %d in year %d (Max: %d)", day, month, year, maxDays)
            );
        }
    }

    // ตรวจสอบจำนวนวันสูงสุดของเดือนนั้นๆ
    private int getDaysInMonth(int month, int year) {
        return switch (month) {
            case 4, 6, 9, 11 -> 30;
            case 2 -> isLeapYear(year) ? 29 : 28;
            default -> 31;
        };
    }

    // สูตรตรวจสอบปีอธิกสุรทิน (Leap Year)
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", this.day, this.month, this.year);
    }
}