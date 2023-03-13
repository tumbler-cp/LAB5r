package commands;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class History extends Command{
    List<String> list = new ArrayList<>();
    public History(){
        super("history", "вывести последние 14 команд (без их аргументов)");
    }

    public void add(String c){
        this.list.add(c);
        if(list.size() > 14) list.remove(0);
    }

    @Override
    public void execute(AtomicBoolean lever) {
        for (String s : list) System.out.println(s);
    }
}
