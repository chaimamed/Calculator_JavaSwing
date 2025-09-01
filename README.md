# Java Swing Calculator



## 🚀 Overview

**Java Swing Calculator** is a modern, user-friendly desktop calculator built with Java Swing. It supports basic arithmetic operations, operator precedence, and a clean, intuitive interface. Perfect for learning Java GUI development or as a handy desktop tool.

## ✨ Features

- Responsive GUI with buttons for numbers, operations, clear, and sign change
- Operator precedence (e.g., multiplication/division before addition/subtraction)
- Real-time input display
- Error handling for invalid operations
- L

## 🛠️ Getting Started

### Prerequisites
- Java JDK 8 or higher

### Run the Calculator

```sh
javac -d bin src/Main.java
java -cp bin Main
```

# Calculator_JavaSwing
Consider the expression: "3 + 5 * 2 - 4 / 2".

Initialization:

The operandStack and operatorStack are initially empty.

Input "3":
User clicks on the "3" button.
textField is updated to "3".
Operand stack: [3.0], Operator stack: [].

Input "+":
User clicks on the "+" button.
handleOperator is called.
operatorStack is updated with +.
Current operand (3.0) is pushed onto operandStack.
textField is cleared.
Operand stack: [3.0], Operator stack: [+].

Input "5":
User clicks on the "5" button.
textField is updated to "5".
Operand stack: [3.0, 5.0], Operator stack: [+].

Input "*":
User clicks on the "*" button.
handleOperator is called.
operatorStack is updated with *.
Current operand (5.0) is pushed onto operandStack.
textField is cleared.
Operand stack: [3.0, 5.0], Operator stack: [+, *].

Input "2":
User clicks on the "2" button.
textField is updated to "2".
Operand stack: [3.0, 5.0, 2.0], Operator stack: [+, *].

Input "-":
User clicks on the "-" button.
handleOperator is called.
Since * has higher precedence than -, performOperation is called once.
Multiplication is performed (5 * 2 = 10), and the result is pushed onto operandStack.
operatorStack is updated with -.
textField is cleared.
Operand stack: [3.0, 10.0], Operator stack: [-].

Input "4":
User clicks on the "4" button.
textField is updated to "4".
Operand stack: [3.0, 10.0, 4.0], Operator stack: [-].

Input "/":
User clicks on the "/" button.
handleOperator is called.
Division is performed (10 / 4 = 2.5), and the result is pushed onto operandStack.
operatorStack is updated with /.
textField is cleared.
Operand stack: [3.0, 2.5], Operator stack: [-, /].

Input "2":
User clicks on the "2" button.
textField is updated to "2".
Operand stack: [3.0, 2.5, 2.0], Operator stack: [-, /].

Input "=":
User clicks on the "=" button.
handleEquals is called.
Remaining operations are performed (2.5 / 2 = 1.25, 3.0 - 1.25 = 1.75).
Final result (1.75) is displayed in textField.
Operand stack: [1.75], Operator stack: [].


## 🏗️ Technologies Used
- Java
- Swing (javax.swing)

## 🤝 Contributing
Contributions are welcome! Please open issues or submit pull requests for improvements.

## 📄 License
This project is open source and available under the [MIT License](LICENSE).
