package textprocessing;

// Author James Jensen

public class TextProcessing {

    public static void main(String[] args) {
        String text = "Sed ut perspiciatis unde omnis iste natus error sit "
                + "voluptatem accusantium doloremque laudantium, totam rem "
                + "aperiam, eaque ipsa quae ab illo inventore veritatis et "
                + "quasi architecto beatae vitae dicta sunt explicabo. Nemo "
                + "enim ipsam voluptatem quia voluptas sit aspernatur aut "
                + "odit aut fugit, sed quia consequuntur magni dolores eos "
                + "qui ratione voluptatem sequi nesciunt. Neque porro quisquam "
                + "est, qui dolorem ipsum quia dolor sit amet, consectetur, "
                + "adipisci velit, sed quia non numquam eius modi tempora "
                + "incidunt ut labore et dolore magnam aliquam quaerat "
                + "voluptatem. Ut enim ad minima veniam, quis nostrum "
                + "exercitationem ullam corporis suscipit laboriosam, nisi ut "
                + "aliquid ex ea commodi consequatur? Quis autem vel eum iure "
                + "reprehenderit qui in ea voluptate velit esse quam nihil "
                + "molestiae consequatur, vel illum qui dolorem eum fugiat quo "
                + "voluptas nulla pariatur?";
        
        System.out.println("The string is " + text.length() + " characters long.");
        
        char[] array = text.toCharArray();
        int letters = 0, digits = 0, whitespaces = 0;
        for (int i = 0; i < array.length; i++) {
            if (Character.isLetter(array[i]))
                letters++;
            else if (Character.isDigit(array[i]))
                digits++;
            else if (Character.isWhitespace(array[i]))
                whitespaces++;            
        }
        
        System.out.println("The string contains " + letters + " letters.");
        System.out.println("The string contains " + digits + " digits.");
        System.out.println("The string contains " + whitespaces + " spaces.");
        
        String quote = "incidunt ut";
        int lastPosition = text.lastIndexOf(quote);
        System.out.println("The offset of the last instance of " + quote
                + " is " + lastPosition);
        
        String substr = "sed";
        int times = substringChecker(substr, text);        
        System.out.println("The substring " + substr + " appears " + times
                + " times.");
        
        substr = "reprehenerit";
        times = substringChecker(substr, text);        
        System.out.println("The substring " + substr + " appears " + times
                + " times.");
        
        String original = "sed", replacer = "grep", newText =  text.replaceAll("sed", "grep");
        System.out.println("The string after replacing " + original
                + " with " + replacer + " is " + newText.length() + " characters long.");
        
        StringBuilder builder = new StringBuilder(text);
        builder.insert(54, "orange");
        builder.deleteCharAt(21);
        builder.append("avocado");
        System.out.println("The modified string builder is " + builder.length()
            + " character long");
        
        String search = "orange";
        if (builder.indexOf(search) == builder.lastIndexOf(search)) {
            System.out.println("The methods indexOf and lastIndexOf return the same value.");
        }
        else {
            System.out.println("The methods indexOf and lastIndexOf do not return the same value.");
        }
    }
    
    static int substringChecker (String substr, String text) {
        int counter = 0;
        int instances = text.lastIndexOf(substr);
        while (instances != -1) {
            instances = text.lastIndexOf(substr, instances - 1);
            counter++;
        }
        return counter;
    }
}
