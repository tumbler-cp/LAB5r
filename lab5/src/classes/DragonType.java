package classes;

public enum DragonType {
    UNDERGROUND,
    AIR,
    FIRE;
    public static DragonType toDragonType(String string){
        switch (string) {
            case ("UNDERGROUND") : return UNDERGROUND;
            case ("AIR") : return AIR;
            case ("FIRE") : return FIRE;
        }
        return null;
    }
    public static DragonType toDragonType(int s){
        switch (s) {
            case (1) : return UNDERGROUND;
            case (2) : return AIR;
            case (3) : return FIRE;
        }
        return null;
    }
}
