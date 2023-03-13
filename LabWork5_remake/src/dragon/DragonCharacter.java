package dragon;

public enum DragonCharacter {
    WISE,
    GOOD,
    CHAOTIC_EVIL;
    public static DragonCharacter toDragonCharacter(String string) {
        switch (string) {
            case "WISE", "1" : return WISE;
            case "GOOD", "2" : return GOOD;
            case "CHAOTIC_EVIL", "3" : return CHAOTIC_EVIL;
        }
        return null;
    }
}
