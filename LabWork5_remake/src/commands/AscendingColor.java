package commands;

import collection.CollectionManager;
import dragon.Dragon;
import dragon.Color;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class AscendingColor extends Command{
    CollectionManager collection;
    public AscendingColor(CollectionManager collectionManager){
        super("print_field_ascending_color", "вывести значения поля color всех элементов в порядке возрастания");
        this.collection = collectionManager;
    }

    @Override
    public void execute(AtomicBoolean lever) {
        HashMap<Integer, Color> buffer = new HashMap<Integer, Color>();
        for (Dragon d : collection.get_list()) {
            buffer.put(d.getId(), d.getColor());
        }
        buffer.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);
    }
}
