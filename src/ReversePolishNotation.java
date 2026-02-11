import java.util.ArrayList;

public class ReversePolishNotation {
    public static int evaluatePostfix(String input){
        Stack s = new Stack();
        for(int i = 0; i < input.length() - 1; i++){
            if(input.substring(i, i + 1).equals("+")){
                System.out.println("num" + s.peek());
                int firstNum = s.pop();
                System.out.println("num" + s.peek());
                s.push(firstNum + s.pop());
                System.out.println("result" + s.peek());
            }
            else if(input.substring(i, i + 1).equals("-")){
                s.push(s.pop() - s.pop());
            }
            else if(input.substring(i, i + 1).equals("*")){
                s.push(s.pop() * s.pop());
            }
            else if(input.substring(i, i + 1).equals("/")){
                s.push(s.pop() / s.pop());
            }
            else{
                s.push(Integer.parseInt(input.substring(i, i + 1)));
                System.out.println(s.peek());
            }
        }
        return s.peek();
    }
    public static String infixToPostfix(String input){
        Stack s = new Stack();
        String output = "";
        String numbers = "0123456789";
        for(int i = 0; i < input.length() - 1; i++){
            if(numbers.contains(input.substring(i, i + 1))){
                output += input.substring(i, i + 1);
            }
            else{
                if(input.substring(i, i + 1).equals("+")){
                    while(s.peek() >= 0){
                        if(s.peek() == 0){
                            s.pop();
                            output += "+";
                        }
                        else if(s.peek() == 1){
                            s.pop();
                            output += "-";
                        }
                        else if(s.peek() == 2){
                            s.pop();
                            output += "*";
                        }
                        else if(s.peek() == 3){
                            s.pop();
                            output += "/";
                        }
                    }
                    s.push(0);
                }
                else if(input.substring(i, i + 1).equals("-")){
                    while(s.peek() >= 0){
                        if(s.peek() == 0){
                            s.pop();
                            output += "+";
                        }
                        else if(s.peek() == 1){
                            s.pop();
                            output += "-";
                        }
                        else if(s.peek() == 2){
                            s.pop();
                            output += "*";
                        }
                        else if(s.peek() == 3){
                            s.pop();
                            output += "/";
                        }
                    }
                    s.push(1);
                }
                else if(input.substring(i, i + 1).equals("*")){
                    s.push(2);
                }
                else if(input.substring(i, i + 1).equals("/")) {
                    s.push(3);
                }
                else if(input.substring(i, i + 1).equals("(")){
                    s.push(4);
                }
                else if(input.substring(i, i + 1).equals(")")){
                    while(s.peek() < 4){
                        if(s.peek() == 0){
                            s.pop();
                            output += "+";
                        }
                        if(s.peek() == 1){
                            s.pop();
                            output += "-";
                        }
                    }
                }
            }
        }
        return output;
    }

}
