import com.nastusenka.weekdaycounter.DayCountUtility;
import com.nastusenka.weekdaycounter.exceptions.InvalidDateException;
import org.junit.Assert;
import org.junit.Test;

public class DayCountUtilityTest {

    @Test(expected = InvalidDateException.class)
    public void testBothInputParamsWrong() throws InvalidDateException {
        new DayCountUtility("sds", "cdds");
    }

    @Test(expected = InvalidDateException.class)
    public void testFirstParamWrong() throws InvalidDateException {
        new DayCountUtility("sds", "2017-12-12");
    }

    @Test(expected = InvalidDateException.class)
    public void testSecondParamWrong() throws InvalidDateException {
        new DayCountUtility("2017-12-12", "hkjn");
    }

    @Test(expected = InvalidDateException.class)
    public void testInvalidDateFormat() throws InvalidDateException {
        new DayCountUtility("2017-12-12", "01-11-2018");
    }

    @Test
    public void testCountSundaySpacePrependedParams() throws InvalidDateException {
        DayCountUtility count = new DayCountUtility("   2015-01-12", "   2015-12-21 ");
        Assert.assertEquals(3, count.countSundays());
    }

    @Test
    public void testCountSundayNormalOrder() throws InvalidDateException {
        DayCountUtility count = new DayCountUtility("2016-05-01", "2018-01-01");
        Assert.assertEquals(3, count.countSundays());
    }

    @Test
    public void testCountSundayReversedOrder() throws InvalidDateException {
        DayCountUtility count = new DayCountUtility("2018-01-01", "2016-05-01");
        Assert.assertEquals(3, count.countSundays());
    }

    @Test
    public void testCountSundayNoSundays() throws InvalidDateException {
        DayCountUtility count = new DayCountUtility("2017-02-07", "2017-08-09");
        Assert.assertEquals(0, count.countSundays());
    }

    @Test
    public void testCountSundaySameDates() throws InvalidDateException {
        DayCountUtility count = new DayCountUtility("2017-02-07", "2017-02-07");
        Assert.assertEquals(0, count.countSundays());
    }

    @Test
    public void testCountSundayLongAgo() throws InvalidDateException {
        DayCountUtility count = new DayCountUtility("1918-01-01", "1918-12-02");
        Assert.assertEquals(2, count.countSundays());
    }

    @Test
    public void testCountSundaySecondParamFirstSunday() throws InvalidDateException {
        DayCountUtility count = new DayCountUtility("2016-09-01", "2017-10-01");
        Assert.assertEquals(2, count.countSundays());
    }
}
