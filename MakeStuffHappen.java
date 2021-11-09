package makestuffhappen;

import java.util.*;

public class MakeStuffHappen {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        boolean done = false;
        while (!done) {
            try {
                System.out.print("enter a number: ");
                String strNumber = keyboard.next();
                Magick magick = new Magick(strNumber);
                int number = keyboard.nextInt();
                Magick moreMagick = new Magick(number);
                System.out.println("Everything's fine (dog in building)");
                done = true;
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("That's not a number");
                System.out.println(e);
            } catch (Exception e) {
                System.out.println("Exception");
                System.out.println(e);
            } finally {
                keyboard.nextLine();
                System.out.println("Finally!");
            }
        }
    }
}

class Magick {
    private int number;
    public Magick(int number) {
        this.number = number;
    }
    public Magick(String number) {
        this.number = Integer.parseInt(number);
    }
}