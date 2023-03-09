package collection;

import commClasses.Command;

import java.util.Map;
import java.util.HashMap;

public class CommandList {
    Map<String, Command> dictionary = new HashMap<>();
    public void addCommand(Command command){
        this.dictionary.put(command.getName(), command);
    }
    public Map<String, Command> getAll(){
        return this.dictionary;
    }
}
