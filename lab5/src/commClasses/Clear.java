package commClasses;

import classes.Dragon;
import collection.CollectionControl;

import java.util.HashMap;
import java.util.Map;

public class Clear extends Command {
    CollectionControl collection;
    public Clear(CollectionControl COLLECTION){
        super("clear", "очистить коллекцию");
        this.collection = COLLECTION;
    }
    public void execute(){
        this.collection.clear();
    }
}
