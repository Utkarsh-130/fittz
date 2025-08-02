package model;

public enum ActivityType {
    RUNNING,
    CYCLING,
    SWIMMING,
    WALKING,
    HIKING,
    YOGA,
    TABLE_TENNIS,
    GYM_WORKOUT,
    DANCE,
    TEAM_SPORTS,
    MARTIAL_ARTS,
    OTHER;

    public static ActivityType fromString(String type) {
        try {
            return ActivityType.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e) {
            return OTHER; // Default to OTHER if the type is not recognized
        }
    }

}
