package algo;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ArithmeticBinaryExpression {

    static class Node {
        char value;
        Node left, right;
        Node(char item) {
            value = item;
            left = right = null;
        }
    }

    static class CalculateBinExpression {
        Stack<Character> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();
        public int calculate(Node node) {
            operands.clear();
            operators.clear();
            bstTraversal(node);
            //while ()
            // System.out.println(operators);
            //System.out.println(operands);
            //       while (!operands.isEmpty())
            //         System.out.println(operands.pop());
            System.out.println(operands);
            System.out.println(operators);
            int result = Character.getNumericValue(operands.pop());

            while (!operands.isEmpty()) {
                char operator = (operators.pop());
                int operand = Character.getNumericValue(operands.pop());
                System.out.println("Current operand " + operand);
                if (operator == '*')
                    result *= operand;
                if (operator == '+')
                    result += operand;
            }
            return result;
        }

        private void bstTraversal(Node node) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(node);

            while (!queue.isEmpty()) {
                Node currentNode = queue.poll();
                if (currentNode.value == '*' || currentNode.value == '+' || currentNode.value == '-') {
                    operators.push(currentNode.value);
                } else {
                    operands.push(currentNode.value);
                }
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }
    }

    public static void main(String... args) {
        Node root = new Node('+');
        Node three = new Node('3');
        Node mult = new Node('*');
        Node plus = new Node('+');
        Node five = new Node('5');
        Node nine = new Node('9');
        Node two = new Node('2');

        root.left = three;
        root.right = mult;
        mult.right = two;
        mult.left = plus;
        plus.left = five;
        plus.right = nine;
        CalculateBinExpression calculateBinExpression = new CalculateBinExpression();
        System.out.println(calculateBinExpression.calculate(root));

    }
}
