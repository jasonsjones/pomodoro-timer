/**
 * Filename: Timer.java
 *
 * Simple timer class that represents a timer with the notion of an hour,
 * minute, and second in the form of H:MM:SS. Provides some basic functionality
 * of incrementing (by a second) and resetting the timer.
 *
 * @author: Jason Jones (jsjones<at>gmail.com)
 * @version 0.1
 *
 */
public class Timer {

    // instance variable representing the hour
    private int hour;

    // instance variable representing the minute
    private int minute;

    // instance variable representing the second
    private int second;


    /**
     * Contructs a default Timer object intializing the hour, minute, and
     * second to 0
     */
    public Timer() {

        this(0, 0, 0);
    }


    /**
     * Contructs a Timer object initializing the hour to h, and minute and
     * second to 0
     *
     * @param h the hour
     */
    public Timer(int h) {

        this(h, 0, 0);
    }


    /**
     * Contructs a Timer object intializing the hour to h, minute to m, and
     * second to 0
     *
     * @param h the hour
     * @param m the minute
     */
    public Timer(int h, int m) {

        this(h, m, 0);
    }


    /**
     * Contructs a Timer object initializing the hour to h, minute to m, and
     * second to s.
     *
     * @param h the hour
     * @param m the minute
     * @param s the second
     */
    public Timer(int h, int m, int s) {

        setTimer(h, m, s);
    }


    /**
     * Sets the starting time of the timer.  Sets the hour to h, the minute to
     * m, and second to s.
     *
     * @param h the hour
     * @param m the minute
     * @param s the second
     */
    public void setTimer(int h, int m, int s) {

        setHour(h);
        setMinute(m);
        setSecond(s);
    }


    /**
     * Sets the hour for the timer to h.  Checks to ensure the parameter is
     * a valid value to represent an hour (0-23), otherwise sets hour to 0.
     *
     * @param h the hour
     */
    public void setHour(int h) {

        this.hour = ( h >= 0 && h < 24 ) ? h : 0;
    }


    /**
     * Sets the minute for the timer to m.  Checks to ensure the parameter is
     * a valid value to represent a minute (0-59), otherwise sets minute to 0.
     *
     * @param m the minute
     */
    public void setMinute(int m) {

        this.minute = (m >= 0 && m < 60 ) ? m : 0;
    }


    /**
     * Sets the second for the timer to s.  Checks to ensure the parameter is
     * a valid value to represent a second (0-59), otherwise sets second to 0.
     *
     * @param s the second
     */
    public void setSecond(int s) {

        this.second = (s >= 0 && s < 60 ) ? s : 0;
    }


    /**
     * Returns the value of 'hour' field for the timer object.
     *
     * @return the value of the hour field
     */
    public int getHour(){
        return this.hour;
    }


    /**
     * Returns the value of 'minute' field for the timer object.
     *
     * @return the value of the minute field
     */
    public int getMinute(){
        return this.minute;
    }


    /**
     * Returns the value of 'second' field for the timer object.
     *
     * @return the value of the second field
     */
    public int getSecond(){
        return this.second;
    }


    /**
     * Returns the total time (in minutes) the timer has been running.  Any
     * value over 30 seconds will round up to the next minute.
     *
     * @return the total time in minutes
     */
    public int getTotalTimeInMinutes() {
        return getHour() * 60 + getMinute() + ( getSecond() > 30 ? 1 : 0 );

    }


    /**
     * Increments the second value by one.  If the value is incremented to 60,
     * the minute value is incremented by one and the seconds are reset to 0.
     */
    public void incrementSecond() {

        int s = getSecond() + 1;

        if (s == 60) {
            setSecond(0);
            incrementMinute();
        } else
            setSecond(s);
    }


    /**
     * Resets the timer to 0:00:00.
     */
    public void reset() {
        setTimer(0, 0, 0);
    }


    /**
     * Returns a string representation of the timer object in the from of
     * H:MM:SS.  For example if the timer was at 1 minute 30 seconds, the
     * representation would be 0:01:30.
     *
     *@returns the string representation (H:MM:SS)
     */
    public String toString() {

        return String.format("%d:%02d:%02d",
                getHour(), getMinute(), getSecond());
    }


    //============================
    // Private methods
    //============================

    private void incrementHour() {

        setHour((getHour() + 1) % 24);
    }


    private void incrementMinute() {

        int m = getMinute() + 1;

        if (m == 60) {
            setMinute(0);
            incrementHour();
        } else
            setMinute(m);
    }
}
