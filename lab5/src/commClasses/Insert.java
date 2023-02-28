package commClasses;

import classes.*;
import collection.CollectionControl;

import java.util.Objects;

public class Insert extends Command{
    CollectionControl collectionControl;
    String[] args;
    public Insert(CollectionControl collectionControl, String[] Args){
        super("insert", " null {element} добавить новый элемент с заданным ключом.\nEnter 'insert man' to see how to add new objects to collection and their parameters.");
        this.collectionControl = collectionControl;
        this.args = Args;
    }
    //name, coordinates, age, color, type, character, cave
    public void execute() {
        if (Objects.equals(args[0], "man")){
            System.out.println("Syntax: insert <Integer key(id)> <String name> <x/y(coordinates)> <int age> <int color> <int type> <int character> <int cave(Num of treasures)>");
            System.out.println("Color: \n" +
                    "1. RED \n" +
                    "2. YELLOW \n" +
                    "3. ORANGE \n" +
                    "4. WHITE \n" +
                    "5. BROWN \n" +
                    "Type: \n" +
                    "1. UNDERGROUND \n" +
                    "2. AIR \n" +
                    "3. FIRE \n" +
                    "Character: \n" +
                    "1. CUNNING \n" +
                    "2. EVIL \n" +
                    "3. CHAOTIC \n");
        }else {
            collectionControl.addWithKey(Integer.parseInt(args[0]), new Dragon(
                    args[1],
                    Coordinates.toCoordinates(args[2].split("/")[0] + " " + args[2].split("/")[1]),
                    Integer.parseInt(args[3]),
                    Color.toColor(Integer.parseInt(args[4])),
                    DragonType.toDragonType(Integer.parseInt(args[5])),
                    DragonCharacter.toDragonCharacter(Integer.parseInt(args[6])),
                    new DragonCave(Integer.parseInt(args[7]))
            ));
        }
    }

    public void setArgs(String[] args) {
        this.args = args;
    }
}
