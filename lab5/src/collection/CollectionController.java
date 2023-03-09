package collection;

import classes.Dragon;

import java.util.*;


public class CollectionController
{
    private HashMap<Integer, Dragon> collection = new HashMap();
    private Date initDate;
    public CollectionController(){
        initDate = new Date();
    }
    public void clear(){
        collection.clear();
    }
    public boolean add(Dragon dragon){
        if (dragon.check() && dragon.getCave().check()) {
            this.IdCheck(dragon);
            collection.put(dragon.getId(), dragon);
            Dragon.setMaxId(this.getBiggestId());
            return true;
        }
        else {
            return false;
        }
    }
    private void IdCheck(Dragon dragon){
        for(Dragon d : collection.values()){
            if (Objects.equals(dragon.getId(), d.getId())){
                System.out.println("Есть совпадение id. Исправление...");
                dragon.setId(Dragon.getMaxId());
            }
        }
    }
    public boolean addWithKey(Integer key, Dragon dragon){
        dragon.setId(key);
        return this.add(dragon);
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
