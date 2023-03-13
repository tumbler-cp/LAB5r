package commands;

import collection.CollectionManager;
import dragon.*;

import java.util.concurrent.atomic.AtomicBoolean;

public class UpdateId extends Command{
    CollectionManager collection;
    public UpdateId(CollectionManager collectionManager){
        super("update id {element}", "обновить значение элемента коллекции, id которого равен заданному");
        collection = collectionManager;
    }

    public void manual(){
        System.out.println(
                """
                        Syntax: update <int id> <int var> <text>\s
                        Vars:
                        1 - name
                        2 - Coordinates. <int x>/<int y>
                        3 - age
                        4 - color:
                            1 - GREEN
                            2 - RED
                            3 - BLUE
                            4 - YELLOW
                            5 - BROWN
                        5 - type:
                            1 - UNDERGROUND
                            2 - FIRE
                            3 - AIR
                        6 - character:
                            1 - WISE
                            2 - GOOD
                            3 - CHAOTIC_EVIL
                        7 - cave. <int Num. of treasure>
                """
        );
    }

    @Override
    public void execute(AtomicBoolean lever) {
        String[] argLine = this.getArgs();
        if (argLine[0].equals("man")) manual();
        else
        {
            int id = Integer.parseInt(argLine[0]);
            Dragon dragon = null;
            for (Dragon d : collection.get_collection().values()){
                if(id == d.getId()) {
                    dragon = d;
                    break;
                }
            }
            switch (argLine[1]){
                case "1" :
                    dragon.setName(argLine[2]);
                    break;
                case "2" :
                    dragon.setCoordinates(Coordinates.toCoordinates(argLine[2]));
                    break;
                case "3" :
                    dragon.setAge(Integer.parseInt(argLine[2]));
                    break;
                case "4" :
                    dragon.setColor(Color.toColor(argLine[2]));
                    break;
                case "5" :
                    dragon.setType(DragonType.toDragonType(argLine[2]));
                    break;
                case "6" :
                    dragon.setCharacter(DragonCharacter.toDragonCharacter(argLine[2]));
                    break;
                case "7" :
                    dragon.setCave(new DragonCave(Integer.parseInt(argLine[2])));
                    break;
            }
        }
    }
}
