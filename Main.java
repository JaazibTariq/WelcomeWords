import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Initialize a random number generator
        Random rand = new Random();

        // Array of passwords and usernames (for demo purposes)
        String[] usernames = {"Jaaz", "Har", "Tahu", "Kalu", "simin"};
        String[] passwords = {"1234", "456", "789", "heehee", "123"};

        // Create a JFrame (window) for the login page
        JFrame frame = new JFrame("Login Page");
        frame.setSize(700, 400); // Set the size of the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close application on window close

        // Create a JPanel to hold components using GridBagLayout
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        frame.add(panel); // Add the panel to the frame

        // Constraints for GridBagLayout
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 10, 5, 10); // Padding
        constraints.anchor = GridBagConstraints.WEST; // Alignment

        // Username label and text field
        JLabel userLabel = new JLabel("Username:");
        constraints.gridx = 0; // Column 0
        constraints.gridy = 0; // Row 0
        panel.add(userLabel, constraints);

        JTextField userText = new JTextField(20); // 20 columns wide
        constraints.gridx = 1; // Column 1
        panel.add(userText, constraints);

        // Password label and password field
        JLabel passwordLabel = new JLabel("Password:");
        constraints.gridx = 0; // Column 0
        constraints.gridy = 1; // Row 1
        panel.add(passwordLabel, constraints);

        JPasswordField passwordField = new JPasswordField(20); // 20 columns wide
        constraints.gridx = 1; // Column 1
        panel.add(passwordField, constraints);

        // Login button
        JButton loginButton = new JButton("Login");
        constraints.gridx = 0; // Column 0
        constraints.gridy = 2; // Row 2
        constraints.gridwidth = 2; // Span 2 columns
        constraints.anchor = GridBagConstraints.CENTER; // Centered
        panel.add(loginButton, constraints);


        // Message label for displaying login status
        JLabel messageLabel = new JLabel("");
        messageLabel.setForeground(Color.RED); // Set text color to red
        constraints.gridy = 4; // Row 4
        panel.add(messageLabel, constraints);

        // Action listener for the login button
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordField.getPassword());

                // Check against hardcoded credentials 
                boolean isAuthenticated = false;
                for (int i = 0; i < usernames.length; i++) {
                    if (usernames[i].equals(username) && passwords[i].equals(password)) {
                        isAuthenticated = true;
                        break;
                    }
                }

                // Display appropriate message based on authentication status
                if (isAuthenticated) {
                    messageLabel.setText("Login successful!");
                    messageLabel.setForeground(Color.GREEN);

                    // Call the HomePage class to display the home page
                    HomePage.showHomePage();

                    // Close the login page
                    frame.dispose();
                } else {
                    messageLabel.setText("Invalid username or password!");
                    messageLabel.setForeground(Color.RED);
                }
            }
        });

        // Center the frame on the screen
        frame.setLocationRelativeTo(null);
        // Make the frame visible
        frame.setVisible(true);
    }

    
}
