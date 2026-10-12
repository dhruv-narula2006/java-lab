/* 6. Write a Java program that creates a user interface to perform integer divisions. The user enters two numbers in the text fields, Num1 and Num2. the division of Num1 and Num2 is displayed in the Result field when the Divide button is clicked. If Num1 or Num2 were not an integer, the program would throw a Number Format Exception. If Num2 were zero, the program would throw an Arithmetic Exception. Display the exception in a message dialog box.*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class IntegerDivision extends JFrame implements ActionListener {
    JTextField num1Field, num2Field, resultField;
    JButton divideButton;
    public IntegerDivision(){
        setTitle("Integer Division");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));
        add(new JLabel("Num1: "));
        num1Field = new JTextField();
        add(num1Field);
        add(new JLabel("Num2: "));
        num2Field = new JTextField();
        add(num2Field);
        add(new JLabel("Result: "));
        resultField = new JTextField();
        resultField.setEditable(false);
        add(resultField);
        divideButton = new JButton("Divide");
        divideButton.addActionListener(this);
        add(divideButton);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        try{
            int num1 = Integer.parseInt(num1Field.getText());
            int num2 = Integer.parseInt(num2Field.getText());
            int result = num1 / num2;
            resultField.setText(String.valueOf(result));
        }
        catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "Please enter valid integers!", "Number Format Error", JOptionPane.ERROR_MESSAGE);
        }
        catch (ArithmeticException ex){
            JOptionPane.showMessageDialog(this, "Cannot divide by zero!", "Arithmetic Error", JOptionPane.ERROR_MESSAGE);
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "An unexpected error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void main(String [] args){
        new IntegerDivision();
    }
}