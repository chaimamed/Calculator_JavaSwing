import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class Main extends JFrame implements ActionListener {


    private JTextField textField;
    private JButton[] numberButtons = new JButton[10];
    private JButton[] functionButtons = new JButton[6];
    private JButton addButton, subButton, mulButton, divButton, eqButton, clearButton, negButton;

    private Stack<Double> operandStack;
    private Stack<Character> operatorStack;

    public Main() {
        setTitle("Calculator");
        setBounds(200, 200, 320, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        operandStack = new Stack<>();
        operatorStack = new Stack<>();

        textField = new JTextField();
        textField.setBounds(10, 10, 290, 50);
        textField.setFont(new Font("Arial", Font.PLAIN, 20));
        textField.setEditable(false);
        add(textField);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        eqButton = new JButton("=");
        clearButton = new JButton("C");
        negButton = new JButton("+/-");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = eqButton;
        functionButtons[5] = clearButton;

        for (int i = 0; i < 6; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(new Font("Arial", Font.PLAIN, 18));
            functionButtons[i].setBackground(Color.LIGHT_GRAY);
            functionButtons[i].setFocusPainted(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(new Font("Arial", Font.PLAIN, 18));
            numberButtons[i].setBackground(Color.WHITE);
            numberButtons[i].setFocusPainted(false);
        }

        negButton.addActionListener(this);
        negButton.setFont(new Font("Arial", Font.PLAIN, 18));
        negButton.setBackground(Color.WHITE);
        negButton.setFocusPainted(false);

        clearButton.addActionListener(this);
        clearButton.setFont(new Font("Arial", Font.PLAIN, 18));
        clearButton.setBackground(Color.RED);
        clearButton.setFocusPainted(false);

        clearButton.setBounds(10, 70, 50, 50);
        negButton.setBounds(70, 70, 50, 50);
        divButton.setBounds(130, 70, 50, 50);
        mulButton.setBounds(190, 70, 50, 50);

        numberButtons[7].setBounds(10, 130, 50, 50);
        numberButtons[8].setBounds(70, 130, 50, 50);
        numberButtons[9].setBounds(130, 130, 50, 50);
        subButton.setBounds(190, 130, 50, 50);

        numberButtons[4].setBounds(10, 190, 50, 50);
        numberButtons[5].setBounds(70, 190, 50, 50);
        numberButtons[6].setBounds(130, 190, 50, 50);
        addButton.setBounds(190, 190, 50, 50);

        numberButtons[1].setBounds(10, 250, 50, 50);
        numberButtons[2].setBounds(70, 250, 50, 50);
        numberButtons[3].setBounds(130, 250, 50, 50);
        eqButton.setBounds(190, 250, 50, 50);

        numberButtons[0].setBounds(10, 310, 110, 50);

        add(clearButton);
        add(negButton);
        add(divButton);
        add(mulButton);
        add(subButton);
        add(addButton);
        add(eqButton);
        add(numberButtons[0]);
        add(numberButtons[1]);
        add(numberButtons[2]);
        add(numberButtons[3]);
        add(numberButtons[4]);
        add(numberButtons[5]);
        add(numberButtons[6]);
        add(numberButtons[7]);
        add(numberButtons[8]);
        add(numberButtons[9]);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == clearButton) {
            textField.setText("");
            operandStack.clear();
            operatorStack.clear();
        }

        if (e.getSource() == negButton) {
            double value = Double.parseDouble(textField.getText());
            value = -value;
            textField.setText(String.valueOf(value));
        }

        if (e.getSource() == addButton || e.getSource() == subButton ||
                e.getSource() == mulButton || e.getSource() == divButton) {
            handleOperator(e.getActionCommand().charAt(0));
        }

        if (e.getSource() == eqButton) {
            handleEquals();
        }
    }

    private void handleOperator(char newOperator) {
        while (!operatorStack.isEmpty() && precedence(operatorStack.peek()) >= precedence(newOperator)) {
            performOperation();
        }
        operatorStack.push(newOperator);
        operandStack.push(Double.parseDouble(textField.getText()));
        textField.setText("");
    }

    private void handleEquals() {
        operandStack.push(Double.parseDouble(textField.getText()));
        while (!operatorStack.isEmpty()) {
            performOperation();
        }
        if (!operandStack.isEmpty()) {
            textField.setText(String.valueOf(operandStack.pop()));
        }
    }

    private void performOperation() {
        char operator = operatorStack.pop();
        double operand2 = operandStack.pop();
        double operand1 = operandStack.pop();
        double result = performSingleOperation(operator, operand1, operand2);
        operandStack.push(result);
    }

    private double performSingleOperation(char operator, double operand1, double operand2) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 != 0) {
                    return operand1 / operand2;
                } else {
                    JOptionPane.showMessageDialog(this, "Cannot divide by zero");
                    return 0;
                }
            default:
                return 0;
        }
    }

    private int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }
}
