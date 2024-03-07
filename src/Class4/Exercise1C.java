package Class4;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise1C {
    public static void main(String[] args) {
        Exercise1C.argsValuesValidation(args);
    }

    private static void argsValuesValidation(String[] args) {
        Integer num1 = null;
        Integer num2 = null;
        Integer num3 = null;
        String ascDesc = null;

        int result = 0;
        boolean multipleAscDesc = false;
        String numRegEx = "[0-9]+";
        String charRegEx = "^[ad]$";
        String negNumRegEx = "^-[0-9]+$";
        Pattern pattern = Pattern.compile(numRegEx);
        Pattern pattern2 = Pattern.compile(charRegEx);
        Pattern pattern3 = Pattern.compile(negNumRegEx);

        if(args.length >= 1) {
            for(String arg : args) {
                Matcher matcher = pattern.matcher(arg);
                Matcher matcher2 = pattern2.matcher(arg);
                Matcher matcher3 = pattern3.matcher(arg);

                if (result < 3 && matcher.matches() && arg.length() < 6) {
                    result++;

                    switch (result) {
                        case 1 -> num1 = Integer.parseInt(arg);
                        case 2 -> num2 = Integer.parseInt(arg);
                        case 3 -> num3 = Integer.parseInt(arg);
                    }
                } else if (ascDesc == null && matcher2.matches()) {
                    ascDesc = arg;
                } else if (result < 3 && matcher.matches() && arg.length() > 5) {
                    System.out.println("The number is so long! Please type a shorter number");
                } else if(result < 3 && matcher3.matches() && arg.length() > 5) {
                    System.out.println("Please, don't type a negative number and a long number!");
                } else if(result < 3 && matcher3.matches()) {
                    System.out.println("Please, don't type a negative number!");
                } else if(matcher.matches() || matcher3.matches()) {
                    System.out.println("You just have to sent 3 numbers!");
                    if(arg.length() > 5) System.out.println("Also, the number is so long, please type a shorter number");
                } else if (matcher2.matches()) {
                    System.out.println("You just have to sent 1 char value! Type \"a\" to get an ascendant order or \"d\" to get a descendant order!");
                    multipleAscDesc = true;
                }
            }
        }

        if(result == 3 && ascDesc != null && !multipleAscDesc) {
            Exercise1C.printNumbers(num1, num2, num3, ascDesc);
        } else {
            switch(result) {
                case 0 -> {
                    num1 = Exercise1C.getInputNumbers("first");
                    num2 = Exercise1C.getInputNumbers("second");
                    num3 = Exercise1C.getInputNumbers("third");
                } case 1 -> {
                    num2 = Exercise1C.getInputNumbers("second");
                    num3 = Exercise1C.getInputNumbers("third");
                } case 2 -> num3 = Exercise1C.getInputNumbers("third");
            }

            if(ascDesc != null) {
                Exercise1C.printNumbers(num1, num2, num3, ascDesc);
            } else {
                Exercise1C.printNumbers(num1, num2, num3);
            }
        }
    }

    private static Integer getInputNumbers(String message) {
        Integer num = null;
        String strNum;
        String regEx = "-[0-9]+";
        String allNumRegEx = "[0-9]+";

        Pattern pattern = Pattern.compile(regEx);
        Pattern pattern2 = Pattern.compile(allNumRegEx);
        System.out.println("Please, type your " + message + " number:");
        Scanner input = new Scanner(System.in);

        do {
            strNum = input.nextLine();

            Matcher matcher = pattern.matcher(String.valueOf(strNum));
            Matcher matcher2 = pattern2.matcher(strNum);

            //matches() -> coincide con TODA la cadena de texto
            //find() -> busca coincidencias en subcadenas dentro de la cadena de texto

            if(matcher.matches()) {
                if(strNum.length() > 6) {
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
                }
            }

        } while(num == null || num < 0 || String.valueOf(num).length() > 5);

        return num;
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

    private static void printNumbers(Integer num1, Integer num2, Integer num3, String ascDesc) {
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

    private static void printNumbers(Integer num1, Integer num2, Integer num3) {
        Scanner input = new Scanner(System.in);
        boolean isAscendant = false;
        Integer[] arrayNum = new Integer[3];
        Integer xNum = null;
        int result = 0;

        System.out.println("Type A if you want an ascendant number order, type D if you want a " +
                "decreasing number order");
        String letter = input.nextLine();

        do{
            if(letter.equalsIgnoreCase("a")) {
                isAscendant = true;
            } else if(!letter.equalsIgnoreCase("n")) {
                System.out.println("Please, type A if you want an ascendant number order, type D if you want a " +
                        "decreasing number order");
                letter = input.nextLine(); //To clean input value
            }
        } while(!letter.equalsIgnoreCase("a") && !letter.equalsIgnoreCase("d"));

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

            if(matcher.matches()) { //It's a negative number
                if(strNum.length() > 5) {
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
                    input.next();
                }
            }

        } while(xNum == null);

        for(int num : arrayNum) {
            if(xNum < num) result += num;
        }

        System.out.println("The plus result of the numbers more than " + xNum + " is -> " + result);
    }
}
