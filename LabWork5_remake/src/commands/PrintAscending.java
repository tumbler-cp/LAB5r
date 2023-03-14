package commands;

import collection.CollectionManager;
import dragon.Dragon;

import java.util.ArrayList;
import java.util.List;
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
        List<Dragon> list = collection.get_list();
        Collections.sort(list);
        for (Dragon d : list) System.out.println(d);
    }
}
