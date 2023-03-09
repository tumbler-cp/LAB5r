import java.util.Scanner;


import collection.CollectionController;
import collection.CommandList;
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
        CollectionController control = new CollectionController();
        History history = new History();
        var commDictionary = new CommandList(){{
            addCommand(new Help(this));
            addCommand(new Info(control));
            addCommand(new Show(control));
            addCommand(new Insert(control, null));
            addCommand(new Update(control));
            addCommand(new RemoveKey(control));
            addCommand(new Clear(control));
            addCommand(new Save(args[0], control));
            addCommand(new Exit());
            addCommand(history);
            addCommand(new PrintAscending(control));
        }};
        Terminal console = new Terminal(userIn, commDictionary, history);
        commDictionary.addCommand(new ExecuteScript(console));
        FileManager mainFM = new FileManager(args[0], control);
        try { console.run(); }
        catch (Exception e) {
            for(Command comm : commDictionary.getAll().values()) {
                if (comm.getName().equals("save")){
                    comm.execute();
                }
            }
        }
    }
}
