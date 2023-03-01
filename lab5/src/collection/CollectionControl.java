package collection;

import classes.Dragon;

import java.util.HashMap;
import java.util.Date;
import java.util.Objects;


public class CollectionControl {
    private HashMap<Integer, Dragon> collection = new HashMap();
    private Date initDate;
    public CollectionControl(){
        initDate = new Date();
    }
    public void clear(){
        collection.clear();
    }
    public void add(Dragon dragon){
        if (dragon.check() && dragon.getCave().check()) {
            this.IdCheck(dragon);
            collection.put(dragon.getId(), dragon);
        }
        else {
            System.out.println("Следующий дракон не подходит под условия:");
            dragon.printInfo();
        }
        Dragon.setMaxId(this.getBiggestId());
    }
    private void IdCheck(Dragon dragon){
        for(Dragon d : collection.values()){
            if (Objects.equals(dragon.getId(), d.getId())){
                System.out.println("Есть совпадение id. Исправление...");
                dragon.setId(Dragon.getMaxId());
            }
        }
    }
    public void addWithKey(Integer key, Dragon dragon){
        dragon.setId(key);
        this.add(dragon);
    }
    public void remove(Dragon dragon){
        collection.remove(dragon.getId());
    }
    public HashMap<Integer, Dragon> getCollection() {
        return collection;
    }
    public Date getInitDate(){
        return this.initDate;
    }
    public String getType(){
        return String.valueOf(collection.getClass()).split("class java.util.")[1];
    }
    public int getObjCount(){
        return collection.size();
    }
    public int getBiggestId(){
        int buff = 0;
        for (Dragon a : collection.values()){
            if (a.getId() > buff) buff = a.getId();
        }
        return buff;
    }
    public void remove(Integer key){
        this.collection.remove(key);
    }
}
