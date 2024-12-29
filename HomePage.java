import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class HomePage {
    // Method to display the home page
    public static void showHomePage() {
        // Create a JFrame for the home page
        JFrame frame = new JFrame("Home Page");
        frame.setSize(700, 400); // Set the size of the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Terminate application on window close
        frame.setLayout(new GridLayout(3, 1)); // Use GridLayout with 3 rows and 1 column
        frame.getContentPane().setBackground(new Color(70, 130, 180)); // Set background color

        // Create a title label
        JLabel titleLabel = new JLabel("Welcome to Learn English!");
        titleLabel.setHorizontalAlignment(JLabel.CENTER); // Center-align the text
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20)); // Set font style and size
        titleLabel.setForeground(Color.WHITE); // Set text color to white
        frame.add(titleLabel); // Add the title label to the frame

        // Create buttons with custom styling for different modes and actions
        JButton easyButton = new CustomButton("Easy Mode", new Color(50, 205, 50));
        easyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the current frame
                new QuizPage(); // Open a new QuizPage
            }
        });
        frame.add(easyButton); // Add the easy mode button to the frame

        JButton hardButton = new CustomButton("Hard Mode", new Color(255, 69, 0));
        hardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the current frame
                new QuizPage2(); // Open a new QuizPage2 for hard mode
            }
        });
        frame.add(hardButton); // Add the hard mode button to the frame

        JButton numbers = new CustomButton("Learn Numbers 1", new Color(255, 69, 0));
        numbers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Look at the console for a message.");
                frame.dispose(); // Close the current frame
                startGame(); // Call the startGame method to initiate a game
            }
        });
        frame.add(numbers); // Add the numbers learning button to the frame

        // Center the frame on the screen
        frame.setLocationRelativeTo(null);
        frame.setVisible(true); // Make the frame visible
    }

    // Method to create a generic styled button (not used in the provided code)
    private static JButton createButton(String text, Color backgroundColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 16));
        button.setBackground(backgroundColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        return button;
    }

    // Method to start a game, prompting the user for input
    static void startGame() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the size of the letters list: ");
        if (input.hasNextInt()) {
            int size = input.nextInt();
            input.nextLine(); // Consume the newline character
            LetterGame game = new LetterGame(size);
            game.playGame(); // Start the game with the specified size
        } else {
            System.out.println("Invalid input. Please enter a valid integer.");
            input.nextLine(); // Consume the newline character
            startGame(); // Prompt user again for valid input
        }

        input.close(); // Close the scanner to prevent resource leak
    }
}
