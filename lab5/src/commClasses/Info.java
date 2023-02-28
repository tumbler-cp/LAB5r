package commClasses;

import collection.CollectionControl;
import terminal.Terminal;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Info extends Command{  
     CollectionControl collectionControl;
     public Info(CollectionControl collection){
         super("info", "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
         this.collectionControl = collection;
     }

    @Override
    public void execute() {
        Date date = collectionControl.getInitDate();
        String pattern = "dd.MM.yyyy";
        SimpleDateFormat formatDate = new SimpleDateFormat(pattern);
        System.out.println(Terminal.YELLOW + "Тип коллекции: " + Terminal.RESET + collectionControl.getType());
        System.out.println(Terminal.YELLOW + "Дата инициализации: " + Terminal.RESET + formatDate.format(date));
        System.out.println(Terminal.YELLOW + "Количество объектов в коллекции: " + Terminal.RESET + collectionControl.getObjCount());
        System.out.println(Terminal.YELLOW + "Тип хранимого объекта: " + Terminal.RESET + "Dragon");
    }
}
