/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */

class Stack<E>
{
	ArrayList<E> a = new ArrayList<E>();
	
	void push(E e) {
		a.add(0, e);//add at index zero add(element, index)
	}
	
	E pop() {
		return a.remove(0);
	}
	
	boolean isEmpty() {
		return a.isEmpty();
	}
}

class Parenthesis
{
	
	int longestValidSubstring(String pattern)
	{
		Stack<Integer> s = new Stack<>();
		
		int maxValidSub = 0;
		int currentValidSub = -1;
		int j; 
		
		for (int i = 0; i < pattern.length(); i++) {
			if (pattern.charAt(i) == '(') {
				s.push(i);
			}
			else {
				if (pattern.charAt(i) == ')') {
					if (!s.isEmpty()) {
						j = s.pop();
						currentValidSub = i - j + 1;
						maxValidSub = currentValidSub > maxValidSub ? currentValidSub : maxValidSub;
					}
				}
			}
			
		}
		
		return maxValidSub;
	}
	
	
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Parenthesis p = new Parenthesis();
		System.out.println("len:" + p.longestValidSubstring("))))))"));
		System.out.println(p.longestValidSubstring(")())))"));		
		System.out.println(p.longestValidSubstring(")(()))"));		
		System.out.println(p.longestValidSubstring("((((("));		
		System.out.println(p.longestValidSubstring("((((()"));




	}
}