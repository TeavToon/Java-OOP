public class Time {
    private int hour;
    private int minute;
    private int second;

    public Time(int hour, int minute, int second) {
        setTime(hour, minute, second); // ตรวจสอบค่าผ่าน setTime ตั้งแต่เริ่มต้น
    }

    public int getHour() {
        return this.hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public int getSecond() {
        return this.second;
    }

    public void setHour(int hour) {
        if (hour < 0 || hour >= 24) {
            throw new IllegalArgumentException("Hour must be between 0 and 23: " + hour);
        }
        this.hour = hour;
    }

    public void setMinute(int minute) {
        if (minute < 0 || minute >= 60) {
            throw new IllegalArgumentException("Minute must be between 0 and 59: " + minute);
        }
        this.minute = minute;
    }

    public void setSecond(int second) {
        if (second < 0 || second >= 60) {
            throw new IllegalArgumentException("Second must be between 0 and 59: " + second);
        }
        this.second = second;
    }

    public void setTime(int hour, int minute, int second) {
        setHour(hour);
        setMinute(minute);
        setSecond(second);
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", this.hour, this.minute, this.second);
    }

    public Time nextSecond() {
        this.second++;
        if (this.second >= 60) {
            this.second = 0;
            this.minute++;
            if (this.minute >= 60) {
                this.minute = 0;
                this.hour++;
                if (this.hour >= 24) {
                    this.hour = 0;
                }
            }
        }
        return this;
    }

    public Time previousSecond() {
        this.second--;
        if (this.second < 0) {
            this.second = 59;
            this.minute--;
            if (this.minute < 0) {
                this.minute = 59;
                this.hour--;
                if (this.hour < 0) {
                    this.hour = 23;
                }
            }
        }
        return this;
    }
}