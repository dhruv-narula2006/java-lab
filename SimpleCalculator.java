/* 5. WAP to work as a simple calculator using grid layout to arrange buttons for digits and for the +, -, *, /, % operations. Add a text field to display the result and handle any possible exceptions like divide by zero. */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends JFrame implements ActionListener {
    JTextField display;
    double num1, num2, result;
    char operator;
    String currentInput = "";

    JButton[] buttons = new JButton[10];
    JButton add, subtract, mul, div, mod, equal, clear;


    public SimpleCalculator() {
        // Frame Settings
        setTitle("Simple Calculator");
        setSize(400, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Text Field
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Times New Roman", Font.BOLD, 32));
        display.setHorizontalAlignment(JTextField.RIGHT);
        

        // Creating Panel with GridLayout
        JPanel displayPanel = new JPanel(new BorderLayout());
        displayPanel.setBorder(
            BorderFactory.createEmptyBorder(15, 15, 5, 15)
        );
        displayPanel.add(display, BorderLayout.CENTER);

        add(displayPanel, BorderLayout.NORTH);

        // Button Panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 8, 8));
        panel.setBorder(
            BorderFactory.createEmptyBorder(5, 15, 10, 15)
        );

        // Digit Buttons
        for(int i = 0; i < 10; i++){
            buttons[i] = new JButton(String.valueOf(i));
            buttons[i].setFont(new Font("Times New Roman", Font.BOLD, 24));
            buttons[i].setFocusPainted(false);
            buttons[i].setBorder(
                BorderFactory.createLineBorder(Color.LIGHT_GRAY)
            );
            buttons[i].addActionListener(this);
        }

        // Operator Buttons
        add = new JButton("+");
        subtract = new JButton("-");
        mul = new JButton("*");
        div = new JButton("/");
        mod = new JButton("%");
        equal = new JButton("=");

        clear = new JButton("C");

        // Set operator button font
        add.setFont(new Font("Times New Roman", Font.BOLD, 24));
        add.setFocusPainted(false);
        add.setBackground(new Color(225, 165, 0));
        subtract.setFont(new Font("Times New Roman", Font.BOLD, 24));
        subtract.setFocusPainted(false);
        subtract.setBackground(new Color(225, 165, 0));
        mul.setFont(new Font("Times New Roman", Font.BOLD, 24));
        mul.setFocusPainted(false);
        mul.setBackground(new Color(225, 165, 0));
        div.setFont(new Font("Times New Roman", Font.BOLD, 24));
        div.setFocusPainted(false);
        div.setBackground(new Color(225, 165, 0));
        mod.setFont(new Font("Times New Roman", Font.BOLD, 24));
        mod.setFocusPainted(false);
        mod.setBackground(new Color(225, 165, 0));
        equal.setFont(new Font("Times New Roman", Font.BOLD, 24));
        equal.setFocusPainted(false);
        equal.setBackground(new Color(225, 165, 0));
        equal.setForeground(Color.WHITE);

        clear.setFont(new Font("Times New Roman", Font.BOLD, 24));
        clear.setFocusPainted(false);
        clear.setBackground(new Color(225, 165, 0));
        clear.setForeground(Color.WHITE);

        // Add action listeners
        add.addActionListener(this);
        subtract.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);
        mod.addActionListener(this);
        equal.addActionListener(this);
        clear.addActionListener(this);

        // Add buttons to grid
        panel.add(buttons[7]);
        panel.add(buttons[8]);
        panel.add(buttons[9]);
        panel.add(div);

        panel.add(buttons[4]);
        panel.add(buttons[5]);
        panel.add(buttons[6]);
        panel.add(mul);

        panel.add(buttons[1]);
        panel.add(buttons[2]);
        panel.add(buttons[3]);
        panel.add(subtract);

        panel.add(buttons[0]);
        panel.add(mod);
        panel.add(equal);
        panel.add(add);

        // Add panel to frame
        add(panel, BorderLayout.CENTER);

        // Clear button at Bottom
        JPanel clearPanel = new JPanel(new BorderLayout());
        clearPanel.setBorder(
            BorderFactory.createEmptyBorder(0, 15, 15, 15)
        );
        clearPanel.add(clear, BorderLayout.CENTER);
        add(clearPanel, BorderLayout.SOUTH);

        // Show Window
        setVisible(true);
    }

    @Override public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        // If digit is pressed
        if(command.charAt(0) >= '0' && command.charAt(0) <='9'){
            currentInput += command;
            display.setText(display.getText() + command);
        }
        
        // Clear button
        else if (command.equals("C")){
            display.setText("");
            currentInput = "";
            num1 = num2 = result = 0;
            operator = '\0';
        }

        // Operator buttons
        else if (command.equals("+") || command.equals("-") ||
                 command.equals("*") || command.equals("/") ||
                 command.equals("%")){

                    try {
                        num1 = Double.parseDouble(currentInput);
                        operator = command.charAt(0);
                        display.setText(display.getText() + " " + command + " ");
                        currentInput = "";
                    }
                    catch (NumberFormatException ex) {
                        display.setText("Invalid Input");
                        currentInput = "";
                    }
                 }

                //  Equal button
                else if (command.equals("=")) {
                    try {
                        num2 = Double.parseDouble(currentInput);

                        switch(operator) {
                            case '+':
                                result = num1 + num2;
                                break;
                            case '-':
                                result = num1 - num2;
                                break;
                            case '*':
                                result = num1 * num2;
                                break;
                            case '/':
                                if(num2 == 0){
                                    throw new ArithmeticException("Cannot divide by zero");
                                }
                                result = num1/num2;
                                break;
                            case '%':
                                if (num2 == 0) {
                                    throw new ArithmeticException("Cannot divide by zero");
                                }
                                result = num1 % num2;
                                break;
                            default:
                                throw new ArithmeticException("No operator selected");
                        }
                        // Display Result
                        display.setText(String.valueOf(result));

                        // Store result for next calculation
                        currentInput = String.valueOf(result);
                    }
                    catch (NumberFormatException ex) {
                        display.setText("invalid Input");
                        currentInput = "";
                    }
                    catch(ArithmeticException ex) {
                        display.setText(ex.getMessage());
                        currentInput = "";
                    }
                }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SimpleCalculator();
        });
}
}

