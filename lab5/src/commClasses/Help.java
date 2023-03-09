package commClasses;

import collection.CommandList;
import terminal.Terminal;

public class Help extends Command{
    private CommandList commandList;
    public Help(CommandList dictionary){
        super("help", "вывести справку по доступным командам");
        this.commandList = dictionary;
    }
    public void execute(){
        commandList.getAll().values().forEach(command -> {
            System.out.println(Terminal.PURPLE + command.getName() + " " + command.getArgsText() + " : " + Terminal.RESET + command.getDescription());
        });
    }
}
