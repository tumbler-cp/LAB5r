package commands;

import collection.CollectionManager;
import dragon.*;

import java.util.concurrent.atomic.AtomicBoolean;

public class ReplaceGreater extends Command{
    CollectionManager collection;
    public ReplaceGreater(CollectionManager collectionManager){
        super("replace_if_greater null {element}", "заменить значение по ключу, если новое значение больше старого");
        this.collection = collectionManager;
    }


    /*
    * public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    * */
    public void manual(){
        System.out.println(
                """
                Syntax: replace_if_greater <int key> <int var> <String arg>\s
                Vars:
                        1 - name                           | 1 - GREEN       | 1 - \u001B[33mUNDERGROUND\u001B[0m  | 1 - WISE
                        2 - Coordinates. <int x>/<int y>   | 2 - RED         | 2 - \u001B[31mFIRE\u001B[0m         | 2 - GOOD
                        3 - age                            | 3 - BLUE        | 3 - \u001B[32mAIR\u001B[0m          | 3 - CHAOTIC_EVIL
                        4 - color: column 1                | 4 - YELLOW      |                  |
                        5 - type: column 2                 | 5 - BROWN       |                  |
                        6 - character: column 3            |                 |                  |
                        7 - cave. <int Num. of treasure>   |                 |                  |
                """
        );
    }

    @Override
    public void execute(AtomicBoolean lever) {
        String[] args = this.getArgs();
        if (this.getArgs()[0].equals("man")) manual();
        else {
            Dragon dragon = collection.get_collection().get(Integer.parseInt(args[0]));
            switch (args[1]) {
                case "1":
                    if (dragon.getName().compareTo(args[2]) > 0) return;
                    dragon.setName(args[2]);
                    break;
                case "2":
                    if (dragon.getCoordinates().compareTo(Coordinates.toCoordinates(args[2])) > 0) return;
                    dragon.setCoordinates(Coordinates.toCoordinates(args[2]));
                    break;
                case "3":
                    if (dragon.getAge() > Integer.parseInt(args[2])) return;
                    dragon.setAge(Integer.parseInt(args[2]));
                    break;
                case "4":
                    if (dragon.getColor().compareTo(Color.toColor(args[2])) > 0) return;
                    dragon.setColor(Color.toColor(args[2]));
                    break;
                case "5":
                    if (dragon.getType().compareTo(DragonType.toDragonType(args[2])) > 0) return;
                    dragon.setType(DragonType.toDragonType(args[2]));
                    break;
                case "6":
                    if (dragon.getCharacter().compareTo(DragonCharacter.toDragonCharacter(args[2])) > 0) return;
                    dragon.setCharacter(DragonCharacter.toDragonCharacter(args[2]));
                    break;
                case "7":
                    if (dragon.getCave().compareTo(new DragonCave(Integer.parseInt(args[2]))) > 0) return;
                    dragon.setCave(new DragonCave(Integer.parseInt(args[2])));
                    break;
            }
        }
    }
}

