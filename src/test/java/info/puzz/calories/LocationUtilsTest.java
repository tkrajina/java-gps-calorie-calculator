package info.puzz.calories;

import org.junit.Assert;
import org.junit.Test;

public class LocationUtilsTest {
    @Test
    public void testDistance() {
        Location loc1 = new Location(0, 0, null, null, null);
        Location loc2 = new Location(0, 1, null, null, null);
        Assert.assertTrue(Math.abs(LocationUtils.ONE_DEGREE - loc1.distance(loc2)) < 100);
    }
}
