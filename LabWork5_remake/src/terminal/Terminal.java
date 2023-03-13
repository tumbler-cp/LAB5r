package terminal;

import commands.CommandManager;
import commands.History;

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
    private CommandManager commands;
    private Scanner user_in;
    History history;
    public Terminal(CommandManager commandManager, Scanner scanner, History history){
        this.commands = commandManager;
        this.user_in = scanner;
        this.history = history;
    }
    public void executor(String[] line, AtomicBoolean l){
        String command = line[0];
        String[] args = new String[line.length-1];
        for (int i =0;i<line.length-1;i++){
            args[i] = line[i+1];
        }
        for(String command_key : commands.get_map().keySet()){
            if(command.equals(command_key)){
                var c = commands.get_map().get(command_key);
                if (args.length > 0) c.setArgs(args);
                try
                {
                    c.execute(l);
                } catch (ArrayIndexOutOfBoundsException a) {
                    System.out.println("Вы не ввели все аргументы либо ввели лишние пробелы.");
                }
                history.add(command);
                return;
            }
        }
        System.out.println("Команда '" + command + "' не найдена.");
    }
    public void run(){
        AtomicBoolean lever = new AtomicBoolean();
        lever.set(true);
        while(lever.get()){
            String[] line = user_in.nextLine().split(" ");
            executor(line, lever);
        }
    }

}
