package dragon;

public enum Color {
    GREEN,
    RED,
    BLUE,
    YELLOW,
    BROWN;
    public static Color toColor(String string){
        switch (string) {
            case "GREEN", "1": return GREEN;
            case "RED", "2": return RED;
            case "BLUE", "3": return BLUE;
            case "YELLOW", "4": return YELLOW;
            case "BROWN", "5": return BROWN;
        }
        return null;
    }
}
