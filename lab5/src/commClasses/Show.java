package commClasses;

import classes.Dragon;
import collection.CollectionController;

public class Show extends Command{
    CollectionController collectionController;
    public Show(CollectionController C){
        super("show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        this.collectionController = C;
    }

    @Override
    public void execute() {
        for (Dragon dragon : this.collectionController.getCollection().values()){
            dragon.printInfo();
        }
    }
}
