package section3_apis.part1_interfaces;

import java.util.ArrayList;
import java.util.List;

public class CaesarCypher implements EncryptionEngine {

    @Override
    public String encrypt(String message) {
        List<String> messageOutList = new ArrayList<>();
        char newLetter;
        for (char letter : message.toCharArray()) {
            if ((int) letter >= 65 && (int) letter < 68) {
                newLetter = (char)((int) letter + 23);
            } else if ((int) letter >= 97 && (int) letter < 100) {
                newLetter = (char)((int) letter + 23);
            } else if ((int) letter >= 65 & (int) letter <= 90 || (int) letter >= 97 & (int) letter <= 122) {
                newLetter = (char) ((int) letter - 3);
            } else {
                newLetter = letter;
            }
            messageOutList.add(String.valueOf(newLetter));
        }
        return String.join("", messageOutList);
    }


    @Override
    public String decrypt(String encryptedMessage) {
        List<String> messageOutList = new ArrayList<>();
        char newLetter;
        for (char letter : encryptedMessage.toCharArray()) {
            if ((int) letter >= 88 && (int) letter < 91) {
                newLetter = (char)((int) letter - 23);
            } else if ((int) letter >= 120 && (int) letter < 123) {
                newLetter = (char)((int) letter - 23);
            } else if ((int) letter >= 65 & (int) letter <= 90 || (int) letter >= 97 & (int) letter <= 122) {
                newLetter = (char) ((int) letter + 3);
            } else {
                newLetter = letter;
            }
            messageOutList.add(String.valueOf(newLetter));
        }
        return String.join("", messageOutList);
    }}