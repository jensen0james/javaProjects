package arraylistslab;

import java.util.*;

public class ArrayListsLab {

    public static void main(String[] args) {
        ArrayList<String> titleCaseStrings = new ArrayList<>();
        titleCaseStrings.add("titleCaseOne");
        titleCaseStrings.add("titleCaseTwo");
        titleCaseStrings.add("titleCaseThree");
        titleCaseStrings.add("titleCaseFour");
        titleCaseStrings.add("titleCaseFive");
        titleCaseStrings.add("titleCaseSix");
        titleCaseStrings.remove(3);
        
        Display(titleCaseStrings);        
        
        for (int i = 0; i < titleCaseStrings.size(); i++) {
            titleCaseStrings.set(i, titleCaseStrings.get(i).toUpperCase());
    }
        
        Display(titleCaseStrings);
    
        isEmpty(titleCaseStrings);
        
        System.out.println("the Array list has " + titleCaseStrings.size() + " items");
        
        for (int i = 0; i < titleCaseStrings.size(); i++) {
            titleCaseStrings.remove(i);
    }
        System.out.println("the Array list has " + titleCaseStrings.size() + " items");
        Display(titleCaseStrings);
        isEmpty(titleCaseStrings);
}
    public static void Display(ArrayList<String> titleCaseStrings) {
        //Enhanced for loop
            titleCaseStrings.forEach(title -> {
            System.out.println(title);
        });
}
    public static void isEmpty(ArrayList<String> titleCaseStrings) {
        boolean answer = titleCaseStrings.isEmpty();
        if (answer == true)
            System.out.println("The ArrayList is empty");
        else
            System.out.println("The ArrayList is not empty");
}
}
