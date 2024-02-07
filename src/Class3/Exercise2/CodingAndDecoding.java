package Class3.Exercise2;

import java.util.Scanner;

public class CodingAndDecoding {
    public static void main(String[] args) {
        String abc = " abcdefghijklmnñopqrstuvwxyz";
        StringBuilder outWord = new StringBuilder();
        StringBuilder finalWord = new StringBuilder();

        Scanner input = new Scanner(System.in);
        System.out.println("Type a phrase, you must type just letters, don't use symbols or a dot.");
        String word = input.nextLine();
        //String[] arrWord = word.split("");

        for(int i = 0; i < word.length(); i++) {
            for(int j = 0; j < abc.length(); j++) {
                //boolean isMatch = arrWord[i].equalsIgnoreCase(String.valueOf(abc.charAt(j)));
                boolean isMatch = word.toLowerCase().charAt(i) == abc.charAt(j);
                if(isMatch) {
                    boolean isLowCase = word.charAt(i) == abc.charAt(j);
                    if(isLowCase) {
                        outWord.append(abc.charAt(j + 1));
                    } else {
                        outWord.append(abc.toUpperCase().charAt(j + 1));
                    }
                }
            }
        }

        for(int i = 0; i < outWord.length(); i++) {
            boolean isSpace = String.valueOf(outWord.charAt(i)).equalsIgnoreCase("a");
            boolean isFinal = (i == outWord.length() - 1);
            if(isSpace && !isFinal) { //I must have a control about index out of bounds error.
                boolean isLowCase = String.valueOf(outWord.charAt(i + 1)).matches("[a-z]");
                if(isLowCase) {
                    finalWord.append(outWord.charAt(i));
                } else {
                    finalWord.append(outWord.toString().toUpperCase().charAt(i));
                    //boolean a = outWord.toString().
                }
            } else {
                finalWord.append(outWord.charAt(i));
            }
        }

        System.out.println(finalWord);
    }
}