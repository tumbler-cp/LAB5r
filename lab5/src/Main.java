import java.util.Scanner;


import collection.CollectionControl;
import collection.CommDictionary;
import collection.FileManager;
import commClasses.*;
import terminal.Terminal;


public class Main {
    /**
     *
     * You are able to control every parameter of the app from here - method main().
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
        }};
        Terminal console = new Terminal(userIn, commDictionary, history);
        FileManager mainFM = new FileManager(args[0], control);
        console.run();
    }
}
