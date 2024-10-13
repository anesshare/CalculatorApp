package pckg;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator implements ActionListener {
    JFrame frame;
    JTextField textField;
    JButton[] numberBtn = new JButton[10];
    JButton[] funcBtn = new JButton[8];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton;
    JPanel panel;
    Font myFont = new Font("Monospaced", Font.BOLD, 20);
    double num1 = 0;
    double num2 = 0;
    double res = 0;
    char operator;
    boolean operatorClicked = false; 

    Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.black);
        
      

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("DELETE");
        clrButton = new JButton("CLEAR");

        funcBtn[0] = addButton;
        funcBtn[1] = subButton;
        funcBtn[2] = mulButton;
        funcBtn[3] = divButton;
        funcBtn[4] = decButton;
        funcBtn[5] = equButton;
        funcBtn[6] = delButton;
        funcBtn[7] = clrButton;

        for (int i = 0; i < 8; i++) {
            funcBtn[i].addActionListener(this);
            funcBtn[i].setFont(myFont);
            funcBtn[i].setFocusable(false);
            funcBtn[i].setBackground(Color.orange);
        }

        for (int i = 0; i < 10; i++) {
            numberBtn[i] = new JButton(String.valueOf(i));
            numberBtn[i].addActionListener(this);
            numberBtn[i].setFont(myFont);
            numberBtn[i].setFocusable(false);
            numberBtn[i].setBackground(Color.orange);
        }

        delButton.setBounds(50, 430, 145, 50);
        clrButton.setBounds(205, 430, 145, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        panel.add(numberBtn[1]);
        panel.add(numberBtn[2]);
        panel.add(numberBtn[3]);
        panel.add(addButton);
        panel.add(numberBtn[4]);
        panel.add(numberBtn[5]);
        panel.add(numberBtn[6]);
        panel.add(subButton);
        panel.add(numberBtn[7]);
        panel.add(numberBtn[8]);
        panel.add(numberBtn[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberBtn[0]);
        panel.add(equButton);
        panel.add(divButton);
        panel.setBackground(Color.black);

        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }

    public void actionPerformed(ActionEvent e) {
        
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberBtn[i]) {
                if (operatorClicked) {
                    textField.setText(""); 
                    operatorClicked = false;
                }
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

       
        if (e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
        }

       
        if (e.getSource() == addButton) {
            handleOperatorClick('+');
        }

       
        if (e.getSource() == subButton) {
            if (textField.getText().isEmpty()) {
                textField.setText("-");  
            } else {
                handleOperatorClick('-');
            }
        }

  
        if (e.getSource() == mulButton) {
            handleOperatorClick('*');
        }

       
        if (e.getSource() == divButton) {
            handleOperatorClick('/');
        }

      
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+': res = num1 + num2; break;
                case '-': res = num1 - num2; break;
                case '*': res = num1 * num2; break;
                case '/': res = num1 / num2; break;
            }
            textField.setText(String.valueOf(res));
            num1 = res;
        }

      
        if (e.getSource() == clrButton) {
            textField.setText("");
        }

        
        if (e.getSource() == delButton) {
            String string = textField.getText();
            if (!string.isEmpty()) {
                textField.setText(string.substring(0, string.length() - 1));
            }
        }
    }

    private void handleOperatorClick(char operatorSymbol) {
        num1 = Double.parseDouble(textField.getText());
        operator = operatorSymbol;
        operatorClicked = true;  
        textField.setText("");  
    }
}
