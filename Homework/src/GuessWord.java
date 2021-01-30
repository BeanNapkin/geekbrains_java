import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GuessWord {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        String word = words[random.nextInt(words.length)];

        System.out.println("Попробуйте угадать слово из категории еды для вегана.");

        boolean isUserGuess = false;

        while (!isUserGuess) {
            System.out.println("Введите слово на английском: ");
            String usersInput = scanner.nextLine().toLowerCase();

            char[] guessedLetters = new char[15];
            for (int k = 0; k < guessedLetters.length - 1; k++) {
                guessedLetters[k] = '#';
            }

            if (word.equals(usersInput)) {
                System.out.println("Правильно!");
                isUserGuess = true;
            } else {
                for (int i = 0; i < word.length() && i < usersInput.length(); i++) {
                    if (word.charAt(i) == usersInput.charAt(i)) {
                        guessedLetters[i] = usersInput.charAt(i);
                    }
                }
            }

            if (!isUserGuess) {
                for (char c : guessedLetters) {
                    System.out.print(c);
                }
                System.out.println();
            }
        }

        scanner.close();
    }
}
