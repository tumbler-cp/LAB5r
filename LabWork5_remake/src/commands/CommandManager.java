package commands;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CommandManager {
    HashMap<String, Command> list = new LinkedHashMap<>();
    public void add(String CommandName, Command command){
        this.list.put(CommandName, command);
    }
    public Map<String,Command> get_map(){
        return this.list;
    }
}
