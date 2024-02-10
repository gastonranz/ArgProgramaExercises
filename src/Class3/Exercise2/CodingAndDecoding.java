package Class3.Exercise2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodingAndDecoding {

    public static void main(String[] args) throws IOException {
        String abc = " abcdefghijklmnñopqrstuvwxyz";
        String abc2 = " abcdefghijklmnñopqrstuvwxyzabcdefghijklmnñopqrstuvwxyz";
        StringBuilder outWord = new StringBuilder();
        StringBuilder finalWord = new StringBuilder();

        String word = CodingAndDecoding.getWord();
        int decodeNum = CodingAndDecoding.getDecodeNum(); //Make a validation to avoid index out of bounds exception.
        //String[] arrWord = word.split("");

        CodingAndDecoding.getOutWord(abc, abc2, word, outWord, decodeNum);
        CodingAndDecoding.getFinalWord(abc, outWord, finalWord, decodeNum);


        System.out.println(finalWord);
    }

    private static String getWord() {
        Scanner input = new Scanner(System.in);
        System.out.println("Type a phrase, you must type just letters, don't use symbols or a dot.");
        String word = input.nextLine();

        String regEx = "\\p{P}|\\p{S}+";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(word);

        while(matcher.find()) {
            System.out.println("Please, don't use symbols or a dot!");
            word = input.nextLine();
            matcher = pattern.matcher(word);
        }

        return word;
    }

    private static int getDecodeNum() throws IOException {
        String regEx = "[^0-9]";
        InputStreamReader keyboard = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(keyboard);

        System.out.println("Please type the number of letter you want to decode your words:");
        String strNum = buffer.readLine();

        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(strNum);

        while(matcher.find() || strNum.isEmpty()) {
            System.out.println("Please, type just a number:");
            strNum = buffer.readLine();
            matcher = pattern.matcher(strNum);
        }

        int num = Integer.parseInt(strNum);

        while(num > 26) {
            System.out.println("You've passed the limit number, please, type a number smaller than \"27\":");
            strNum = buffer.readLine();
            matcher = pattern.matcher(strNum);

            while(matcher.find() || strNum.isEmpty()) {
                if(matcher.find()) {
                    System.out.println("Please, type just a number:");
                } else {
                    System.out.println("Your text is empty! Please, type a value:");
                }

                strNum = buffer.readLine();
                matcher = pattern.matcher(strNum);
            }

            num = Integer.parseInt(strNum);
        }

        return num;
    }

    private static void getOutWord(String abc, String abc2, String word, StringBuilder outWord, int decodeNum) {
        for(int i = 0; i < word.length(); i++) {
            for(int j = 0; j < abc.length(); j++) {
                boolean isMatch = word.toLowerCase().charAt(i) == abc.charAt(j);
                if(isMatch) {
                    boolean isLowCase = word.charAt(i) == abc.charAt(j);

                    try {
                        if(isLowCase) {
                            outWord.append(abc.charAt(j + decodeNum));
                        } else {
                            outWord.append(abc.toUpperCase().charAt(j + decodeNum));
                        }
                    } catch (StringIndexOutOfBoundsException e) {
                        if(isLowCase) {
                            outWord.append(abc2.charAt(j + decodeNum));
                        } else {
                            outWord.append(abc2.toUpperCase().charAt(j + decodeNum));
                        }
                    }
                }
            }
        }
    }

    private static void getFinalWord(String abc, StringBuilder outWord, StringBuilder finalWord, int decodeNum) {
        int nextWord = 1;
        for(int i = 0; i < outWord.length(); i++) {
            boolean isSpace = String.valueOf(outWord.charAt(i)).equalsIgnoreCase(String.valueOf(abc.charAt(decodeNum)));
            int num = outWord.length() - nextWord;
            boolean isFinal = (i == num);
            boolean isNextSpace = false;

            if(!isFinal) {
                isNextSpace = String.valueOf(outWord.charAt(i + 1)).equalsIgnoreCase(String.valueOf(abc.charAt(decodeNum)));
            }

            if(isSpace && !isFinal && !isNextSpace) { //I must have a control about index out of bounds error.
                boolean isLowCase = String.valueOf(outWord.charAt(i + nextWord)).matches("[a-z]");
                if(isLowCase) {
                    finalWord.append(outWord.charAt(i));
                } else {
                    finalWord.append(outWord.toString().toUpperCase().charAt(i));
                }
            } else {
                finalWord.append(outWord.charAt(i));
            }
        }
    }
}