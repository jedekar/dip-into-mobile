package ua.kpi.comsys.io8128.other;

import java.util.Calendar;
import java.util.Date;

public class TimeOK {
    private long hours;
    private long minutes;
    private long seconds;

    long getHours() {
        return this.hours;
    }

    void setHours(final long hours) {
        if (hours < 0 || hours >= 24) {
            throw new ExceptionInInitializerError("Please see your hours");
        }
        this.hours = hours;
    }

    long getMinutes() {
        return this.minutes;
    }

    void setMinutes(final long minutes) {
        if (minutes < 0L || minutes >= 60L) {
            throw new ExceptionInInitializerError("Please see your minutes");
        }
        this.minutes = minutes;
    }

    long getSeconds() {
        return this.seconds;
    }

    void setSeconds(final long seconds) {
        if (seconds < 0L || seconds >= 60L) {
            throw new ExceptionInInitializerError("Please see your seconds");
        }
        this.seconds = seconds;
    }

    TimeOK() {
        this.setHours(0L);
        this.setMinutes(0L);
        this.setSeconds(0L);
    }

    public TimeOK(final long hours, final long minutes, final long seconds) {
        this.setHours(hours);
        this.setMinutes(minutes);
        this.setSeconds(seconds);
    }

    public TimeOK(final Date date) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        this.setHours(calendar.get(11));
        this.setMinutes(calendar.get(12));
        this.setSeconds(calendar.get(13));
    }

    @Override
    public String toString() {
        String output;
        if (this.hours < 12) {
            output = String.format("%02d:%02d:%02d AM", hours, minutes, seconds);
        } else if (this.hours == 12) {
            output = String.format("%02d:%02d:%02d PM", hours, minutes, seconds);
        } else {
            output = String.format("%02d:%02d:%02d PM", hours-12, minutes, seconds);
        }
        return output;
    }

    private static TimeOK add(final TimeOK first, final TimeOK second) {
        long seconds;
        long minutes = 0L;
        long hours = 0L;
        final long currentSeconds = first.seconds + second.seconds;
        if (currentSeconds >= 60L) {
            ++minutes;
            seconds = currentSeconds - 60L;
        } else {
            seconds = currentSeconds;
        }
        final long currentMinutes = minutes + first.minutes + second.minutes;
        if (currentMinutes >= 60L) {
            ++hours;
            minutes = currentMinutes - 60L;
        } else {
            minutes = currentMinutes;
        }
        final long currentHours = hours + first.hours + second.hours;
        if (currentHours >= 24L) {
            hours = currentHours - 24L;
        } else {
            hours = currentHours;
        }
        return new TimeOK(hours, minutes, seconds);
    }

    private static TimeOK substract(final TimeOK first, final TimeOK second) {
        long hours = 0L;
        long minutes = 0L;
        long seconds = 0L;
        boolean minusSecond = false;
        if (first.hours == 0L & first.minutes == 0L & first.seconds == 0L) {
            first.setHours(23L);
            first.setMinutes(59L);
            first.setSeconds(59L);
            minusSecond = true;
        }
        final long currentHours = first.hours - second.hours;
        if (currentHours >= 0L) {
            hours = currentHours;
            final long currentMinutes = first.minutes - second.minutes;
            if (currentMinutes >= 0L) {
                minutes = currentMinutes;
            } else {
                --hours;
                minutes = first.minutes + 60L - second.minutes;
            }
            final long currentSeconds = first.seconds - second.seconds;
            if (currentSeconds >= 0L) {
                seconds = currentSeconds;
            } else {
                --minutes;
                seconds = first.seconds + 60L - second.seconds;
            }
            if (minusSecond) {
                ++seconds;
            }
            return new TimeOK(hours, minutes, seconds);
        }
        throw new ArithmeticException("Hours out of bound exception");
    }

    public TimeOK add(final TimeOK term) {
        return add(this, term);
    }

    public TimeOK substract(final TimeOK substracted) {
        return substract(this, substracted);
    }

    public static TimeOK addTwoObjects(final TimeOK first, final TimeOK second) {
        return add(first, second);
    }

    public static TimeOK subtractTwoObjects(final TimeOK first, final TimeOK second) {
        return substract(first, second);
    }

}
