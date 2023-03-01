package classes;

import collection.CollectionControl;
import terminal.Terminal;

import java.time.LocalDate;
public class Dragon implements Check, Comparable<Dragon>{
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private int age; //Значение поля должно быть больше 0
    private Color color; //Поле не может быть null
    private DragonType type; //Поле может быть null
    private DragonCharacter character; //Поле может быть null
    private DragonCave cave; //Поле может быть null
    //id, name, coordinates, creationDate, age, color, type, character, cave
    public Dragon(String name, Coordinates coordinates, Integer age, Color color, DragonType type, DragonCharacter character, DragonCave cave){
        this.id = maxId;
        Dragon.updateId();
        this.name = name;
        this.coordinates = coordinates;
        this.age = age;
        this.color = color;
        this.type = type;
        this.character = character;
        this.cave = cave;
        this.creationDate = LocalDate.now();
    }

    private static int maxId = 1;
    public static void updateId(){
        maxId += 1;
    }

    public static void setMaxId(int maxId) {
        Dragon.maxId = maxId;
    }

    public static int getMaxId() {
        return maxId;
    }

    public boolean check() {
        if (this.name == null || this.name.isEmpty()) return false;
        if (this.coordinates==null) return false;
        if (this.age <= 0) return false;
        if (this.color == null) return false;
        if (this.type == null) return false;
        if (this.character == null) return false;
        return this.cave != null;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    public void setCave(DragonCave cave) {
        this.cave = cave;
    }
    public DragonCave getCave() {
        return cave;
    }
    public void setCharacter(DragonCharacter character) {
        this.character = character;
    }
    public DragonCharacter getCharacter() {
        return character;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public Color getColor() {
        return color;
    }
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
    public Coordinates getCoordinates() {
        return coordinates;
    }
    public void setCreationDate(String s) {
        LocalDate creationDate;
        String[] c = s.split("-");
        creationDate = LocalDate.of(Integer.parseInt(c[0]), Integer.parseInt(c[1]) , Integer.parseInt(c[2]));
        this.creationDate = creationDate;
    }
    public LocalDate getCreationDate() {
        return creationDate;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setType(DragonType type) {
        this.type = type;
    }
    public DragonType getType() {
        return type;
    }
    public void printInfo(){
        System.out.print(
                Terminal.BLUE + "Id: " + Terminal.RESET + this.id + "\n"+
                Terminal.BLUE + "Name: " + Terminal.RESET + this.name + "\n"+
                Terminal.BLUE + "Coordinates: " + Terminal.RESET + this.coordinates + "\n"+
                Terminal.BLUE + "CreationDate: " + Terminal.RESET);
        System.out.printf("%d-%d-%d \n", this.creationDate.getYear(), this.creationDate.getMonthValue(),this.creationDate.getDayOfMonth());
        System.out.println(
                Terminal.BLUE + "Age: " + Terminal.RESET + this.age + "\n"+
                Terminal.BLUE + "Color: " + Terminal.RESET + this.color + "\n"+
                Terminal.BLUE + "Type: " + Terminal.RESET + this.type + "\n"+
                Terminal.BLUE + "Character: " + Terminal.RESET + this.character + "\n"+
                Terminal.BLUE + "Cave: " + Terminal.RESET + this.cave + "\n"
        );
    }

    @Override
    public int compareTo(Dragon o) {
        return this.id.compareTo(o.getId());
    }
}

