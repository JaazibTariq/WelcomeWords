import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// Class representing a game where the player sorts random letters
class LetterGame {
    private char[] originalLetters;         // Array to store original random letters
    private char[] userSortedLetters;       // Array to store letters sorted by the player
    private char[] correctSortedLetters;    // Array to store correct sorted order of letters

    private static final String SCORES_FILE = "letterscores.txt";  // File to store player scores

    // Constructor to initialize arrays and generate random letters
    public LetterGame(int size) {
        originalLetters = new char[size];
        userSortedLetters = new char[size];
        correctSortedLetters = new char[size];
        generateLetters(size, 0); // Start recursive generation of random letters
    }

    // Recursive method to generate random letters for the game
    private void generateLetters(int size, int index) {
        if (index < size) {
            Random random = new Random();
            originalLetters[index] = (char) (random.nextInt(26) + 'A');
            generateLetters(size, index + 1); // Recursive call for the next index
        } else {
            // Make a copy of the original letters for correct sorting display
            System.arraycopy(originalLetters, 0, correctSortedLetters, 0, size);
        }
    }

    // Bubble sort algorithm to sort an array of characters
    private void bubbleSort(char[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    char temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Method to write the player's score to a file
    private void writeScores(int score) {
        try (FileWriter writer = new FileWriter(SCORES_FILE, true);
             BufferedWriter bw = new BufferedWriter(writer);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(score);  // Writing the score on a new line in the file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to read the highest score from the file
    private int readHighScore() {
        try (FileReader reader = new FileReader(SCORES_FILE);
             BufferedReader br = new BufferedReader(reader)) {
            String line;
            int maxScore = Integer.MIN_VALUE;
            while ((line = br.readLine()) != null) {
                int score = Integer.parseInt(line);
                if (score > maxScore) {
                    maxScore = score;
                }
            }
            return maxScore;
        } catch (IOException | NumberFormatException e) {
            return 0; // If the file does not exist or is empty
        }
    }

    // Method to play the letter sorting game
    public void playGame() {
        int highScore = readHighScore();
        System.out.println("High Score: " + highScore);

        System.out.println("Welcome to the Letter Sorting Game!");
        System.out.println("Original Letters: " + Arrays.toString(originalLetters));
        System.out.println("Try to sort the letters index by index.");

        Scanner scanner = new Scanner(System.in);

        // Get player input for sorting letters
        for (int i = 0; i < originalLetters.length; i++) {
            System.out.print("Enter the value for index " + i + ": ");
            userSortedLetters[i] = Character.toUpperCase(scanner.next().charAt(0));
        }

        System.out.println("Your Sorted Letters: " + Arrays.toString(userSortedLetters));

        // Display correct sorted order
        System.out.print("Correct Sorted Order: ");
        bubbleSort(correctSortedLetters);
        System.out.println(Arrays.toString(correctSortedLetters));

        // Calculate and display the player's score
        int score = calculateScore();
        System.out.println("Your Score: " + score);

        // Write the score to the file
        writeScores(score);

        // Display the play again menu
        playAgainMenu();

        scanner.close();
    }

    // Method to calculate the player's score based on the sorted order
    private int calculateScore() {
        int score = 0;
        for (int i = 0; i < originalLetters.length; i++) {
            if (userSortedLetters[i] == correctSortedLetters[i]) {
                score++;
            }
        }
        return score;
    }

    // Method to display the play again menu and handle user choice
    private void playAgainMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nOptions:");
        System.out.println("1. Play Again");
        System.out.println("2. Quit");
        System.out.print("Enter your choice (1 or 2): ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("\nStarting a new game...");
                HomePage.startGame();
                break;
            case 2:
                System.out.println("\nQuitting the game...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 2.");
                playAgainMenu();
                break;
        }

        scanner.close();
    }
}
