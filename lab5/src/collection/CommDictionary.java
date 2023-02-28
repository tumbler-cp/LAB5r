package collection;

import commClasses.Command;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class CommDictionary {
    List<Command> dictionary = new ArrayList<>();
    public CommDictionary(){

    }
    public void addCommand(Command command){
        this.dictionary.add(command);
    }
    public List<Command> getAll(){
        return this.dictionary;
    }
}
