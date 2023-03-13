package commands;

import collection.CollectionManager;

import java.util.concurrent.atomic.AtomicBoolean;

public class RemoveKey extends Command{
    CollectionManager collection;
    public RemoveKey(CollectionManager collectionManager){
        super("remove_key null", "удалить элемент из коллекции по его ключу");
        collection = collectionManager;
    }

    @Override
    public void execute(AtomicBoolean lever) {
        int key = Integer.parseInt(this.getArgs()[0]);
        collection.get_collection().remove(key);
    }
}
