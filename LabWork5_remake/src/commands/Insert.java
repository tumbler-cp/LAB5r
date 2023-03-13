package commands;

import collection.CollectionManager;
import dragon.*;

import java.util.concurrent.atomic.AtomicBoolean;

public class Insert extends Command{
    private CollectionManager collectionManager;
    public Insert(CollectionManager collectionManager){
        super("insert null {element}","добавить новый элемент с заданным ключом");
        this.collectionManager = collectionManager;
    }

    public static boolean IdChecker(CollectionManager collectionManager, Integer id){
        for (Integer d : collectionManager.get_collection().keySet()){
            if (id.equals(d)) return true;
        }
        return false;
    }

    public static void adder(CollectionManager collection, String[] argLine, int offset){
        Integer id = Integer.parseInt(argLine[0]);
        if (IdChecker(collection, id)){
            Integer i = 1;
            while (true){
                if(!IdChecker(collection, i)) {
                    id = i;
                    break;
                }
                i++;
            }
        }
        Integer finalId = id;
        collection.insert
                (new Dragon(
                         argLine[1],
                         Coordinates.toCoordinates(argLine[2]),
                         Integer.parseInt(argLine[3+offset]),
                         Color.toColor(argLine[4+offset]),
                         DragonType.toDragonType(argLine[5+offset]),
                         DragonCharacter.toDragonCharacter(argLine[6+offset]),
                         new DragonCave(Integer.parseInt(argLine[7+offset]))
                 ) {{
                     setId(finalId);
                     if (offset==1) setCreationDate(argLine[3]);
                 }}
                );
    }
    public static void manual(){
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
    }
    @Override
    public void execute(AtomicBoolean lever) {
        String[] args = this.getArgs();
        if (args[0].equals("man")) manual();
        else
        {
            adder(collectionManager, args, 0);
        }
    }
}
