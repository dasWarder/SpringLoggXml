package other;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Random;

public class Event {

    private int id = new Random().nextInt(1000) + 1;
    private String msg;
    private Date date;
    private DateFormat df;

    public static boolean isDay() {
        LocalTime localTime = LocalTime.now();
        int hour = localTime.getHour();
        if (hour > 8 && hour < 17) {
            return true;
        }
        return false;
    }

    public Event(Date date, DateFormat df) {
        this.date = date;
        this.df = df;
    }

    public DateFormat getDf() {
        return df;
    }

    public void setDf(DateFormat df) {
        this.df = df;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "other.Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + df.format(date) +
                '}';
    }
}
