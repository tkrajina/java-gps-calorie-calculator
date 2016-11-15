package info.puzz.calories;

import org.junit.Assert;
import org.junit.Test;

public class LocationUtilsTest {
    @Test
    public void testDistance() {
        Location loc1 = new Location(0, 0, null, null, null);
        Location loc2 = new Location(1 / 1000., 0, null, null, null);
        Assert.assertTrue(Math.abs(LocationUtils.ONE_DEGREE / 1000. - loc1.distance(loc2)) < 100 / 1000.);
    }

    @Test
    public void testLongDistance() {
        Location loc1 = new Location(0, 0, null, null, null);
        Location loc2 = new Location(0, 45, null, null, null);
        Assert.assertTrue(Math.abs(LocationUtils.ONE_DEGREE * 45 - loc1.distance(loc2)) < 45 * 100);
    }
}
