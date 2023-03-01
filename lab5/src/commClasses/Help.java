package commClasses;

import collection.CommDictionary;
import terminal.Terminal;

public class Help extends Command{
    private CommDictionary commDictionary;
    public Help(CommDictionary dictionary){
        super("help", "вывести справку по доступным командам");
        this.commDictionary = dictionary;
    }
    public void execute(){
        commDictionary.getAll().forEach(command -> {
            System.out.println(Terminal.PURPLE + command.getName() + " " + command.getArgs() + " : " + Terminal.RESET + command.getDescription());
        });
    }
}
