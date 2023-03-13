package file;

import collection.CollectionManager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import commands.Insert;
import dragon.*;

public class FileManager {
    private String filename;
    private CollectionManager collection;
    public FileManager(String filename, CollectionManager collectionManager) {
        this.filename = filename;
        this.collection = collectionManager;
        try{
            this.update();
        }
        catch (FileNotFoundException f){
            System.out.println("Указанный файл не найден: " + filename);
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Ошибка потока ввода/вывода.");;
        }

    }

    public void update() throws IOException, CsvValidationException {
        CSVReader in = new CSVReader(new FileReader(this.filename));
        String[] currentLine;

        while((currentLine = in.readNext())!=null){
            if (currentLine.length == 0) return;
            Insert.adder(collection, currentLine, 1);
        }
        in.close();
    }
    public void write() throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter(this.filename));
        CSVWriter out = new CSVWriter(bw);
        out.writeAll(get_dragon(collection));
        out.flush();
        out.close();
    }
    private static List<String[]> get_dragon(CollectionManager c){
        List<String[]> returnable = new ArrayList<>(){{
            /**/
            for (Dragon d : c.get_collection().values()){
                add(new String[]{
                                d.getId().toString(),
                                d.getName(),
                                d.getCoordinates().toString(),
                                d.getCreationDate().toString(),
                                String.valueOf(d.getAge()),
                                d.getColor().toString(),
                                d.getType().toString(),
                                d.getCharacter().toString(),
                                d.getCave().toString()
                        }
                );
            }
        }};
        return returnable;
    }
}
