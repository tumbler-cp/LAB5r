import collection.CollectionManager;
import commands.*;
import file.FileManager;
import terminal.Terminal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
import dragon.Dragon;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        CollectionManager collection = new CollectionManager();
        FileManager file = new FileManager(args[0], collection);
        CommandManager command_list = new CommandManager(){{
            add("help", new Help(this));
            add("info", new Info(collection));
            add("show", new Show(collection));
            add("exit", new Exit());
            add("clear", new Clear(collection));
            add("save", new Save(file));
            add("insert", new Insert(collection));
            add("print_ascending", new PrintAscending(collection));
            add("remove_key", new RemoveKey(collection));
            add("update", new UpdateId(collection));
            add("remove_lower_key", new RemoveLowerKey(collection));
        }};
        History history = new History();
        Terminal terminal = new Terminal(command_list, in, history);
        command_list.add("history", history);
        command_list.add("execute_script", new ExecuteScript(terminal));
        terminal.run();
    }
}
