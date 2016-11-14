package info.puzz.calories;

public final class LocationUtils {

    public static final double ONE_DEGREE = 1000.0 * 10000.8 / 90.0;
    public static final double EARTH_RADIUS = 6371 * 1000;

    private LocationUtils() throws Exception {
        throw new Exception("!");
    }

    public static double toRad(double d) {
        return d / 180. * Math.PI;
    }

    public static double haversineDistance(Location loc1, Location loc2) {
        double lat1 = loc1.getLatitude();
        double lat2 = loc2.getLatitude();
        double lon1 = loc1.getLongitude();
        double lon2 = loc2.getLongitude();
        double dLat = toRad(lat1 - lat2);
        double dLon = toRad(lon1 - lon2);
        double thisLat1 = toRad(lat1);
        double thisLat2 = toRad(lat2);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.sin(dLon / 2) * Math.sin(dLon / 2) * Math.cos(thisLat1) * Math.cos(thisLat2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return EARTH_RADIUS * c;
    }

    public static double distance(Location loc1, Location loc2) {
        double lat1 = loc1.getLatitude();
        double lat2 = loc2.getLatitude();
        double lon1 = loc1.getLongitude();
        double lon2 = loc2.getLongitude();
        double absLat = Math.abs(lat1 - lat2);
        double absLon = Math.abs(lon1 - lon2);
        if (absLat > 0.2 || absLon > 0.2) {
            return haversineDistance(loc1, loc2);
        }

        double coef = Math.cos(toRad(lat1));
        double x = lat1 - lat2;
        double y = (lon1 - lon2) * coef;

        double distance2d = Math.sqrt(x * x + y * y) * ONE_DEGREE;

        if (loc1.getElevation() == null || loc2.getElevation() == null) {
            return distance2d;
        }

        int eleDiff = loc1.getElevation().intValue() - loc2.getElevation().intValue();

        return Math.sqrt(Math.pow(distance2d, 2) + Math.pow(eleDiff, 2));
    }
}
