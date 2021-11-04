package arraylistslab;

import java.util.*;

public class ArrayListsLab {

    public static void main(String[] args) {
        ArrayList<String> TitleCaseStrings = new ArrayList<>();
        TitleCaseStrings.add("TitleCaseOne");
        TitleCaseStrings.add("TitleCaseTwo");
        TitleCaseStrings.add("TitleCaseThree");
        TitleCaseStrings.add("TitleCaseFour");
        TitleCaseStrings.add("TitleCaseFive");
        TitleCaseStrings.add("TitleCaseSix");
        TitleCaseStrings.remove(3);
        
        Display(TitleCaseStrings);        
        
        for (int i = 0; i < TitleCaseStrings.size(); i++) {
            TitleCaseStrings.set(i, TitleCaseStrings.get(i).toUpperCase());
    }
        
        Display(TitleCaseStrings);
    
        arrayListEmpty(TitleCaseStrings);
        
        System.out.println("the Array list has " + TitleCaseStrings.size() + " items");
        
        for (int i = 0; i < TitleCaseStrings.size(); i++) {
            while(TitleCaseStrings.size() > 0) 
                TitleCaseStrings.remove(0); 
    }
        System.out.println("the Array list has " + TitleCaseStrings.size() + " items");
        Display(TitleCaseStrings);
        arrayListEmpty(TitleCaseStrings);
}
    public static void Display(ArrayList<String> titleCaseStrings) {
        //Enhanced for loop
            titleCaseStrings.forEach(title -> {
            System.out.println(title);
        });
}
    public static void arrayListEmpty(ArrayList<String> titleCaseStrings) {
        boolean answer = titleCaseStrings.isEmpty();
        if (answer == true)
            System.out.println("The ArrayList is empty");
        else
            System.out.println("The ArrayList is not empty");
}
}