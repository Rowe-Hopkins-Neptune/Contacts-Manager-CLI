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


}
