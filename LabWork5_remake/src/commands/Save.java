package commands;

import file.FileManager;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public class Save extends Command{
    FileManager fm;
    public Save(FileManager fileManager){
        super("save", "сохранить коллекцию в файл");
        this.fm = fileManager;
    }

    @Override
    public void execute(AtomicBoolean lever) {
        try {
            this.fm.write();
        }catch (IOException io){
            System.out.println("Ошибка записи в файл.");
        }
    }
}
