import java.awt.*;
import java.awt.event.*;

public class CalculatorAWT extends Frame implements ActionListener {

    TextField tf;
    Button add, sub, mul, div, clr;
    double num1, num2, result;
    String operator;

    CalculatorAWT() {
        // TextField
        tf = new TextField();
        tf.setBounds(50, 50, 200, 30);

        // Buttons
        add = new Button("+");
        sub = new Button("-");
        mul = new Button("*");
        div = new Button("/");
        clr = new Button("C");

        add.setBounds(50, 100, 40, 40);
        sub.setBounds(100, 100, 40, 40);
        mul.setBounds(150, 100, 40, 40);
        div.setBounds(200, 100, 40, 40);
        clr.setBounds(125, 160, 50, 40);

        // Add components
        add(tf);
        add(add);
        add(sub);
        add(mul);
        add(div);
        add(clr);

        // Add listeners
        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);
        clr.addActionListener(this);

        // Frame settings
        setTitle("AWT Calculator");
        setSize(300, 250);
        setLayout(null);
        setVisible(true);

        // Close window
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {

        try {
            if (e.getSource() == clr) {
                tf.setText("");
                return;
            }

            num2 = Double.parseDouble(tf.getText());

            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        throw new ArithmeticException("Divide by zero");
                    }
                    result = num1 / num2;
                    break;
            }

            tf.setText(String.valueOf(result));

        } catch (ArithmeticException ae) {
            tf.setText("Error: ÷ by 0");
        } catch (Exception ex) {
            tf.setText("Invalid Input");
        }

        if (e.getSource() != clr) {
            try {
                num1 = Double.parseDouble(tf.getText());
                operator = ((Button) e.getSource()).getLabel();
                tf.setText("");
            } catch (Exception ignored) {}
        }
    }

    public static void main(String[] args) {
        new CalculatorAWT();
    }
}

