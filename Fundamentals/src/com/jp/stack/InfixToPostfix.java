package com.jp.stack;

import java.util.Stack;

import javax.sound.midi.Synthesizer;

public class InfixToPostfix {

	public static void main(String[] args) {

		/*
		 * a+b*c+d compiler have to scan first b*c then scan to add a and d so to reduce
		 * scanning again and again compiler convert infix to postfix (abc*d++)or prefix
		 * 
		 * 1 scan the infix from left to right 2 if the scanned char is oprand output it
		 * 3 else if the precedence of the scanned operator is greater than the
		 * precedence of the operator in the stack or stack is empty then push it. else
		 * pop the operator from the stack untill the precedence of the scanned operator
		 * is less or equal to top opeartor from stack then push the scanned operator
		 * 
		 * 4 if scan char is ( push it to stack 5 if scan char is ) pop and output from
		 * stack until you find (
		 * 
		 * 6 repeat step from 2 to 6 7 pop and output from stack untill stack is empty
		 * 
		 */

		infixToPostfix("2*3+1");

	}

	public static void infixToPostfix(String string) {

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			if (isOprand(c)) {
				System.out.print(c);
			} else if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					System.out.print(stack.pop());
				}
				if (!stack.isEmpty() && stack.peek() != '(')
					throw new RuntimeException("Invalid Expression");
				else
					System.out.print(stack.pop());

			} else {
				if(stack.isEmpty() || precedance(c)>precedance(stack.peek())) {
					stack.push(c);
					
				}else {
				while (!stack.isEmpty() && precedance(c) <= precedance(stack.peek())) {
					System.out.print(stack.pop());

				}
				stack.push(c);
				}
			}
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop());
		}

	}

	static boolean isOprand(char c) {
		return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
	}

	static int precedance(char c) {
		switch (c) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		default:
			return -1;
		}
	}
}
