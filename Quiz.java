import java.security.MessageDigest;

public class Quiz {

    public static void main(String[] args) {
        String text;
        text="Madam, I'm Adam!";

        text=text.toLowerCase();
        text=text.replaceAll("[^a-zA-Z0-9]","");
        System.out.println(text);
    }
}