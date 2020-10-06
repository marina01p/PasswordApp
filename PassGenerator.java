package sample;

import java.util.*;

public class PassGenerator {
public static String getPassString() {
    String passCHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890._*#";
    StringBuilder pass = new StringBuilder();
    Random rnd = new Random();
    while (pass.length() < 8) {
        int index = (int) (rnd.nextFloat() * passCHARS.length());
        pass.append(passCHARS.charAt(index));
    }
    String passStr = pass.toString();
    return passStr;

}

}
