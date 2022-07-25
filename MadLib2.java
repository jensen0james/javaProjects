import java.awt.Component;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MadLib2 extends JFrame {

        private Map<String, Color> colourMap = new HashMap();
        private final JButton cyan;
        private final JButton gray;
        private final JButton lightGray;
        private final JButton orange;
        private final JButton red;
        private final JButton yellow;
        private final JButton blue;
        private final JButton darkGray;
        private final JButton green;
        private final JButton magenta;
        private final JButton pink;
        int pressColorButton = 0;

        public MadLib2() {

                JFrame background = new JFrame("Background");
                background.setVisible(true);
                background.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                background.setLocation(1100, 550);
                background.setSize(300, 200);

                JPanel panel = new JPanel();

                background.add(panel);

                JLabel lbl1 = new JLabel("Pick a color for your background, then border:");
                lbl1.setAlignmentX(Component.CENTER_ALIGNMENT);
                panel.add(lbl1);

                cyan = new JButton("Cyan");
                gray = new JButton("Gray");
                lightGray = new JButton("Light Gray");
                orange = new JButton("Orange");
                red = new JButton("Red");
                yellow = new JButton("Yellow");
                blue = new JButton("Blue");
                darkGray = new JButton("Dark Gray");
                green = new JButton("Green");
                magenta = new JButton("Magenta");
                pink = new JButton("Pink");

                panel.add(cyan);
                panel.add(gray);
                panel.add(lightGray);
                panel.add(orange);
                panel.add(red);
                panel.add(yellow);
                panel.add(blue);
                panel.add(darkGray);
                panel.add(green);
                panel.add(magenta);
                panel.add(pink);
                cyan.addActionListener(new ButtonListener());
                gray.addActionListener(new ButtonListener());
                lightGray.addActionListener(new ButtonListener());
                orange.addActionListener(new ButtonListener());
                red.addActionListener(new ButtonListener());
                yellow.addActionListener(new ButtonListener());
                blue.addActionListener(new ButtonListener());
                darkGray.addActionListener(new ButtonListener());
                green.addActionListener(new ButtonListener());
                magenta.addActionListener(new ButtonListener());
                pink.addActionListener(new ButtonListener());

                background.setVisible(true);

                colorMap.put("Cyan", Color.cyan);
                colorMap.put("Grey", Color.gray);
                colorMap.put("Light Gray", Color.lightGray);
                colorMap.put("Orange", Color.orange);
                colorMap.put("Red", Color.red);
                colorMap.put("Yellow", Color.yellow);
                colorMap.put("Blue", Color.blue);
                colorMap.put("Dark Gray", Color.darkGray);
                colorMap.put("Green", Color.green);
                colorMap.put("Magenta", Color.magenta);
                colorMap.put("Pink", Color.pink);

        }

        private class ButtonListener implements ActionListener {

                private void uiColor(boolean test,String color) {
                       String attribute;

                       if(test == true)
                       {
                        attribute = "Panel.background";
                       }
                       else
                       {
                        attribute = "OptionPane.background";
                       }


                        UIManager UI = new UIManager();
                        UI.put(attribute, new ColorUIResource(colourMap.get(color)));
                        JOptionPane.showMessageDialog(null, "You picked " + color + " for your background.");
                }



                @Override
                public void actionPerformed(ActionEvent e) {
                        String actionCommand = e.getActionCommand();
                        pressColorButton++;
                        if (pressColorButton == 1) {
                                uiColor(true,actionCommand);
                        }
                        if (pressColorButton == 2) {
                                uiColor(false,actionCommand);
                        }

                        if (pressColorButton >= 2) {

                                /*
                                 * Display the First dialog box explaining the game.
                                 */
                                JOptionPane.showMessageDialog(null, "You have started a Mad Lib Game!\n\n\n"
                                                + "The rules are as follows:\n\n"
                                                + "I will ask for a 'Part of Speech'\n"
                                                + "You will type a word that matches the 'Part of Speech'\n"
                                                + "To proceed press 'OK'\n"
                                                + "Repeat until your custom MadLib is displayed\n\n\n"
                                                + "There are a total of five different Mad Libs to explore\n"
                                                + "Once you finish one Mad Lib the program will close"
                                                + "\n\n\nPress 'OK' to continue");

                                Random rand = new Random(); // instance of random class
                                int upperbound = 49;
                                int intRandom = rand.nextInt(upperbound);

                                if (intRandom <= 9) {

                                        String name; // A name
                                        String place; // A Place
                                        String number; // A Number
                                        String numberFinal;
                                        String animals;
                                        char animalsChar;
                                        int num;

                                        /*
                                         * Get a 'name' from the User
                                         */
                                        name = JOptionPane.showInputDialog("Pick any random name");

                                        /*
                                         * If no data was entered then program will continuously kickback to the
                                         * original question until a valid value has been inputted.
                                         */
                                        while (name.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");
                                                name = JOptionPane.showInputDialog("Pick any random name");
                                        }

                                        /*
                                         * Get a 'place' from the User
                                         */
                                        place = JOptionPane.showInputDialog("Pick any random place");

                                        while (place.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Really?");
                                                place = JOptionPane.showInputDialog("Pick any random name");
                                        }

                                        animals = JOptionPane.showInputDialog("Pick any random animal");

                                        while (animals.isBlank()) {
                                                JOptionPane.showMessageDialog(null, "Now you're just needy!");
                                                animals = JOptionPane.showInputDialog("Pick any random name");
                                        }

                                        animalsChar = animals.charAt(0);
                                        /*
                                         * Get a 'number' from the User
                                         */

                                        number = JOptionPane.showInputDialog("Pick any random number");

                                        while (number.isBlank()) {
                                                JOptionPane.showMessageDialog(null, "Come on man!");
                                                number = JOptionPane.showInputDialog("Pick any random name");
                                        }

                                        num = Integer.parseInt(number);

                                        if (num == 0) {
                                                numberFinal = "didn't see any animals";
                                                JOptionPane.showMessageDialog(null,
                                                                "My Short Story\n" + name + " went to " + place
                                                                                + " and\n" + "saw " + numberFinal);
                                        }

                                        if (num == 1) {
                                                numberFinal = "a";
                                                if (animalsChar == 'a') {
                                                        numberFinal = "an";
                                                }
                                                if (animalsChar == 'A') {
                                                        numberFinal = "an";

                                                }
                                                if (animalsChar == 'e') {
                                                        numberFinal = "an";

                                                }
                                                if (animalsChar == 'E') {
                                                        numberFinal = "an";

                                                }
                                                if (animalsChar == 'i') {
                                                        numberFinal = "an";

                                                }
                                                if (animalsChar == 'I') {
                                                        numberFinal = "an";

                                                }
                                                if (animalsChar == 'o') {
                                                        numberFinal = "an";

                                                }
                                                if (animalsChar == 'O') {
                                                        numberFinal = "an";

                                                }
                                                if (animalsChar == 'u') {
                                                        numberFinal = "an";

                                                }
                                                if (animalsChar == 'U') {
                                                        numberFinal = "an";

                                                }

                                                JOptionPane.showMessageDialog(null,
                                                                "My Short Story\n" + name + " went to " + place
                                                                                + " and\n" + "saw " + numberFinal + " "
                                                                                + animals + "(s)");

                                        }

                                        if (num >= 2) {
                                                JOptionPane.showMessageDialog(null,
                                                                "My Short Story\n" + name + " went to " + place
                                                                                + " and\n" + "saw " + number + " "
                                                                                + animals + "(s)");
                                        }

                                        /**
                                         * * Get a 'name' from the User
                                         */
                                        /*
                                         * Show the MadLib
                                         */
                                } else if (intRandom <= 19) {
                                        String adjective1;
                                        String adjective2;
                                        String noun1;
                                        String noun2;
                                        String pnoun1;
                                        String game1;
                                        String pnoun2;
                                        String verbing1;
                                        String verbing2;
                                        String pnoun3;
                                        String verbing3;
                                        String noun3;
                                        String plant1;
                                        String bodyPart1;
                                        String place1;
                                        String verbing4;
                                        String adjective3;
                                        String number1;
                                        String pnoun4;

                                        adjective1 = JOptionPane.showInputDialog("Pick an adjective");
                                        while (adjective1.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                adjective1 = JOptionPane.showInputDialog("Pick an adjective");
                                        }

                                        adjective2 = JOptionPane.showInputDialog("Pick an adjective");
                                        while (adjective2.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                adjective2 = JOptionPane.showInputDialog("Pick an adjective");
                                        }

                                        noun1 = JOptionPane.showInputDialog("Pick an noun");
                                        while (noun1.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                noun1 = JOptionPane.showInputDialog("Pick a noun");
                                        }
                                        noun2 = JOptionPane.showInputDialog("Pick an noun");
                                        while (noun2.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                noun2 = JOptionPane.showInputDialog("Pick a noun");
                                        }

                                        pnoun1 = JOptionPane.showInputDialog("Pick a plural noun");
                                        while (pnoun1.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                pnoun1 = JOptionPane.showInputDialog("Pick a plural noun");
                                        }

                                        game1 = JOptionPane.showInputDialog("Pick a game");
                                        while (game1.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                game1 = JOptionPane.showInputDialog("Pick a game");
                                        }

                                        pnoun2 = JOptionPane.showInputDialog("Pick a plural noun");
                                        while (pnoun2.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                pnoun2 = JOptionPane.showInputDialog("Pick a plural noun");
                                        }

                                        verbing1 = JOptionPane.showInputDialog("Pick a verb ending in 'ing'");
                                        while (verbing1.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                verbing1 = JOptionPane.showInputDialog("Pick a verb ending in 'ing'");
                                        }

                                        verbing2 = JOptionPane.showInputDialog("Pick a verb ending in 'ing'");
                                        while (verbing2.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                verbing2 = JOptionPane.showInputDialog("Pick a verb ending in 'ing'");
                                        }

                                        pnoun3 = JOptionPane.showInputDialog("Pick a plural noun");
                                        while (pnoun3.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                pnoun3 = JOptionPane.showInputDialog("Pick a plural noun");
                                        }

                                        verbing3 = JOptionPane.showInputDialog("Pick a verb ending in 'ing'");
                                        while (verbing3.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                verbing3 = JOptionPane.showInputDialog("Pick a verb ending in 'ing'");
                                        }

                                        noun3 = JOptionPane.showInputDialog("Pick a noun");
                                        while (noun3.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                noun3 = JOptionPane.showInputDialog("Pick a noun");
                                        }

                                        plant1 = JOptionPane.showInputDialog("Pick a plant");
                                        while (plant1.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                plant1 = JOptionPane.showInputDialog("Pick a plant");
                                        }

                                        bodyPart1 = JOptionPane.showInputDialog("Pick a body part");
                                        while (bodyPart1.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                bodyPart1 = JOptionPane.showInputDialog("Pick a body part");
                                        }

                                        place1 = JOptionPane.showInputDialog("Pick a place");
                                        while (place1.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                place1 = JOptionPane.showInputDialog("Pick a place");
                                        }

                                        verbing4 = JOptionPane.showInputDialog("Pick a verb ending in 'ing'");
                                        while (verbing4.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                verbing4 = JOptionPane.showInputDialog("Pick a verb ending in 'ing'");
                                        }

                                        adjective3 = JOptionPane.showInputDialog("Pick an adjective");
                                        while (adjective3.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                adjective3 = JOptionPane.showInputDialog("Pick an adjective");
                                        }

                                        number1 = JOptionPane.showInputDialog("Pick a number");
                                        while (number1.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                number1 = JOptionPane.showInputDialog("Pick a number");
                                        }

                                        pnoun4 = JOptionPane.showInputDialog("Pick a plural noun");
                                        while (pnoun4.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                pnoun4 = JOptionPane.showInputDialog("Pick a plural noun");
                                        }

                                        JOptionPane.showMessageDialog(null, "Summer Trip\n\n"
                                                        + "A vacation is when you take a trip to some " + adjective1
                                                        + " place\n" + "with your " + adjective2
                                                        + " family. Usually you go to some place\n"
                                                        + "that is near a/an " + noun1 + " or up on a/an " + noun2
                                                        + ".\n" + "A good vacation place is one where you can ride "
                                                        + pnoun1 + "\n" + "or play " + game1 + " or go hunting for "
                                                        + pnoun2 + ". I like\n" + "to spend my time " + verbing1
                                                        + " or " + verbing2 + ".\n"
                                                        + "When parents go on a vacation, they spend their time eating\n"
                                                        + "three " + pnoun3
                                                        + " a day, and fathers play golf, and mothers\n" + "sit around "
                                                        + verbing3 + ". Last summer, my little brother\n"
                                                        + "fell in a/an " + noun3 + " and got poison " + plant1
                                                        + " all\n" + "over his " + bodyPart1
                                                        + ". My family is going to go to (the)\n" + place1
                                                        + ", and I will practice " + verbing4 + ". Parents\n"
                                                        + "need vacations more than kids because parents are always very\n"
                                                        + adjective3 + " and because they have to work " + number1
                                                        + "\n" + "hours every day all year making enough " + pnoun4
                                                        + " to pay\n" + "for the vacation.");

                                } else if (intRandom <= 29) {
                                        String name1;
                                        String name2;
                                        String adjective1;
                                        String pastVerb1;
                                        String adjective2;
                                        String pnoun1;
                                        String verbing1;
                                        String adverb1;
                                        String noun1;
                                        String verb1;
                                        String pnoun2;
                                        String adjective3;
                                        String pastVerb2;
                                        String adverb2;
                                        String pnoun3;
                                        String noun2;
                                        String pnoun4;
                                        String animal1;
                                        String pastVerb3;
                                        String noun3;
                                        String pastVerb4;
                                        String noun4;
                                        String pastVerb5;
                                        String verbing2;
                                        String adjective4;
                                        String noun5;
                                        String verb2;
                                        String adjective5;
                                        String noun6;
                                        String pnoun5;
                                        String adjective6;

                                        name1 = JOptionPane.showInputDialog("Pick a name");
                                        while (name1.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                name1 = JOptionPane.showInputDialog("Pick a name");
                                        }

                                        name2 = JOptionPane.showInputDialog("Pick a name");
                                        while (name2.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                name2 = JOptionPane.showInputDialog("Pick a name");
                                        }

                                        adjective1 = JOptionPane.showInputDialog("Pick an adjective");
                                        while (adjective1.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                adjective1 = JOptionPane.showInputDialog("Pick an adjective");
                                        }

                                        pastVerb1 = JOptionPane.showInputDialog("Pick a verb");
                                        while (pastVerb1.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                pastVerb1 = JOptionPane.showInputDialog("Pick a verb");
                                        }

                                        adjective2 = JOptionPane.showInputDialog("Pick a adjective");
                                        while (adjective2.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                adjective2 = JOptionPane.showInputDialog("Pick a adjective");
                                        }

                                        pnoun1 = JOptionPane.showInputDialog("Pick a plural noun");
                                        while (pnoun1.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                pnoun1 = JOptionPane.showInputDialog("Pick a plural noun");
                                        }

                                        verbing1 = JOptionPane.showInputDialog("Pick a verb ending in 'ing'");
                                        while (verbing1.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                verbing1 = JOptionPane.showInputDialog("Pick a verb ending in 'ing'");
                                        }

                                        adverb1 = JOptionPane.showInputDialog("Pick a adverb");
                                        while (adverb1.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                adverb1 = JOptionPane.showInputDialog("Pick a adverb");
                                        }

                                        noun1 = JOptionPane.showInputDialog("Pick a noun");
                                        while (noun1.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                noun1 = JOptionPane.showInputDialog("Pick a noun");
                                        }

                                        verb1 = JOptionPane.showInputDialog("Pick a verb");
                                        while (verb1.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                verb1 = JOptionPane.showInputDialog("Pick a verb");
                                        }

                                        pnoun2 = JOptionPane.showInputDialog("Pick a plural noun");
                                        while (pnoun2.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                pnoun2 = JOptionPane.showInputDialog("Pick a plural noun");
                                        }

                                        adjective3 = JOptionPane.showInputDialog("Pick an adjective");
                                        while (adjective3.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                adjective3 = JOptionPane.showInputDialog("Pick an adjective");
                                        }

                                        pastVerb2 = JOptionPane.showInputDialog("Pick a past tense verb");
                                        while (pastVerb2.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                pastVerb2 = JOptionPane.showInputDialog("Pick a past tense verb");
                                        }

                                        adverb2 = JOptionPane.showInputDialog("Pick an adverb");
                                        while (adverb2.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                adverb2 = JOptionPane.showInputDialog("Pick an adverb");
                                        }

                                        pnoun3 = JOptionPane.showInputDialog("Pick a plural noun");
                                        while (pnoun3.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                pnoun3 = JOptionPane.showInputDialog("Pick a plural noun");
                                        }

                                        noun2 = JOptionPane.showInputDialog("Pick a noun");
                                        while (noun2.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                noun2 = JOptionPane.showInputDialog("Pick a noun");
                                        }

                                        pnoun4 = JOptionPane.showInputDialog("Pick a plural noun");
                                        while (pnoun4.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                pnoun4 = JOptionPane.showInputDialog("Pick a plural noun");
                                        }

                                        animal1 = JOptionPane.showInputDialog("Pick an animal");
                                        while (animal1.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                animal1 = JOptionPane.showInputDialog("Pick an animal");
                                        }

                                        pastVerb3 = JOptionPane.showInputDialog("Pick a past tense verb");
                                        while (pastVerb3.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                pastVerb3 = JOptionPane.showInputDialog("Pick a past tense verb");
                                        }

                                        noun3 = JOptionPane.showInputDialog("Pick a noun");
                                        while (noun3.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                noun3 = JOptionPane.showInputDialog("Pick a noun");
                                        }

                                        pastVerb4 = JOptionPane.showInputDialog("Pick a past tense verb");
                                        while (pastVerb4.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                pastVerb4 = JOptionPane.showInputDialog("Pick a past tense verb");
                                        }

                                        noun4 = JOptionPane.showInputDialog("Pick a noun");
                                        while (noun4.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                noun4 = JOptionPane.showInputDialog("Pick a noun");
                                        }

                                        pastVerb5 = JOptionPane.showInputDialog("Pick a past tense verb");
                                        while (pastVerb5.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                pastVerb5 = JOptionPane.showInputDialog("Pick a past tense verb");
                                        }

                                        verbing2 = JOptionPane.showInputDialog("Pick a verb ending in 'ing'");
                                        while (verbing2.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                verbing2 = JOptionPane.showInputDialog("Pick a verb ending in 'ing'");
                                        }

                                        adjective4 = JOptionPane.showInputDialog("Pick an adjective");
                                        while (adjective4.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                adjective4 = JOptionPane.showInputDialog("Pick an adjective");
                                        }

                                        noun5 = JOptionPane.showInputDialog("Pick a noun");
                                        while (noun5.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                noun5 = JOptionPane.showInputDialog("Pick a noun");
                                        }

                                        verb2 = JOptionPane.showInputDialog("Pick a verb");
                                        while (verb2.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                verb2 = JOptionPane.showInputDialog("Pick a verb");
                                        }

                                        adjective5 = JOptionPane.showInputDialog("Pick an adjective");
                                        while (adjective5.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                adjective5 = JOptionPane.showInputDialog("Pick an adjective");
                                        }

                                        noun6 = JOptionPane.showInputDialog("Pick a noun");
                                        while (noun6.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                noun6 = JOptionPane.showInputDialog("Pick a noun");
                                        }

                                        pnoun5 = JOptionPane.showInputDialog("Pick a plural noun");
                                        while (pnoun5.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                pnoun5 = JOptionPane.showInputDialog("Pick a plural noun");
                                        }

                                        adjective6 = JOptionPane.showInputDialog("Pick an adjective");
                                        while (adjective6.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                adjective6 = JOptionPane.showInputDialog("Pick an adjective");
                                        }

                                        JOptionPane.showMessageDialog(null, "A Camping Adventure\n\n" + name1 + " and "
                                                        + name2 + " went on a " + adjective1 + " camping trip. They\n"
                                                        + pastVerb1 + " thier " + adjective2 + " " + pnoun1
                                                        + " and started " + verbing1 + "\n" + adverb1 + " to build a "
                                                        + noun1 + ". They knew they needed to " + verb1 + " a\n"
                                                        + "lot of " + pnoun2 + " before it became too " + adjective3
                                                        + " so they " + pastVerb2 + "\n" + "very " + adverb2
                                                        + ". For a snack they decided to make " + pnoun3 + "\n"
                                                        + "on a " + noun2 + " and cook up a can of " + pnoun4
                                                        + ". As it got dark\n" + "outside, " + name2 + " heard a "
                                                        + animal1 + " make a sound in the\n" + "wood! " + name1
                                                        + " was scared and " + pastVerb3 + " a " + noun3 + "!\n"
                                                        + "Outside, " + name2 + " " + pastVerb4 + " a " + noun4
                                                        + " from inside the tent.\n" + "The " + animal1 + " "
                                                        + pastVerb5 + " but not before " + verbing2 + " over all the\n"
                                                        + adjective4 + " " + noun5 + "! When the morning came, " + name1
                                                        + " and\n" + name2 + " left to go " + verb2 + " up a "
                                                        + adjective5 + " " + noun6 + " and\n" + "gather " + pnoun5
                                                        + ". It truly was a " + adjective6 + " camping trip!");
                                } else if (intRandom <= 39) {
                                        String adjective1;
                                        String noun1;
                                        String place1;
                                        String clothing1;
                                        String adjective2;
                                        String adjective3;
                                        String adjective4;
                                        String adjective5;
                                        String songTitle1;
                                        String food1;
                                        String adjective6;
                                        String pastVerb1;
                                        String noun2;
                                        String noun3;
                                        String pastVerb2;
                                        String pastVerb3;
                                        String noun4;
                                        String noun5;
                                        String verb1;
                                        String verb2;
                                        String verb3;
                                        String adjective7;

                                        adjective1 = JOptionPane.showInputDialog("Pick an adjective");
                                        while (adjective1.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                adjective1 = JOptionPane.showInputDialog("Pick an adjective");
                                        }

                                        noun1 = JOptionPane.showInputDialog("Pick a noun");
                                        while (noun1.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                noun1 = JOptionPane.showInputDialog("Pick a noun");
                                        }

                                        place1 = JOptionPane.showInputDialog("Pick a place");
                                        while (place1.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                place1 = JOptionPane.showInputDialog("Pick a place");
                                        }

                                        clothing1 = JOptionPane.showInputDialog("Pick an article of clothing");
                                        while (clothing1.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                clothing1 = JOptionPane.showInputDialog("Pick an article of clothing");
                                        }

                                        adjective2 = JOptionPane.showInputDialog("Pick an adjective");
                                        while (adjective2.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                adjective2 = JOptionPane.showInputDialog("Pick an adjective");
                                        }

                                        adjective3 = JOptionPane.showInputDialog("Pick an adjective");
                                        while (adjective3.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                adjective3 = JOptionPane.showInputDialog("Pick an adjective");
                                        }

                                        adjective4 = JOptionPane.showInputDialog("Pick an adjective");
                                        while (adjective4.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                adjective4 = JOptionPane.showInputDialog("Pick an adjective");
                                        }

                                        adjective5 = JOptionPane.showInputDialog("Pick an adjective");
                                        while (adjective5.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                adjective5 = JOptionPane.showInputDialog("Pick an adjective");
                                        }

                                        songTitle1 = JOptionPane.showInputDialog("Pick a song title");
                                        while (songTitle1.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                songTitle1 = JOptionPane.showInputDialog("Pick a song title");
                                        }

                                        food1 = JOptionPane.showInputDialog("Pick a type of food");
                                        while (food1.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                food1 = JOptionPane.showInputDialog("Pick a type of food");
                                        }

                                        adjective6 = JOptionPane.showInputDialog("Pick an adjective");
                                        while (adjective6.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                adjective6 = JOptionPane.showInputDialog("Pick an adjective");
                                        }

                                        pastVerb1 = JOptionPane.showInputDialog("Pick a past tense verb");
                                        while (pastVerb1.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                pastVerb1 = JOptionPane.showInputDialog("Pick a past tense verb");
                                        }

                                        noun2 = JOptionPane.showInputDialog("Pick a noun");
                                        while (noun2.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                noun2 = JOptionPane.showInputDialog("Pick a noun");
                                        }

                                        noun3 = JOptionPane.showInputDialog("Pick a noun");
                                        while (noun3.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                noun3 = JOptionPane.showInputDialog("Pick a noun");
                                        }

                                        pastVerb2 = JOptionPane.showInputDialog("Pick a past tense verb");
                                        while (pastVerb2.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                pastVerb2 = JOptionPane.showInputDialog("Pick a past tense verb");
                                        }

                                        pastVerb3 = JOptionPane.showInputDialog("Pick a past tense verb");
                                        while (pastVerb3.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                pastVerb3 = JOptionPane.showInputDialog("Pick a past tense verb");
                                        }

                                        noun4 = JOptionPane.showInputDialog("Pick a noun");
                                        while (noun4.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                noun4 = JOptionPane.showInputDialog("Pick a noun");
                                        }

                                        noun5 = JOptionPane.showInputDialog("Pick a noun");
                                        while (noun5.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                noun5 = JOptionPane.showInputDialog("Pick a noun");
                                        }

                                        verb1 = JOptionPane.showInputDialog("Pick a verb");
                                        while (verb1.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                verb1 = JOptionPane.showInputDialog("Pick a verb");
                                        }

                                        verb2 = JOptionPane.showInputDialog("Pick a verb");
                                        while (verb2.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                verb2 = JOptionPane.showInputDialog("Pick a verb");
                                        }

                                        verb3 = JOptionPane.showInputDialog("Pick a verb");
                                        while (verb3.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                verb3 = JOptionPane.showInputDialog("Pick a verb");
                                        }

                                        adjective7 = JOptionPane.showInputDialog("Pick an adjective");
                                        while (adjective7.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                adjective7 = JOptionPane.showInputDialog("Pick an adjective");
                                        }

                                        JOptionPane.showMessageDialog(null, "A Spooky Campfire Story\n\n" + "It was a "
                                                        + adjective1 + " summer day. " + noun1
                                                        + "and I were excited to\n" + "go camping at " + place1
                                                        + ". It was my first time going there. I\n"
                                                        + "packed my favorite " + clothing1 + ". It is " + adjective2
                                                        + " and " + adjective3 + ".\n"
                                                        + "Perfect for camping! On the road we went in our "
                                                        + adjective4 + "\n" + adjective5 + " van! We were listening to "
                                                        + songTitle1 + " all the\n"
                                                        + "way down. The drive was about 5 hours but it was worth it.\n"
                                                        + "When we got there we unpacked the van. I could smell "
                                                        + food1 + "\n" + "being cooked. It smelled " + adjective6
                                                        + ". I " + pastVerb1 + " to the room\n"
                                                        + "I was staying in with my " + noun2
                                                        + ". The next thing I knew,\n" + noun3 + " came and "
                                                        + pastVerb2 + " on the bed. I heard my mom\n" + "scream, " + '"'
                                                        + "Get off the bed!" + '"' + " I " + pastVerb3
                                                        + " outside. I saw " + noun4 + ".\n" + "It was " + noun5
                                                        + ". Over the next few days I got to " + verb1 + ".\n" + verb2
                                                        + " and " + verb3 + ". My camping trip was " + adjective7
                                                        + ".\n\n" + "I CAN'T WAIT TO GO BACK!!!");
                                } else if (intRandom <= 49) {
                                        String noun1;
                                        String adjective1;
                                        String noun2;
                                        String adjective2;
                                        String adjective3;
                                        String verb1;
                                        String verb2;
                                        String number1;
                                        String verb3;
                                        String adverb1;
                                        String noun3;
                                        String color1;
                                        String verb4;
                                        String noun4;
                                        String exclaim1;
                                        String verb5;
                                        String adverb2;
                                        String noun5;
                                        String verb6;
                                        String verb7;
                                        String noun6;
                                        String pnoun1;
                                        String verb8;
                                        String name1;
                                        String verb9;
                                        String noun7;
                                        String verb10;
                                        String adjective4;
                                        String adverb3;
                                        String adverb4;
                                        String noun8;
                                        String adjective5;
                                        String noun9;
                                        String adjective6;

                                        noun1 = JOptionPane.showInputDialog("Pick a noun");
                                        while (noun1.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                noun1 = JOptionPane.showInputDialog("Pick a noun");
                                        }

                                        adjective1 = JOptionPane.showInputDialog("Pick an adjective");
                                        while (adjective1.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                adjective1 = JOptionPane.showInputDialog("Pick an adjective");
                                        }

                                        noun2 = JOptionPane.showInputDialog("Pick a noun");
                                        while (noun2.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                noun2 = JOptionPane.showInputDialog("Pick a noun");
                                        }

                                        adjective2 = JOptionPane.showInputDialog("Pick an adjective");
                                        while (adjective2.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                adjective2 = JOptionPane.showInputDialog("Pick an adjective");
                                        }

                                        adjective3 = JOptionPane.showInputDialog("Pick an adjective");
                                        while (adjective3.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                adjective3 = JOptionPane.showInputDialog("Pick an adjective");
                                        }

                                        verb1 = JOptionPane.showInputDialog("Pick a verb");
                                        while (verb1.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                verb1 = JOptionPane.showInputDialog("Pick a verb");
                                        }

                                        verb2 = JOptionPane.showInputDialog("Pick a verb");
                                        while (verb2.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                verb2 = JOptionPane.showInputDialog("Pick a verb");
                                        }

                                        number1 = JOptionPane.showInputDialog("Pick a number");
                                        while (number1.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                number1 = JOptionPane.showInputDialog("Pick a number");
                                        }
                                        verb3 = JOptionPane.showInputDialog("Pick a verb");
                                        while (verb3.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                verb3 = JOptionPane.showInputDialog("Pick a verb");
                                        }

                                        adverb1 = JOptionPane.showInputDialog("Pick an adverb");
                                        while (adverb1.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                adverb1 = JOptionPane.showInputDialog("Pick an adverb");
                                        }

                                        noun3 = JOptionPane.showInputDialog("Pick a noun");
                                        while (noun3.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                noun3 = JOptionPane.showInputDialog("Pick a noun");
                                        }

                                        color1 = JOptionPane.showInputDialog("Pick a color");
                                        while (color1.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                color1 = JOptionPane.showInputDialog("Pick a color");
                                        }

                                        verb4 = JOptionPane.showInputDialog("Pick a verb");
                                        while (verb4.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                verb4 = JOptionPane.showInputDialog("Pick a verb");
                                        }

                                        noun4 = JOptionPane.showInputDialog("Pick a noun");
                                        while (noun4.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                noun4 = JOptionPane.showInputDialog("Pick a noun");
                                        }

                                        exclaim1 = JOptionPane.showInputDialog("Pick an exclamation");
                                        while (exclaim1.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                exclaim1 = JOptionPane.showInputDialog("Pick an exclamation");
                                        }

                                        verb5 = JOptionPane.showInputDialog("Pick a verb");
                                        while (verb5.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                verb5 = JOptionPane.showInputDialog("Pick a verb");
                                        }

                                        adverb2 = JOptionPane.showInputDialog("Pick an adverb");
                                        while (adverb2.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                adverb2 = JOptionPane.showInputDialog("Pick an adverb");
                                        }

                                        noun5 = JOptionPane.showInputDialog("Pick a noun");
                                        while (noun5.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                noun5 = JOptionPane.showInputDialog("Pick a noun");
                                        }

                                        verb6 = JOptionPane.showInputDialog("Pick a verb");
                                        while (verb6.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                verb6 = JOptionPane.showInputDialog("Pick a verb");
                                        }

                                        verb7 = JOptionPane.showInputDialog("Pick a verb");
                                        while (verb7.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                verb7 = JOptionPane.showInputDialog("Pick a verb");
                                        }

                                        noun6 = JOptionPane.showInputDialog("Pick a noun");
                                        while (noun6.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                noun6 = JOptionPane.showInputDialog("Pick a noun");
                                        }

                                        pnoun1 = JOptionPane.showInputDialog("Pick a plural noun");
                                        while (pnoun1.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                pnoun1 = JOptionPane.showInputDialog("Pick a plural noun");
                                        }

                                        verb8 = JOptionPane.showInputDialog("Pick a verb");
                                        while (verb8.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                verb8 = JOptionPane.showInputDialog("Pick a verb");
                                        }

                                        name1 = JOptionPane.showInputDialog("Pick a name");
                                        while (name1.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                name1 = JOptionPane.showInputDialog("Pick a name");
                                        }

                                        verb9 = JOptionPane.showInputDialog("Pick a verb");
                                        while (verb9.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                verb9 = JOptionPane.showInputDialog("Pick a verb");
                                        }

                                        noun7 = JOptionPane.showInputDialog("Pick a noun");
                                        while (noun7.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                noun7 = JOptionPane.showInputDialog("Pick a noun");
                                        }

                                        verb10 = JOptionPane.showInputDialog("Pick a verb");
                                        while (verb10.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                verb10 = JOptionPane.showInputDialog("Pick a verb");
                                        }

                                        adjective4 = JOptionPane.showInputDialog("Pick an adjective");
                                        while (adjective4.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                adjective4 = JOptionPane.showInputDialog("Pick an adjective");
                                        }

                                        adverb3 = JOptionPane.showInputDialog("Pick an adverb");
                                        while (adverb3.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                adverb3 = JOptionPane.showInputDialog("Pick an adverb");
                                        }

                                        adverb4 = JOptionPane.showInputDialog("Pick an adverb");
                                        while (adverb4.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                adverb4 = JOptionPane.showInputDialog("Pick an adverb");
                                        }

                                        noun8 = JOptionPane.showInputDialog("Pick a noun");
                                        while (noun8.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                noun8 = JOptionPane.showInputDialog("Pick a noun");
                                        }

                                        adjective5 = JOptionPane.showInputDialog("Pick an adjective");
                                        while (adjective5.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                adjective5 = JOptionPane.showInputDialog("Pick an adjective");
                                        }

                                        noun9 = JOptionPane.showInputDialog("Pick a noun");
                                        while (noun9.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                noun9 = JOptionPane.showInputDialog("Pick a noun");
                                        }

                                        adjective6 = JOptionPane.showInputDialog("Pick an adjective");
                                        while (adjective6.isBlank()) {

                                                JOptionPane.showMessageDialog(null, "Try again!");

                                                adjective6 = JOptionPane.showInputDialog("Pick an adjective");
                                        }

                                        JOptionPane.showMessageDialog(null, "Road Trip\n\n"
                                                        + "Yay! It's road trip day! My family and I hopped in the "
                                                        + noun1 + " for a\n" + adjective1 + " week at the " + noun2
                                                        + "! When we stopped to fill up\n" + "the " + adjective2
                                                        + " tank, a " + adjective3 + " frog " + verb1 + " in the car\n"
                                                        + "while we " + verb2 + " out to get " + number1 + " snakes.\n"
                                                        + "We " + verb3 + " back in the car and " + adverb1
                                                        + " got on the " + noun3 + "\n" + "about 30 minutes in, the "
                                                        + color1 + " frog " + verb4 + " onto the\n" + noun4
                                                        + " my mom was holding! '" + exclaim1 + "' she screamed!\n"
                                                        + "'Get off!' my dad thought she was " + verb5
                                                        + " to him so he " + adverb2 + "\n" + "swerved the " + noun5
                                                        + " onto the exit ramp! We " + verb6 + " from\n"
                                                        + "left to right. The frog " + verb7 + " onto the" + noun6
                                                        + " causing my\n" + "dad to slam on the " + pnoun1
                                                        + ". Snacks went everywhere, my mom was\n" + verb8
                                                        + " and my dad, " + name1 + ", " + verb9
                                                        + " out of the car like\n" + "a " + noun7
                                                        + ". My brother and I " + verb10 + ". The " + adjective4 + "\n"
                                                        + "frog " + adverb3 + " hopped out off into the brush.\n"
                                                        + "We " + adverb4 + " closed the " + noun8
                                                        + " doors and headed back\n" + "on the " + adjective5
                                                        + " to the " + noun9 + ".\n" + "' What a " + adjective6
                                                        + " road trip' my mom said!");
                                }
                                System.exit(0);
                        }

                }

        }

        public static void main(String[] args) {
                new MadLib2();
        }
}
