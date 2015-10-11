/**
 * Filename: StopWatchModel.java
 *
 * Simple timer class that represents a timer with the notion of an hour,
 * minute, and second in the form of H:MM:SS. Provides some basic functionality
 * of incrementing (by a second) and resetting the timer.
 *
 * @author Jason Jones (jsjones96@gmail.com)
 * @version 0.1
 *
 */
public class StopWatchModel {

    private int timeInSeconds;


    /**
     * Constructs a default StopWatch object initializing the hour, minute, and
     * second to 0
     */
    public StopWatchModel() {
        this(0, 0, 0);
    }


    /**
     * Constructs a StopWatch object initializing the hour to h, and minute and
     * second to 0
     *
     * @param h the hour
     */
    public StopWatchModel(int h) {
        this(h, 0, 0);
    }


    /**
     * Constructs a StopWatch object initializing the hour to h, minute to m, and
     * second to 0
     *
     * @param h the hour
     * @param m the minute
     */
    public StopWatchModel(int h, int m) {
        this(h, m, 0);
    }


    /**
     * Constructs a StopWatch object initializing the hour to h, minute to m, and
     * second to s.
     *
     * @param h the hour
     * @param m the minute
     * @param s the second
     */
    public StopWatchModel(int h, int m, int s) {
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
     * Returns the value of 'hour' field for the timer object.
     *
     * @return the value of the hour field
     */
    public int getHour(){
        return this.getTimeInSeconds() / (60 * 60);
    }


    /**
     * Returns the value of 'minute' field for the timer object.
     *
     * @return the value of the minute field
     */
    public int getMinute(){
        return this.getTimeInSeconds() / 60;
    }


    /**
     * Returns the value of 'second' field for the timer object.
     *
     * @return the value of the second field
     */
    public int getSecond(){
        return this.getTimeInSeconds() % 60;
    }


    /**
     * Increments the second value by one.  If the value is incremented to 60,
     * the minute value is incremented by one and the seconds are reset to 0.
     */
    public void incrementSecond() {
        this.timeInSeconds++;
    }

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
     * Returns a string representation of the timer object in the from of
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

