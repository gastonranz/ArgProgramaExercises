package Class3.Exercise1;

public class ExerciseA {
    public static void main(String[] args) {
        String phrase = "Hello! My name is Gaston";
        char letter = 'm';
        int result = 0;

        for(int i = 0; i < phrase.length(); i++) {
            boolean isMatch = letter == phrase.toLowerCase().charAt(i) || letter == phrase.toUpperCase().charAt(i);
            if(isMatch) {
                result++;
            }
        }

        System.out.println("The letter " + letter + " is " + result + " times on the phrase!");
    }
}
