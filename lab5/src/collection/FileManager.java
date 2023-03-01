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
        String[] buff;
        while ((buff = fileIn.readNext())!=null) {
            String[] finalBuff = buff;
            this.collectionControl.add(new Dragon(
                    finalBuff[1],
                    Coordinates.toCoordinates(finalBuff[2]),
                    Integer.valueOf(finalBuff[4]),
                    Color.toColor(finalBuff[5]),
                    DragonType.toDragonType(finalBuff[6]),
                    DragonCharacter.toDragonCharacter(finalBuff[7]),
                    new DragonCave(Integer.parseInt(finalBuff[8]))
            ){{
                setId(Integer.parseInt(finalBuff[0]));
                setCreationDate(finalBuff[3]);
            }});
        }
    }
}
