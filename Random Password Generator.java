

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class RandomPassword extends JFrame {
    private JTextField passwordField;
    private JSpinner lengthSpinner;
    
    public RandomPassword() {
        setTitle("Random Password Generator");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Password display
        passwordField = new JTextField();
        passwordField.setFont(new Font("Monospaced", Font.BOLD, 16));
        passwordField.setEditable(false);
        passwordField.setHorizontalAlignment(JTextField.CENTER);
        add(passwordField, BorderLayout.CENTER);
        
        // Control panel
        JPanel controlPanel = new JPanel();
        controlPanel.add(new JLabel("Length:"));
        lengthSpinner = new JSpinner(new SpinnerNumberModel(8, 4, 20, 1));
        JButton generateButton = new JButton("Generate");
        JButton copyButton = new JButton("Copy");
        
        controlPanel.add(lengthSpinner);
        controlPanel.add(generateButton);
        controlPanel.add(copyButton);
        add(controlPanel, BorderLayout.SOUTH);
        
        generateButton.addActionListener(e -> generatePassword());
        copyButton.addActionListener(e -> {
            passwordField.selectAll();
            passwordField.copy();
            JOptionPane.showMessageDialog(this, "Password copied!");
        });
    }
    
    private void generatePassword() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                       "abcdefghijklmnopqrstuvwxyz" +
                       "0123456789" +
                       "!@#$%^&*";
        
        int length = (Integer)lengthSpinner.getValue();
        Random random = new Random();
        StringBuilder password = new StringBuilder();
        
        for(int i = 0; i < length; i++) {
            int index = random.nextInt(chars.length());
            password.append(chars.charAt(index));
        }
        
        passwordField.setText(password.toString());
    }
    
    public static void main(String[] args) {
        new RandomPassword().setVisible(true);
    }
}

