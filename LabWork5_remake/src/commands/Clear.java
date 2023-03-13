package commands;

import collection.CollectionManager;

import java.util.concurrent.atomic.AtomicBoolean;

public class Clear extends Command{
    CollectionManager collection;
    public Clear(CollectionManager collectionManager){
        super("clear", "очистить коллекцию");
        this.collection = collectionManager;
    }

    @Override
    public void execute(AtomicBoolean lever) {
        collection.get_collection().clear();
    }
}
