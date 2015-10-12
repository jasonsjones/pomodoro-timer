import org.junit.Assert;

public class TimeModelTest {

    @org.junit.Test
    public void testDefaultConstructor() throws Exception {

        TimeModel tm = new TimeModel();
        Assert.assertEquals(0, tm.getTimeInSeconds());
    }

    @org.junit.Test
    public void testConstructorWithOneArgument() throws Exception {

        TimeModel tm = new TimeModel(32);
        Assert.assertEquals(32, tm.getTimeInSeconds());
    }

    @org.junit.Test
    public void testConstructorWithTwoArguments() throws Exception {

        TimeModel tm = new TimeModel(15, 34);
        Assert.assertEquals((15*60)+34, tm.getTimeInSeconds());
    }

    @org.junit.Test
    public void testConstructorWithThreeArguments() throws Exception {

        TimeModel tm = new TimeModel(2, 15, 34);
        Assert.assertEquals((2*60*60)+(15*60)+34, tm.getTimeInSeconds());
    }
}