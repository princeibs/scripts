package Default;

class DateTime {

    private int month;
    private int day;
    private int year;
    private int hour;
    private int minute;
    private int second;

    private static final int[] daysPerMonth
            = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    DateTime(int month, int day, int year, int hour, int minute, int second) {
        // Validate year
        if (year < 1700 || year > 2021) {
            throw new IllegalArgumentException("year (" + year + ") out-of-range");
        }

        // Validate month
        if (month <= 0 || month > 12) {
            throw new IllegalArgumentException(
                    "month (" + month + ") must be 1-12");
        }

        // Validate day
        if (day < 0 || (day > daysPerMonth[month] && !(month == 2 && day == 29))) {
            throw new IllegalArgumentException(
                    "day (" + day + ") out-of-range for the specific month and year");
        }

        // check for leap if month is 2 and day is 29
        if (month == 2 && day == 29 && !(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))) {
            throw new IllegalArgumentException(
                    "day (" + day + ") out-of-range for the specific month and year");
        }

        // Validate hour
        if (hour < 0 || hour >= 24) {
            throw new IllegalArgumentException("hour must be 0-23");
        }

        // Validate minute
        if (minute < 0 || minute >= 60) {
            throw new IllegalArgumentException("minute must be 0-59");
        }

        // Validate second
        if (second < 0 || second >= 60) {
            throw new IllegalArgumentException("second must be 0-59");
        }

        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.month = month;
        this.day = day;
        this.year = year;

        System.out.printf("Date object constructor for date %s%n", this);

    }

    // Default constructor
    public DateTime() {
        this.month = 1;
        this.day = 1;
        this.year = 1700;
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    public DateTime(DateTime dateTime) {
        // TODO: To be conpleted
    }

    // Get methods
    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    // Set methods
    public void setTime(int hour, int minute, int second) {
        if (hour < 0 || hour >= 24) {
            throw new IllegalArgumentException("hour must be 0-23");
        }
        if (minute < 0 || minute >= 60) {
            throw new IllegalArgumentException("minute must be 0-59");
        }
        if (second < 0 || second >= 60) {
            throw new IllegalArgumentException("second must be 0-59");
        }

        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public void setHour(int hour) {
        if (hour < 0 || hour >= 24) {
            throw new IllegalArgumentException("hour must be 0-23");
        }

        this.hour = hour;
    }

    public void setMinute(int minute) {
        if (minute < 0 || minute >= 60) {
            throw new IllegalArgumentException("minute must be 0-59");
        }

        this.minute = minute;
    }

    public void setSecond(int second) {
        if (second < 0 || second >= 60) {
            throw new IllegalArgumentException("second must be 0-59");
        }

        this.second = second;
    }

    /* Increment methods */
    public void nextDay() {
        if (day == daysPerMonth[month]) { // if day is last day of month
            day = 1;
            incrementMonth();
        } else {
            ++day;
        }
    }

    //* Move to next year
    public void incrementMonth() {
        if (month == 12) { // if month is last month of the year
            month = 1;
            incrementYear();
        } else {
            ++month;
        }
    }

    public void incrementYear() {
        ++year;
    }

    public void tick() {
        if (this.second == 59) {
            this.second = 0;
            incrementMinute();
        } else {
            ++this.second;
        }

    }

    public void incrementMinute() {
        if (this.minute == 59) {
            this.minute = 0;
            this.incrementHour();
        } else {
            ++this.minute;
        }
    }

    public void incrementHour() {
        if (hour == 23) {
            hour = 0;
            nextDay();
        } else {
            ++hour;
        }
    }

    // Display time in universal formaat
    public String toUniversalString() {
        return String.format("%d/%d/%d %02d:%02d:%02d",
                getMonth(), getDay(), getYear(), getHour(), getMinute(), getSecond());
    }

    @Override
    public String toString() {
        return String.format("%d/%d/%d %d:%02d:%02d %s%n",
                month, day, year,
                (hour == 0 || hour == 12) ? 12 : hour % 12, minute, second, (hour < 12 ? "AM" : "PM"));
    }

}

// Class to test DateTune
public class DateTimeClass {

    public static void main(String[] args) {
        try {
            DateTime time = new DateTime(07, 21, 2021, 23, 59, 55); // MM DD YY HH MM SS
            //DateTime time1 = new DateTime();

            for (int i = 1; i < 10; i++) {
                time.tick();
                System.out.printf("%s", time);
            }

        } catch (IllegalArgumentException e) {
            System.out.printf("An Exception has occured: %s%n", e.getMessage());
        }
    }
}


//TODO: Include the equivalent setDate, setDay, setMonth, setYear methods.
