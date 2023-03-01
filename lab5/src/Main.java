import java.util.Scanner;


import collection.CollectionControl;
import collection.CommDictionary;
import collection.FileManager;
import commClasses.*;
import terminal.Terminal;


public class Main {
    /**
     * Здесь нужно обязательно создать экземпляры CollectionControl, History, Terminal, FileManager
     *
     */
    public static void main(String[] args) throws Exception {
        Scanner userIn = new Scanner(System.in);
        CollectionControl control = new CollectionControl();
        History history = new History();
        var commDictionary = new CommDictionary(){{
            addCommand(new Help(this));
            addCommand(new Info(control));
            addCommand(new Clear(control));
            addCommand(new Exit());
            addCommand(history);
            addCommand(new Show(control));
            addCommand(new Insert(control, null));
            addCommand(new Save(args[0], control));
            addCommand(new RemoveKey(control));
            addCommand(new Update(control));
        }};
        Terminal console = new Terminal(userIn, commDictionary, history);
        commDictionary.addCommand(new ExecuteScript(console));
        FileManager mainFM = new FileManager(args[0], control);
        console.run();
    }
}
