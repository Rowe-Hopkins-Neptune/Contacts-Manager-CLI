import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Contacts {
    private String name;
    private String number;

    public Contacts(String name, String number) {
        this.name=name;
        this.number=number;
    }

    public Contacts() {

    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }
        //Delete Contacts
//    List<String> currentList = new ArrayList<>();
//        try{
//        currentList = Files.readAllLines(toOurDataFile);
//    }catch(IOException ioe){
//        ioe.printStackTrace();
//    }
//    Iterator<String> listIterator = currentList.iterator();
//        while(listIterator.hasNext()) {
//        String empress = listIterator.next();
//        if(empress.equals("Galla Placidia")){
//            listIterator.remove();
//        }
//    }
//        try{
//        Files.write(toOurDataFile, currentList);
//    }catch(IOException ioe){
//        ioe.printStackTrace();
//    }
//        io.readFileAndOutput(toOurDataFile);
//}
}
