import java.util.Scanner;

public class ContactsApp {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. View contacts.");
        System.out.println("2. Add a new contact.");
        System.out.println("3. Search a contact by name.");
        System.out.println("4. Delete an existing contact.");
        System.out.println("5. Exit.");
        int userInput;
        do {
            System.out.println("Enter an option (1, 2, 3, 4, 5):");
            userInput = scanner.nextInt();
        } while(userInput >5 || userInput <1);
        switch(userInput){
            case 1:
                readFileAndOutput();
                break;
            case 2:
                Contacts contacts = new Contacts();
                break;
            case 3:
                Search();
                break;
            case 4:
                Delete();
                break;
            case 5:
                break;

        }

    }
}
