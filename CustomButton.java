import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// CustomButton class that extends JButton for creating stylized buttons
class CustomButton extends JButton {

    // Constructor to create a CustomButton with specified text and background color
    public CustomButton(String text, Color backgroundColor) {
        // Call the constructor of the superclass (JButton) with the provided text
        super(text);

        // Set custom styling for the button
        setFont(new Font("Arial", Font.PLAIN, 16)); // Set the font style and size
        setBackground(backgroundColor); // Set the background color
        setForeground(Color.WHITE); // Set the text color to white
        setFocusPainted(false); // Remove the focus border

        // Add an ActionListener to handle button clicks
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle button click (you can customize this behavior)
                System.out.println("Button Clicked: " + text);
            }
        });
    }
}