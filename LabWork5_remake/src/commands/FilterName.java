package commands;

import collection.CollectionManager;
import dragon.Dragon;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilterName extends Command {
    CollectionManager collection;
    public FilterName(CollectionManager collectionManager){
        super("filter_contains_name name", "вывести элементы, значение поля name которых содержит заданную подстроку");
        this.collection = collectionManager;
    }

    @Override
    public void execute(AtomicBoolean lever) {
        String reg = ".*" + this.getArgs()[0] + ".*";
        Pattern pattern = Pattern.compile(reg);
        List<Dragon> list = collection.get_list();
        for (Dragon d : list){
            Matcher matcher = pattern.matcher(d.getName());
            if (matcher.matches()) System.out.println(d);
        }
    }
}
