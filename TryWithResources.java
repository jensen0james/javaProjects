package trywithresources;

import java.io.*;
import java.util.*;

public class TryWithResources {

    private static double TOTAL;

    public static void main(String[] args) {

        File inFile = new File("C:\\Users\\ncc lab user\\Downloads\\inventory.txt");
        try (Scanner readFile = new Scanner(inFile)) {
            readFile.useDelimiter("[|\n\r]");
            int count = 0;
            while (readFile.hasNext()) {
                String item = readFile.next();
                String name = readFile.next();
                double price = readFile.nextDouble();
                int quantity = readFile.nextInt();
                System.out.printf("%3s\t%-40s\t%3.2f\t%3d\n", item, name, price, quantity);
                count += quantity;
                TOTAL += price * quantity;
            }
            System.out.printf("Item Count: %d\n", count);
            System.out.printf("Iventory Value: $ %,.2f\n", TOTAL);
            
            }catch (FileNotFoundException e) {
            System.out.println(e);
        }catch (Exception e) {
            System.out.println(e);
        }

        }
    }
