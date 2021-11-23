package trywithresources;

import java.io.*;
import java.util.*;

public class TryWithResources {

    private static int TOTAL;
    private static int PRICE;
    private static int QUANTITY;

    public static void main(String[] args) {

        File inFile = new File("C:\\Users\\ncc lab user\\Downloads\\inventory.txt");
        try (Scanner readFile = new Scanner(inFile)) {
            readFile.useDelimiter("[|\n\r]");
            while (readFile.hasNext()) {
                for (int i = 0; i < 4; i++) {
                    if (i < 2) {
                        System.out.printf(format, args);
                    } else if (i == 2) {
                        String PRICE = readFile.next();
                    } else {
                        String QUANTITY = readFile.next();
                    }
                    TOTAL = PRICE * QUANTITY;
                }

            }catch (FileNotFoundException e) {
            System.out.println(e);
        }catch (Exception e) {
            System.out.println(e);
        }

        }
    }
}
