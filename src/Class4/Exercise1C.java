package Class4;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise1C {
    public static void main(String[] args) {
        Integer num1 = null;
        Integer num2 = null;
        Integer num3 = null;
        String ascDesc = null;
        int argsIndexValidation = 4;

        if(args.length == argsIndexValidation) {
            boolean correctValues = Exercise1C.argsValuesValidation(args);

            if(correctValues) {
                Exercise1C.printNumbersByArgs(num1, num2, num3, ascDesc);
            }
        } else {
            num1 = Exercise1C.getInputNumbers("first", num1);
            num2 = Exercise1C.getInputNumbers("second", num2);
            num3 = Exercise1C.getInputNumbers("third", num3);

            Exercise1C.printNumbers(num1, num2, num3);
        }

    }

    private static void printNumbersByArgs(Integer num1, Integer num2, Integer num3, String ascDesc) {
        boolean isAscendant = false;
        Integer[] arrayNum = new Integer[3];

        if(!ascDesc.equalsIgnoreCase("d")) {
           isAscendant = true;
        }

        if(isAscendant) {
            Exercise1C.getOrderedNumbers(arrayNum, num1, num2, num3);
            System.out.println(Arrays.toString(arrayNum));
        } else {
            Integer[] newArrayNum = new Integer[3];
            Exercise1C.getOrderedNumbers(arrayNum, num1, num2, num3);
            int j = 2;

            for(int i = 0; i < arrayNum.length; i++) {
                newArrayNum[i] = arrayNum[j];
                j--;
            }

            System.out.println(Arrays.toString(newArrayNum));
        }
    }

    private static boolean argsValuesValidation(String[] args, Integer num1, Integer num2, Integer num2, String ascDesc) {
        boolean correctValues = false;
        boolean isChar = false;
        int result = 0;
        String numRegEx = "[0-9]+";
        String charRegEx = "^[ad]$";
        Pattern pattern = Pattern.compile(numRegEx);
        Pattern pattern2 = Pattern.compile(charRegEx);

        for(int i = 0; i < args.length; i++) {
            Matcher matcher = pattern.matcher(args[i]);
            Matcher matcher2 = pattern2.matcher(args[i]);

            /*
            if(i <= 2 && matcher.matches()) {
                result++;
            } else if(i <= 2 && !matcher.matches()) {
                System.out.println("The " + args[i] + " value must be a number!");
                break;
            } else if(i == 3 && matcher2.matches()) {
                result++;
            } else if(i == 3 && !matcher2.matches()) {
                System.out.println("The " + args[i] + "th value must be \"a\" to ascendant order or \"d\" to descendant order!");
            } else {
                System.out.println("one of the values is incorrect!");
                break;
            }*/

            if(result < 4 && matcher.matches()) {
                result++;
                switch(result) {
                    case 1 -> num1 = args[i];
                }
            } else if(!isChar && matcher2.matches()) {
                isChar = true;
            } else if(matcher.matches()) {
                System.out.println("You just have to sent 3 numbers!");
            } else if(matcher2.matches()) {
                System.out.println("You just have to sent 1 char value! Type \"a\" to get an ascendant order or \"d\" to get a descendant order!");
            }
        }

        if(result == 3 && isChar) {
            correctValues = true;
        }

        return correctValues;
    }

    private static Integer getInputNumbers(String message, Integer num) {
        System.out.println("Please, type your " + message + " number:");
        Scanner input = new Scanner(System.in);

        do {
            String strNum = input.nextLine();

            String regEx = "-[0-9]+";
            Pattern pattern = Pattern.compile(regEx);
            Matcher matcher = pattern.matcher(String.valueOf(strNum));

            String allNumRegEx = "[0-9]+";
            Pattern pattern2 = Pattern.compile(allNumRegEx);
            Matcher matcher2 = pattern2.matcher(strNum);

            //matches() -> coincide con toda la cadena de texto
            //find() -> busca coincidencias en subcadenas dentro de la cadena de texto

            if(matcher.matches()) {
                if(strNum.length() > 9) {
                    System.out.println("You've typed a negative number and it's so long!\nType a smaller and a positive number!");
                } else {
                    System.out.println("You've typed a negative number, please, type a positive number!");
                }
            } else {
                try {
                    if(matcher2.matches() && strNum.length() > 5) {
                        System.out.println("The number is so long! Type a smaller number!");
                    } else {
                        num = Integer.parseInt(strNum);
                    }
                } catch(NumberFormatException e) {
                    System.out.println("Please, type just a number!");
                    //input.next();
                }
            }

        } while(num == null || num < 0 || String.valueOf(num).length() > 5);

        return num;
    }

    private static void printNumbers(Integer num1, Integer num2, Integer num3) {
        Scanner input = new Scanner(System.in);
        boolean isAscendant = false;
        Integer[] arrayNum = new Integer[3];
        Integer xNum = null;
        int result = 0;

        System.out.println("Type Y if you want an ascendant number order, type N if you want a " +
                "decreasing number order");
        String letter = input.nextLine();

        do{
            if(letter.equalsIgnoreCase("y")) {
                isAscendant = true;
            } else if(!letter.equalsIgnoreCase("n")) {
                System.out.println("Please, type Y if you want an ascendant number order, type N if you want a " +
                        "decreasing number order");
                letter = input.nextLine();
            }
        } while(!letter.equalsIgnoreCase("y") && !letter.equalsIgnoreCase("n"));

        if(isAscendant) {
            Exercise1C.getOrderedNumbers(arrayNum, num1, num2, num3);
            System.out.println(Arrays.toString(arrayNum));
        } else {
            Integer[] newArrayNum = new Integer[3];
            int j = 2;
            Exercise1C.getOrderedNumbers(arrayNum, num1, num2, num3);
            for(int i = 0; i < arrayNum.length; i++) {
                newArrayNum[i] = arrayNum[j];
                j--;
            }
            System.out.println(Arrays.toString(newArrayNum));
        }

        System.out.println("Now type a number to save the add result of all numbers.");

        do {
            String strNum = input.nextLine();

            String regEx = "-[0-9]+";
            Pattern pattern = Pattern.compile(regEx);
            Matcher matcher = pattern.matcher(String.valueOf(strNum));

            String allNumRegEx = "[0-9]+";
            Pattern pattern2 = Pattern.compile(allNumRegEx);
            Matcher matcher2 = pattern2.matcher(strNum);

            if(matcher.matches()) {
                if(strNum.length() > 9) {
                    System.out.println("You've typed a negative number and it's so long!\nType a smaller and a positive number!");
                } else {
                    System.out.println("You've typed a negative number, please, type a positive number!");
                }
            } else {
                try {
                    if(matcher2.matches() && Integer.parseInt(strNum) >= arrayNum[2]) {
                        if(Integer.parseInt(strNum) == arrayNum[2]) {
                            System.out.println("The number must be smaller than the highest number you've typed before!");
                        } else {
                            System.out.println("The number is bigger than the highest number you've typed before!" +
                                    "\nType a smaller number!");
                        }
                    } else {
                        xNum = Integer.parseInt(strNum);
                    }
                } catch(NumberFormatException e) {
                    System.out.println("Please, type just a number!");
                    //input.next();
                }
            }

        } while(xNum == null || xNum < 0 || xNum >= arrayNum[2]);

        for(int num : arrayNum) {
            if(xNum < num) result += num;
        }

        System.out.println("The plus result of the numbers more than " + xNum + " is -> " + result);
    }

    private static void getOrderedNumbers(Integer[] arrayNum, Integer num1, Integer num2, Integer num3) {
        Integer bigNum = num1;
        Integer smallNum = num2;
        Integer mediumNum = null;

        if(bigNum < num2) bigNum = num2;
        if(bigNum < num3) bigNum = num3;

        if(smallNum > num1) smallNum = num1;
        if(smallNum > num3) smallNum = num3;

        if(num1 > smallNum && num1 < bigNum) mediumNum = num1;
        if(num2 > smallNum && num2 < bigNum) mediumNum = num2;
        if(num3 > smallNum && num3 < bigNum) mediumNum = num3;

        arrayNum[0] = smallNum;
        arrayNum[1] = mediumNum;
        arrayNum[2] = bigNum;
    }
}
