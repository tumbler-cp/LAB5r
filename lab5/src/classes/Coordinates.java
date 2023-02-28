package classes;

public class Coordinates implements Check {
    private Long x; //Поле не может быть null
    private double y; //Максимальное значение поля: 346
    public Coordinates(double x, double y){
        this.x = (long) x;
        this.y = y;
    }
    public boolean check(){
        return this.x!=null && this.y <= 346;
    }
    public static Coordinates toCoordinates(String string){
        double x = Double.parseDouble(string.split(" ")[0]);
        double y = Double.parseDouble(string.split(" ")[1]);
        return new Coordinates(x, y);
    }

    @Override
    public String toString() {
        return this.x + " x " + (int) this.y;
    }

    public void setX(Long x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    public Long getX() {
        return x;
    }
    public double getY() {
        return y;
    }
}
