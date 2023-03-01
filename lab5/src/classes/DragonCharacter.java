package classes;

public enum DragonCharacter {
    WISE,
    GOOD,
    CHAOTIC_EVIL;
    public static DragonCharacter toDragonCharacter(String string) {
        switch (string) {
            case ("WISE") : return WISE;
            case ("GOOD") : return GOOD;
            case ("CHAOTIC_EVIL") : return CHAOTIC_EVIL;
        }
        return null;
    }
    public static DragonCharacter toDragonCharacter(int s) {
        switch (s) {
            case (1) : return WISE;
            case (2) : return GOOD;
            case (3) : return CHAOTIC_EVIL;
        }
        return null;
    }
}
