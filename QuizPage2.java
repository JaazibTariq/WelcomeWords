import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class QuizPage2 extends JFrame {
    private JLabel imageLabel;
    private JButton[] optionButtons;
    Random random = new Random();
    int randomNumber = random.nextInt(20);

    public QuizPage2() {
        // Array of image filenames and corresponding answers
        String[] images = {"Apple.jpg", "pencil.jpg", "phone.jpeg", "stopsign.jpeg", "dog.jpg", "car.jpg", "chair.jpg", "tree.jpg", "sun.jpg", "book.jpg", "shirt.jpg", "clock.jpeg", "house.jpeg", "water.jpg", "guitar.jpg", "camera.jpg", "pizza.jpg", "family.jpg", "sky.jpeg", "map.jpg"};
        String[] answers = {"apple", "pencil", "phone", "stop sign", "dog", "car", "chair", "tree", "sun", "book", "shirt", "clock", "house", "water", "guitar", "camera", "pizza", "family", "sky", "map"};

        // Set up JFrame properties
        setTitle("Quiz Page #2");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Constraints for GridBagLayout
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 10, 5, 10);
        constraints.anchor = GridBagConstraints.WEST;

        // Display image on the top
        imageLabel = new JLabel(resizeImage(new ImageIcon(images[randomNumber])));
        add(imageLabel, BorderLayout.NORTH);

        // Panel for options and input field
        JPanel optionsPanel = new JPanel(new GridLayout(5, 1));
        optionButtons = new JButton[4];

        // Add text input field
        JTextField answerTextField = new JTextField();
        constraints.gridx = 0;
        constraints.gridy = 0;
        optionsPanel.add(answerTextField, constraints);

        // Add submit button
        JButton submitButton = new JButton("Submit");
        constraints.gridx = 1;
        constraints.gridy = 0;
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve the user's answer from the text field
                String userAnswer = answerTextField.getText().trim().toLowerCase();

                // Check if the user's answer is correct
                if (userAnswer.equals(answers[randomNumber])) {
                    JOptionPane.showMessageDialog(QuizPage2.this, "Correct!");

                    // Automatically redirect to the next question
                    dispose();
                    new QuizPage2();
                } else {
                    JOptionPane.showMessageDialog(QuizPage2.this, "Incorrect. The correct answer is: " + answers[randomNumber]);
                    dispose();
                    new QuizPage2();
                }
            }
        });
        optionsPanel.add(submitButton, constraints);

        // Add skip button
        JButton skipButton = new JButton("Skip Question");
        constraints.gridx = 0;
        constraints.gridy = 1;
        skipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Skip the current question and move to the next one
                dispose();
                new QuizPage2();
            }
        });
        optionsPanel.add(skipButton, constraints);

        // Add home button
        JButton homeButton = new JButton("Home Page");
        constraints.gridx = 0;
        constraints.gridy = 1;
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Redirect to the home page
                dispose();
                HomePage.showHomePage();
            }
        });
        optionsPanel.add(homeButton, constraints);

        add(optionsPanel, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Method that makes all images the same size
    private ImageIcon resizeImage(ImageIcon icon) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int targetWidth = screenSize.width;
        int targetHeight = screenSize.height / 2;
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new QuizPage2());
    }
}
