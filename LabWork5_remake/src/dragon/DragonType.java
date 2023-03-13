package dragon;

public enum DragonType {
    UNDERGROUND,
    AIR,
    FIRE;
    public static DragonType toDragonType(String string){
        switch (string) {
            case "UNDERGROUND", "1" : return UNDERGROUND;
            case "AIR", "2" : return AIR;
            case "FIRE", "3" : return FIRE;
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
