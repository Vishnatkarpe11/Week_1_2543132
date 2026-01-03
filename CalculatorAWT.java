Implement AWT Calculator with basic operations
import java.awt.*;
import java.awt.event.*;

public class CalAWT extends Frame implements ActionListener {
    TextField tf;
    Button add, sub, mul, div, cl;
    double num1, num2, result;
    String operator;
    CalAWT(){
        tf = new TextField();
        tf.setBounds(50, 50, 200, 30);
        add = new Button("+");
        sub = new Button("-");
        mul = new Button("*");
        div = new Button("/");
        cl = new Button("C");
        add.setBounds(50, 100, 40, 40);
        sub.setBounds(100, 100, 40, 40);
        mul.setBounds(150, 100, 40, 40);
        div.setBounds(200, 100, 40, 40);
        cl.setBounds(125, 160, 50, 40);
        add(tf);
        add(add);
        add(sub);
        add(mul);
        add(div);
        add(cl);
        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);
        cl.addActionListener(this);
        setTitle("AWT Calculator");
        setSize(300, 250);
        setLayout(null);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {

        try {
            if (e.getSource() == cl) {
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
            tf.setText("Error: Ã· by 0");
        } catch (Exception ex) {
            tf.setText("Invalid Input");
        }

        if (e.getSource() != cl) {
            try {
                num1 = Double.parseDouble(tf.getText());
                operator = ((Button) e.getSource()).getLabel();
                tf.setText("");
            } catch (Exception ignored) {}
        }
    }

    public static void main(String[] args) {
        new CalAWT();
    }
}