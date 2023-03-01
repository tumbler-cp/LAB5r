package collection;

import classes.*;
import com.opencsv.CSVReader;

import java.io.FileReader;


public class FileManager {
    CollectionController collectionController;
    public FileManager(String filename, CollectionController collControl) throws Exception {
        this.collectionController = collControl;
        this.read(filename);
    }
    public void read(String filename) throws Exception
    {
        //id, name, coordinates, creationDate, age, color, type, character, cave
        CSVReader fileIn = new CSVReader(new FileReader(filename));
        String[] buff;
        while ((buff = fileIn.readNext())!=null) {
            if (buff.length < 9) break;
            String[] finalBuff = buff;
            this.collectionController.add(new Dragon(
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
