package patternn;

public class week5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}Exeperiment 5                                                                                                    import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleCalculator extends JFrame implements ActionListener {
    private JTextField textField;   // Calculator screen
    private String operator = "";   // Stores which operator was pressed
    private double num1 = 0;        // Stores first number

    public SimpleCalculator() {
        setTitle("MY CALCULATOR");       // Title of window
        setSize(300, 400);               // Size of frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // ===== Screen at the top =====
        textField = new JTextField();
        textField.setEditable(false);
        textField.setFont(new Font("Arial", Font.BOLD, 24));   // Bigger font
        textField.setHorizontalAlignment(JTextField.RIGHT);    // Right alignment
        textField.setPreferredSize(new Dimension(300, 50));    // Bigger height
        add(textField, BorderLayout.NORTH);

        // ===== Panel for buttons =====
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 5, 5)); // 5 rows, 4 columns

        // Buttons to add
        String[] buttons = {
            "7", "8", "9", "/", 
            "4", "5", "6", "*", 
            "1", "2", "3", "-", 
            "0", "%", "=", "+", 
            "C"
        };

        for (String label : buttons) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 18)); // Big font on buttons
            button.addActionListener(this);
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();   // Which button was clicked?

        if (command.matches("[0-9]")) {
            // Append digit to screen
            textField.setText(textField.getText() + command);
        } 
        else if (command.equals("C")) {
            // Clear all
            textField.setText("");
            num1 = 0;
            operator = "";
        } 
        else if (command.equals("+") || command.equals("-") || 
                 command.equals("*") || command.equals("/") || 
                 command.equals("%")) {
            // Operator pressed
            try {
                num1 = Double.parseDouble(textField.getText());  // Save first number
                operator = command;   // Save operator
                textField.setText(""); // Clear screen for second number
            } catch (Exception ex) {
                textField.setText("Error");
            }
        } 
        else if (command.equals("=")) {
            try {
                double num2 = Double.parseDouble(textField.getText()); // Second number
                double result = 0;

                switch (operator) {
                    case "+": result = num1 + num2; break;
                    case "-": result = num1 - num2; break;
                    case "*": result = num1 * num2; break;
                    case "/":
                        if (num2 == 0) {
                            textField.setText("Error (÷0)");
                            return;
                        }
                        result = num1 / num2; 
                        break;
                    case "%":
                        if (num2 == 0) {
                            textField.setText("Error (%0)");
                            return;
                        }
                        result = num1 % num2;
                        break;
                }
                textField.setText(String.valueOf(result));
            } catch (Exception ex) {
                textField.setText("Error");
            }
        }
    }

    public static void main(String[] args) {
        new SimpleCalculator();
    }
}
