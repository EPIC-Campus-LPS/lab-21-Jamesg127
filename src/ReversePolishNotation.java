import java.util.ArrayList;
import java.util.Stack;
public class ReversePolishNotation {
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
    public static String infixToPostfix(String input){
        Stack<Integer> s = new Stack<>();
        String output = "";
        String letters = "qwertyuiopasdfghjklzxcvbnm";
        for(int i = 0; i < input.length(); i++){
            if(letters.contains(input.substring(i, i + 1))){
                output += input.substring(i, i + 1);
            }
            else if(input.substring(i, i + 1).equals("+")){
                for(int j = 0; j < s.size(); j++){
                    if(s.peek() > 1 || s.isEmpty()){
                        output += s.pop();
                    }
                }
                s.push(0);

            }
            else if(input.substring(i, i + 1).equals("-")){
                if(s.peek() > 1){
                    s.push(1);
                }
                else{
                    s.pop();
                    output += "-";
                }
            }
            else if(input.substring(i, i + 1).equals("*")){
                if(s.peek() < 2){
                    s.push(2);
                }
                else{
                    output += "*";
                }
            }
            else if(input.substring(i, i + 1).equals("/")) {
                if(s.peek() < 2){
                    s.push(3);
                }
                else{
                    output += "/";
                }
            }
        }
        return output;
    }
}
