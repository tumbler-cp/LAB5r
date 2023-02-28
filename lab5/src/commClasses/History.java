package commClasses;

import terminal.Terminal;

import java.util.*;

public class History extends Command{
    private int index;
    List<Command> commHistory = new ArrayList<>();
    public History(){
        super("history", "вывести последние 14 команд (без их аргументов)");
    }
    public void addCommand(Command command){

        this.commHistory.add(command);
        this.checkForDel();
    }
    private void checkForDel(){
        if(this.commHistory.size()>14){
            this.commHistory.remove(0);
        }
    }

    @Override
    public void execute() {
        for (Command command : this.commHistory) {
            System.out.println(Terminal.CYAN + command.getName());
        }
        System.out.print(Terminal.GREEN);
    }
}
