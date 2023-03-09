package commClasses;

import classes.*;
import collection.CollectionController;

import java.util.Objects;

public class Insert extends Command{
    CollectionController collectionController;
    String[] args;
    public Insert(CollectionController collectionController, String[] Args){
        super("insert", "добавить новый элемент с заданным ключом. Инструкции: insert man", "null {element} ");
        this.collectionController = collectionController;
        this.args = Args;
    }
    //name, coordinates, age, color, type, character, cave
    public void execute() {
        if (Objects.equals(args[0], "man")){
            System.out.println("Syntax: insert <Integer key(id)> <String name> <x/y(coordinates)> <int age> <int color> <int type> <int character> <int cave(Num of treasures)>");
            System.out.println("Color: \n" +
                    "1. GREEN \n" +
                    "2. RED \n" +
                    "3. BLUE \n" +
                    "4. YELLOW \n" +
                    "5. BROWN \n" +
                    "Type: \n" +
                    "1. UNDERGROUND \n" +
                    "2. AIR \n" +
                    "3. FIRE \n" +
                    "Character: \n" +
                    "1. WISE \n" +
                    "2. GOOD \n" +
                    "3. CHAOTIC_EVIL \n");
        }else {
            if (!collectionController.addWithKey(
                    Integer.parseInt(args[0]),
                    new Dragon(
                    args[1],
                    Coordinates.toCoordinates(args[2].split("/")[0] + " " + args[2].split("/")[1]),
                    Integer.parseInt(args[3]),
                    Color.toColor(Integer.parseInt(args[4])),
                    DragonType.toDragonType(Integer.parseInt(args[5])),
                    DragonCharacter.toDragonCharacter(Integer.parseInt(args[6])),
                    new DragonCave(Integer.parseInt(args[7])
                    )
            ))){
                System.out.println("Дракон с id " + args[0]+" не подходит под условия.");
            }
        }
    }

    public void setArgs(String[] args) {
        this.args = args;
    }
}
