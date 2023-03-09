package terminal;

import collection.CommandList;
import commClasses.*;

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
    private CommandList commandList;
    private Scanner input;
    History history;
    public Terminal(Scanner input, CommandList commandList, History history){
        this.commandList = commandList;
        this.input = input;
        this.history = history;
    }
    public void executeCommand(String comm, String[] args){
        AtomicBoolean k = new AtomicBoolean(true);
        commandList.getAll().values().forEach(command -> {
            if (comm.equals(command.getName())) {
                if (args.length > 0) this.argExecute(command, args, k);
                else this.normalExecute(command, k);
            }
        });
        if (k.get()) System.out.println("No such command: " + comm);
    }


    private void normalExecute(Command command, AtomicBoolean checker){
        command.execute();
        history.addCommand(command);
        checker.set(false);
    }

    private void argExecute(Command command, String[] args, AtomicBoolean checker){
        command.setArgs(args);
        command.execute();
        history.addCommand(command);
        checker.set(false);
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
            executeCommand(comm, arguments);
        }
    }
}
