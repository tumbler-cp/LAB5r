package terminal;

import collection.CommDictionary;
import commClasses.History;
import commClasses.Insert;

import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class Terminal {
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    private CommDictionary commDictionary;
    private Scanner input;
    History history;
    public Terminal(Scanner input, CommDictionary commDictionary, History history){
        this.commDictionary = commDictionary;
        this.input = input;
        this.history = history;
    }
    public void run(){
        while (true){
            System.out.print(GREEN);
            String line = input.nextLine();
            System.out.print(RESET);
            String comm = line.split(" ")[0];
            var splitting = line.split(" ");
            final int argSize = splitting.length - 1;
            String[] arguments = new String[argSize];
            for (int i =0;i<argSize;i++){
                arguments[i] = splitting[i+1];
                System.out.println(arguments[i]);
            }
            AtomicBoolean k = new AtomicBoolean(true);
            commDictionary.getAll().forEach(command -> {
                if(Objects.equals(comm, "insert")){
                    if (Objects.equals(comm, command.getName())){
                        ((Insert) command).setArgs(arguments);
                        command.execute();
                        k.set(false);
                        history.addCommand(command);
                    }
                }
                else if(Objects.equals(comm, command.getName())) {
                    command.execute();
                    k.set(false);
                    history.addCommand(command);
                }
            });
            if (k.get()) System.out.println("No such command: "+comm);
        }
    }
}
