import java.util.ArrayList;
import java.util.Stack;
public class ReversePolishNotation {
    /**
     * evaluate the value of input
     * @param input
     * @return value of input
     */
    public static int evaluatePostfix(String input){
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < input.length(); i++){
            if(input.substring(i, i + 1).equals("+")){
                int firstNum = s.pop();
                int nextNum = s.pop();
                s.push(firstNum + nextNum);
            }
            else if(input.substring(i, i + 1).equals("-")){
                int firstNum = s.pop();
                int nextNum = s.pop();
                s.push(nextNum - firstNum);
            }
            else if(input.substring(i, i + 1).equals("*")){
                int firstNum = s.pop();
                int nextNum = s.pop();
                s.push(firstNum * nextNum);
            }
            else if(input.substring(i, i + 1).equals("/")){
                int firstNum = s.pop();
                int nextNum = s.pop();
                s.push(nextNum / firstNum);
            }
            else{
                s.push(Integer.parseInt(input.substring(i, i + 1)));
            }
        }
        return s.peek();
    }

    /**
     * turns a normal expression into a postfix expression
     * @param input
     * @return postfix equation of input
     */
    public static String infixToPostfix(String input){
        Stack<Integer> s = new Stack<>();
        String output = "";
        String letters = "qwertyuiopasdfghjklzxcvbnm";
        String temp = "";
        String[] tempArraries = {"+","-","*", "/"};
        int tempSize = 0;
        for (int i = 0; i < input.length(); i++) {
            if (letters.contains(input.substring(i, i + 1))) {
                output += input.substring(i, i + 1);

                if (i == input.length() - 1) {
                    while (!s.isEmpty()) {
                        output += tempArraries[s.peek()];
                        s.pop();
                    }
                }
            }
            else if (input.substring(i, i + 1).equals("+")) {
                if (!s.isEmpty()) {
                    for (int j = 0; j < s.size() + 1; j++) {
                        output += tempArraries[s.pop()];

                    }
                }
                s.push(0);
            }
            else if (input.substring(i, i + 1).equals("-")) {
                for (int j = 0; j < s.size(); j++) {
                    if (!s.isEmpty()) {
                        output += tempArraries[s.pop()];
                    }
                }
                s.push(1);
            }
            else if (input.substring(i, i + 1).equals("/")) {
                if (s.peek() < 2) {
                    s.push(3);

                }
                else {
                    output += "/";
                    s.pop();
                }
            }
            else if (input.substring(i, i + 1).equals("*")) {
                if (s.peek() < 2) {
                    s.push(2);

                }
                else {
                    output += "*";
                    s.pop();
                }
            }

        }
        return output;
    }
}
