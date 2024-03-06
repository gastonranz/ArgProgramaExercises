package Class4;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise1A {
    public static void main(String[] args) {
        /*
        Integer num1 = null;
        Integer num2 = null;
        Integer num3 = null;
        num1 = Exercise1.getInputNumbers("first", num1);
        num2 = Exercise1.getInputNumbers("second", num2);
        num3 = Exercise1.getInputNumbers("third", num3);
        */

        if(args.length == 4) {
            Integer num1 = Integer.parseInt(args[0]);
            Integer num2 = Integer.parseInt(args[1]);
            Integer num3 = Integer.parseInt(args[2]);
            String ascendentDescendent = args[3];

            Exercise1A.printNumbers(num1, num2, num3, ascendentDescendent);
        }
    }

    private static Integer getInputNumbers(String message, Integer num) {
        System.out.println("Please, type your " + message + "number:");
        Scanner input = new Scanner(System.in);

        do {
            try {
                num = input.nextInt();
            } catch(Exception e) {
                System.out.println("Please, type a number!");
                input.next();
            }
        } while(num == null);

        return num;
    }

    private static void printNumbers(Integer num1, Integer num2, Integer num3, String ascDesc) {
        //Scanner input = new Scanner(System.in);
        boolean isAscendant = false;
        Integer[] arrayNum = new Integer[3];
        Integer xNum = null;
        int result = 0;

        if(ascDesc.equalsIgnoreCase("a")) {
            isAscendant = true;
        }

        if(!isAscendant && !ascDesc.equalsIgnoreCase("d")) {
            System.out.println("The fourth value must me \"a\" to ascendant order or \"d\" to descendant order");
        } else {
            if(isAscendant) {
                Exercise1A.getOrderedNumbers(arrayNum, num1, num2, num3);
                System.out.println(Arrays.toString(arrayNum));
            } else {
                Integer[] newArrayNum = new Integer[arrayNum.length];
                int j = 2;
                Exercise1A.getOrderedNumbers(arrayNum, num1, num2, num3);

                for(int i = 0; i < arrayNum.length; i++) {
                    newArrayNum[i] = arrayNum[j];
                    j--;
                }

                System.out.println(Arrays.toString(newArrayNum));
            }
        }

        /*
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
            Exercise1.getOrderedNumbers(arrayNum, num1, num2, num3);
            System.out.println(Arrays.toString(arrayNum));
        } else {
            Integer[] newArrayNum = new Integer[3];
            int j = 2;
            Exercise1.getOrderedNumbers(arrayNum, num1, num2, num3);
            for(int i = 0; i < arrayNum.length; i++) {
                newArrayNum[i] = arrayNum[j];
                j--;
            }
            System.out.println(Arrays.toString(newArrayNum));
        }

        System.out.println("Now type a number to save the add result of all numbers.");
        do {
            try {
                xNum = input.nextInt();
            } catch(Exception e) {
                System.out.println("Please write a number!");
                input.next();
            }
        } while(xNum == null);

        for(Integer num : arrayNum) {
            if(xNum < num) {
                result += num;
            }
        }
        System.out.println("The plus result of the numbers more than " + xNum + " is -> " + result);

         */
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
