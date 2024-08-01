package cz.vsb.austra.dto.tomorrowio.enums;

public enum WindDirection {
    NORTH(0),
    NORTH_NORTHEAST(1),
    NORTH_EAST(2),
    EAST_NORTHEAST(3),
    EAST(4),
    EAST_SOUTHEAST(5),
    SOUTHEAST(6),
    SOUTH_SOUTHEAST(7),
    SOUTH(8),
    SOUTH_SOUTHWEST(9),
    SOUTHWEST(10),
    WEST_SOUTHWEST(11),
    WEST(12),
    WEST_NORTHWEST(13),
    NORTHWEST(14),
    NORTH_NORTHWEST(15);
    public final Integer directionCode;

    WindDirection(int directionCode) {
        this.directionCode = directionCode;
    }

    public static WindDirection valueOfCode(Integer directionCode) {
        for (WindDirection weatherCode : values()) {
            if (weatherCode.directionCode == directionCode) {
                return weatherCode;
            }
        }
        return null;
    }
}
