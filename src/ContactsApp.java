import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ContactsApp {

    //Print out contact
    public void readFileAndOutput(Path pathToFile) {
        List<String> currentList = new ArrayList<>();
        try {
            currentList = Files.readAllLines(pathToFile);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        System.out.println("Name\t| Number");
        System.out.println("----------------------");
        for (String line : currentList) {

            System.out.println(line);
        }
    }

    //Add new contact
    public static void addContact(String name, String number, Path path) {
        try {
            Files.writeString(path, name + "\t| " + number + "\n", StandardOpenOption.APPEND);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    //Search contact
    public static void searchContacts(String name, Path path) {
        List<String> currentList = new ArrayList<>();
        try {
            currentList = Files.readAllLines(path);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        Iterator<String> listIterator = currentList.iterator();
        while (listIterator.hasNext()) {
            String contact = listIterator.next();
            if (contact.contains(name)) {
                System.out.println(contact);
            }
        }
    }

    //Delete Contacts
    public static void Delete(String name, Path path) {
        Scanner sc = new Scanner(System.in);
        List<String> currentList = new ArrayList<>();
        try {
            currentList = Files.readAllLines(path);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        Iterator<String> listIterator = currentList.iterator();
        while (listIterator.hasNext()) {
            String contact = listIterator.next();
            if (contact.contains(name)) {
                System.out.printf("Are you sure you want to delete %s?\n", name);
                String verify = sc.next();
                if (verify.equals("y") || verify.equals("yes")) {
                    listIterator.remove();
                } else {
                    break;
                }
            }
        }
        try {
            Files.write(path, currentList);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }


    public static void main(String[] args) {

        ContactsApp io = new ContactsApp();

        Path toOurDataPlace = Paths.get("src/contacts");
//        try {
//            if (Files.notExists(toOurDataPlace)){
//                Files.createDirectories(toOurDataPlace);
//        }else{
//            System.out.println("The " + toOurDataPlace + " directory already exists.");
//        }
//        }catch (IOException ioe){
//            ioe.printStackTrace();
//        }

        Path toOurDataFile = Paths.get(String.valueOf(toOurDataPlace), "contact.txt");
//        try{
//            if(Files.notExists(toOurDataFile)){
//                Files.createFile(toOurDataFile);
//            }
//            Files.createFile(toOurDataFile);
//        }catch(IOException ioe){
//            ioe.printStackTrace();
//        }

        Scanner scanner = new Scanner(System.in);
        int userInput;
        //loop for menu
        do {
            System.out.println();
            System.out.println("1. View contacts.");
            System.out.println("2. Add a new contact.");
            System.out.println("3. Search a contact by name.");
            System.out.println("4. Delete an existing contact.");
            System.out.println("5. Exit.");

            //verification loop
            do {
                System.out.println("Enter an option (1, 2, 3, 4, 5):");
                userInput = scanner.nextInt();
            } while (userInput > 5 || userInput < 1);
            scanner.nextLine();
            //Menu options
            switch (userInput) {
                case 1:
                    io.readFileAndOutput(toOurDataFile);
                    break;
                case 2:
                    System.out.print("Please enter a name:");
                    String name = scanner.nextLine();
                    System.out.print("\nPlease enter number:");
                    String number = scanner.next();
                    Contacts contacts = new Contacts(name, number);
                    addContact(contacts.getName(), contacts.getNumber(), toOurDataFile);
                    break;
                case 3:
                    System.out.print("Please enter a name:");
                    String searchName = scanner.nextLine();
                    searchContacts(searchName, toOurDataFile);
                    break;
                case 4:
                    System.out.println("Please enter a name");
                    String deleteName = scanner.nextLine();
                    Delete(deleteName, toOurDataFile);
                    io.readFileAndOutput(toOurDataFile);
                    break;
                case 5:
                    break;

            }
        } while (userInput != 5);
    }

}
