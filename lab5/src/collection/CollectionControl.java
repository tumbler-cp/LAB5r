package collection;

import classes.Dragon;

import java.util.HashMap;
import java.util.Date;


public class CollectionControl {
    public static String buffer = "";
    private HashMap<Integer, Dragon> collection = new HashMap();
    Date initDate;
    public CollectionControl(){
        initDate = new Date();
    }
    public void clear(){
        collection.clear();
    }
    public void add(Dragon dragon){
        if (dragon.check() && dragon.getCave().check() && dragon.getCoordinates().check()) {
            collection.put(dragon.getId(), dragon);
        }
        else {
            System.out.println("Следующий дракон не подходит под условия:");
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
}
