
package main;

public class Main {

    
    public static void main(String[] args) {
        Picture starryNight = new Picture("Landscape","Black");
        Picture chestnutTreeInBlossom = new Picture("Chestnut Tree","Green");
        System.out.println("The subject is " + starryNight.getSubject() + 
                "\nThe primary color is " + starryNight.getPrimaryColor());
        System.out.println("The subject is " + chestnutTreeInBlossom.getSubject() 
                + "\nThe primary color is " + chestnutTreeInBlossom.getPrimaryColor());
        System.out.println(starryNight);
    }
    
}
class Picture {
    // fields
    private String subject;
    private String primaryColor;
    
    public Picture (String subject, String primaryColor) {
        this.subject = subject;
        this.primaryColor = primaryColor;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    public void setPrimaryColor(String primaryColor) {
        this.primaryColor = primaryColor;
    }
    
    public String getSubject() {
        return subject;
    }
    
    public String getPrimaryColor() {
        return primaryColor;
    }
    
    public String toString() {
        return subject + primaryColor;
    }

} 