package collection;

import dragon.Dragon;
import terminal.Terminal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class CollectionManager {
    private HashMap<Integer, Dragon> dragons = new HashMap<>();
    private LocalDate initDate;
    public CollectionManager(){
        initDate = LocalDate.now();
    }
    public boolean insert(Dragon dragon){
        if(dragon.check()) {
            this.dragons.put(dragon.getId(), dragon);
            return true;
        }
        System.out.println("Дракон с id " + dragon.getId() + " не подходит.");
        return false;
    }
    public HashMap<Integer, Dragon> get_collection(){
        return this.dragons;
    }

    public List<Dragon> get_list(){
        return new ArrayList<>(this.dragons.values());
    }

    @Override
    public String toString() {
        String valueType = "";
        for (Dragon dragon : this.dragons.values()) {
            Dragon a = dragon;
            valueType = a.getClass().toString();
            break;
        }
        return  Terminal.YELLOW + "Collection type: " + Terminal.RESET +this.dragons.getClass().toString().split("class java.util.")[1] + "\n" +
                Terminal.YELLOW + "Collection value type:" + Terminal.RESET +" Dragon" + "\n" +
                Terminal.YELLOW + "Init. Date: " + Terminal.RESET + this.initDate.toString() + "\n" +
                Terminal.YELLOW + "Object count: " + Terminal.RESET + this.dragons.size() + "\n";
    }
}
