package commClasses;

import classes.Dragon;
import collection.CollectionControl;

public class Show extends Command{
    CollectionControl collectionControl;
    public Show(CollectionControl C){
        super("show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        this.collectionControl = C;
    }

    @Override
    public void execute() {
        for (Dragon dragon : this.collectionControl.getCollection().values()){
            dragon.printInfo();
        }
    }
}
