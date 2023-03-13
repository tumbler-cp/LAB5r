package commands;

import collection.CollectionManager;
import dragon.Dragon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;

public class PrintAscending extends Command{
    CollectionManager collection;
    public PrintAscending(CollectionManager collectionManager){
        super("print_ascending", "вывести элементы коллекции в порядке возрастания");
        collection = collectionManager;
    }

    @Override
    public void execute(AtomicBoolean lever) {
        ArrayList<Dragon> list = new ArrayList<>();
        this.collection.get_collection().values().forEach(list::add);
        Collections.sort(list);
        for (Dragon d : list) System.out.println(d);
    }
}
