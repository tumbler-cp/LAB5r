package commClasses;

import classes.*;
import collection.CollectionController;

public class Update extends Command{
    CollectionController control;
    private String[] arg;
    public Update(CollectionController collectionController){
        super("update", "обновить значение элемента коллекции, id которого равен заданному. Инструкции: update man.", "id {element}");
        this.control = collectionController;
    }

    //name, coordinates, age, color, type, character, cave
    @Override
    public void execute() {
        if (arg[0].equals("man")) this.instructions();
        else {
            for (Dragon obj : control.getCollection().values()) {
                if (Integer.parseInt(this.arg[0]) == obj.getId()) {
                    switch (Integer.parseInt(arg[1])) {
                        case 1:
                            obj.setName(arg[2]);
                            break;
                        case 2:
                            obj.setCoordinates(Coordinates.toCoordinates(arg[2]));
                            break;
                        case 3:
                            obj.setAge(Integer.parseInt(arg[2]));
                            break;
                        case 4:
                            obj.setColor(Color.toColor(Integer.parseInt(arg[2])));
                            break;
                        case 5:
                            obj.setType(DragonType.toDragonType(Integer.parseInt(arg[2])));
                            break;
                        case 6:
                            obj.setCharacter(DragonCharacter.toDragonCharacter(Integer.parseInt(arg[2])));
                            break;
                        case 7:
                            obj.setCave(new DragonCave(Integer.parseInt(arg[2])));
                            break;
                        case 8:
                            obj.setCreationDate(arg[2]);
                            break;
                    }
                }
            }
        }
    }
    public void instructions(){
        System.out.println("Syntax: update <id> <element> <value>");
        System.out.println("Element code: \n" +
                "1. Name. String \n" +
                "2. Coordinates. Syntax: x/y \n" +
                "3. Age. Integer \n" +
                "4. Color. Value code down here \n" +
                "5. Dragon Type. Value code down here \n" +
                "6. Dragon Character. Value code down here \n" +
                "7. Dragon Cave. Integer \n" +
                "8. Creation Date. Format: yyyy-mm-dd \n\n" +
                "Type: \n" +
                "1. UNDERGROUND \n" +
                "2. AIR \n" +
                "3. FIRE \n" +
                "Character: \n" +
                "1. WISE \n" +
                "2. GOOD \n" +
                "3. CHAOTIC_EVIL \n" +
                "Color: \n" +
                "1. GREEN \n" +
                "2. RED \n" +
                "3. BLUE \n" +
                "4. YELLOW \n" +
                "5. BROWN");
    }
    public void setArg(String[] arg) {
        this.arg = arg;
    }
}
