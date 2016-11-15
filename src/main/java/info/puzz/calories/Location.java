package info.puzz.calories;

import lombok.Getter;

public final class Location {
    @Getter final double latitude;
    @Getter final double longitude;
    @Getter final long time;

    @Getter final Float speed;
    @Getter final Integer elevation;

    public Location(double latitude, double longitude, long time, Float speed, Integer elevation) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.speed = speed;
        this.time = time;
        this.elevation = elevation;
    }

    public Location(double latitude, double longitude, long time) {
        this(latitude, longitude, time, null, null);
    }

    public double distance (Location loc) {
        return LocationUtils.distance(this, loc);
    }
}
