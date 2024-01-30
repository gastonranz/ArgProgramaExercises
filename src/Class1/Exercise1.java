package Class1;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please, type your \"first\" number: ");
        Integer initialNum = Exercise1.getNumValidation(input);
        System.out.println("Now please, type your \"final\" number: ");
        Integer finalNum = Exercise1.getNumValidation(input);

        boolean isOdd = Exercise1.getValidation(input, "just odd numbers");
        boolean isReverse = Exercise1.getValidation(input, "reverse numbers");

        Exercise1.printNumbers(isOdd, isReverse, initialNum, finalNum);
    }

    private static Integer getNumValidation(Scanner input) {
        Integer num = null;
        do {
            try {
                num = input.nextInt();
            } catch(Exception e) {
                System.out.println("Please, type just a number!");
                input.next(); //It's so important to use this line, this method CLEAN the incorrect input buffer value.
                //"input" is a variable, so I have to change its value.
            }
        } while(num == null);
        return num;
    }

    private static boolean getValidation(Scanner input, String message) {
        boolean value = false;
        System.out.println("type Y if you want to get " + message + ", type N if you want to skip this:");
        String result = input.nextLine();
        while(!result.equalsIgnoreCase("y") && !result.equalsIgnoreCase("n")) {
            System.out.println("Please, type Y if you want to get " + message + ", N if you want to skip this:");
            result = input.nextLine();
        }

        if(result.equalsIgnoreCase("y")) {
            value = true;
        }
        return value;
    }

    private static void printNumbers(boolean isOdd, boolean isReverse, Integer initialNum, Integer finalNum) {
        if(initialNum > finalNum) {
            int value = finalNum;
            finalNum = initialNum;
            initialNum = value;
        }

        if(!isReverse) {
            while(initialNum <= finalNum) {
                boolean initRest = initialNum % 2 == 0;

                if(isOdd && initRest) {
                    System.out.println(initialNum);
                } else if(!isOdd){
                    System.out.println(initialNum);
                }
                initialNum++;
            }
        } else {
            boolean finalRest = finalNum % 2 == 0;
            for(int i = finalNum; i >= initialNum; i--) {
                if(isOdd && finalRest) {
                    System.out.println(i);
                } else if(!isOdd) {
                    System.out.println(i);
                }
            }
        }
    }
}