package commands;

import collection.CollectionManager;

import java.util.concurrent.atomic.AtomicBoolean;

public class Info extends Command{
    CollectionManager collectionManager;
    public Info(CollectionManager collectionManager){
        super("info", "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(AtomicBoolean lever) {
        System.out.println(this.collectionManager);
    }
}
