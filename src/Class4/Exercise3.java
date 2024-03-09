package Class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise3 {
    public static void main(String[] args) throws IOException {
        String abc = " abcdefghijklmnñopqrstuvwxyz";
        String abc2 = " abcdefghijklmnñopqrstuvwxyzabcdefghijklmnñopqrstuvwxyz";
        StringBuilder outWord = new StringBuilder();
        StringBuilder finalWord = new StringBuilder();
        String word;
        Path inFile = null;
        int decodeNum;

        if(args[0].equalsIgnoreCase("e") || args[0].equalsIgnoreCase("d")) {
            if(args[0].equalsIgnoreCase("e")) {
                word = Exercise3.getWord();
                Exercise3.setInFile(word);
                inFile = Exercise3.getInFile();
                Boolean[] spaces = Exercise3.getSpaces(word);

                Path decodeFile = Exercise3.getDecodeFile();
                String[] strDecodeNum = new String[1];
                List<String> decodeNumList = Files.readAllLines(decodeFile);
                strDecodeNum[0] = decodeNumList.get(0);
                decodeNum = Exercise3.getDecodeNum(strDecodeNum);
                Exercise3.getOutWord(abc, abc2, word, outWord, decodeNum);
                Exercise3.getFinalWord(outWord, finalWord, spaces);

                Exercise3.setOutFile(inFile);
                System.out.println(finalWord);

            } else if(args[0].equalsIgnoreCase("d")) {
                Path decodeFile = Exercise3.getDecodeFile();

                //Reading Decode File and getting the text
                StringBuilder strBuilderWord = new StringBuilder();
                List<String> outFileTexts = Files.readAllLines(Exercise3.getOutFile());
                for(String text : outFileTexts) {
                    strBuilderWord.append(text);
                }

                word = strBuilderWord.toString();
                Exercise3.setInFile(finalWord.toString());
                inFile = Exercise3.getInFile();
                Boolean[] spaces = Exercise3.getSpaces(word);

                String[] strDecodeNum = new String[1];
                List<String> decodeNumList = Files.readAllLines(decodeFile);
                strDecodeNum[0] = decodeNumList.get(0);
                decodeNum = Exercise3.getDecodeNum(strDecodeNum);
                Exercise3.getOutWord(abc, abc2, word, outWord, decodeNum);
                Exercise3.getFinalWord(outWord, finalWord, spaces);

                Exercise3.setOutFile(inFile);
                System.out.println(finalWord);
            }
        } else {
            word = Exercise3.getWord();
            Boolean[] spaces = Exercise3.getSpaces(word);
            Exercise3.setInFile(word);
            decodeNum = Exercise3.getDecodeNum(args); //Make a validation to avoid index out of bounds exception.
            Exercise3.setDecodeFile(decodeNum);
            inFile = Exercise3.getInFile();

            Exercise3.getOutWord(abc, abc2, word, outWord, decodeNum);
            Exercise3.getFinalWord(outWord, finalWord, spaces);
            Exercise3.setOutFile(inFile);

            System.out.println(finalWord);
        }
    }

    private static Path getInFile() {
        String inStrFile = "C:\\Users\\Gastón\\Documents\\InFile.txt";
        Path inPath = Paths.get(inStrFile);

        try {
            if(!Files.exists(inPath)) Files.createFile(inPath);
        } catch(IOException e) {
            System.out.println("\"In File\" already exists");
        }

        return inPath;
    }

    private static List<String> readInFile() {
        String inStrFile = "C:\\Users\\Gastón\\Documents\\InFile.txt";
        Path inPath = Paths.get(inStrFile);
        List<String> inFileText = null;

        try {
            inFileText = Files.readAllLines(inPath);
        } catch(IOException e) {
            System.out.println("\"In File\" text doesn't exist");
        }

        return inFileText;
    }

    private static void setInFile(String text) {
        String inStrFile = "C:\\Users\\Gastón\\Documents\\InFile.txt";
        Path inPath = Paths.get(inStrFile);

        try {
            Files.write(inPath, text.getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
        } catch(IOException e) {
            System.out.println("\"In File\" already exists");
        }
    }

    private static Path getOutFile() {
        String outStrPath = "C:\\Users\\Gastón\\Documents\\OutFile.txt";
        Path outPath = Paths.get(outStrPath);

        try {
            if(!Files.exists(outPath)) Files.createFile(outPath);
        } catch(IOException e) {
            System.out.println("The \"output\" file doesn't exist");
        }

        return outPath;
    }

    private static void setOutFile(Path inFile) {
        boolean value = false;
        try {
            Path outPath = Exercise3.getOutFile();

            List<String> inFileLineTexts = Files.readAllLines(inFile);
            if(inFileLineTexts.size() == 1) {
                for(String text : inFileLineTexts) {
                    Files.write(outPath, text.getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
                }
            } else {
                for(String text : inFileLineTexts) {
                    if(!value) {
                        Files.write(outPath, text.getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
                        value = true;
                    } else {
                        Files.write(outPath, (System.lineSeparator() + text).getBytes(), StandardOpenOption.APPEND);
                    }
                }
            }
        } catch(IOException e) {
            System.out.println("\"InFile\" wasn't found");
        }
    }

    private static void setDecodeFile(Integer num) {
        String strDecodeNumPath = "C:\\Users\\Gastón\\Documents\\DecodeFile.txt";
        Path decodeNumPath = Paths.get(strDecodeNumPath);

        try {
            if(!Files.exists(decodeNumPath)) Files.createFile(decodeNumPath);
            Files.write(decodeNumPath, String.valueOf(num).getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            System.out.println("There's a problem about creating \"DecodeFile\"");
        }
    }

    private static Path getDecodeFile() {
        String strDecodeNumPath = "C:\\Users\\Gastón\\Documents\\DecodeFile.txt";
        return Paths.get(strDecodeNumPath);
    }

    private static Boolean[] getSpaces(String word) {
        Boolean[] spaces = new Boolean[word.length()];
        for(int i = 0; i < word.length(); i++) {
            boolean isSpace = String.valueOf(word.charAt(i)).equals(" ");
            spaces[i] = isSpace;
        }

        return spaces;
    }

    private static String getWord() {
        Scanner input = new Scanner(System.in);
        System.out.println("Type a phrase, you must type just letters, don't use symbols, numbers or a dot.");
        String word = input.nextLine();

        String regEx = "\\p{P}|\\p{S}|[0-9]+";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(word);

        while(matcher.find()) {
            System.out.println("Please, don't use symbols, numbers or a dot!");
            word = input.nextLine();
            matcher = pattern.matcher(word);
        }

        return word;
    }

    private static int getDecodeNum(String[] args) throws IOException {
        boolean value = false;
        int num = 0;

        if(args.length > 1) {
            if(args[1].matches("[0-9]")) {
                if(Integer.parseInt(args[1]) < 28) {
                    num = Integer.parseInt(args[1]);
                } else {
                    value = true;
                }
            }
        }

        if(value) {
            String regEx = "[^0-9]";
            InputStreamReader keyboard = new InputStreamReader(System.in);
            BufferedReader buffer = new BufferedReader(keyboard);

            System.out.println("Now type the number of letter you want to decode your words:");
            String strNum = buffer.readLine();

            Pattern pattern = Pattern.compile(regEx);
            Matcher matcher = pattern.matcher(strNum);

            while(matcher.find() || strNum.isEmpty()) {
                System.out.println("Please, type just a number:");
                strNum = buffer.readLine();
                matcher = pattern.matcher(strNum);
            }

            num = Integer.parseInt(strNum);

            while(num > 27) {
                System.out.println("You've passed the limit number, please, type a number smaller than \"28\":");
                strNum = buffer.readLine();
                matcher = pattern.matcher(strNum);

                while(matcher.find() || strNum.isEmpty()) {
                    if(matcher.find()) {
                        System.out.println("Please, type just a number:");
                    } else {
                        if(strNum.matches("\\p{P}|\\p{S}")) {
                            System.out.println("Please, don't use symbols! Type again:");
                        } else if(strNum.matches("[a-z]")) {
                            System.out.println("Please, don't use letters! Type again:");
                        } else {
                            System.out.println("Your text is empty! Please, type a value:");
                        }
                    }

                    strNum = buffer.readLine();
                    matcher = pattern.matcher(strNum);
                }

                num = Integer.parseInt(strNum);
            }
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

    private static void getFinalWord(StringBuilder outWord, StringBuilder finalWord, Boolean[] spaces) {
        int nextWord = 1;
        for(int i = 0; i < outWord.length(); i++) {
            //String a = String.valueOf(outWord.charAt(i));
            //String b = String.valueOf(abc.charAt(decodeNum));
            //boolean isSpace = String.valueOf(outWord.charAt(i)).equalsIgnoreCase(String.valueOf(abc.charAt(decodeNum)));
            boolean isSpace = spaces[i];
            int num = outWord.length() - nextWord;
            boolean isFinal = (i == num);
            boolean isNextSpace = false;

            if(!isFinal) {
                //isNextSpace = String.valueOf(outWord.charAt(i + 1)).equalsIgnoreCase(String.valueOf(abc.charAt(decodeNum)));
                isNextSpace = spaces[i + nextWord];
            }

            if(isSpace && !isFinal && !isNextSpace) { //I must have a control about index out of bounds error.
                boolean isNextLowCase = String.valueOf(outWord.charAt(i + nextWord)).matches("[a-z]");
                if(isNextLowCase) {
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
