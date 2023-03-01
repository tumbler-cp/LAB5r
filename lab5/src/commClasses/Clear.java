package commClasses;

import collection.CollectionController;

public class Clear extends Command {
    CollectionController collection;
    public Clear(CollectionController COLLECTION){
        super("clear", "очистить коллекцию");
        this.collection = COLLECTION;
    }
    public void execute(){
        this.collection.clear();
    }
}
