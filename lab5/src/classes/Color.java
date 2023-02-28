package classes;

public enum Color {
    RED,
    YELLOW,
    ORANGE,
    WHITE,
    BROWN;
    public static Color toColor(String string){
        switch (string) {
            case ("RED") -> {
                return RED;
            }
            case ("YELLOW") -> {
                return YELLOW;
            }
            case ("ORANGE") -> {
                return ORANGE;
            }
            case ("WHITE") -> {
                return WHITE;
            }
            case ("BROWN") -> {
                return BROWN;
            }
        }
        return null;
    }
    public static Color toColor(int c){
        switch (c){
            case (1): return RED;
            case (2): return YELLOW;
            case (3): return ORANGE;
            case (4): return WHITE;
            case (5): return BROWN;
        }
        return null;
    }
}
