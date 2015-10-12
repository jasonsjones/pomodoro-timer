/**
 * Filename: TimeModel.java
 *
 * Simple timer class that represents a time model with the notion of an hour,
 * minute, and second in the form of H:MM:SS. Provides some basic functionality
 * of incrementing/decrementing (by a second) and resetting the timer.
 *
 * To simplify the model, the internal time is only tracked by the total number
 * of seconds.  The notion of the hour, minute, and second are simply calculated
 * by the respective getter method based on the total time in seconds.
 *
 * @author Jason Jones (jsjones96@gmail.com)
 * @version 0.1
 *
 */
public class TimeModel {

    private int timeInSeconds;

    /**
     * Constructs a default TimeModel object initializing the hour, minute, and
     * second to 0
     */
    public TimeModel() {
        this(0, 0, 0);
    }


    /**
     * Constructs a TimeModel object initializing the second to s, and minute and
     * hour to 0
     *
     * @param s the second
     */
    public TimeModel(int s) {
        this(0, 0, s);
    }


    /**
     * Constructs a TimeModel object initializing the minute to m, second to s, and
     * hour to 0
     *
     * @param m the minute
     * @param s the second
     */
    public TimeModel(int m, int s) {
        this(0, m, s);
    }


    /**
     * Constructs a TimeModel object initializing the hour to h, minute to m, and
     * second to s.
     *
     * @param h the hour
     * @param m the minute
     * @param s the second
     */
    public TimeModel(int h, int m, int s) {
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
        this.timeInSeconds = (h * 60 * 60) + (m * 60) + s;
    }


    public int getTimeInSeconds() {
        return this.timeInSeconds;
    }

    /**
     * Returns the value of the 'hour' for the time model object.
     *
     * @return the value of the hour
     */
    public int getHour(){
        return this.getTimeInSeconds() / (60 * 60);
    }


    /**
     * Returns the value of the 'minute' for the time model object.
     *
     * @return the value of the minute
     */
    public int getMinute(){
        return (this.getTimeInSeconds() / 60) % 60;
    }


    /**
     * Returns the value of the 'second' for the time model object.
     *
     * @return the value of the second
     */
    public int getSecond(){
        return this.getTimeInSeconds() % 60;
    }


    /**
     * Increments the second value by one.
     *
     * The 'getter' methods handle the equivalent conversions for the minute
     * hour field for the time model object.
     */
    public void incrementSecond() {
        this.timeInSeconds++;
    }

    /**
     * Decrements the second value by one.
     */
    public void decrementSecond() {
        if (this.getTimeInSeconds() > 0) {
            this.timeInSeconds--;
        }
    }


    /**
     * Resets the timer to 0:00:00.
     */
    public void reset() {
        setTimer(0, 0, 0);
    }


    /**
     * Returns a string representation of the time model object in the from of
     * H:MM:SS.  For example if the timer was at 1 minute 30 seconds, the
     * representation would be 0:01:30.
     *
     *@return the string representation (H:MM:SS)
     */
    public String toString() {
        return String.format("%d:%02d:%02d",
                this.getHour(), this.getMinute(), this.getSecond());
    }

}

