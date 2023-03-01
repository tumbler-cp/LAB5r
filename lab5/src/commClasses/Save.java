package commClasses;

import classes.Dragon;
import collection.CollectionController;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Save extends Command{
    private BufferedWriter writer;
    CollectionController collectionController;
    String filename;
    public Save(String filename, CollectionController control){
        super ("save", "сохранить коллекцию в файл");
        this.collectionController = control;
        this.filename = filename;
    }
    //77,gg,1 3,12.12.12,12,RED,FIRE,CHAOTIC_EVIL,12
    public void save() throws IOException {
        writer = new BufferedWriter(new FileWriter(filename));
        for (Dragon d : collectionController.getCollection().values()){
            String writable = d.getId().toString() + ","
                    + d.getName()+ ","
                    + d.getCoordinates().toString()+ ","
                    + d.getCreationDate().toString()+ ","
                    + d.getAge()+ ","
                    + d.getColor().toString()+ ","
                    + d.getType().toString()+ ","
                    + d.getCharacter().toString()+ ","
                    + d.getCave().toString() + "\n";
            writer.write(writable);
        }
        writer.flush();
        writer.close();
    }

    @Override
    public void execute() {
        try {
            this.save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
