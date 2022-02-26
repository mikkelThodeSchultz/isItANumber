package com.company;

public class IsItANumber {


    public boolean isItANumber(String line) {
        boolean isNumber = false;
        String numbers = "1234567890";
        String alphabet = "abcdefghijklmnopqrstuvwxyzæøpå";
        int counter = 0;
        int eCounter = 0;

        //Checks if the line contains a number
        for (int i = 0; i < numbers.length(); i++) {
            String number = numbers.substring(i, i + 1);
            if (line.contains(number)) {
                isNumber = true;
                break;
            }
        }
        //If it does, it checks if it contains a minus,
        // if it does that as well, it checks that the minus is at index 0
        if (isNumber) {
            if (line.contains("-")) {
                if (line.charAt(0) != '-') {
                    isNumber = false;
                }
            }
        }
        //Checks if the line contains a letter
        for (int i = 0; i < alphabet.length(); i++) {
            String letter = alphabet.substring(i, i + 1);
            if (line.contains(letter)) {
                isNumber = true;
                // Counter to make sure that there is only 1 letter
                counter++;
                String specificLetter = alphabet.substring(i, i + 1);
                // Checks if the letter is the letter 'e'
                if (!specificLetter.equals("e")) {
                    isNumber = false;
                    // Checks that the index position before the 'e' is not a minus
                } else if (line.charAt(i - 1) == '-') {
                    isNumber = false;
                    // Checks that the 'e' is not the first or the last index of the String
                } else if (line.endsWith("e") || line.startsWith("e")) {
                    isNumber = false;
                } else {
                    // Checks that there is no multiple 'e's
                    for (int e = 0; e < line.length(); e++) {
                        if (line.charAt(e) == 'e') {
                            eCounter++;
                        }
                    }
                }
            }
        }
        //Makes sure there is only one letter
        if (counter > 1 || eCounter > 1) {
            isNumber = false;
        }
        return isNumber;
    }
}
