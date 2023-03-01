package commClasses;

import classes.Dragon;
import collection.CollectionController;

import java.util.Arrays;

public class PrintAscending extends Command
{
    CollectionController collectionController;
    public PrintAscending(CollectionController c) {
        super("print_ascending", "вывести элементы коллекции в порядке возрастания");
        this.collectionController = c;
    }

    @Override
    public void execute()
    {
        Dragon[] dragons = collectionController.getCollection().values().toArray(new Dragon[0]);
        Arrays.sort(dragons);
        for (int i = 0; i <dragons.length;i++) dragons[i].printInfo();
    }
}
