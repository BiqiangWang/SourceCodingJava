package exams.rongyao;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title test3
 * @description
 * @create 2024/9/21 19:28
 */

public class test3 {
    // note AC
    // 自定义测试用例 abc3(A)2[as3{t}]
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')') {
                StringBuilder temp = new StringBuilder();
                char pre = stack.pop();
                while (pre != '(') {
                    temp.append(pre);
                    pre = stack.pop();
                }
                temp.reverse();
                int numberBuilder = 0, base = 1;
                pre = stack.pop();
                while (pre >= '0' && pre <= '9' && !stack.isEmpty()) {
                    numberBuilder += (pre - '0') * base;
                    base *= 10;
                    pre = stack.pop();
                }
                if (!(pre >= '0' && pre <= '9')) {
                    stack.push(pre);
                }
                String repeatPart = temp.toString();
                for (int j = 1; j < numberBuilder; j++) {
                    temp.append(repeatPart);
                }
                for (char ch : temp.toString().toCharArray()) {
                    stack.push(ch);
                }
            } else if (c == ']') {
                StringBuilder temp = new StringBuilder();
                char pre = stack.pop();
                while (pre != '[') {
                    temp.append(pre);
                    pre = stack.pop();
                }
                temp.reverse();
                int numberBuilder = 0, base = 1;
                pre = stack.pop();
                while (pre >= '0' && pre <= '9' && !stack.isEmpty()) {
                    numberBuilder += (pre - '0') * base;
                    base *= 10;
                    pre = stack.pop();
                }
                if (!(pre >= '0' && pre <= '9')) {
                    stack.push(pre);
                }
                String repeatPart = temp.toString();
                for (int j = 1; j < numberBuilder; j++) {
                    temp.append(repeatPart);
                }
                for (char ch : temp.toString().toCharArray()) {
                    stack.push(ch);
                }
            } else if (c == '}') {
                StringBuilder temp = new StringBuilder();
                char pre = stack.pop();
                while (pre != '{') {
                    temp.append(pre);
                    pre = stack.pop();
                }
                temp.reverse();
                int numberBuilder = 0, base = 1;
                pre = stack.pop();
                while (pre >= '0' && pre <= '9' && !stack.isEmpty()) {
                    numberBuilder += (pre - '0') * base;
                    base *= 10;
                    pre = stack.pop();
                }
                if (!(pre >= '0' && pre <= '9')) {
                    stack.push(pre);
                }
                String repeatPart = temp.toString();
                for (int j = 1; j < numberBuilder; j++) {
                    temp.append(repeatPart);
                }
                for (char ch : temp.toString().toCharArray()) {
                    stack.push(ch);
                }
            }
            else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());
    }
}
