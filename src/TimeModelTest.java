import org.junit.Assert;
import org.junit.Test;

public class TimeModelTest {

    @Test
    public void testDefaultConstructor() throws Exception {

        TimeModel tm = new TimeModel();
        Assert.assertEquals(0, tm.getTimeInSeconds());
    }

    @Test
    public void testConstructorWithOneArgument() throws Exception {

        TimeModel tm = new TimeModel(32);
        Assert.assertEquals(32, tm.getTimeInSeconds());
    }

    @Test
    public void testConstructorWithTwoArguments() throws Exception {

        TimeModel tm = new TimeModel(15, 34);
        Assert.assertEquals((15*60)+34, tm.getTimeInSeconds());
    }

    @Test
    public void testConstructorWithThreeArguments() throws Exception {

        TimeModel tm = new TimeModel(2, 15, 34);
        Assert.assertEquals((2*60*60)+(15*60)+34, tm.getTimeInSeconds());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testConstructorWithNegativeArgument() throws Exception {

        new TimeModel(-34);
    }

    @Test
    public void testIncrementOnTheMinute() {

        TimeModel tm = new TimeModel(59);
        tm.incrementSecond();
        Assert.assertTrue(tm.toString().equals("0:01:00"));
    }

    @Test
    public void testIncrementOnTheHour() {

        TimeModel tm = new TimeModel(59, 59);
        tm.incrementSecond();
        Assert.assertTrue(tm.toString().equals("1:00:00"));
    }

    @Test
    public void testDecrementOnTheMinute() {

        TimeModel tm = new TimeModel(1, 00);
        tm.decrementSecond();
        Assert.assertTrue(tm.toString().equals("0:00:59"));
    }

    @Test
    public void testDecrementOnTheHour() {

        TimeModel tm = new TimeModel(1, 0, 0);
        tm.decrementSecond();
        Assert.assertTrue(tm.toString().equals("0:59:59"));
    }

    @Test
    public void testDecrementOnZero() {

        TimeModel tm = new TimeModel();
        tm.decrementSecond();
        Assert.assertTrue(tm.toString().equals("0:00:00"));
    }
}