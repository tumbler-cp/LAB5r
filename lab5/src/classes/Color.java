package classes;

public enum Color {
    GREEN,
    RED,
    BLUE,
    YELLOW,
    BROWN;
    public static Color toColor(String string){
        switch (string) {
            case "GREEN" : return GREEN;
            case ("RED") : return RED;
            case ("BLUE") : return BLUE;
            case ("YELLOW") : return YELLOW;
            case ("BROWN") : return BROWN;
        }
        return null;
    }
    public static Color toColor(int c){
        switch (c){
            case (1): return GREEN;
            case (2): return RED;
            case (3): return BLUE;
            case (4): return YELLOW;
            case (5): return BROWN;
        }
        return null;
    }
}
