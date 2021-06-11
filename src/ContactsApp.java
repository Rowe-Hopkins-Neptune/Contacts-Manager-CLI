import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class ContactsApp {

    //Print out contact
    public void readFileAndOutput(Path pathToFile) {
        List<String> currentList = new ArrayList<>();
        try {
            currentList = Files.readAllLines(pathToFile);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        System.out.println("|\t\tName\t\t |\t\tNumber\t |");
        System.out.println("--------------------------------------");
        for (String line : currentList) {
            String[] parts = line.split("\\|");
            System.out.printf("|%-20s|%-15s|\n",parts[0], parts[1]);
        }
    }

    public static void welcome() {
        System.out.println(" __          __  _                          ");
        System.out.println(" \\ \\        / / | |                         ");
        System.out.println("  \\ \\  /\\  / /__| | ___ ___  _ __ ___   ___ ");
        System.out.println("   \\ \\/  \\/ / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\");
        System.out.println("    \\  /\\  /  __/ | (_| (_) | | | | | |  __/");
        System.out.println("     \\/  \\/ \\___|_|\\___\\___/|_| |_| |_|\\___|");
        System.out.println("");
        System.out.println("To the contacts manager!");
    }

    //Add new contact
    public static void addContact(String name, String number, Path path) {
        try {
            Files.writeString(path, name + " | " + number + "\n", StandardOpenOption.APPEND);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    //Search contact
    public static void searchContacts(String name, Path path) {
        String nameLower = name.toLowerCase(Locale.ROOT);
        List<String> currentList = new ArrayList<>();
        try {
            currentList = Files.readAllLines(path);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        Iterator<String> listIterator = currentList.iterator();
        while (listIterator.hasNext()) {
            String contact = listIterator.next();
            if (contact.toLowerCase(Locale.ROOT).contains(nameLower)) {
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
            if (contact.toLowerCase(Locale.ROOT).contains(name)) {
                System.out.printf("Are you sure you want to delete %s?\n", contact);
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

        welcome();

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
                    System.out.print("\nPlease enter a 10 digit number with no special characters:");
                    Long number = scanner.nextLong();
                    String numberEdit = String.valueOf(number).replaceFirst("(\\d{3})(\\d{3})(\\d+)",
                            "($1)-$2-$3");
                    Contacts contacts = new Contacts(name, numberEdit);
                    addContact(contacts.getName(), contacts.getNumber(), toOurDataFile);
                    io.readFileAndOutput(toOurDataFile);
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
                    System.out.println("Thank you and have a great day.");
                    break;

            }
        } while (userInput != 5);
    }

}
