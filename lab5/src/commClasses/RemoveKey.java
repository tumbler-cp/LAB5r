package commClasses;

import collection.CollectionControl;

public class RemoveKey extends Command
{
    CollectionControl control;
    String arg;
    public RemoveKey(CollectionControl collectionControl){
        super("remove_key", "удалить элемент из коллекции по его ключу", "null");
        this.control = collectionControl;
    }

    @Override
    public void execute() {
        control.remove(Integer.parseInt(arg));
    }

    public void setArg(String arg) {
        this.arg = arg;
    }
}
