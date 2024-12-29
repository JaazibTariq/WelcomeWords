import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.Random;

public class QuizSelector {
    // Random number generator for selecting quizzes
    Random random = new Random();

    // Generate a random number between 0 and 20
    int randomNumber = random.nextInt(20);

    // Getter method to retrieve the generated random number
    int getNum() {
        return randomNumber;
    }

    // Method to select a quiz based on the random number
    public String[] selector() {
        // 2D array containing quizzes for different categories
        String[][] quiz = {
            {"Apple", "Banana", "Pear", "Eggplant"},
            {"Pencil", "Pen", "Marker", "Ruler"},
            {"Phone", "Computer", "TV", "Calculator"},
            {"Stop Sign", "Yield Sign", "Pedestrian", "Phone"},
            {"Dog", "Cat", "Fish", "Rabbit"},
            {"Car", "Bicycle", "Bus", "Train"},
            {"Chair", "Table", "Sofa", "Bed"},
            {"Tree", "Flower", "Grass", "Mountain"},
            {"Sun", "Moon", "Star", "Cloud"},
            {"Book", "Pen", "Paper", "Notebook"},
            {"Shirt", "Pants", "Shoes", "Hat"},
            {"Clock", "Watch", "Calendar", "Timer"},
            {"House", "Building", "Street", "Bridge"},
            {"Water", "Milk", "Juice", "Tea"},
            {"Guitar", "Piano", "Violin", "Drums"},
            {"Camera", "Computer", "Phone", "Headphones"},
            {"Pizza", "Burger", "Salad", "Pasta"},
            {"Family", "Friend", "Team", "Class"},
            {"Sunset", "Rainbow", "Thunderstorm", "Snowfall"},
            {"Map", "Compass", "GPS", "Sign"}
        };

        // Return the selected quiz based on the random number
        return quiz[randomNumber];
    }
}