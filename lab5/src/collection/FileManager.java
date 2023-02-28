package collection;

import classes.*;
import com.opencsv.CSVReader;

import java.io.FileReader;


public class FileManager {
    CollectionControl collectionControl;
    public FileManager(String filename, CollectionControl collControl) throws Exception {
        this.collectionControl = collControl;
        this.read(filename);
    }
    public void read(String filename) throws Exception
    {
        //id, name, coordinates, creationDate, age, color, type, character, cave
        CSVReader fileIn = new CSVReader(new FileReader(filename));
        fileIn.readNext();
        String[] buff;
        while ((buff = fileIn.readNext())!=null) {
            this.collectionControl.add(new Dragon(
                    buff[1],
                    Coordinates.toCoordinates(buff[2]),
                    Integer.valueOf(buff[4]),
                    Color.toColor(buff[5]),
                    DragonType.toDragonType(buff[6]),
                    DragonCharacter.toDragonCharacter(buff[7]),
                    new DragonCave(Integer.parseInt(buff[8]))
            ));
        }
    }
}
