package day03;

import java.util.Stack;

//https://leetcode.com/problems/valid-parentheses/description/
public class ValidParenthesis {

    public static void main(String[] args) {
        System.out.println(isValid("[]{}"));
        System.out.println(isValid("[]{}("));
    }

    //[]{}    // stack - ]
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char each : s.toCharArray()) {
            if (each == '(') {
                stack.push(')');
            } else if (each == '[') {
                stack.push(']');
            } else if (each == '{') {
                stack.push('}');
                //stack is empty or closing one is not matching correct closing from stack return false
            } else if(stack.isEmpty() || each != stack.pop()) {  // closing one ],),}
                return false;
            }
        }
        return stack.isEmpty();
    }
}
