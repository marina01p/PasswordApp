package sample;
import java.util.*;

public class PassGenerator {

    static char[] random_Password(int len) {

        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*_=+-/.?<>)";


        String values = Capital_chars + Small_chars + numbers + symbols;

        Random rndm_method = new Random();
        char[] password = new char[len];

        for (int i = 0; i < len; i++) {
            password[i] = values.charAt(rndm_method.nextInt(values.length()));

        }
        return password;
    }
}