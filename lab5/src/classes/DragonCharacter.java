package classes;

public enum DragonCharacter {
    CUNNING,
    EVIL,
    CHAOTIC;
    public static DragonCharacter toDragonCharacter(String string) {
        switch (string) {
            case ("CUNNING") : return CUNNING;
            case ("EVIL") : return EVIL;
            case ("CHAOTIC") : return CHAOTIC;
        }
        return null;
    }
    public static DragonCharacter toDragonCharacter(int s) {
        switch (s) {
            case (1) : return CUNNING;
            case (2) : return EVIL;
            case (3) : return CHAOTIC;
        }
        return null;
    }
}
