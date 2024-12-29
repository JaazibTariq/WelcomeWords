import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

// Class representing the Quiz Page GUI
public class QuizPage extends JFrame {
    private JLabel imageLabel;            // Label to display the image
    private JButton[] optionButtons;      // Array to store option buttons
    QuizSelector randomQuiz = new QuizSelector(); // Instance of QuizSelector to get random quizzes
    int num = randomQuiz.getNum();       // Get a random quiz index

    // Constructor to initialize the Quiz Page
    public QuizPage() {
        setTitle("Quiz Page");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Generate random answers for the quiz
        String[] answers = generateAnswers();
        // Array of image file names
        String[] images = {"Apple.jpg", "pencil.jpg", "phone.jpeg", "stopsign.jpeg", "dog.jpg", "car.jpg", "chair.jpg",
                "tree.jpg", "sun.jpg", "book.jpg", "shirt.jpg", "clock.jpeg", "house.jpeg", "water.jpg", "guitar.jpg",
                "camera.jpg", "pizza.jpg", "family.jpg", "sky.jpeg", "map.jpg"};

        // Display image on the left side
        imageLabel = new JLabel(resizeImage(new ImageIcon(images[num])));
        add(imageLabel, BorderLayout.WEST);

        // Options panel on the right side
        JPanel optionsPanel = new JPanel(new GridLayout(4, 1));
        optionButtons = new JButton[4];

        // Create an array of random wrong answers
        String[] wrongAnswers = {answers[1], answers[2], answers[3]};

        // Add correct answer to a random position
        int correctIndex = new Random().nextInt(4);
        optionButtons[correctIndex] = new JButton(answers[0]);
        optionsPanel.add(optionButtons[correctIndex]);

        // Add wrong answers to the remaining positions
        for (int i = 0, j = 0; i < 4; i++) {
            if (i != correctIndex) {
                optionButtons[i] = new JButton(wrongAnswers[j++]);
                optionsPanel.add(optionButtons[i]);
            }
        }

        // Add action listeners to the option buttons
        for (JButton button : optionButtons) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Check if the selected option is correct
                    if (button.getText().equals(answers[0])) {
                        JOptionPane.showMessageDialog(QuizPage.this, "Correct!");

                        // Automatically redirect to the next question
                        dispose(); // Close the current frame
                        new QuizPage(); // Open a new QuizPage frame
                    } else {
                        JOptionPane.showMessageDialog(QuizPage.this, "Incorrect. The correct answer is: " + answers[0]);
                    }
                }
            });
        }

        // Home button to return to the home page
        JButton homeButton = new JButton("Home");
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Redirect to the home page
                dispose(); // Close the current frame
                HomePage.showHomePage(); // Open the home page
            }
        });
        optionsPanel.add(homeButton);

        // Add the options panel to the center of the frame
        add(optionsPanel, BorderLayout.CENTER);

        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true); // Make the frame visible
    }

    // Method to generate random answers for the quiz
    public String[] generateAnswers() {
        String[] randomQuiz2 = randomQuiz.selector();
        return randomQuiz2;
    }

    // Method to resize the image to fit the frame
    private ImageIcon resizeImage(ImageIcon icon) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int targetWidth = screenSize.width / 3;
        int targetHeight = screenSize.height;
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }

    // Main method to run the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new QuizPage());
    }
}
