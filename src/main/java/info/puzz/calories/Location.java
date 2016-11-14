package info.puzz.calories;

import lombok.Getter;

public final class Location {
    @Getter final double latitude;
    @Getter final double longitude;

    @Getter final Float speed;
    @Getter final Float time;
    @Getter final Integer elevation;

    public Location(double latitude, double longitude, Float speed, Float time, Integer elevation) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.speed = speed;
        this.time = time;
        this.elevation = elevation;
    }

    public double distance (Location loc) {
        return LocationUtils.distance(this, loc);
    }
}
