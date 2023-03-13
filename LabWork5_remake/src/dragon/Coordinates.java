package dragon;

public class Coordinates {
    private float x; //Поле не может быть null
    private float y; //Максимальное значение поля: 346
    public Coordinates(double x, double y){
        this.x = (float) x;
        this.y = (float) y;
    }
    public static Coordinates toCoordinates(String string){
        float x, y;
        try {
            x = Float.parseFloat(string.split(" ")[0]);
            y = Float.parseFloat(string.split(" ")[1]);
        } catch (IndexOutOfBoundsException | NumberFormatException i){
            x = Float.parseFloat(string.split("/")[0]);
            y = Float.parseFloat(string.split("/")[1]);
        }

        return new Coordinates(x, y);
    }

    @Override
    public String toString() {
        return this.x + " " + this.y;
    }

    public void setX(float x) {
        this.x = x;
    }
    public void setY(float y) {
        this.y = y;
    }
    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }
}
