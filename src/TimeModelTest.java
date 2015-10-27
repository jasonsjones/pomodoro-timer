import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TimeModelTest {

    private TimeModel tm;

    @Before
    public void Before() {
        tm = new TimeModel();
    }
    @Test
    public void testDefaultConstructor() throws Exception {

        Assert.assertEquals(0, tm.getTimeInSeconds());
    }

    @Test
    public void testConstructorWithOneArgument() throws Exception {

        tm.setTimer(0, 0, 32);
        Assert.assertEquals(32, tm.getTimeInSeconds());
    }

    @Test
    public void testConstructorWithTwoArguments() throws Exception {

        tm.setTimer(0, 15, 34);
        Assert.assertEquals((15*60)+34, tm.getTimeInSeconds());
    }

    @Test
    public void testConstructorWithThreeArguments() throws Exception {

        tm.setTimer(2, 15, 34);
        Assert.assertEquals((2*60*60)+(15*60)+34, tm.getTimeInSeconds());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testConstructorWithNegativeArgument() throws Exception {

        tm.setTimer(0, 0, -34);
    }

    @Test
    public void testIncrementOnTheMinute() {

        tm.setTimer(0, 0, 59);
        tm.incrementSecond();
        Assert.assertTrue(tm.toString().equals("0:01:00"));
    }

    @Test
    public void testIncrementOnTheHour() {

        tm.setTimer(0, 59, 59);
        tm.incrementSecond();
        Assert.assertTrue(tm.toString().equals("1:00:00"));
    }

    @Test
    public void testDecrementOnTheMinute() {

        tm.setTimer(0, 1, 0);
        tm.decrementSecond();
        Assert.assertTrue(tm.toString().equals("0:00:59"));
    }

    @Test
    public void testDecrementOnTheHour() {

        tm.setTimer(1, 0, 0);
        tm.decrementSecond();
        Assert.assertTrue(tm.toString().equals("0:59:59"));
    }

    @Test
    public void testDecrementOnZero() {

        tm.decrementSecond();
        Assert.assertTrue(tm.toString().equals("0:00:00"));
    }
}