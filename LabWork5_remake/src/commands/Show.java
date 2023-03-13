package commands;

import collection.CollectionManager;
import dragon.Dragon;

import java.util.concurrent.atomic.AtomicBoolean;

public class Show extends Command{
    CollectionManager collection;
    public Show(CollectionManager collection){
        super("show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        this.collection = collection;
    }

    @Override
    public void execute(AtomicBoolean lever) {
        for (Dragon dragon : collection.get_collection().values()) {
            System.out.println(dragon);
        }
    }
}
