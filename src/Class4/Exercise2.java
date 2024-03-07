package Class4;

import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.FileTime;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise2 {
    public static void main(String[] args) {

        if(args.length > 0) {
            String regEx = "^[ 0-9]+$";
            Pattern pattern = Pattern.compile(regEx);

            try {
                Path archive = Paths.get("C:\\Users\\Gastón\\Documents\\Ex2.txt");
                if(!Files.exists(archive)) Files.createFile(archive);

                List<String> strList = Files.readAllLines(archive);

                StringBuilder strNumBuilder = new StringBuilder();
                Double result = 0d;

                for(String text : strList) {
                    strNumBuilder.append(text);
                }

                Matcher matcher = pattern.matcher(strNumBuilder.toString());

                if(matcher.matches()) {
                    String[] arrayStrNum = strNumBuilder.toString().split(" ");

                    if(args[0].equalsIgnoreCase("s")) {
                        result = Exercise2.getPlus(arrayStrNum, result);
                    } else if(args[0].equalsIgnoreCase("m")) {
                        result = Exercise2.getMultiplication(arrayStrNum, result);
                    } else {
                        System.out.println("Please, type \"s\" to get a plus result or \"m\" to get a multiplication result");
                    }

                } else {
                    //System.out.println("The archive must contain just text");
                    StringBuilder newStrNumBuilder = new StringBuilder();
                    Files.write(archive, "29 298 11 2".getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
                    strList = Files.readAllLines(archive);

                    for(String text : strList) {
                        System.out.println(text);
                        newStrNumBuilder.append(text);
                    }

                    String[] newArrayNum = newStrNumBuilder.toString().split(" ");

                    if(args[0].equalsIgnoreCase("s")) {
                        result = Exercise2.getPlus(newArrayNum, result);
                    } else if(args[0].equalsIgnoreCase("m")) {
                        result = Exercise2.getMultiplication(newArrayNum, result);
                    } else {
                        System.out.println("Please, type \"s\" to get a plus result or \"m\" to get a multiplication result");
                    }
                }

                if(args[0].equalsIgnoreCase("s") || args[0].equalsIgnoreCase("m"))
                    System.out.println("The result is " + result);

            /*
            Files.writeString(archive, "New text");

            strList = Files.readAllLines(archive);

            for(String text : strList) {
                System.out.println(text);
            }

            FileTime lastModifiedTime = Files.getLastModifiedTime(archive);
            System.out.println(lastModifiedTime);

            Path newArchive = Paths.get("C:\\Users\\Gastón\\Documents\\Ex22.txt");

            boolean isFile = Files.exists(newArchive);
            if(!isFile) Files.createFile(newArchive);

            System.out.println(Files.exists(newArchive));

            Files.writeString(newArchive, "Hi World");




            Files.write(newArchive, (System.lineSeparator() + "Kim").getBytes(), StandardOpenOption.APPEND);

            strList = Files.readAllLines(newArchive);

            for(String text : strList) {
                System.out.println(text);
            }

            Path iso88591File = Files.createTempFile("some", ".txt");
            Files.write(iso88591File, "hello Kim".getBytes(StandardCharsets.ISO_8859_1));

            strList = Files.readAllLines(iso88591File);
            for(String text : strList) {
                System.out.println(text);
            }


            Path dir = Paths.get("C:\\Users\\Gastón\\Documents\\");
            System.out.println(Files.isRegularFile(newArchive));
            */
            } catch (Exception e) {
                System.out.println("The file doesn't exist");
            }
        } else {
            System.out.println("Please, type \"s\" to get a plus result or \"m\" to get a multiplication result of all the numbers in the file");
        }
    }

    private static Double getPlus(String[] newArrayNum, Double result) {
        for(String strNum : newArrayNum) {
            result += Double.parseDouble(strNum);
        }
        return result;
    }

    private static Double getMultiplication(String[] newArrayNum, Double result) {
        for(String strNum : newArrayNum) {
            if(result == 0) {
                result = Double.parseDouble(strNum);
            } else {
                result *= Double.parseDouble(strNum);
            }
        }
        return result;
    }
}