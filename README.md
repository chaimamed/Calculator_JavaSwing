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
