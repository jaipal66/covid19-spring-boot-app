package com.jp.stack;

import java.util.Stack;

public class CheckParenthesis {

	public static void main(String[] args) {

		System.out.println(Paranthesis.check_parenthesis("[{{(())}}]"));
	}
}

class Paranthesis {

	public static boolean check_parenthesis(String string) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			if (c == '[' || c == '{' || c == '(') {
				stack.push(c);
			} else if (!stack.isEmpty() && ((c == ')' && stack.pop() == '(') || (c == '}' && stack.pop() == '{')
					|| (c == ']' && stack.pop() == '['))) {

			} else
				return false;
		}

		if (!stack.isEmpty())
			return false;

		return true;

	}

	public static boolean checkPranthesis(String string) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < string.length(); i++) {

			if(isOpen(string.charAt(i))) {
				stack.push(string.charAt(i));
			}else if(isClosed(string.charAt(i))) {
				
			}else{
				return false;
			}
		}
		return true;
	}

	private static boolean isOpen(char ch) {
		switch (ch) {
		case '[':
		case '{':
		case '(':
			return true;
		default:
			break;
		}
		return false;
	}
	private static boolean isClosed(char ch) {
		switch (ch) {
		case ']':
		case '}':
		case ')':
			return true;
		default:
			break;
		}
		return false;
	}
}