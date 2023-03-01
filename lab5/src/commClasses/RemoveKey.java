package commClasses;

import collection.CollectionController;

public class RemoveKey extends Command
{
    CollectionController control;
    String arg;
    public RemoveKey(CollectionController collectionController){
        super("remove_key", "удалить элемент из коллекции по его ключу", "null");
        this.control = collectionController;
    }

    @Override
    public void execute() {
        control.remove(Integer.parseInt(arg));
    }

    public void setArg(String arg) {
        this.arg = arg;
    }
}
