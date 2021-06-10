import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Contacts {
    private String name;
    private String number;

    Scanner sc = new Scanner(System.in);


    public void Contacts(){
        System.out.println("Please enter a name.(First Name Last Name)");
         name = sc.nextLine();
        System.out.println("Please enter a number.(XXX-XXX-XXXX)");
         number = sc.next();
        addContact(name, number);
    }

    Path toOurDataPlace = Paths.get("src/contacts");

        //View contacts
//    public void readFileAndOutput(Path pathToFile) {
//        List<String> currentList = new ArrayList<>();
//        try {
//            currentList = Files.readAllLines(pathToFile);
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        }
//
//        for (String line : currentList) {
//            System.out.println(line);
//        }
//    }


        //Add contact
    public void addContact(String name, String number) {
    try{
            Files.writeString(toOurDataFile, name + " | " + number, StandardOpenOption.APPEND);
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
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
