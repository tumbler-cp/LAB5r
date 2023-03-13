package commands;

import collection.CollectionManager;

import java.util.concurrent.atomic.AtomicBoolean;

public class RemoveLowerKey extends Command{
    CollectionManager collection;
    public RemoveLowerKey(CollectionManager collectionManager){
        super("remove_lower_key null", "удалить из коллекции все элементы, ключ которых меньше, чем заданный");
        collection = collectionManager;
    }

    @Override
    public void execute(AtomicBoolean lever) {
        int key = Integer.parseInt(this.getArgs()[0]);
        for (Integer currentKey : collection.get_collection().keySet()){
            if (key > currentKey) collection.get_collection().remove(currentKey);
        }
    }
}
